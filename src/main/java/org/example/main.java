package org.example;

import java.util.Scanner;

public class main {

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
                    for (cumpleAgenda c : repo.GetLista()) {
                        System.out.println(c.GetNombre());
                    }
                    break;

                case "2":
                    System.out.print("Día: ");
                    int dia = Integer.parseInt(sc.nextLine());
                    for (cumpleAgenda c : repo.BuscarPorDia(dia)) {
                        System.out.println(c.GetNombre());
                    }
                    break;

                case "3":
                    System.out.print("Nombre: ");
                    cumpleAgenda c = repo.BuscarPorNombre(sc.nextLine());
                    if (c != null) System.out.println(c.GetNombre());
                    break;

                case "4":
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Día: ");
                    int d = Integer.parseInt(sc.nextLine());
                    System.out.print("Mes: ");
                    int m = Integer.parseInt(sc.nextLine());
                    repo.AddCumple(new cumpleAgenda(nombre, d, m));
                    break;

                case "5":
                    System.out.print("Eliminar nombre: ");
                    repo.EliminarPorNombre(sc.nextLine());
                    break;

                case "6":
                    salir = true;
                    break;
            }
        }
    }
}
