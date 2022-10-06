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
		
		String query = "SELECT usuario, clave FROM usuarios where usuario = ?";
		String clave = "";
		
		try (PreparedStatement pStm = connection.prepareStatement(query)){
			pStm.setString(1, usuario.getNombre());
			
			pStm.execute();
			
			try (ResultSet resultSet = pStm.getResultSet()) {
				while(resultSet.next()) {
					clave = (resultSet.getString(2));
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("[" + usuario.getClave() +"]");
		System.out.println("[" + clave +"]");
		
		return (clave == usuario.getClave());
	}
	
}
