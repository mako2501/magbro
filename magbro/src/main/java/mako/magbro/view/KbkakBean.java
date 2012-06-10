package mako.magbro.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import mako.magbro.bean.AscriptionManager;
import mako.magbro.bean.KbkakDao;
import mako.magbro.model.Kbkak;

@Named("kbkakBean")
@RequestScoped
public class KbkakBean {

	@Inject
	KbkakDao kbkakDao;
	
	@Inject 
	AscriptionManager am;
	
	private Kbkak kbkak = new Kbkak();
	private ListDataModel <Kbkak> kalachs = new ListDataModel<Kbkak>();
	
	private Kbkak kbkakToAscript = new Kbkak();
		
	public Kbkak getKbkakToAscript() {
		return kbkakToAscript;
	}
	public void setKbkakToAscript(Kbkak kbkakToAscript) {
		this.kbkakToAscript = kbkakToAscript;
	}
	public Kbkak getKbkak() {
		return kbkak;
	}
	public void setKbkak(Kbkak kbkak) {
		this.kbkak = kbkak;
	}
	public ListDataModel<Kbkak> getKalachs() {
		kalachs.setWrappedData(kbkakDao.getKalachs());
		return kalachs;
	}
	
	public String saveKbkak()
	{
		kbkakDao.saveKbkak(kbkak);
		kbkak = new Kbkak();
		return "/widoki/kbkak/allkbkak";
	}
	public String deleteKbkak()
	{
		Kbkak kbkak = kalachs.getRowData();
		kbkakDao.deleteKbkak(kbkak);
		return null;
	}
	
	public ListDataModel<Kbkak> getPrzypisaneKbkak()
	{
		kalachs.setWrappedData(kbkakDao.getPrzypisaneKbkak());
		return kalachs;
	}
	public ListDataModel<Kbkak> getNiePrzypisaneKbkak()
	{
		kalachs.setWrappedData(kbkakDao.getNiePrzypisaneKbkak());
		return kalachs;
	}
	//gdy nie znam zolnierza a chce przekazac nr broni
	public String setKbkakToAscript()
	{
		kbkakToAscript = kalachs.getRowData();
		am.setKbkakToAscript(kbkakToAscript);
		return "/widoki/zolnierze/soldierWithNoGunsGive";
	}
	//gdy znam zolnierza i teraz chce wyslac uruchmic przypisanie
	public String setKbkToAscriptWithSoldier()
	{
		kbkakToAscript=kalachs.getRowData();
		am.giveKbkakToSoldier(kbkakToAscript);
		return "/widoki/kbkak/przypisanekbkak";
	}
	
	public String anulujPrzypisanie()
	{
		//wyczyszczenie zmiennych aby sie pozniej nie pojawily w dziwnych miejscach
		kbkakToAscript=null;
		am.setKbkakToAscript(kbkakToAscript);
		am.setSoldierToAscript(null);
		return "/widoki/kbkak/nieprzypisanekbkak";
	}
	
}
