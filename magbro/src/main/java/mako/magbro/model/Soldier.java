package mako.magbro.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SOLDIERS")
public class Soldier {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
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
	

	@Size(max = 20)
	@NotNull
	@NotEmpty
	private String rank;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Kbkak kbkak;
	
	public Kbkak getKbkak() {
		return kbkak;
	}

	public void setKbkak(Kbkak kbkak) {
		this.kbkak = kbkak;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
}
