package jwd.test28.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_zadatak")
public class Zadatak extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String naziv;

	@Column(nullable = false)
	private String zaduzeni;

	@Column(name = "procenjeno_sati")
	private Integer procenjenoSati;

	@Column
	private String opis;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Projekat projekat;

	@ManyToOne(fetch = FetchType.EAGER)
	private Stanje stanje;

}
