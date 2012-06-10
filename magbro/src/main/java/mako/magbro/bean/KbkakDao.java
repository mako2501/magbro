package mako.magbro.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import mako.magbro.model.Kbkak;
import mako.magbro.model.Soldier;
import mako.magbro.qualifier.DataRepository;

@Stateless
public class KbkakDao {

	@Inject
	@DataRepository
	private EntityManager em;
	
	public void saveKbkak(Kbkak k)
	{
		em.persist(k);
	}
	
	@SuppressWarnings("unchecked")
	public List<Soldier> getKalachs()
	{
		//;D nazwa metody duzo mowi
		return em.createQuery("select p from Kbkak p").getResultList();
		//return em.createQuery("soldiers.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Soldier> getPrzypisaneKbkak()
	{
		return em.createQuery("from Kbkak k left join fetch k.soldier where soldier_id!=null").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Soldier> getNiePrzypisaneKbkak()
	{
		return em.createQuery("from Kbkak k where soldier_id=null").getResultList();
	}

	public void deleteKbkak(Kbkak k)
	{
		//znajduje element klasy Kbkak po jego polu id i zwraca go
		k = em.find(Kbkak.class, k.getId());
		em.remove(k);
	}
	
	/*
	 * zrobilem nowa klase ascription i tam jest ta metoda
	public void giveKbkakToSoldier(Kbkak k)
	{
		
		Soldier s = em.find(Soldier.class, 1);//wybieram na razie pierwszego zolnierza
		s.setKbkak(k);//i przydzielam zolniezowi wybrany kbkak
		k = em.find(Kbkak.class, k.getId());//wybieram kalacha z bazy po id
		k.setSoldier(s);// i dodaje mu zolnierza
		em.persist(k);
		em.persist(s);
		
	}
	*/
}
