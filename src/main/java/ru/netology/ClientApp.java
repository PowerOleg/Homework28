package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket clientSocket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String serverResponse = in.readLine();
            System.out.printf("Please enter a word that starts with the last letter of %s\n", serverResponse);
            System.out.print(">>");
            String s = scanner.nextLine();
            out.println(s);
            String serverResponse2 = in.readLine();
            System.out.println(serverResponse2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
