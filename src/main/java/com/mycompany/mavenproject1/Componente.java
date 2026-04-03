package com.mycompany.mavenproject1;

public class Componente {
    // Atributos
    private String nombre;
    private String marca;
    private double precio;
    private boolean enStock;

    // constructor
    public Componente(String nombre, String marca, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.enStock = true;
    }

    public boolean consultarStock() {
        return enStock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void vender() {
        enStock = false;
    }

    public void reponerStock() {
        enStock = true;
    }
}