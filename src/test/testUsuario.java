package test;

import java.text.ParseException;

import controller.UsuarioController;

import model.Usuario;

public class testUsuario {

	public static void main(String[] args) throws ParseException {
		UsuarioController usuarioController = new UsuarioController();

		boolean resultado = usuarioController.validate(new Usuario("Jose", "jose"));
		
		System.out.println(resultado);
	}

}
