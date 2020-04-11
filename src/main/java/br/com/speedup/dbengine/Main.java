package br.com.speedup.dbengine;


import br.com.speedup.dbengine.dbconnection.Connection;
import br.com.speedup.dbengine.dbconnection.ConnectionDB;
import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class Main {
//
//    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    public static String randomAlphaNumeric(int count) {
//        StringBuilder builder = new StringBuilder();
//        while (count-- != 0) {
//            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
//            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
//        }
//        return builder.toString();
//    }

    public static void main(String[] args) throws InterruptedException {

        Connection connection = ConnectionDB.getInstance();

        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("DIGITE O COMANDO : ");
            String command = ler.nextLine().trim();

            String value = command.trim().substring(0,3);

            if (value.trim().toUpperCase().equals("SET")) {
                connection.createCommand(command.trim()).setDocument();
            } else if (value.trim().toUpperCase().equals("GET")) {
                System.out.println(connection.createCommand(command.trim()).getDocument());
//                log.info(connection.createCommand(command.trim()).getDocument());
            } else if (value.trim().toUpperCase().equals("DEL")) {
                connection.createCommand(command.trim()).deleteDocument();
            }

            if (value.equals("exit")) {
                break;
            }

        }

    }

}
