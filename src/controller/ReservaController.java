package controller;

import java.sql.Connection;
import java.util.List;

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
	
	public List<Reserva> read() {
		return reservaDAO.read();
	}
	
	public List<Reserva> read(String filter) {
		return reservaDAO.read(filter);
	}
	
	public void delete(int id) {
		reservaDAO.delete(id);
	}

	public int update(Reserva reserva) {
		return reservaDAO.update(reserva);
	}
}
