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
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String dui;
    private String sexo;
    private String telefono;
    private String email;
    private String direccion;
    private int estado;

    public Cliente(String nombre, String apellido, String dui, String sexo, String telefono, String email, String direccion, int estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Cliente(int idCliente, String nombre, String apellido, String dui, String sexo, String telefono, String email, String direccion, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Cliente(String nombre, String apellido, String dui) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
    }

    public Cliente(int id,String nombre, String apellido, String dui) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.idCliente = id;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
