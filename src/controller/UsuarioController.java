package controller;

import java.sql.Connection;

import dao.UsuarioDAO;
import factory.ConnectionFactory;
import model.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {

		Connection con = new ConnectionFactory().getConexion();
		this.usuarioDAO = new UsuarioDAO(con);
		
	}
	
	public boolean validate(Usuario usuario) {
		return usuarioDAO.validate(usuario);
	}
	
}
