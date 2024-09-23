import java.io.*;
import java.net.*;

public class ChatRoomClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345); // Connect to the server
             BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Start a thread to listen for messages from the server
            new Thread(() -> {
                String serverMessage;
                try {
                    // Continuously listen for messages from the server
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage); // Print the message to the console
                    }
                } catch (IOException e) {
                    System.out.println("Connection to server lost.");
                }
            }).start();

            // Send user input to the server
            String userMessage;
            while ((userMessage = userInputReader.readLine()) != null) {
                out.println(userMessage); // Send user input to the server
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server.");
            e.printStackTrace();
        }
    }
}
