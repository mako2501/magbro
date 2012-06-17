package mako.magbro.view;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import mako.magbro.bean.AscriptionManager;
import mako.magbro.bean.SoldierDao;
import mako.magbro.model.Soldier;


@Named("soldierBean")
@RequestScoped
public class SoldierBean {

	@Inject
	private SoldierDao sdao;
	
	@Inject 
	AscriptionManager am;
	
	private Soldier soldier = new Soldier();
	/*
	 * by nie trzymac obiektu Soldier w roznych zmiennych zaleznych od zapytan poki co
	 * trzymam ja w soldiers, by moc z tej kozystac w roznych metodach usuwania itd zamiast
	 * private ListDataModel<Soldier> soldiersWithKbkak = new ListDataModel<Soldier>();
	 */
	
	private ListDataModel<Soldier> soldiers = new ListDataModel<Soldier>();
	
	//zolnierz wykorzystywany do przypisywania mu broni	
	private Soldier soldierToAscript;

	public Soldier getSoldierToAscript() {
		return soldierToAscript;
	}

	/*
	 * zolnierze maja stopnie wybierane z listy rozwijanej
	 */
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
		return "/widoki/zolnierze/allsoldiers";
	}
	public String saveSoldierToShow()
	{
		sdao.saveSoldierToShow(soldier);
		soldier = new Soldier();
		return "/widoki/zolnierze/allsoldiers";
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
		//soldiersWithKbkak.setWrappedData(sdao.getSoldiersWhosGotKbkak());
		soldiers.setWrappedData(sdao.getSoldiersWhosGotKbkak());
		return soldiers;
	}
	//soldiersWithoutKbkak
	public ListDataModel<Soldier>getSoldiersWithoutKbkak()
	{
		//soldiersWithKbkak.setWrappedData(sdao.getSoldiersWhosGotKbkak());
		soldiers.setWrappedData(sdao.getSoldiersWithoutKbkak());
		return soldiers;
	}
	public Soldier getSoldier()
	{
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	//gdy juz znam bron teraz podaje zolnierza
	public String setSoldierToAscript()
	{
		soldierToAscript = soldiers.getRowData();
		am.giveKbkakToSoldier(soldierToAscript);
		return "/widoki/zolnierze/allsoldiersWithGuns";
	}
	//gdy nie znam jeszcze kbkak ale musze przekazac zolnierza
	public String setSoldierToAscriptKbkak()
	{
		soldierToAscript = soldiers.getRowData();
		am.setSoldierToAscript(soldierToAscript);
		return "/widoki/kbkak/kbkakWithoutToAscript";
	}
	//gdy anuluje przypisanie kbk
	public String anulujPrzypisanieKbkak()
	{
		soldierToAscript=null;
		am.setSoldierToAscript(soldierToAscript);
		am.setKbkakToAscript(null);
		return "/widoki/zolnierze/allsoldiersWithoutGuns";
	}
	public String zdejmijKbkak()
	{
		am.zdejmijKbkakWSoldier(soldiers.getRowData());
		return null;
	}
	/*jako, ze po wykonaniu details trzeba wrocic do starego formularza musi do obsluzyc inna metoda
	 * by return byl inny
	 */
	public String details()
	{
		soldier=soldiers.getRowData();
		sdao.setId(soldier.getId());//zapamietuje jego id w DAO
		return "detailsSoldier";
	}
	
	
}
