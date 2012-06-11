package mako.magbro.bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import mako.magbro.model.Kbkak;
import mako.magbro.model.Soldier;
import mako.magbro.qualifier.DataRepository;


/*
 * klasa odpowiedzialna za przypisywanie sprzetom zolnierzy i odwrotnie
 */

@Stateless
public class AscriptionManager {

	
	@Inject
	@DataRepository
	private EntityManager em;
	
	Kbkak kbkakToAscript;
	Soldier soldierToAscript;
	
	public Soldier getSoldierToAscript() {
		return soldierToAscript;
	}


	public void setSoldierToAscript(Soldier soldierToAscript) {
		this.soldierToAscript = soldierToAscript;
	}


	public Kbkak getKbkakToAscript() {
		return kbkakToAscript;
	}


	public void setKbkakToAscript(Kbkak kbkakToAscript) {
		this.kbkakToAscript = kbkakToAscript;
	}


	public void giveKbkakToSoldier(Soldier s)
	{
		
		s = em.find(Soldier.class, s.getId());//wybieram na razie pierwszego zolnierza
		s.setKbkak(kbkakToAscript);//i przydzielam zolniezowi wybrany kbkak
		kbkakToAscript = em.find(Kbkak.class, kbkakToAscript.getId());//wybieram kalacha z bazy po id
		kbkakToAscript.setSoldier(s);// i dodaje mu zolnierza
		em.persist(kbkakToAscript);
		em.persist(s);
		kbkakToAscript=null;
		soldierToAscript=null;
		
	}
	public void giveKbkakToSoldier(Kbkak k)
	{
		
		soldierToAscript = em.find(Soldier.class, soldierToAscript.getId());//wybieram na razie pierwszego zolnierza
		k = em.find(Kbkak.class, k.getId());//wybieram kalacha z bazy po id
		soldierToAscript.setKbkak(k);//i przydzielam zolniezowi wybrany kbkak
		k.setSoldier(soldierToAscript);// i dodaje mu zolnierza
		em.persist(k);
		em.persist(soldierToAscript);
		kbkakToAscript=null;
		soldierToAscript=null;
		
	}
/*
 * zdjecie kbkak z soldier i viceversa po przekazaniu kbkak
 */
	public void zdejmijKbkak(Kbkak k) {
		//pobieram z bazy kbk
		k = em.find(Kbkak.class, k.getId());
		//szukam zolnierza po jego id z kbkak
		Soldier s = em.find(Soldier.class, k.getSoldier().getId());
		
		//teraz mam kbkak i moge mu skasowac zolnierza
		k.setSoldier(null);//kasuje mu zolnierza
		em.persist(k);
		//to samo robie z kbk
		s.setKbkak(null);
		em.persist(s);	
	}

/*
 * metoda dziala tj. zdejmijKbkak(Kbkak k)
 */
	public void zdejmijKbkakWSoldier(Soldier s) {
		s = em.find(Soldier.class, s.getId());
		Kbkak k = em.find(Kbkak.class, s.getKbkak().getId());
		
		s.setKbkak(null);
		k.setSoldier(null);
		em.persist(s);
		em.persist(k);
		
	}
}
