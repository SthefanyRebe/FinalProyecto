package ProyectoF121;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArchCuentas implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador de versión para la serialización
    private List<CuentaBancaria> cuentas;
    private List<Cliente> clientes;

    public ArchCuentas(List<CuentaBancaria> cuentas, List<Cliente> clientes) {
        this.cuentas = cuentas;
        this.clientes = clientes;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    //modificar
    public void modificar(int nroCuenta, double saldo) {
        String sql = "UPDATE cuentas SET saldo = ? WHERE nro_cuenta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, saldo);
            pstmt.setInt(2, nroCuenta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar cuentas desde la base de datos
    public void cargarCuentasDesdeBD() {
        String sql = "SELECT * FROM cuentas";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int nroCuenta = rs.getInt("nro_cuenta");
                double saldo = rs.getDouble("saldo");
                String tipo = rs.getString("tipo");
                String clienteId = rs.getString("cliente_id");

                Cliente cliente = obtenerCliente(clienteId);
                if (cliente != null) {
                    if (tipo.equals("ahorro")) {
                        double tasaInteres = rs.getDouble("tasa_interes");
                        double saldoMinimo = rs.getDouble("saldo_minimo");
                        CuentaAhorros cuenta = new CuentaAhorros(nroCuenta, saldo, tasaInteres, saldoMinimo, "laboral");
                        cliente.agregarCuenta(cuenta);
                    } else if (tipo.equals("corriente")) {
                        double limiteSobregiro = rs.getDouble("limite_sobregiro");
                        CuentaCorriente cuenta = new CuentaCorriente(nroCuenta, saldo, limiteSobregiro);
                        cliente.agregarCuenta(cuenta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar cuentas en la base de datos
    public void guardarCuentasEnBD() {
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                for (CuentaBancaria cuenta : cliente.getCuentas()) {
                    if (!existeCuenta(cuenta.getNroCuenta())) {
                        cuenta.guardarEnBD(cliente.getId());
                    } else {
                        System.out.println("La cuenta con numero " + cuenta.getNroCuenta() + " ya existe.");
                    }
                }
            }
        } else {
            System.out.println("Error: La lista de clientes es null.");
        }
    }

    // Método para verificar si una cuenta ya existe en la base de datos
    public boolean existeCuenta(int nroCuenta) {
        String sql = "SELECT COUNT(*) FROM cuentas WHERE nro_cuenta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nroCuenta);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
  //PERSISTENCIA
    
    // Método para guardar la lista de cuentas en un archivo
    public void guardarEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(cuentas);
            System.out.println("Cuentas guardadas en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de cuentas desde un archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            cuentas = (List<CuentaBancaria>) ois.readObject();
            System.out.println("Cuentas cargadas desde el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}