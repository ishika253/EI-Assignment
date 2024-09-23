import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ChatRoomServer {
    // Store all connected clients
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Start server on port 12345
        System.out.println("Chat Room Server is starting...");
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Wait for clients to connect
            ClientHandler clientHandler = new ClientHandler(clientSocket); // Create new handler for the client
            clientHandlers.add(clientHandler); // Add client handler to the list
            new Thread(clientHandler).start(); // Start the handler in a new thread
        }
    }

    // Broadcast a message to all clients
    static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.sendMessage(message); // Send the message to every client
        }
    }

    // Inner class to handle each client connection
    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Initialize input and output streams
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Ask the client for their name
                out.println("Enter your name: ");
                clientName = in.readLine();
                System.out.println(clientName + " has joined the chat.");
                broadcastMessage(getCurrentTime() + " " + clientName + " has joined the chat.", this); // Notify everyone

                // Continuously listen for messages from the client
                String message;
                while ((message = in.readLine()) != null) {
                    String formattedMessage = getCurrentTime() + " [" + clientName + "]: " + message;
                    System.out.println(formattedMessage); // Display message on server console
                    broadcastMessage(formattedMessage, this); // Broadcast to others
                }
            } catch (IOException e) {
                System.out.println("Connection error with client: " + clientName);
            } finally {
                // Clean up when the client disconnects
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(clientName + " has left the chat.");
                broadcastMessage(getCurrentTime() + " " + clientName + " has left the chat.", this); // Notify others of the disconnect
                clientHandlers.remove(this); // Remove client from the set
            }
        }

        // Send a message to this client
        void sendMessage(String message) {
            out.println(message);
        }

        // Get the current time in [HH:mm:ss] format
        private String getCurrentTime() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            return "[" + LocalDateTime.now().format(dtf) + "]";
        }
    }
}
