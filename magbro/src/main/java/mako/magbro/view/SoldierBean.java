package mako.magbro.view;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;

import javax.inject.Inject;
import javax.inject.Named;

import mako.magbro.bean.SoldierDao;
import mako.magbro.model.Kbkak;
import mako.magbro.model.Soldier;


@Named("soldierBean")
@RequestScoped
public class SoldierBean {

	@Inject
	private SoldierDao sdao;
	
	private Soldier soldier = new Soldier();
	private ListDataModel<Soldier> soldiers = new ListDataModel<Soldier>();
	private ListDataModel<Soldier> soldiersWithKbkak = new ListDataModel<Soldier>();
	private Kbkak kbkak = new Kbkak();

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
	
	public String deleteSoldier()
	{
		Soldier soldierToDelete = soldiers.getRowData();
		sdao.deleteSoldier(soldierToDelete);
		return null;
	}
	
	public ListDataModel<Soldier>getSoldiers()
	{
		soldiers.setWrappedData(sdao.getSoldiers());
		return soldiers;
	}
	
	public ListDataModel<Soldier>getSoldiersWhosGotKbkak()
	{
		soldiersWithKbkak.setWrappedData(sdao.getSoldiersWhosGotKbkak());
		return soldiersWithKbkak;
	}
	
	public Soldier getSoldier()
	{
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	
	public String getKbkak()
	{
		kbkak = sdao.getKbkak(soldier);
		return "aa85654";
	}

	
	
}
