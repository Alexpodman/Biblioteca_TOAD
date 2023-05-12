package com.emergentes.model;

public class Libro {
    private int id;
    private String nombre;
    private String categoria;
    private int isbn;
    
    public Libro() {
        id = 0;
        nombre = "";
        categoria = "";
        isbn = 0;
    }

    // Metodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
}
