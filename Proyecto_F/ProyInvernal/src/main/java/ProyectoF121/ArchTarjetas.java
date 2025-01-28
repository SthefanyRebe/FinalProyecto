package ProyectoF121;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArchTarjetas implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador de versión para la serialización
    private List<Cliente> clientes;
    private List<TarjetaCredito> tarjetasDeCredito;

    public ArchTarjetas(List<Cliente> clientes, List<TarjetaCredito> tarjetasDeCredito) {
        this.clientes = clientes;
        this.tarjetasDeCredito = tarjetasDeCredito;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<TarjetaCredito> getTarjetasDeCredito() {
        return tarjetasDeCredito;
    }

    public void setTarjetasDeCredito(List<TarjetaCredito> tarjetasDeCredito) {
        this.tarjetasDeCredito = tarjetasDeCredito;
    }

    //Modficar
public void modificar(String num, double limite, double saldo) {
    String sql = "UPDATE tarjetas SET limite = ?, saldo = ? WHERE num_tarjeta = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setDouble(1, limite);
        pstmt.setDouble(2, saldo);
        pstmt.setString(3, num);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    // Método para cargar tarjetas desde la base de datos
    public void cargarTarjetasDesdeBD() {
        String sql = "SELECT * FROM tarjetas";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String numTarjeta = rs.getString("num_tarjeta");
                double limite = rs.getDouble("limite");
                double saldo = rs.getDouble("saldo");
                String clienteId = rs.getString("cliente_id");

                Cliente cliente = obtenerCliente(clienteId);
                if (cliente != null) {
                    TarjetaCredito tarjeta = new TarjetaCredito(numTarjeta, limite, saldo);
                    cliente.agregarTarjeta(tarjeta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar tarjetas en la base de datos
    public void guardarTarjetasEnBD() {
        for (Cliente cliente : clientes) {
            for (TarjetaCredito tarjeta : cliente.getTarjetasDeCredito()) {
                if (!existeTarjeta(tarjeta.getNumTargeta())) {
                    tarjeta.guardarEnBD(cliente.getId());
                } else {
                    System.out.println("La tarjeta con numero " + tarjeta.getNumTargeta() + " ya existe.");
                }
            }
        }
    }

    // Método para verificar si una tarjeta ya existe en la base de datos
    public boolean existeTarjeta(String numTarjeta) {
        String sql = "SELECT COUNT(*) FROM tarjetas WHERE num_tarjeta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numTarjeta);
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
    
    // Método para guardar la lista de tarjetas en un archivo
    public void guardarEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(tarjetasDeCredito);
            System.out.println("Tarjetas guardadas en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de tarjetas desde un archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            tarjetasDeCredito = (List<TarjetaCredito>) ois.readObject();
            System.out.println("Tarjetas cargadas desde el archivo: " + nombreArchivo);
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