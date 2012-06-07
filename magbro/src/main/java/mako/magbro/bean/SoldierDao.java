package mako.magbro.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import mako.magbro.model.Soldier;
import mako.magbro.qualifier.DataRepository;

@Stateless
public class SoldierDao {

	@Inject
	@DataRepository
	private EntityManager em;

	
	public void saveSoldier(Soldier s)
	{
		em.persist(s);
	}
	@SuppressWarnings("unchecked")
	public List<Soldier> getSoldiers()
	{
		return em.createQuery("select p from Soldier p").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Soldier> getSoldiersWhosGotKbkak()
	{
		return em.createQuery("select p from Soldier p where kbkak_id!=null").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Soldier> getSoldiersBy(String what,String var)
	{
		return em.createQuery("select p from Soldier p where "+what+"="+"var").getResultList();
	}
	
	

}
