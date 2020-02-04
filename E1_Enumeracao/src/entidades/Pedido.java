package entidades;

import java.util.Date;
import entidades.enums.Status;

public class Pedido {
	private Integer id;
	private Date moment;
	private Status status;
	
	// CONSTRUTOR
	public Pedido() {
	}
	
	public Pedido(Integer id, Date moment, Status status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}
	
	// GET SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getMoment() {
		return moment;
	}
	public void setmoment(Date moment) {
		this.moment = moment;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", moment=" + moment + ", status=" + status + "]";
	}
	
}
