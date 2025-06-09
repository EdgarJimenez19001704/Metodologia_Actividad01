package SistemaPedidos;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Validador {
    public static String leerTexto(Scanner scanner, String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine();
        } while (!input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
        return input;
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        String input;
        while (true) {
            System.out.print(mensaje);
            input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    public static double leerDouble(Scanner scanner, String mensaje) {
        String input;
        while (true) {
            System.out.print(mensaje);
            input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número decimal.");
            }
        }
    }

    public static String leerEmail(Scanner scanner, String mensaje) {
        String input;
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        do {
            System.out.print(mensaje);
            input = scanner.nextLine();
        } while (!pattern.matcher(input).matches());
        return input;
    }
}