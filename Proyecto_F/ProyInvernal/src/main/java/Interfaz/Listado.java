/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;
import ProyectoF121.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author choqu
 */
public class Listado extends javax.swing.JFrame {

    /**
     * Creates new form Listado
     */
    private static index inicio;
    private Banco banco=new Banco("Banco Central");
    List<Cliente> clientes = new ArrayList<>();
        List<CuentaBancaria> cuentas = new ArrayList<>();
        List<TarjetaCredito> tarjetasDeCredito = new ArrayList<>();
        List<Cajeros> cajeros = new ArrayList<>();
        // Crear instancias de las clases Arch
        ArchCliente archCliente = new ArchCliente(clientes);
        ArchCuentas archCuentas = new ArchCuentas(cuentas, clientes);
        ArchTarjetas archTarjetas = new ArchTarjetas(clientes, tarjetasDeCredito);
        ArchCajeros archCajeros = new ArchCajeros(cajeros);
    private Cliente cliente1 = new Cliente("C001", "Calle Falsa N 123");
      private Cliente cliente2 = new Cliente("C002", "Avenida Siempre Viva N 742");
      private Cliente cliente3 = new Cliente("C003","Calle Alegria N 345");
      private Cliente cliente4 = new Cliente("C004","Avenida Arce N 324");
      private Cliente cliente5 = new Cliente("C005","San Francisco N 457");
      private Cliente cliente6 = new Cliente("C006","Otero De La Vega N 549");
      // Crear Cajeros
      private  Cajeros cajero1 = new Cajeros("Sucursal Centro", "Cajero001", 5000.0);
      private  Cajeros cajero2 = new Cajeros("Sucursal Norte", "Cajero002", 8000.0);
      private  Cajeros cajero3 = new Cajeros("Sucursal Sur", "Cajero003", 8000.0);
      private  Cajeros cajero4 = new Cajeros("Sucursal Centro", "Cajero004", 8000.0);
      private  Cajeros cajero5 = new Cajeros("Sucursal Norte", "Cajero005", 8000.0);
      private  Cajeros cajero6 = new Cajeros("Sucursal Sur", "Cajero006", 8000.0);
        
        // agregacion de las tarjetas de debito
       private TarjetaCredito tarjeta1 = new TarjetaCredito("123456789", 5000.0, 2000.0);
       private TarjetaCredito tarjeta2 = new TarjetaCredito("987654321", 3000.0, 1500.0);
       private TarjetaCredito tarjeta3 = new TarjetaCredito("555555555", 4000.0, 2500.0);
       private TarjetaCredito tarjeta4 = new TarjetaCredito("666666666", 6000.0, 3500.0);
       private TarjetaCredito tarjeta5 = new TarjetaCredito("777777777", 8000.0, 1000.0);
       private TarjetaCredito tarjeta6 = new TarjetaCredito("888888888", 9000.0, 4500.0);

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public static index getInicio() {
        return inicio;
    }

    public static void setInicio(index inicio) {
        Listado.inicio = inicio;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Cliente getCliente2() {
        return cliente2;
    }

    public void setCliente2(Cliente cliente2) {
        this.cliente2 = cliente2;
    }

    public Cliente getCliente3() {
        return cliente3;
    }

    public void setCliente3(Cliente cliente3) {
        this.cliente3 = cliente3;
    }

    public Cliente getCliente4() {
        return cliente4;
    }

    public void setCliente4(Cliente cliente4) {
        this.cliente4 = cliente4;
    }

    public Cliente getCliente5() {
        return cliente5;
    }

    public void setCliente5(Cliente cliente5) {
        this.cliente5 = cliente5;
    }

    public Cliente getCliente6() {
        return cliente6;
    }

    public void setCliente6(Cliente cliente6) {
        this.cliente6 = cliente6;
    }

    public Cajeros getCajero1() {
        return cajero1;
    }

    public void setCajero1(Cajeros cajero1) {
        this.cajero1 = cajero1;
    }

    public Cajeros getCajero2() {
        return cajero2;
    }

    public void setCajero2(Cajeros cajero2) {
        this.cajero2 = cajero2;
    }

    public Cajeros getCajero3() {
        return cajero3;
    }

    public void setCajero3(Cajeros cajero3) {
        this.cajero3 = cajero3;
    }

    public Cajeros getCajero4() {
        return cajero4;
    }

    public void setCajero4(Cajeros cajero4) {
        this.cajero4 = cajero4;
    }

    public Cajeros getCajero5() {
        return cajero5;
    }

    public void setCajero5(Cajeros cajero5) {
        this.cajero5 = cajero5;
    }

    public Cajeros getCajero6() {
        return cajero6;
    }

    public void setCajero6(Cajeros cajero6) {
        this.cajero6 = cajero6;
    }

    public TarjetaCredito getTarjeta1() {
        return tarjeta1;
    }

    public void setTarjeta1(TarjetaCredito tarjeta1) {
        this.tarjeta1 = tarjeta1;
    }

    public TarjetaCredito getTarjeta2() {
        return tarjeta2;
    }

    public void setTarjeta2(TarjetaCredito tarjeta2) {
        this.tarjeta2 = tarjeta2;
    }

    public TarjetaCredito getTarjeta3() {
        return tarjeta3;
    }

    public void setTarjeta3(TarjetaCredito tarjeta3) {
        this.tarjeta3 = tarjeta3;
    }

    public TarjetaCredito getTarjeta4() {
        return tarjeta4;
    }

    public void setTarjeta4(TarjetaCredito tarjeta4) {
        this.tarjeta4 = tarjeta4;
    }

    public TarjetaCredito getTarjeta5() {
        return tarjeta5;
    }

    public void setTarjeta5(TarjetaCredito tarjeta5) {
        this.tarjeta5 = tarjeta5;
    }

    public TarjetaCredito getTarjeta6() {
        return tarjeta6;
    }

    public void setTarjeta6(TarjetaCredito tarjeta6) {
        this.tarjeta6 = tarjeta6;
    }
    
    public Listado(index a) {
        this.inicio = a;
        banco = a.getBanco();
        // agregar cuentas 
       cliente1.CrearCuentaCorriente(123, 400, 1000);
       cliente1.CrearCuentaAhorros(5345, 100, 10, 50,"laboral");
       cliente1.ObtenerTarjeta("A1234",1000 , 3050);
       cliente1.ObtenerTarjeta("BR143", 3000, 200);
     
       cliente2.CrearCuentaAhorros(7438, 300, 5, 100,"privado");
       
       cliente3.CrearCuentaCorriente(1234, 780, 139);
       cliente3.CrearCuentaCorriente(6462, 1000, 1);
       cliente3.CrearCuentaCorriente(34589, 14522,120);
       cliente3.CrearCuentaAhorros(5345, 100, 10, 50,"laboral");
       cliente3.ObtenerTarjeta("H12658",2300 , 55);
       
       
     cliente3.ObtenerTarjeta("F785",3000, 10);
     cliente3.CrearCuentaCorriente(3748, 1439, 9);
    
     cliente3.ObtenerTarjeta("W48573",2300 , 55);
     cliente2.CrearCuentaAhorros(3548, 450, 4, 1500,"privado");
     
     cliente3.ObtenerTarjeta("Q4753",49483,378);
     // Agregar clientes y cajeros al banco
         banco.agregarCliente(cliente1);
         banco.agregarCliente(cliente2);
         banco.agregarCliente(cliente3);
         banco.agregarCliente(cliente4);
         banco.agregarCliente(cliente5);
         banco.agregarCliente(cliente6);
         
        banco.getCajeros().add(cajero1);
        banco.getCajeros().add(cajero2);
        banco.getCajeros().add(cajero3);
        banco.getCajeros().add(cajero4);
        banco.getCajeros().add(cajero5);
        banco.getCajeros().add(cajero6);
        
        banco.getTarjetasDeCredito().add(tarjeta1);
        banco.getTarjetasDeCredito().add(tarjeta2);
        banco.getTarjetasDeCredito().add(tarjeta3);
        banco.getTarjetasDeCredito().add(tarjeta4);
        banco.getTarjetasDeCredito().add(tarjeta5);
        banco.getTarjetasDeCredito().add(tarjeta6);
        banco.getTarjetasDeCredito().add(tarjeta1);
        banco.getTarjetasDeCredito().add(tarjeta2);
        banco.getTarjetasDeCredito().add(tarjeta3);
        banco.getTarjetasDeCredito().add(tarjeta4);
        banco.getTarjetasDeCredito().add(tarjeta5);
        banco.getTarjetasDeCredito().add(tarjeta6);
        archCliente.cargarClientesDesdeBD();
        archCuentas.cargarCuentasDesdeBD();
        archTarjetas.cargarTarjetasDesdeBD();
        archCajeros.cargarCajerosDesdeBD();

        // Asignar las listas cargadas al banco
        banco.setClientes(clientes);
        banco.setCuentas(cuentas);
        banco.setTarjetasDeCredito(tarjetasDeCredito);
        banco.setCajeros(cajeros);
        archCliente.guardarClientesEnBD();
        archCuentas.guardarCuentasEnBD();
        archTarjetas.guardarTarjetasEnBD();
        archCajeros.guardarCajerosEnBD();

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(0, 204, 204));
        jButton2.setText("Ejer1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(0, 204, 204));
        jButton3.setText("Ejer2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(0, 204, 204));
        jButton4.setText("Ejer3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(0, 204, 204));
        jButton5.setText("Ejer4");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(0, 204, 204));
        jButton6.setText("Ejer5");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
        // Definir los encabezados de la tabla
        String[] campos = {banco.getNombre()};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(campos);

        // Limpiar la tabla
        modelo.setRowCount(0);

        // Agregar encabezados
        modelo.addRow(new Object[] {"Clientes"});

        // Agregar información de clientes
        for (Cliente cliente : banco.getClientes()) {
            modelo.addRow(new Object[] {"Cliente ID: " + cliente.getId()});
            modelo.addRow(new Object[] {"Direccion: " + cliente.getDireccion()});

            // Agregar información de cuentas
            modelo.addRow(new Object[] {"Cuentas:"});
            for (CuentaBancaria cuenta : cliente.getCuentas()) {
                modelo.addRow(new Object[] {"Nro Cuenta: " + cuenta.getNroCuenta()});
                modelo.addRow(new Object[] {"Saldo: " + cuenta.getSaldo()});
            }

            // Agregar información de tarjetas de crédito
            modelo.addRow(new Object[] {"Tarjetas de Credito:"});
            for (TarjetaCredito credito : cliente.getTarjetasDeCredito()) {
                modelo.addRow(new Object[] {"Numero de Tarjeta: " + credito.getNumTargeta()});
                modelo.addRow(new Object[] {"Limite: " + credito.getLimite()});
                modelo.addRow(new Object[] {"Saldo: " + credito.getSaldo()});
            }
        }
    // Mostrar la tabla
    this.jTable1.setModel(modelo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SolCuentaCorriente scc = new SolCuentaCorriente(inicio);
        scc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RealizarAccion ra = new RealizarAccion(inicio);
        ra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        NuevoCliente nc = new NuevoCliente(inicio);
        nc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Depositar dep = new Depositar(inicio);
        dep.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        NuevaTarjeta nt=new NuevaTarjeta(inicio);
        nt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Listado(inicio).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
