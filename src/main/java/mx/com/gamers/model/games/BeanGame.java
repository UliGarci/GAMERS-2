package mx.com.gamers.model.games;

import java.util.Date;

public class BeanGame {
    private int id;
    private String nombre;
    private Date fecha;
    private int status;
    private String descripcion;

    public BeanGame() {
    }

    public BeanGame(int id, String nombre, Date fecha, int status, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.status = status;
        this.descripcion = descripcion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
