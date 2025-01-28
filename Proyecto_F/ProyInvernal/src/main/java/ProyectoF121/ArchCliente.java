package ProyectoF121;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArchCliente implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador de versión para la serialización
    private List<Cliente> clientes;

    public ArchCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Método para cargar clientes desde la base de datos
    public void cargarClientesDesdeBD() {
        String sql = "SELECT * FROM clientes";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("id");
                String direccion = rs.getString("direccion");

                Cliente cliente = new Cliente(id, direccion);
                this.clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar clientes en la base de datos
    public void guardarClientesEnBD() {
        String sql = "INSERT INTO clientes (id, direccion) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Cliente cliente : clientes) {
                if (!existeCliente(cliente.getId())) {
                    pstmt.setString(1, cliente.getId());
                    pstmt.setString(2, cliente.getDireccion());
                    pstmt.executeUpdate();
                } else {
                    System.out.println("El cliente con ID " + cliente.getId() + " ya existe.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si un cliente ya existe en la base de datos
    public boolean existeCliente(String id) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para guardar la lista de clientes en un archivo
    public void guardarEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(clientes);
            System.out.println("Clientes guardados en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de clientes desde un archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            clientes = (List<Cliente>) ois.readObject();
            System.out.println("Clientes cargados desde el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}