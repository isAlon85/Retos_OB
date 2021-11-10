package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Introduce el nombre y/o apellidos de la persona: ");
        String nombre = null;
        while (nombre == null || nombre.equals("")) {
            Scanner scanner = new Scanner(System.in);
            nombre = scanner.nextLine();
        }

        nomPila(nombre);

    }

    public static void nomPila(String nombreComp) {
        ArrayList<String> comprobacion = new ArrayList<>();
        boolean segundoNombre = false;
        try {
            Scanner input = new Scanner(new File("nombres.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                comprobacion.add(line);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Ha habido un error leyendo la BBDD de nombres: " + e.getMessage());
        }
        String[] newStr = nombreComp.split("\\s+");
        if (newStr.length != 1) {
            for (String s : comprobacion)
                if (Objects.equals(newStr[1], s)) {
                    segundoNombre = true;
                    break;
                }
        }
        if (segundoNombre) {
            if (newStr.length == 4) {
                System.out.println("nombre: " + newStr[0] + " " + newStr[1] + ", apellido1: "
                        + newStr[2] + ", apellido2: " + newStr[3]);
            } else if (newStr.length == 3) {
                System.out.println("nombre: " + newStr[0] + " " + newStr[1] + ", apellido1: "
                        + newStr[2]);
            } else if (newStr.length == 2) {
                System.out.println("nombre: " + newStr[0] + " " + newStr[1]);
            }
        }else {
            if (newStr.length == 3) {
                System.out.println("nombre: " + newStr[0] + ", apellido1: " + newStr[1] + ", apellido2: "
                        + newStr[2]);
            } else if (newStr.length == 2) {
                System.out.println("nombre: " + newStr[0] + ", apellido1: " + newStr[1]);
            } else if (newStr.length == 1) {
                System.out.println("nombre: " + newStr[0]);
            }
        }
    }
}
