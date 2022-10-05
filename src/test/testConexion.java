package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import controller.ReservaController;

import java.sql.Date;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class testConexion {

	public static void main(String[] args) throws ParseException {
		ReservaController reservasController = new ReservaController();

		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fechaEntrada = new java.sql.Date(df.parse("03-01-2023").getTime());
		Date fechaSalida = new java.sql.Date(df.parse("15-01-2023").getTime());
		
		reservasController.create(new Reserva(fechaEntrada, fechaSalida, 1500, "Efectivo"));
		
		//reservasController.delete(4);

	}

}
