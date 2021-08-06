package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.JFuzzyLogic;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c,b;
		Scanner in = new Scanner(System.in);
		System.out.print("Ortam Isik Yogunlugu (0-2000 lux):");
		int oy = in.nextInt();
		System.out.print("Acik Renk Yogunlugu (0-350 cd/m2 ):");
		int ay = in.nextInt();
		if(ay>=0 && ay<70) {  c=0; b=69;}
		else if(ay>69 && ay<140) {  c=70; b=139;}
		else if(ay>139 && ay<210) {  c=140; b=209;}
		else if(ay>209 && ay<280) {  c=210; b=279;}
		else {	c=280; b=350;}
		System.out.print("Kapali Renk Yogunlugu ("+c+"-"+b+" cd/m2 ):");
		int ky = in.nextInt();
		
		try {
			Parlaklik ps = new Parlaklik(oy, ay, ky);
			System.out.println(ps+" cd/m2");
			for(Rule r : ps.getModel().getFunctionBlock("EkranParlakligi").getFuzzyRuleBlock("kuralblock1").getRules()) {
				if(r.getDegreeOfSupport()>0) System.out.println(r);
			
			}
			JFuzzyChart.get().chart(ps.getModel());
		
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
