package ProyectoF121;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador de versión para la serialización
     private String id;
    private String direccion;
    private CuentaCorriente corriente;
    private CuentaAhorros ahorros;
    private CuentaBancaria cuentaB;
    private List<CuentaBancaria> cuentas;
    private List<TarjetaCredito> tarjetasDeCredito;

    public Cliente(String id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
        this.tarjetasDeCredito = new ArrayList<>();
    }
    public void CrearCuentaCorriente(int n, double saldo, double lim){
        CuentaCorriente c= new CuentaCorriente(n,saldo,lim);
        agregarCuenta(c);  
    }
    public void CrearCuentaAhorros(int nro,double saldo, double tasain, double salm, String tipo){
           CuentaAhorros ah= new CuentaAhorros(nro,saldo,tasain,salm,tipo);
           agregarCuenta(ah);
    }
    public void ObtenerTarjeta(String nro, double limite, double saldo){
         TarjetaCredito tarjeta = new TarjetaCredito(nro, limite, saldo);
         agregarTarjeta(tarjeta);
         
    }
    public void ClienteadiCuenta() {
        this.cuentas = new ArrayList<>();
        this.tarjetasDeCredito = new ArrayList<>();
        Scanner lee = new Scanner(System.in);
        //hacer
        
        System.out.println("tendra cuentaCorriente s/n");
        String resp = lee.next();
	if(resp.equals("s")) {
                    CuentaCorriente c= new CuentaCorriente(0,0,0);
                    c.leer();  
                    agregarCuenta(c);   
	}
         System.out.println("tendra cuenta de Ahorros s/n");
         String respu = lee.next();
	 if(respu.equals("s")) {
                    CuentaAhorros ah= new CuentaAhorros(0,0,0,0,"");
                    ah.leer();  
                    agregarCuenta(ah);   
	}

    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }
    public void agregarTarjeta(TarjetaCredito tar){
        tarjetasDeCredito.add(tar);
    }
    public void eliminarCuenta(int  numeroCuenta) {
        cuentas.removeIf(cuenta -> cuenta.getNroCuenta()== numeroCuenta);
    }
    
    public void mostrar() {
        System.out.println("Cliente ID: " + id);
        System.out.println("Direccion: " + direccion);
        System.out.println("Cuentas:");
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.mostrar();
        }
         
        System.out.println("Tarjetas de Credito:");
        for(TarjetaCredito credito : tarjetasDeCredito ){
             credito.mostrar();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public CuentaCorriente getCorriente() {
        return corriente;
    }

    public void setCorriente(CuentaCorriente corriente) {
        this.corriente = corriente;
    }

    public CuentaAhorros getAhorros() {
        return ahorros;
    }

    public void setAhorros(CuentaAhorros ahorros) {
        this.ahorros = ahorros;
    }

    public CuentaBancaria getCuentaB() {
        return cuentaB;
    }

    public void setCuentaB(CuentaBancaria cuentaB) {
        this.cuentaB = cuentaB;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public List<TarjetaCredito> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    public void setTarjetasDeCredito(List<TarjetaCredito> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }
    public void AccionesTarjeta(String cuenta, String accion){
        int sw=0;
        System.out.println(tarjetasDeCredito.size());
        for (int i = 0; i < tarjetasDeCredito.size(); i++) {
            TarjetaCredito tarjeta= new TarjetaCredito("",0,0);
             tarjeta=tarjetasDeCredito.get(i);
            if(tarjeta.getNumTargeta()==cuenta){
                System.out.println("su tarjeta fue encontrada");
                sw=1;
                if(accion.equals("realizarPago")){
                    tarjeta.realizarPago(200.0);
                    tarjeta.mostrar();
                }
                if(accion.equals("agregarSaldo")){
                    tarjeta.agregar(300.0);
                    tarjeta.mostrar();
                }
                 if(accion.equals("retiro")){
                    tarjeta.eliminar(100.0);
                    tarjeta.mostrar();
                }
                 if(accion.equals("transaccion")){
                  Transaccion("a",tarjeta);
                }
            }
        }
        if(sw==0){
             System.out.println("su tarjeta no fue encontrada");
        }
    }
    public void Transaccion(String x, TarjetaCredito t){
        if(x.equals("a")){
           t.RealizarTransaccionTarjeta("H234",100, "privado");
        }
    }
} 
