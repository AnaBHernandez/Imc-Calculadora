package com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IMCCalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testCalcularIMC() {
        assertEquals(22.86, IMCCalculator.calcularIMC(70, 1.75), 0.01);
        assertEquals(18.59, IMCCalculator.calcularIMC(50, 1.64), 0.01);
        assertEquals(30.86, IMCCalculator.calcularIMC(100, 1.80), 0.01);
        assertThrows(IllegalArgumentException.class, () -> IMCCalculator.calcularIMC(70, 0));
        assertThrows(IllegalArgumentException.class, () -> IMCCalculator.calcularIMC(70, -1));
    }

    @Test
    void testClasificarIMC() {
        assertEquals("Bajo peso", IMCCalculator.clasificarIMC(18.4));
        assertEquals("Peso normal", IMCCalculator.clasificarIMC(22.0));
        assertEquals("Peso normal", IMCCalculator.clasificarIMC(24.8));
        assertEquals("Sobrepeso", IMCCalculator.clasificarIMC(27.5));
        assertEquals("Sobrepeso", IMCCalculator.clasificarIMC(29.8));
        assertEquals("Obesidad", IMCCalculator.clasificarIMC(30.0));
        assertEquals("Obesidad", IMCCalculator.clasificarIMC(35.0));
    }


    @Test
    void testMain() {
        String input = "70\n1.75\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IMCCalculator.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Su IMC es: 22,86"));
        assertTrue(output.contains("Categoría: Peso normal"));
    }
}
