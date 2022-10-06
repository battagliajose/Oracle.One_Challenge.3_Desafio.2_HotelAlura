package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

import controller.ReservaController;
import controller.UsuarioController;
import model.Reserva;
import model.Usuario;

public class testReadReservas {

	public static void main(String[] args) throws ParseException, IOException {
		ReservaController reservaController = new ReservaController();
		
		List<Reserva> reservas = reservaController.read();
				
		System.out.println(reservas);
	}

}
