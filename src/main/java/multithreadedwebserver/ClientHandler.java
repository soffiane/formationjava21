package multithreadedwebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable{

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(OutputStream outputStream = socket.getOutputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                System.out.println(line);
            }
            String httpResponse = "HTTP/1.1 200 OK\nContent-Type: text/html\nContent-Legnth: 11\n\nHello World";
            outputStream.write(httpResponse.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("failed to close socket "+e.getMessage());
            }
        }
    }
}
