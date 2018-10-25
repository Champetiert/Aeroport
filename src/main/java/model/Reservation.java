package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(nullable = false)
	@ManyToOne
	private Person client;
	
	//@Column(nullable = false)
	@ManyToOne
	private Vol numVol;

	public Reservation() {
		super();
	}

	public Reservation(Person client, Vol numVole) {
		super();
		this.client = client;
		this.numVol = numVole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getClient() {
		return client;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public Vol getNumVol() {
		return numVol;
	}

	public void setNumVol(Vol numVol) {
		this.numVol = numVol;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client=" + client + "]";
	}
	
	

}
