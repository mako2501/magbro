package mako.magbro.view;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import mako.magbro.bean.SoldierDao;
import mako.magbro.model.Soldier;


@Named("soldierBean")
@RequestScoped
public class SoldierBean {

	@Inject
	private SoldierDao sdao;
	
	private Soldier soldier = new Soldier();
	

	private List<String>ranks = new ArrayList<String>();

	public List <String> getRanks()
	{
		ranks.add("mar.");ranks.add("st. mar.");ranks.add("mat");ranks.add("st. mat");ranks.add("bsmt");
		ranks.add("bsm.");ranks.add("st. bsm.");ranks.add("mł. chor.");ranks.add("chor.");ranks.add("st. chor.");
		ranks.add("st. chor. szt.");ranks.add("ppor.");ranks.add("por.");ranks.add("kpt.");ranks.add("kmdr ppor.");
		ranks.add("kmdr por.");ranks.add("kmdr");ranks.add("kadm.");ranks.add("wadm.");ranks.add("adm. fl.");
		ranks.add("adm.");
		return ranks;
	}
		
	public String saveSoldier()
	{
		sdao.saveSoldier(soldier);//dao zapisuje zolnierza
		soldier = new Soldier();//i tworze nowego by wyczyscic wartosci
		return "allsoldiers";
	}
	
	
	public List<Soldier>getSoldiers()
	{
		return sdao.getSoldiers();
	}
	
	public List<Soldier>getSoldiersWhosGotKbkak()
	{
		return sdao.getSoldiersWhosGotKbkak();
	}
	
	public Soldier getSoldier()
	{
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	
}