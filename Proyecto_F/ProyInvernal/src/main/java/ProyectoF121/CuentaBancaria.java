
package ProyectoF121;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CuentaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    // Resto del código de la clase CuentaBancaria...
    protected int nroCuenta;
    protected double Saldo;
   // en este constructor se delegan cuentas aleatorias llamando la funcion random
    public CuentaBancaria(double Saldo) {
        Random dado= new Random();
        //quedamos un limite de intervalos para delegar cuentas
        int aleatorio =(dado.nextInt(10000-1000+1)+1000);
        this.Saldo = Saldo;
    }

    public CuentaBancaria(int nroCuenta, double Saldo) {
        this.nroCuenta = nroCuenta;
        this.Saldo = Saldo;
    }
    
    public void mostrar(){
        System.out.println("cuenta.- "+this.nroCuenta+ " saldo.- "+this.Saldo);
    }
    public void leer(){
        Scanner lee = new Scanner(System.in);
        System.out.println("Ingrese Datos:  NroCuenta-Saldo");
        this.nroCuenta=lee.nextInt();
        this.Saldo=lee.nextDouble();
    }
    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    // Método para guardar la cuenta en la base de datos
    public void guardarEnBD(String clienteId) {
        String sql = "INSERT INTO cuentas (nro_cuenta, saldo, tipo, tasa_interes, saldo_minimo, limite_sobregiro, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.nroCuenta);
            pstmt.setDouble(2, this.Saldo);
            pstmt.setString(3, this instanceof CuentaAhorros ? "ahorro" : "corriente");
            pstmt.setDouble(4, this instanceof CuentaAhorros ? ((CuentaAhorros) this).getTasaInteres() : 0);
            pstmt.setDouble(5, this instanceof CuentaAhorros ? ((CuentaAhorros) this).getSaldoMinimo() : 0);
            pstmt.setDouble(6, this instanceof CuentaCorriente ? ((CuentaCorriente) this).getLimiteSobregiro() : 0);
            pstmt.setString(7, clienteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void RealizarTransaccion(String IdTransaccion, Double Monto, String Tipo){
        Transaccion transaccion1 = new Transaccion(IdTransaccion, Monto,Tipo);
        transaccion1.procesarTransaccion();
        transaccion1.mostrar();
    }
        public void depositar(double monto) {
    if (monto > 0) {
        this.Saldo += monto;
        System.out.println("Deposito de " + monto + " realizado. Nuevo saldo: " + this.Saldo);
    } else {
        System.out.println("Error: El monto del depósito debe ser positivo.");
    }
}
}
