package jwd.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_projekat")
public class Kompanija extends BaseEntity {

	@Column
	private String naziv;

	@Column
	private String adresa;

	@Column
	private String telefon;

	@OneToMany(mappedBy = "kompanija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Automobil> automobili = new ArrayList<>();

	public Kompanija() {
		super();
	}

	public Kompanija(String naziv, String adresa, String telefon) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Automobil> getAutomobili() {
		return this.automobili;
	}

	public void setAutomobili(List<Automobil> automobili) {
		this.automobili = automobili;
	}
	
	
	/**
	 * Dodaj automobil u listu automobila te kompanije i postavi tu kompaniju tom automobilu, ako nije vec
	 * 
	 * @param automobil
	 */
	public void addAutomobil(Automobil automobil){
		this.automobili.add(automobil);
		
		if(!this.equals(automobil.getKompanija())){
			automobil.setKompanija(this);
		}
	}

}
