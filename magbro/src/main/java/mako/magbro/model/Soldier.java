package mako.magbro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

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
	
	
	@Pattern(regexp = "[0-9]{11}")
	private String pesel;
	
	@Size(max = 25)
	private String ojciec;
	
	
	@Range(max=100,min=16)
	private int age;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getOjciec() {
		return ojciec;
	}

	public void setOjciec(String ojciec) {
		this.ojciec = ojciec;
	}

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
