package ru.gb.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientChat {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8585;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {

            System.out.printf("Подключились к %s%n", SERVER_ADDRESS);

            ChatHandler chatHandler = new ChatHandler(socket);
            chatHandler.start();
            chatHandler.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}