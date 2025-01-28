/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoF121;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Transaccion {
     private String IdTransaccion;
    private Date Fecha;
    private Double Monto;
    private String Tipo;
   // Constructor
    public Transaccion(String IdTransaccion, Double Monto, String Tipo) {
        this.IdTransaccion = IdTransaccion;
        this.Fecha = new Date(); // Asigna la fecha actual por defecto
        this.Monto = Monto;
        this.Tipo = Tipo;
    }

    // Métodos

    // Método para procesar la transacción
    public void procesarTransaccion() {
        if (Tipo.equalsIgnoreCase("deposito")) {
            System.out.println("Procesando un deposito de: " + Monto);
        } else if (Tipo.equalsIgnoreCase("retiro")) {
            System.out.println("Procesando un retiro de: " + Monto);
        } else {
            System.out.println("Tipo de transaccion desconocido.");
        }
    }

    // Método para mostrar los datos de la transacción
    public void mostrar() {
        System.out.println("ID Transaccion: " + IdTransaccion);
        System.out.println("Fecha: " + Fecha);
        System.out.println("Monto: " + Monto);
        System.out.println("Tipo: " + Tipo);
    }

    // Método para leer datos de una transacción sin usar Scanner
    public void leer(String id, Double monto, String tipo) {
        this.IdTransaccion = id;
        this.Monto = monto;
        this.Tipo = tipo;
        this.Fecha = new Date(); // Establece la fecha actual
        System.out.println("Datos de la transaccion leídos correctamente.");
    }

    // Getters y Setters
    public String getIdTransaccion() {
        return IdTransaccion;
    }

    public void setIdTransaccion(String IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
