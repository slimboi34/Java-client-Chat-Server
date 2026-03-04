package com.chatserver.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static volatile boolean running = true;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            // Start a new thread to listen for messages from the server
            Thread listenThread = new Thread(() -> {
                try {
                    String messageFromServer;
                    while (running && (messageFromServer = in.readLine()) != null) {
                        System.out.println("Received: " + messageFromServer);
                    }
                } catch (IOException e) {
                    if (running) {
                        System.out.println("Error reading from server: " + e.getMessage());
                    }
                }
            });
            listenThread.start();

            // Send messages to the server with graceful exit
            System.out.println("Connected to the chat. Type 'quit' or 'exit' to leave.");
            while (running) {
                String message = scanner.nextLine();
                if ("quit".equalsIgnoreCase(message.trim()) || "exit".equalsIgnoreCase(message.trim())) {
                    running = false;
                    break;
                }
                out.println(message);
            }

            // Cleanup
            System.out.println("Disconnecting from server...");
            socket.close();

        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}
