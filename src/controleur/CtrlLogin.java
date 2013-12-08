package controleur;

import vue.DlgLogin;

public class CtrlLogin {
	
	public void ctrl () {
	
	DlgLogin fen = new DlgLogin("S'identifier");
	
	fen.setBounds(500, 250, 500, 150) ;
	fen.setVisible(true);
	} ;
	
}
