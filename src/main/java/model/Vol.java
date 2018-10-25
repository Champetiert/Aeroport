package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vol {

	@Id
	@GeneratedValue
	private Long id;

	private String NumVol;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeAvion typeAvion;
	@Column(nullable = false)
	private Integer nombrePlace;
	@Column(nullable = false)
	private String villeDepart;
	@Column(nullable = false)
	private String villeArrivee;
	@Column(nullable = false)
	private LocalDate dateDepart;

	@OneToMany(mappedBy = "numVol")
	private List<Reservation> listReservation;

	public Vol() {
		super();
	}

	public Vol(TypeAvion typeAvion, Integer nombrePlace, String villeDepart, String villeArrivee,
			LocalDate dateDepart) {
		super();
		this.typeAvion = typeAvion;
		this.nombrePlace = nombrePlace;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = dateDepart;
		this.listReservation = new ArrayList<>();
	}

	public Vol(String numVol, TypeAvion typeAvion, Integer nombrePlace, String villeDepart, String villeArrivee,
			LocalDate dateDepart, List<Reservation> listReservation) {
		super();
		NumVol = numVol;
		this.typeAvion = typeAvion;
		this.nombrePlace = nombrePlace;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = dateDepart;
		this.listReservation = listReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumVol() {
		return NumVol;
	}

	public void setNumVol(String numVol) {
		NumVol = numVol;
	}

	public TypeAvion getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(TypeAvion typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	@Override
	public String toString() {
		return "Vol [NumVol=" + NumVol + ", typeAvion=" + typeAvion + ", nombrePlace=" + nombrePlace + ", villeDepart="
				+ villeDepart + ", villeArrivee=" + villeArrivee + ", dateDepart=" + dateDepart + "]\n";
	}

}
