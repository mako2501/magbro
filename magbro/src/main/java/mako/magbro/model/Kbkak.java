package mako.magbro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="KBKAK")
public class Kbkak {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Soldier soldier= new Soldier();
	
	@Size(max = 7)
	@NotNull
	@NotEmpty
	private String nr;
	
	@Size(max = 4)
	@NotNull
	@NotEmpty
	private String rok;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	/*
	@ManyToOne
    @JoinColumn(name="SOLD_ID", nullable=false)
    public Soldier getCustomer() { return soldier; }
    */
}
