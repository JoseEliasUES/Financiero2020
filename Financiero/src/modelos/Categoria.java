/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

public class Categoria {

    private Integer idCat;
    private String nCat;
    private String descripcion;

    public Categoria(Integer idCat, String nCat, String descripcion) {
        this.idCat = idCat;
        this.nCat = nCat;
        this.descripcion = descripcion;
    }

    public Categoria(String nCat, String descripcion) {
        this.nCat = nCat;
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getnCat() {
        return nCat;
    }

    public void setnCat(String nCat) {
        this.nCat = nCat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
