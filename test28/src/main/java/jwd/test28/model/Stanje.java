package jwd.test28.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_stanje")
public class Stanje extends BaseEntity {

	@Column
	private String naziv;

	@OneToMany(mappedBy = "stanje", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Zadatak> zadaci = new ArrayList<>();
}
