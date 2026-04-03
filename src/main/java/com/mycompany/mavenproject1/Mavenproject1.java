package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Mavenproject1 {
    public static void main(String[] args) {
        
        ArrayList<Componente> inventario = new ArrayList<>();
        ArrayList<Venta> registroVentas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        // Crear objetos
        Componente c1 = new Componente("Procesador Ryzen 7 5700X (AM4)", "AMD", 190.00);
        Componente c2 = new Componente("Tarjeta Gráfica RTX 4060", "NVIDIA", 320.10);
        Componente c3 = new Componente("Motherboard B450M Pro4", "ASRock", 85.25);
        Componente c4 = new Componente("Cooler AK400 White", "DeepCool", 35.50);
        
        inventario.add(c1);
        inventario.add(c2);
        inventario.add(c3);
        inventario.add(c4);
        
        Cliente cliente1 = new Cliente("Agustin");
        System.out.println("Bienvenido a la tienda de Hardware, " + cliente1.getNombre());
        
        System.out.println("--- CATALOGO DISPONIBLE ---");
        int contador = 0;
        for (Componente c : inventario) {
            contador++;
            System.out.println(contador + ". " + c.getNombre() + " - $" + c.getPrecio());
        }
        
        System.out.println("Seleccione el numero del componente que desea comprar:");
        int opcion = sc.nextInt();
        
        // Validar opcion
        if (opcion >= 1 && opcion <= inventario.size()) {
            Componente seleccionado = inventario.get(opcion - 1);

            if (seleccionado.consultarStock()) {
                seleccionado.vender();
                Venta nuevaVenta = new Venta(cliente1, seleccionado);
                registroVentas.add(nuevaVenta);
                System.out.println("Compra realizada con exito");
            } else {
                System.out.println("No hay stock de ese producto");
            }
        } else {
            System.out.println("Opcion incorrecta");
        }
        
        System.out.println("--- STOCK DESPUES DE LA COMPRA ---");
        contador = 0;
        for (Componente c : inventario) {
            contador++;
            String estado = c.consultarStock() ? "En Stock" : "Agotado";
            System.out.println(contador + ". " + c.getNombre() + " | Estado: " + estado);
        }
        
        System.out.println("--- REGISTRO DE VENTAS ---");
        for (Venta v : registroVentas) {
            v.mostrarRecibo();
        }
        
        sc.close();
    }
}
