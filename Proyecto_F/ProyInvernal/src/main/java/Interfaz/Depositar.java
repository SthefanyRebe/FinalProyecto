
package Interfaz;
import ProyectoF121.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Depositar extends javax.swing.JFrame {
    /**
     * Creates new form Depositar
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
    public Depositar(index a) {
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
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------", "Cuenta Ahorros", "Cuenta Corriente", " " }));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Realizar deposito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(0, 204, 204));
        jButton2.setText("ATRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(0, 204, 204));
        jButton3.setText("Realizar Retiro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("ID CLIENTE");

        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("MONTO");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("RETIRO Y DEPOSITO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        String cl = jTextField1.getText();
        double saldo = Double.parseDouble(jTextField2.getText());
        String tipocuenta = (String) jComboBox1.getSelectedItem();
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
        int cont=0;
        for(Cliente cliente : banco.getClientes()){
            if(cliente.getId().equals(cl)){
                modelo.addRow(new Object[] {"Cliente ID: " + cliente.getId()});
            modelo.addRow(new Object[] {"Direccion: " + cliente.getDireccion()});

            // Agregar información de cuentas
            modelo.addRow(new Object[] {"Cuentas:"});
            for (CuentaBancaria cuenta : cliente.getCuentas()) {
                cont++;
                if(cont==1 && tipocuenta.equals("Cuenta Ahorros")){
                    modelo.addRow(new Object[] {"Saldo anterior: " + cuenta.getSaldo()});
                    modelo.addRow(new Object[] {"Saldo Actual: " + (cuenta.getSaldo()+saldo)});
                    archCuentas.modificar(cuenta.getNroCuenta(),(cuenta.getSaldo()+saldo));
                }
                if(cont==2 && tipocuenta.equals("Cuenta Corriente")){
                    modelo.addRow(new Object[] {"Saldo anterior: " + cuenta.getSaldo()});
                    modelo.addRow(new Object[] {"Saldo Actual: " + (cuenta.getSaldo()+saldo)});
                    archCuentas.modificar(cuenta.getNroCuenta(),(cuenta.getSaldo()+saldo));
                }
            }
            break;
            }
        }
    // Mostrar la tabla
    this.jTable1.setModel(modelo);
    archCliente.guardarClientesEnBD();
        archCuentas.guardarCuentasEnBD();
        archTarjetas.guardarTarjetasEnBD();
        archCajeros.guardarCajerosEnBD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Listado listado=new Listado(inicio);
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String cl = jTextField1.getText();
        double saldo = Double.parseDouble(jTextField2.getText());
        String tipocuenta = (String) jComboBox1.getSelectedItem();
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
        int cont=0;
        for(Cliente cliente : banco.getClientes()){
            if(cliente.getId().equals(cl)){
                modelo.addRow(new Object[] {"Cliente ID: " + cliente.getId()});
            modelo.addRow(new Object[] {"Direccion: " + cliente.getDireccion()});

            // Agregar información de cuentas
            modelo.addRow(new Object[] {"Cuentas:"});
            for (CuentaBancaria cuenta : cliente.getCuentas()) {
                cont++;
                if(cont==1 && tipocuenta.equals("Cuenta Ahorros")){
                    modelo.addRow(new Object[] {"Saldo anterior: " + cuenta.getSaldo()});
                    modelo.addRow(new Object[] {"Saldo Actual: " + (cuenta.getSaldo()-saldo)});
                    archCuentas.modificar(cuenta.getNroCuenta(),(cuenta.getSaldo()-saldo));
                }
                if(cont==2 && tipocuenta.equals("Cuenta Corriente")){
                    modelo.addRow(new Object[] {"Saldo anterior: " + cuenta.getSaldo()});
                    modelo.addRow(new Object[] {"Saldo Actual: " + (cuenta.getSaldo()-saldo)});
                    archCuentas.modificar(cuenta.getNroCuenta(),(cuenta.getSaldo()-saldo));
                }
            }
            break;
            }
        }
    // Mostrar la tabla
    this.jTable1.setModel(modelo);
    archCliente.guardarClientesEnBD();
        archCuentas.guardarCuentasEnBD();
        archTarjetas.guardarTarjetasEnBD();
        archCajeros.guardarCajerosEnBD();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Depositar(inicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
