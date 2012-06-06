package mako.magbro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import mako.magbro.model.Kbkak;

@Entity
@Table(name="SOLDIERS")

public class Soldier {

	//private List<Kbkak> kbkakList = new ArrayList<Kbkak>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 25)
	@Size(max = 25)
	@NotNull
	@NotEmpty
	private String firstName;
	
	@Column(length = 25)
	@Size(max = 25)
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	@NotEmpty
	private String rank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Kbkak> getKbkakList() {
		return kbkakList;
	}

	public void setKbkakList(List<Kbkak> kbkakList) {
		this.kbkakList = kbkakList;
	}
*/	
}
