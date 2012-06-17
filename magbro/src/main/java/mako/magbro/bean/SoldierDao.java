package mako.magbro.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

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
	
	/*Id przechowuje id zolnierza ktory ma byc modyfikowany, poniewaz przy robieniu
	 * update na formularzu stary id byl nullowany i nie moglem tutaj odwolac sie do
	 * soldiera z bazy przez id, dlatego w beanie przy wywolywaniu formularza details
	 * wysylam id zolnierza do jego DAO czyli tutaj
	 */
	private int IdOfEditingSoldier;
	

	public int getId() {
		return IdOfEditingSoldier;
	}


	public void setId(int id) {
		IdOfEditingSoldier = id;
	}


	public void saveSoldier(Soldier s)
	{
		em.persist(s);
	}
	
	
	public void saveSoldierToShow(Soldier s)
	{
		Soldier old = em.find(Soldier.class,IdOfEditingSoldier);
		
		/*
		 * wykonuje update danych
		 */
		old.setFirstName(s.getFirstName());
		old.setLastName(s.getLastName());
		old.setAge(s.getAge());
		old.setOjciec(s.getOjciec());
		old.setPesel(s.getPesel());
		old.setRank(s.getRank());
		
		em.persist(old);
		
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
