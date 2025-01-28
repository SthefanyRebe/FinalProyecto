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
public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;
    private double SaldoMinimo;
    private String TipoInteres;
    // constructor para crear las cuentas solicitadas
    public CuentaAhorros(double Tasaintereses, double SaldoMin, int nroCuenta, String TipoInteres, double Saldo) {
        super( Saldo);
        this.tasaInteres = Tasaintereses;
        this.SaldoMinimo = SaldoMin;
        this.TipoInteres = TipoInteres;
    }
     public CuentaAhorros(int nroCuenta, double saldo, double tasaInteres, double saldoMinimo,String TipoInteres) {
        super(nroCuenta, saldo);
        this.tasaInteres = tasaInteres;
        this.SaldoMinimo = saldoMinimo;
        this.TipoInteres= TipoInteres;
    }
    public void agregarInteres() {
        if (Saldo >= SaldoMinimo) {
            Saldo += Saldo * (tasaInteres / 100);
        } else {
            System.out.println("Saldo insuficiente para aplicar interes.");
        }
    }
    public void leer(){
        super.leer();
         Scanner lee = new Scanner(System.in);
        System.out.println("Ingrese Datos: interes- saldo- tipoInteres");
        this.tasaInteres=lee.nextDouble();
        this.SaldoMinimo=lee.nextDouble();
        this.TipoInteres=lee.next();
    }
    public void mostrar(){
        super.mostrar();
        System.out.println(this.tasaInteres+" - "+this.SaldoMinimo+" - "+this.tasaInteres);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getSaldoMinimo() {
        return SaldoMinimo;
    }

    public void setSaldoMinimo(double SaldoMinimo) {
        this.SaldoMinimo = SaldoMinimo;
    }


    public String getTipoInteres() {
        return TipoInteres;
    }

    public void setTipoInteres(String TipoInteres) {
        this.TipoInteres = TipoInteres;
    }
 
}
