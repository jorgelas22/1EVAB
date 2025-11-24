package org.example;

import java.util.Scanner;

public class main {
//Esto es el menu de la agenda//
    public static final String AGENDA = "\n=== AGENDA ===";
    public static final String LISTAR = "1. Listar";
    public static final String BUSCAR_POR_DÍA = "2. Buscar por día";
    public static final String BUSCAR_POR_NOMBRE = "3. Buscar por nombre";
    public static final String AÑADIR = "4. Añadir";
    public static final String ELIMINAR = "5. Eliminar";
    public static final String SALIR = "6. Salir";

    public static void main(String[] args) {

        cumpleRepo repo = new cumpleRepo();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(AGENDA);
            System.out.println(LISTAR);
            System.out.println(BUSCAR_POR_DÍA);
            System.out.println(BUSCAR_POR_NOMBRE);
            System.out.println(AÑADIR);
            System.out.println(ELIMINAR);
            System.out.println(SALIR);

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    extraido1(repo);
                    break;

                case "2":
                    extraido2(sc, repo);
                    break;

                case "3":
                    extraido3(repo, sc);
                    break;

                case "4":
                    extraido4(sc, repo);
                    break;

                case "5":
                    extraido5(repo, sc);
                    break;

                case "6":
                    salir = true;
                    break;
            }
        }
    }

    private static void extraido5(cumpleRepo repo, Scanner sc) {
        System.out.print("Eliminar nombre: ");
        repo.EliminarPorNombre(sc.nextLine());
    }

    private static void extraido4(Scanner sc, cumpleRepo repo) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Día: ");
        int d = Integer.parseInt(sc.nextLine());
        System.out.print("Mes: ");
        int m = Integer.parseInt(sc.nextLine());
        repo.AddCumple(new cumpleAgenda(nombre, d, m));
    }

    private static void extraido3(cumpleRepo repo, Scanner sc) {
        System.out.print("Nombre: ");
        cumpleAgenda c = repo.BuscarPorNombre(sc.nextLine());
        if (c != null) System.out.println(c.GetNombre());
    }

    private static void extraido2(Scanner sc, cumpleRepo repo) {
        System.out.print("Día: ");
        int dia = Integer.parseInt(sc.nextLine());
        for (cumpleAgenda c : repo.BuscarPorDia(dia)) {
            System.out.println(c.GetNombre());
        }
    }

    private static void extraido1(cumpleRepo repo) {
        for (cumpleAgenda c : repo.GetLista()) {
            System.out.println(c.GetNombre());
        }
    }
}
