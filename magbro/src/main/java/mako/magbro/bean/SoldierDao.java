package mako.magbro.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import mako.magbro.model.Soldier;
import mako.magbro.qualifier.DataRepository;

@Stateless
public class SoldierDao {
/*
 * zapytanie o zolnierzy ktorzy maja kbkak i zwrot numerow 
 * SELECT firstname,nr from soldiers  left join kbkak k on soldiers.kbkak_id=k.id where kbkak_id!=0
 */
	
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
		//return em.createQuery("select p from Soldier p where kbkak_id!=null").getResultList();
		return em.createQuery("from Soldier s left join fetch s.kbkak where kbkak_id!=null").getResultList();
	}
	@SuppressWarnings("unchecked")
	public Object getSoldiersWithoutKbkak() {
		
		return em.createQuery("from Soldier s where kbkak_id=null").getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Soldier> getSoldiersBy(String what,String var)
	{
		return em.createQuery("select p from Soldier p where "+what+"="+"var").getResultList();
		
	}
	public void deleteSoldier(Soldier soldierToDelete) {
		soldierToDelete = em.find(Soldier.class, soldierToDelete.getId());
		if(soldierToDelete.getKbkak()!=null)soldierToDelete.setKbkak(null);
		em.remove(soldierToDelete);
	}
	
	
	

}
