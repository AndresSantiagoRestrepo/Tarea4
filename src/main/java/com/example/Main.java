package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArchivoLector controlArchivo = new ArchivoLector();
        ControlRegalos controlRegalos = new ControlRegalos();

        controlArchivo.consultarDatos(controlRegalos);
        System.out.println("-------------------------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la edad de la persona");
        int edadPersona = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el presupuesto para el regalo");
        double presupuesto = Double.parseDouble(scanner.nextLine());

        controlRegalos.recomendarRegalo(edadPersona, presupuesto);

    }
}