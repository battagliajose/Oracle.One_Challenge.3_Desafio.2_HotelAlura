package model;

import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int valor;
	private String formaDePago;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, int valor, String formaDePago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}
	
	public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, int valor, String formaDePago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public int getValor() {
		return valor;
	}
	
	public String getFormaDePago() {
		return formaDePago;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getFechaEntrada().toString() + " - " + this.getFechaSalida().toString() + " - " + this.getValor(); 
	}
	
}
