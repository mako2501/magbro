package mako.magbro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "KBKAK")
public class Kbkak {
	/*
	@OneToOne(fetch=FetchType.LAZY)
	private Soldier soldier;
	
	public Soldier getPerson() {
		return soldier;
	}

	public void setPerson(Soldier soldier) {
		this.soldier = soldier;
	}
	//@OneToOne(mappedBy = "kbkak")
	
	@OneToMany(mappedBy = "kbkak")
	private List<Person> listaOsob;

	public List<Person> getListaOsob() {
		return listaOsob;
	}

	public void setListaOsob(List<Person> listaOsob) {
		this.listaOsob = listaOsob;
	}
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Boolean przypisany;
	
	public Boolean getPrzypisany() {
		return przypisany;
	}

	public void setPrzypisany(Boolean przypisany) {
		this.przypisany = przypisany;
	}

	@Pattern(regexp = "[a-zA-Z]{2}[0-9]{5}")
	@NotNull
	@NotEmpty
	private String nr;
	//kilka wyrazen refularnych by w miare przypominalo realny rok
	@Pattern(regexp = "(19|20)[0-9]{2}")
	@NotNull
	@NotEmpty
	private String rok;//rok produkcji

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getRok() {
		return rok;
	}

	public void setRok(String rok) {
		this.rok = rok;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
