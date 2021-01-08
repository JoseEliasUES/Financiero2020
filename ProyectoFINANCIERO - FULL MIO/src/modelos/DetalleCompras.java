package modelos;

import java.util.Date;

/**
 *
 * @author Josue
 */
public class DetalleCompras {
    private int idDetCompra;
    private Date fecha;
    private double precioCompra;
    private int cantidad;
    private int idProd;
    private int idProv;
    private int idCompra;
    private double total;

    public DetalleCompras(double precioCompra, int cantidad, int idProd, int idCompra) {
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.idProd = idProd;
        this.idCompra = idCompra;
    }

    public DetalleCompras(int idDetCompra, Date fecha, double precioCompra, int cantidad, int idProd, int idProv, int idCompra, double total) {
        this.idDetCompra = idDetCompra;
        this.fecha = fecha;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.idProd = idProd;
        this.idProv = idProv;
        this.idCompra = idCompra;
        this.total = total;
    }
    
    public DetalleCompras(int idDetCompra, double precioCompra, int cantidad, int idProd, int idCompra) {
        this.idDetCompra = idDetCompra;
       
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.idProd = idProd;
        this.idCompra = idCompra;
       
    }

   

    public DetalleCompras() {
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdDetCompra() {
        return idDetCompra;
    }

    public void setIdDetCompra(int idDetCompra) {
        this.idDetCompra = idDetCompra;
    }

    
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }
    
    
}
