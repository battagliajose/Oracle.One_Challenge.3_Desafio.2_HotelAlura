package controller;

import java.sql.Connection;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaController {
	
	private ReservaDAO reservaDAO;
	
	public ReservaController() {

		Connection con = new ConnectionFactory().getConexion();
		this.reservaDAO = new ReservaDAO(con);
		
	}
	
	public int create(Reserva reserva) {
		return reservaDAO.create(reserva);
	}
	
	public void delete(int id) {
		reservaDAO.delete(id);
	}
}
