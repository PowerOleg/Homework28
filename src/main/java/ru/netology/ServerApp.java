package ru.netology;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    static String lastCity = "???";

//    public static String word(String word) {
//        if (word == null) {
//
//        }
//        String lastCity = "???";
//        return lastCity;
//    }
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
        /*ServerSocket serverSocket2 = new ServerSocket(8888)*/) {
            System.out.println("Server has been started");

            while (true) {
                try {
                    //
                    Socket clientSocket = serverSocket.accept();
//                    Socket clientSocket2 = serverSocket2.accept();
                    System.out.println("New connection accepted");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                                out.println(lastCity);
                                lastCity = in.readLine();
                                String response = "OK";
                                out.println(response);
                                out.flush();


                            } catch (IOException e) {
                            throw new RuntimeException(e);
                            }
                        }
                    }).start();



//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
//                                 PrintWriter out = new PrintWriter(clientSocket2.getOutputStream(), true)) {
//
//                                final String request = in.readLine();
//                                String response = String.format("Hi %s, this is server2, your port is %d", request, clientSocket.getPort());
//                                out.println(response);
//                                out.flush();
//
//
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }).start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
