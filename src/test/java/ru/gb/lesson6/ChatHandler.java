package ru.gb.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatHandler {

    private final Socket socket;
    private Thread oneThread;
    private Thread twoThread;

    ChatHandler(Socket socket) {
        this.socket = socket;
    }

    void start() {

        oneThread = new Thread(() -> {
            try (DataInputStream in = new DataInputStream(socket.getInputStream())) {

                while (true) {
                    String message = in.readUTF();
                    System.out.printf("%nНовое сообщение > %s%n", message);
                    System.out.print("Введите сообщение > ");
                    if (isEndMessage(message)) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        twoThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    System.out.print("Введите сообщение > ");
                    String message = scanner.nextLine();
                    out.writeUTF(message);
                    if (isEndMessage(message)) {
                        break;
                    }
                    scanner.hasNextLine();
                    System.out.println("Вы написали:" + message);
                }
//
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        oneThread.start();
        twoThread.start();
    }

    void join() {
        try {
            oneThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isEndMessage(String msg) {
        return msg.equalsIgnoreCase("/q");
    }

}

