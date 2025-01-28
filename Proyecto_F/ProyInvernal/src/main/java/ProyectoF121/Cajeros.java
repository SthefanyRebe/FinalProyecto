/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoF121;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class Cajeros implements Serializable{
     private static final long serialVersionUID = 1L; 
    private String Ubicacion;
    private String idCajero;
    private double EfectivoDisponoble;

    public Cajeros(String Ubicacion, String idCajero, double EfectivoDisponoble) {
        this.Ubicacion = Ubicacion;
        this.idCajero = idCajero;
        this.EfectivoDisponoble = EfectivoDisponoble;
    }
    // Método para guardar el cajero en la base de datos
    public void guardarEnBD() {
        String sql = "INSERT INTO cajeros (id_cajero, ubicacion, efectivo_disponible) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.idCajero);
            pstmt.setString(2, this.Ubicacion);
            pstmt.setDouble(3, this.EfectivoDisponoble);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void consultarSaldo(CuentaBancaria cuenta) {
    System.out.println("Saldo de la cuenta " + cuenta.getNroCuenta() + ": " + cuenta.getSaldo());
}
    public void dispensarEfectivo(double monto) {
    if (monto > 0 && monto <= this.EfectivoDisponoble) {
        this.EfectivoDisponoble -= monto;
        System.out.println("Efectivo dispensado: " + monto);
        System.out.println("Efectivo restante en cajero: " + this.EfectivoDisponoble);
    } else {
        System.out.println("Error: Monto inválido o efectivo insuficiente.");
    }
}
    public void mostrar(){
        System.out.println(this.Ubicacion+this.idCajero+this.EfectivoDisponoble);
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(String idCajero) {
        this.idCajero = idCajero;
    }

    public double getEfectivoDisponoble() {
        return EfectivoDisponoble;
    }

    public void setEfectivoDisponoble(double EfectivoDisponoble) {
        this.EfectivoDisponoble = EfectivoDisponoble;
    }
    
}
