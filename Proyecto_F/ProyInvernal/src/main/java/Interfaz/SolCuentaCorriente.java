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
public class SolCuentaCorriente extends javax.swing.JFrame {
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
    /**
     * Creates new form SolCuentaCorriente
     */
    public SolCuentaCorriente(index a) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 204));
        jButton2.setText("ATRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("ID");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("MOSTRAR CUENTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(72, 72, 72))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cl = jTextField1.getText();
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
        for(Cliente cliente : banco.getClientes()){
            if(cliente.getId().equals(cl)){
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
            break;
            }
        }
    // Mostrar la tabla
    archCliente.guardarClientesEnBD();
        archCuentas.guardarCuentasEnBD();
        archTarjetas.guardarTarjetasEnBD();
        archCajeros.guardarCajerosEnBD();
    this.jTable1.setModel(modelo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Listado listado=new Listado(inicio);
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SolCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolCuentaCorriente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SolCuentaCorriente(inicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
