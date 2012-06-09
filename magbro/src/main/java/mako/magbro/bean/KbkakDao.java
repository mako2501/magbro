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
	
	public void deleteKbkak(Kbkak k)
	{
		//znajduje element klasy Kbkak po jego polu id i zwraca go
		k = em.find(Kbkak.class, k.getId());
		em.remove(k);
	}
	
}
