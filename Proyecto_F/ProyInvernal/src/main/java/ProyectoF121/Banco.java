/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoF121;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Banco {
        private String nombre;
    private List<Cliente> clientes;
    private List<CuentaBancaria> cuentas;
    private List<TarjetaCredito> tarjetasDeCredito;
    private List<Cajeros> cajeros;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.tarjetasDeCredito = new ArrayList<>();
        this.cajeros = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public Cliente obtenerCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public CuentaBancaria obtenerCuenta(int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNroCuenta()== numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public void mostrar() {
        System.out.println("Banco: " + nombre);
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            cliente.mostrar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
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

    public List<Cajeros> getCajeros() {
        return cajeros;
    }

    public void setCajeros(List<Cajeros> cajeros) {
        this.cajeros = cajeros;
    }
    // metodo añadir
    public void SolicitudCuentaA(String cliente) {
        int sw=0;
         for (int i = 0; i < this.clientes.size(); i++) {
            Cliente c= clientes.get(i);
                if(c.getId()== cliente){
                    sw=1;
                    System.out.println("la solicitud fue aceptada");
                    CuentaAhorros cuenta= new CuentaAhorros(3400,10,324,392,"privado");
                    c.getCuentas().add(cuenta);
                     System.out.println("-----------------");
                     c.mostrar();
             }
        }
         if(sw==0){
             System.out.println("no fue encontrado su id ");
         }
     }

    public void SolicitudCuentaC(String cliente) {
       int sw=0;
         for (int i = 0; i < this.clientes.size(); i++) {
            Cliente c= clientes.get(i);
                if(c.getId()== cliente){
                    sw=1;
                    System.out.println("la solicitud fue aceptada");
                    CuentaCorriente cuenta= new CuentaCorriente(3400,10);
                    c.getCuentas().add(cuenta);
                     System.out.println("-----------------");
                     c.mostrar();
             }
        }
         if(sw==0){
             System.out.println("no fue encontrado su id ");
         }
    }
}
