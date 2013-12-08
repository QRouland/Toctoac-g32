package controleur;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import vue.AfficherListeMembre;
import vue.Planning;

import modele.Evenements;


public class CtrlAccesListe {
	
	
	
	public void ctrl() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Evenements e;
		ResultSet r;

		JFrame f_planning ;
		Planning p ;
		
		f_planning = new JFrame("Planning") ;
		p = new Planning() ;
		
		Container c = f_planning.getContentPane();
		c.setLayout(new FlowLayout());
		
		// cr�e le planning � la date actuelle
		c.add(p);
		/*
		// c.add(new Planning(2012, 4, 20)) ;
		p.color_date(11) ;
		p.color_date(20) ;*/
		
		f_planning.pack();
		// f_planning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_planning.setVisible(true);
		f_planning.setResizable(false) ;
		
		
		//ajout d'un evenemebts test
		e = new Evenements();
		
		e.setEvenement("2012-11-20", 1, "toulouse");
		r = e.getEvenement(-1);
		
		while(r.next())
		{
			String str[]=r.getString("dateE").split("-");
			
			p.color_date(Integer.decode( str[2]));
			
		}
		
		
		
		
	}

}
