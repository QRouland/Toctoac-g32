package controleur;

import vue.AfficherListeMembre;
import vue.AjoutPersonne;

public class CtrlSaisieMembre {
	public void ctrl()
	{
		AjoutPersonne fen = new AjoutPersonne("Ajout nouveau membre", 500, 500);
		
		fen.setVisible(true);

		
	}

}
