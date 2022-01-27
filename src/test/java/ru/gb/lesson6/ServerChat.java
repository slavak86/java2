package ru.gb.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

    private static final int SERVER_PORT = 8585;
    private static Socket socket;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            System.out.println("Сервер запущен, ожидаем подключение...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился...");

            new ChatHandler(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
