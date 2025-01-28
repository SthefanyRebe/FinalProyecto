
package ProyectoF121;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarjetaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    // Resto del código de la clase TarjetaCredito...
   private String NumTargeta;
    private double Limite;
    private double Saldo;

    // Constructor
    public TarjetaCredito(String NumTarjeta, double Limite, double Saldo) {
        this.NumTargeta = NumTarjeta;
        this.Limite = Limite;
        this.Saldo = Saldo;
    }

    // Mostrar los datos de la tarjeta
    public void mostrar() {
        System.out.println("Numero de Tarjeta: " + this.NumTargeta + 
                           " - Limite: " + this.Limite + 
                           " - Saldo: " + this.Saldo);
    }
     // Método para guardar la tarjeta en la base de datos
    public void guardarEnBD(String clienteId) {
        String sql = "INSERT INTO tarjetas (num_tarjeta, limite, saldo, cliente_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.NumTargeta);
            pstmt.setDouble(2, this.Limite);
            pstmt.setDouble(3, this.Saldo);
            pstmt.setString(4, clienteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer los datos de la tarjeta
    public void leer(String NumTargeta, double Limite, double Saldo) {
        this.NumTargeta = NumTargeta;
        this.Limite = Limite;
        this.Saldo = Saldo;
    }

    // Realizar un pago (disminuye el saldo si es posible)
    public boolean realizarPago(double monto) {
        if (monto > 0 && monto <= this.Saldo) {
            this.Saldo -= monto;
            System.out.println("Pago realizado con exito. Nuevo saldo: " + this.Saldo);
            return true;
        } else {
            System.out.println("Error: El monto excede el saldo disponible.");
            return false;
        }
    }

    // Realizar un cargo (verifica si supera el límite antes de aumentar el saldo)
    public boolean realizarCargo(double monto) {
        if (monto > 0 && (this.Saldo + monto) <= this.Limite) {
            this.Saldo += monto;
            System.out.println("Cargo realizado con exito. Nuevo saldo: " + this.Saldo);
            return true;
        } else {
            System.out.println("Error: El cargo excede el límite permitido.");
            return false;
        }
    }

    // Agregar un monto al saldo (sin verificar límite)
    public void agregar(double monto) {
        if (monto > 0) {
            this.Saldo += monto;
            System.out.println("Monto agregado exitosamente. Nuevo saldo: " + this.Saldo);
        } else {
            System.out.println("Error: El monto a agregar debe ser positivo.");
        }
    }

    // Eliminar un monto del saldo (sin verificar si el saldo es suficiente)
    public void eliminar(double monto) {
        if (monto > 0 && monto <= this.Saldo) {
            this.Saldo -= monto;
            System.out.println("Monto retiro exitosamente. Nuevo saldo: " + this.Saldo);
        } else {
            System.out.println("Error: El monto a retirar es invalido o excede el saldo disponible.");
        }
    }

    // Getters y Setters
    public String getNumTargeta() {
        return NumTargeta;
    }

    public void setNumTargeta(String NumTargeta) {
        this.NumTargeta = NumTargeta;
    }

    public double getLimite() {
        return Limite;
    }

    public void setLimite(double Limite) {
        this.Limite = Limite;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
     public void RealizarTransaccionTarjeta(String IdTransaccion, double Monto, String Tipo){
        Transaccion transaccion1 = new Transaccion(IdTransaccion, Monto,Tipo);
        transaccion1.procesarTransaccion();
        transaccion1.mostrar();
    }
}
