package realtimechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private final Socket clientSocket;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.out = out;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            String message;
            while((message = reader.readLine()) != null){
                System.out.println("message "+message);
                ChatServer.broadcast(message, this);
            }
        } catch (IOException e) {
            System.out.println("client error");
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket");
            }
        }
    }

    public void sendMessage(String message) {
        if(out != null){
            out.println(message);
        }
    }

}
