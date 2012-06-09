package mako.magbro.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import mako.magbro.bean.KbkakDao;
import mako.magbro.model.Kbkak;


@Named("kbkakBean")
@RequestScoped
public class KbkakBean {

	@Inject
	KbkakDao kbkakDao;
	
	private Kbkak kbkak = new Kbkak();
	private ListDataModel <Kbkak> kalachs = new ListDataModel<Kbkak>();
	
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
		return "allkbkak";
	}
	public String deleteKbkak()
	{
		Kbkak kbkak = kalachs.getRowData();
		kbkakDao.deleteKbkak(kbkak);
		return null;
	}
	
}
