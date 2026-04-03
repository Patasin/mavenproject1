package com.mycompany.mavenproject1;

public class Venta {
    private Cliente cliente;
    private Componente componente;

    public Venta(Cliente cliente, Componente componente) {
        this.cliente = cliente;
        this.componente = componente;
    }

    public void mostrarRecibo() {
        System.out.println("-> COMPROBANTE: " + cliente.getNombre() + " compró un(a) " 
                           + componente.getNombre() + " por $" + componente.getPrecio());
    }
}