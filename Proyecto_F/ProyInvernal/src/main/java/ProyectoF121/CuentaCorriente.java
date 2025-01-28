/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoF121;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    // constructor para crear las cunetas solicitadas
    public CuentaCorriente(double saldo,double limiteSobregiro){
        super(saldo);
        this.limiteSobregiro= limiteSobregiro;
    }

    public CuentaCorriente( int nrocuenta,double saldo, double limiteSobregiro) {
        super(nrocuenta,saldo);
        this.limiteSobregiro = limiteSobregiro;
    }
    public void leer(){
        super.leer();
         Scanner lee = new Scanner(System.in);
        System.out.println("Ingrese Datos de su cuenta: limiteSobregiro");
        this.limiteSobregiro=lee.nextInt();
    }
    public boolean verificarSobregiro(double monto) {
        return monto <= Saldo + limiteSobregiro;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("Limite de Sobregiro: " + limiteSobregiro);
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }
 public void retirar(double monto) {
    if (monto > 0 && monto <= this.Saldo) {
        this.Saldo -= monto;
        System.out.println("Retiro de " + monto + " realizado. Nuevo saldo: " + this.Saldo);
    } else {
        System.out.println("Error: Monto inválido o saldo insuficiente.");
    }
}
}
