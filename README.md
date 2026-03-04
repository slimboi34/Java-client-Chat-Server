# Java Chat Server

A simple, multithreaded chat server and client application built in Java. 

## User Manual

This chat application allows multiple clients to connect to a central server and communicate with each other in real-time. 

### Prerequisites
- **Java Development Kit (JDK):** Ensure you have Java installed on your system. You can check this by running `java -version` in your terminal.
- The project must be compiled. The compiled `.class` files are assumed to be located in the `out/` directory.

### Quick Start Guide

#### 1. Starting the Server
Before any clients can connect, the server must be running. To start the server, open a new terminal window, navigate to the `chat_server` project directory, and run the following command:

```bash
java -cp out com.chatserver.server.ChatServer
```

The server will start listening for connections on port `12345`. You should see an output similar to:
`Chat server started on port 12345...`

#### 2. Starting a Client
Open a **new** terminal window (keep the server terminal running) and run the following command to start a chat client:

```bash
java -cp out com.chatserver.client.ChatClient
```

Upon successful connection, you will see:
`Connected to the chat. Type 'quit' or 'exit' to leave.`

You can repeat this step in multiple terminal windows to connect multiple clients at the same time.

#### 3. Chatting
- Simply type your message into the client terminal and press **Enter** to send it.
- Your message will be broadcasted to all other connected clients.
- If another client sends a message, it will appear in your client terminal as `Received: [message]`.

#### 4. Disconnecting
To gracefully disconnect from the chat server, type either of these commands in your client terminal and press Enter:
- `quit`
- `exit`

You will see a `"Disconnecting from server..."` message, and the client application will close.

## Troubleshooting

- **Connection Refused:** Ensure the server is running *before* trying to start a client. Also, ensure the server and client are using the same port (`12345`).
- **ClassNotFoundException:** Make sure you are running the `java` commands from the root directory of the project (e.g., `/Users/josh/Projects/java_sem2/chat_server`), and that the code has been properly compiled into the `out` directory.
# Java-Chat-Server
