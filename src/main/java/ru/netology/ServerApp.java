package ru.netology;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerApp {

    public static void main(String[] args) {
        ServerThread thread = new ServerThread();
        MyThread thread2 = new MyThread();
        thread.start();
        thread2.start();

    }
}

class MyThread extends Thread {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        try (Socket client = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
            String serverResponse = in.readLine();
            System.out.printf("Please enter a word started with the last letter of %s\n", serverResponse);
            System.out.print(">>");
            String s = scanner.nextLine();
            out.println(s);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

class ServerThread extends Thread {
    String lastCity = "???";

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8080);
                /*ServerSocket serverSocket2 = new ServerSocket(8888)*/) {
            System.out.println("Server has been started");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
//                    Socket clientSocket2 = serverSocket2.accept();
                    System.out.println("New connection accepted");
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                        out.println(lastCity);
                        lastCity = in.readLine();
                        String response = "OK";
                        out.println(response);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
