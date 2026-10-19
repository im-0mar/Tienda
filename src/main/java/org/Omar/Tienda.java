package org.Omar;

import java.util.Scanner;

public class Tienda
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] nombres = {"Refresco", "Papas", "Galletas", "Chocolate", "Agua"};
        double[] precios = {20, 15, 18, 25, 10};
        int[] cantidades = new int[5];

        int opcion;

        do {
            System.out.println("\n===== TIENDA =====");
            for (int i = 0; i < nombres.length; i++) {
                System.out.println((i + 1) + ". " + nombres[i] + " - $" + precios[i]);
            }
            System.out.println("0. Pagar y salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 5)
            {
                System.out.print("¿Cuántos " + nombres[opcion - 1] + " deseas agregar? ");
                int cantidad = sc.nextInt();

                if (cantidad > 0)
                {
                    cantidades[opcion - 1] += cantidad;
                    System.out.println("Agregaste " + cantidad + " " + nombres[opcion - 1]);
                }
                else
                {
                    System.out.println("La cantidad debe ser mayor a 0");
                }
            } else if (opcion != 0)
          {
           System.out.println("Opción no válida");
          }

         } while (opcion != 0);

        // Ticket
        double total = 0;
        System.out.println("\n========== TICKET ==========");
        System.out.printf("%-10s %-12s %-8s %-8s%n", "Cant.", "Producto", "Precio", "Subtotal");
        System.out.println("------------------------------------");

        for (int i = 0; i < nombres.length; i++)
        {
            if (cantidades[i] > 0)
            {
                double subtotal = cantidades[i] * precios[i];
                total += subtotal;
                System.out.printf("%-10d %-12s $%-7.2f $%-7.2f%n",
                        cantidades[i], nombres[i], precios[i], subtotal);
            }
        }

        System.out.println("------------------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
        System.out.println("¡Gracias por su compra!");

        sc.close();
    }
}