package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer {

    private final ClientHandler clientHandler;
    private volatile boolean stop = false;
    private final int port;

    public MyServer(int port, ClientHandler clientHandler) {
        this.port = port;
        this.clientHandler = clientHandler;
        stop = false;
    }

    // Run the server
    private void runServer() throws Exception {
        ServerSocket server = new ServerSocket(port);
        server.setSoTimeout(1000);
        while (!stop) {
            try {
                Socket aClient = server.accept();
                try {
                    clientHandler.handleClient(aClient.getInputStream(), aClient.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    clientHandler.close();
                    aClient.close();

                }
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            }
        }
        server.close();
    }

    // Start server
    public void start() {
        new Thread(() -> {
            try {
                runServer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    // Stopping the server
    public void close() {
        stop = true;
    }
}