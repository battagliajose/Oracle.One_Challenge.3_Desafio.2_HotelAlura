package controller;

import java.sql.Connection;
import java.util.List;

import dao.HuespedDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Huesped;

public class HuespedController {
	
	private HuespedDAO huespedDAO;
	
	public HuespedController() {

		Connection con = new ConnectionFactory().getConexion();
		this.huespedDAO = new HuespedDAO(con);
	}
	
	public Integer create(Huesped huesped) {
		return huespedDAO.create(huesped);
	}
	
	public void delete(int id) {
		huespedDAO.delete(id);
	}

	public List<Huesped> read(String text) {
		return huespedDAO.read(text);
	}
}
