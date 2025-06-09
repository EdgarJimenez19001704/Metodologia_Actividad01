package SistemaPedidos;

import java.util.Scanner;

public class Pedido {
    private static int contador = 1;
    private int id;
    private String nombreRemitente;
    private String tipo;
    private String descripcion;
    private String fechaRecoleccion;
    private String fechaEntrega;
    private int cantidad;
    private double costo;

    public Pedido() {
        this.id = contador++;
    }

    public void capturarDatos(Scanner scanner) {
        this.nombreRemitente = Validador.leerTexto(scanner, "Nombre del remitente: ");
        this.tipo = Validador.leerTexto(scanner, "Tipo de pedido: ");
        System.out.print("Descripción: ");
        this.descripcion = scanner.nextLine();
        System.out.print("Fecha de recolección: ");
        this.fechaRecoleccion = scanner.nextLine();
        System.out.print("Fecha de entrega: ");
        this.fechaEntrega = scanner.nextLine();
        this.cantidad = Validador.leerEntero(scanner, "Cantidad de artículos: ");
        this.costo = Validador.leerDouble(scanner, "Costo: ");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - " + nombreRemitente + " - " + tipo + " - " + descripcion + " - Recolección: " + fechaRecoleccion + ", Entrega: " + fechaEntrega + ", Cantidad: " + cantidad + ", Costo: Q" + costo;
    }
}