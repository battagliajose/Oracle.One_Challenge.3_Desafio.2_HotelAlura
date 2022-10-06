package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO (Connection connection) {
		this.connection = connection;
	}
	
	public boolean validate (Usuario usuario) {
		
		String query = "SELECT usuario, clave FROM usuarios where usuario = ? and clave = ?";
		
		try (PreparedStatement pStm = connection.prepareStatement(query)){
			pStm.setString(1, usuario.getNombre().toLowerCase());
			pStm.setString(2, usuario.getClave().toLowerCase());
			
			pStm.execute();
			
			try (ResultSet resultSet = pStm.getResultSet()) {
				while(resultSet.next()) { 
					return true;
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}
	
}
