package Interfaz;
import ProyectoF121.*;
import java.util.ArrayList;
import java.util.List;

public class index extends javax.swing.JFrame {
    private Banco banco = new Banco("Banco Central");
    List<Cliente> clientes = new ArrayList<>();
        List<CuentaBancaria> cuentas = new ArrayList<>();
        List<TarjetaCredito> tarjetasDeCredito = new ArrayList<>();
        List<Cajeros> cajeros = new ArrayList<>();
        // Crear instancias de las clases Arch
        ArchCliente archCliente = new ArchCliente(clientes);
        ArchCuentas archCuentas = new ArchCuentas(cuentas, clientes);
        ArchTarjetas archTarjetas = new ArchTarjetas(clientes, tarjetasDeCredito);
        ArchCajeros archCajeros = new ArchCajeros(cajeros);
        
        // Crear Clientes
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
    
    
    /**
     * Creates new form index
     */
    public index() {
        // agregar cuentas 
       

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("BIENVENIDO AL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("BANCO CENTRAL DE BOLIVIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Listado listado=new Listado(this);
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
