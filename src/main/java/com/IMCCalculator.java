package com;

import java.util.Scanner;
import java.util.Locale;
import java.util.NoSuchElementException;

public class IMCCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = obtenerNumero(scanner);

        System.out.print("Ingrese su altura en metros: ");
        double altura = obtenerNumero(scanner);

        double imc = calcularIMC(peso, altura);
        String categoria = clasificarIMC(imc);

        System.out.printf("Su IMC es: %.2f\n", imc);
        System.out.println("Categoría: " + categoria);

        scanner.close();
    }

    static double obtenerNumero(Scanner scanner) {
    while (scanner.hasNext()) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido:");
            scanner.next(); // Limpiar el buffer
        }
    }
    throw new NoSuchElementException("No se pudo obtener un número válido");
}


    public static double calcularIMC(double peso, double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero");
        }
        return peso / (altura * altura);
    }

    public static String clasificarIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
