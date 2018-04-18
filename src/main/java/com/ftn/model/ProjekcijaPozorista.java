package com.ftn.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class ProjekcijaPozorista implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Predstava predstava;
	
	@Column(nullable = false)
	private float cena;
	
	//@JsonIgnore
	@ManyToOne
	private Sala sala;
	
	//@JsonIgnore
	@ManyToOne
	private Termin termin;
	
	//@JsonIgnore
	@ManyToOne(optional = false)
	@JsonBackReference(value="repertoarPozorista")
	private RepertoarPozorista repertoarPozorista;
	
	
	
	public RepertoarPozorista getRepertoarPozorista() {
		return repertoarPozorista;
	}

	public void setRepertoarPozorista(RepertoarPozorista  repertoarPozorista) {
		this.repertoarPozorista = repertoarPozorista;
	}

	public ProjekcijaPozorista() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Termin getTermin() {
		return termin;
	}

	
	

	public Predstava getPredstava() {
		return predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

}
