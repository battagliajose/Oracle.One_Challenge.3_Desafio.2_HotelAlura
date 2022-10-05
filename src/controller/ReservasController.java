package controller;

import java.sql.Connection;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservasController {
	
	private ReservaDAO reservaDAO;
	
	public ReservasController() {

		Connection con = new ConnectionFactory().getConexion();
		this.reservaDAO = new ReservaDAO(con);
		
	}
	
	public void create(Reserva reserva) {
		reservaDAO.create(reserva);
	}
	
	public void delete(int id) {
		reservaDAO.delete(id);
	}
}
