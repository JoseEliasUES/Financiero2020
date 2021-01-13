/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Josue
 */
public class Producto {

    private int id;
    private String nombre;
    private String modelo;
    private int stock;
    private MarcaV marca;
    private Categoria categoria;
    private String descripcion;
    private int cantidad;
    private double precio;
    private Proveedor prov;

    public Producto(int id, String nombre, String modelo, MarcaV marca, Categoria categoria, String descripcion, Proveedor prov) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.prov = prov;
    }

    public Producto(String nombre, String modelo, int stock, MarcaV marca, Categoria categoria, String descripcion, Proveedor prov) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.prov = prov;
    }

 
    

    public Producto(int id, String nombre, String modelo, int stock, MarcaV marca, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Producto(String nombre, String modelo, int stock, MarcaV marca, Categoria categoria, int cantidad, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, String modelo, MarcaV marca, Categoria categoria, String descripcion) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, String modelo, MarcaV marca, Categoria categoria, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Producto(String nombre, String modelo, int stock, MarcaV marca, Categoria categoria, String descripcion) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.stock = stock;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Producto(int id, String nombre, String modelo, MarcaV marca, Categoria categoria, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }



    public Producto() {
    }

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public MarcaV getMarca() {
        return marca;
    }

    public void setMarca(MarcaV marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

}
