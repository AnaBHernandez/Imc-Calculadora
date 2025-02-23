package com.anabelen;

import java.util.Scanner;


public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("¡Hola, " + nombre + "! Bienvenido a la aplicación.");

        scanner.close();
    }
}
