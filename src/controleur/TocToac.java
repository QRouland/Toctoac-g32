package controleur;

import java.sql.SQLException;

public class TocToac {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		CtrlLogin log = new CtrlLogin();
		log.ctrl() ;
		
		CtrlAccesListe l = new CtrlAccesListe();
		l.ctrl();
		
		CtrlSaisieMembre m = new CtrlSaisieMembre();
		m.ctrl();
			
	}

}
