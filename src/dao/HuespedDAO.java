package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Huesped;
import model.Reserva;

public class HuespedDAO {
	private Connection connection;
	
	public HuespedDAO (Connection connection) {
		this.connection = connection;
	}
	
	public Integer create (Huesped huesped) {
		
		String query = "INSERT INTO huespedes (nombre, apellido,"
				+ " fechaNacimiento, nacionalidad, telefono, idReserva) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement pStm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pStm.setString(1, huesped.getNombre());
			pStm.setString(2, huesped.getApellido());
			pStm.setDate(3, huesped.getFechaNacimiento());
			pStm.setString(4,huesped.getNacionalidad());
			pStm.setString(5,huesped.getTelefono());
			pStm.setInt(6,huesped.getIdReserva());
			
			int affectedRows = pStm.executeUpdate();
			
	        if (affectedRows == 0) {
	            throw new SQLException("Fallo la creacion del Huesped");
	        }
			
			try (ResultSet resultSet = pStm.getGeneratedKeys()) {
				while (resultSet.next()) {
					huesped.setId(resultSet.getInt(1));
				}
				return huesped.getId();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> read () {
		List<Huesped> huespedes = new ArrayList<>();
		
		
		
		return huespedes;
	}
	
	public void delete (int id) {
		String query = "DELETE FROM huesped WHERE id = ?";
		
		try (PreparedStatement pStm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pStm.setInt(1, id);
						
			pStm.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huesped> read(String filter) {
		String query = "SELECT id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva FROM huespedes WHERE id LIKE ? OR nombre LIKE ? or apellido LIKE ?";
		try {
			final PreparedStatement statement = connection.prepareStatement(query);
			try(statement) {
;
				statement.setString(1, "%" + filter + "%");
				statement.setString(2, "%" + filter + "%");
				statement.setString(3, "%" + filter + "%");
				
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				
				List<Huesped> huespedes = new ArrayList<>();
				
				while(resultSet.next()) {
					Huesped huesped = new Huesped(
							resultSet.getInt("id"),
							resultSet.getString("nombre"),
							resultSet.getString("apellido"),
							resultSet.getDate("fechaNacimiento"),
							resultSet.getString("nacionalidad"),
							resultSet.getString("telefono"),
							resultSet.getInt("idReserva")
							);
					
					huespedes.add(huesped);
				}
				return huespedes;
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
	
