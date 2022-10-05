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
	
	public void create (Reserva reserva) {
		
		String query = "INSERT INTO reservas (fechaEntrada, fechaSalida,"
				+ " valor, formaDePago) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pStm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pStm.setDate(1, reserva.getFechaEntrada());
			pStm.setDate(2, reserva.getFechaSalida());
			pStm.setInt(3, reserva.getValor());
			pStm.setString(4,reserva.getFormaDePago());
			
			pStm.executeUpdate();
			
			try (ResultSet resultSet = pStm.getGeneratedKeys()) {
				while (resultSet.next()) {
					reserva.setId(resultSet.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> read () {
		List<Reserva> reservas = new ArrayList<>();
		
		
		
		return reservas;
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
