package mako.magbro.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "KBKAK")
public class Kbkak {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Soldier soldier;
	
	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
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
