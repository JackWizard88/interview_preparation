package ru.geekbrains.interview_preparation.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SpringClientApp {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;
    private static final String SERVER_CONTEXT_PATH = "/test-server";
    private static final String SERVER_ENDPOINT = "/hello";
    private static final String HTTP_VERSION = "HTTP/1.1";
    private static final String FLAG= "NaN";

    private static String method;

    public static void main(String[] args) {

        while (true) {

            method = FLAG;

            System.out.println("Input http request method:");
            System.out.println("1. GET");
            System.out.println("2. POST");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            while (method.equals("NaN")) {
                switch (command) {
                    case "exit" :
                        System.exit(0);
                        break;
                    case "1" :
                    case"GET":
                    case "get":
                    case "Get" :
                        method = "GET";
                        break;
                    case "2" :
                    case "POST":
                    case "Post" :
                    case "post":
                        method = "POST";
                        break;
                    default:
                        method = "NaN";
                        break;

                }
            }

            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
                StringBuilder out = new StringBuilder();
                out.append(method + " " + SERVER_CONTEXT_PATH + SERVER_ENDPOINT + " " + HTTP_VERSION).append("\r\n");
                out.append("Host: ").append(SERVER_ADDRESS).append(":").append(SERVER_PORT).append("\r\n");
                out.append("Accept: ").append("text/plain;charset=UTF-8").append("\r\n");
                out.append("Connection: Close").append("\r\n");
                out.append("Content-Type: ").append("text/plain;charset=UTF-8").append("\r\n");
                out.append("\r\n");
                System.out.println(out.toString());

                socket.getOutputStream().write(out.toString().getBytes(StandardCharsets.UTF_8));
                socket.getOutputStream().flush();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    System.out.println();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
