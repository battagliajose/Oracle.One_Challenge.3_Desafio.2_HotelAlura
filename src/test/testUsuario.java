package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import controller.UsuarioController;

import model.Usuario;

public class testUsuario {

	public static void main(String[] args) throws ParseException, IOException {
		UsuarioController usuarioController = new UsuarioController();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	 
		boolean validado = false;
		
        // Reading data
        while (validado == false) {
			System.out.print("Usuario: ");
			String usuario = reader.readLine();
			System.out.print("Clave: ");
	        String clave = reader.readLine();
	        
	        validado = usuarioController.validate(new Usuario(usuario, clave));
        }
		
		System.out.println(validado);
	}

}
