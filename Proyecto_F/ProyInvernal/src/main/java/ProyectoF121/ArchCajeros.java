package ProyectoF121;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArchCajeros implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador de versión para la serialización
    private List<Cajeros> cajeros;

    public ArchCajeros(List<Cajeros> cajeros) {
        this.cajeros = cajeros;
    }

    public List<Cajeros> getCajeros() {
        return cajeros;
    }

    public void setCajeros(List<Cajeros> cajeros) {
        this.cajeros = cajeros;
    }

    // Método para cargar cajeros desde la base de datos
    public void cargarCajerosDesdeBD() {
        String sql = "SELECT * FROM cajeros";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idCajero = rs.getString("id_cajero");
                String ubicacion = rs.getString("ubicacion");
                double efectivoDisponible = rs.getDouble("efectivo_disponible");

                Cajeros cajero = new Cajeros(ubicacion, idCajero, efectivoDisponible);
                this.cajeros.add(cajero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar cajeros en la base de datos
    public void guardarCajerosEnBD() {
        String sql = "INSERT INTO cajeros (id_cajero, ubicacion, efectivo_disponible) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Cajeros cajero : cajeros) {
                if (!existeCajero(cajero.getIdCajero())) {
                    pstmt.setString(1, cajero.getIdCajero());
                    pstmt.setString(2, cajero.getUbicacion());
                    pstmt.setDouble(3, cajero.getEfectivoDisponoble());
                    pstmt.executeUpdate();
                } else {
                    System.out.println("El cajero con ID " + cajero.getIdCajero() + " ya existe.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si un cajero ya existe en la base de datos
    public boolean existeCajero(String idCajero) {
        String sql = "SELECT COUNT(*) FROM cajeros WHERE id_cajero = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idCajero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para guardar la lista de cajeros en un archivo
    public void guardarEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(cajeros);
            System.out.println("Cajeros guardados en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de cajeros desde un archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            cajeros = (List<Cajeros>) ois.readObject();
            System.out.println("Cajeros cargados desde el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}