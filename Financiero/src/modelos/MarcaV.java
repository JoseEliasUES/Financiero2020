/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

public class MarcaV {

    private Integer idMarca;
    private String marca;
    private String descripcion;

    public MarcaV() {
    }

    public MarcaV(Integer idMarca, String marca, String descripcion) {
        this.idMarca = idMarca;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public MarcaV(String marca, String descripcion) {
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
