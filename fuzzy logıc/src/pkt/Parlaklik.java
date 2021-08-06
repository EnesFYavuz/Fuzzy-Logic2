package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Parlaklik {
	private final FIS fis;
	private final double ortam_isik_yogunlugu;
	private final double acik_renk_yogunlugu;
	private final double koyu_renk_yogunlugu;
	public Parlaklik(double oy,double ay,double ky) throws URISyntaxException {
		ortam_isik_yogunlugu=oy;
		acik_renk_yogunlugu = ay;
		koyu_renk_yogunlugu = ky;
			File dosya = new File(getClass().getResource("EkranParlakligi.fcl").toURI());
			fis = FIS.load(dosya.getPath(),true);
			fis.setVariable("ortam_isik_yogunlugu", ortam_isik_yogunlugu);
			fis.setVariable("acik_renk_yogunlugu", acik_renk_yogunlugu);
			fis.setVariable("koyu_renk_yogunlugu", koyu_renk_yogunlugu);
			fis.evaluate();
	}
	public FIS getModel() {
		return fis;
	}
	@Override
	public String toString() {
		String cikti = "Ekran Parlakligi-->"+Math.round(fis.getVariable("ekran_parlakligi").getValue());
		return cikti;
		
	}

}
