package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO {
	private Connection connection;
	
	public ReservaDAO (Connection connection) {
		this.connection = connection;
	}
	
	public int create (Reserva reserva) {
		
		String query = "INSERT INTO reservas (fechaEntrada, fechaSalida,"
				+ " valor, formaDePago) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pStm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pStm.setDate(1, reserva.getFechaEntrada());
			pStm.setDate(2, reserva.getFechaSalida());
			pStm.setInt(3, reserva.getValor());
			pStm.setString(4,reserva.getFormaDePago());
			
			int affectedRows = pStm.executeUpdate();
			
	        if (affectedRows == 0) {
	            throw new SQLException("Fallo la creacion de la reserva");
	        }
			
			try (ResultSet resultSet = pStm.getGeneratedKeys()) {
				while (resultSet.next()) {
					reserva.setId(resultSet.getInt(1));
				}
			}
			
			return reserva.getId();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> read () {
		String query = "SELECT id, fechaEntrada, fechaSalida, valor, formaDePago FROM reservas";
		try {
			final PreparedStatement statement = connection.prepareStatement(query);
			try(statement) {
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				
				List<Reserva> reservas = new ArrayList<>();
				
				while(resultSet.next()) {
					Reserva reserva = new Reserva(resultSet.getInt("id"),
							resultSet.getDate("fechaEntrada"),
							resultSet.getDate("fechaSalida"),
							resultSet.getInt("valor"),
							resultSet.getString("formaDePago"));
					
					reservas.add(reserva);
				}
				return reservas;
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete (int id) {
		String query = "DELETE FROM reservas WHERE id = ?";
		
		try (PreparedStatement pStm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pStm.setInt(1, id);
						
			pStm.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
