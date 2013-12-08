package vue;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class AfficherListeMembre extends JFrame
{
	
	// Attributs pour les compsants de la fen�tre
	
	int x, y, h, l ;
	private JLabel l_title ;
	private JList liste ;
	private JScrollPane jsp ;
	private JPanel pan_0, pan_1, pan_2 ;
	private JButton b_retour ;
	

	public AfficherListeMembre (String title)
	{
		super(title);
		
		// D�finir  la fen�tre elle-m�me		
		
		this.setBounds (x, y, l, h);
		this.setResizable(false);
		this.setTitle(title) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		// Cr�ation du Vector et la liste
		
		 
		Vector <String> maListe = new Vector <String>() ;
		int nbC = 22 ;
				
		 for (int i = 1 ; i < nbC ; i++)
			maListe.add("Client " + i) ;
				
		liste = new JList<String>(maListe) ;

		JScrollPane jsp = new JScrollPane(liste) ;
				
				
	    // Cr�er des composants et les ins�rer dans la fen�tre
	    
		
		this.l_title = new JLabel("<html> Liste des membres <br> <br>") ;
		this.b_retour = new JButton("Retour") ;
		
		this.pan_0 = new JPanel() ;
		this.pan_1 = new JPanel() ;
		this.pan_2 = new JPanel() ;
		
		
		// Mise en place des composants
		
		pan_0.add(l_title) ;
		
		this.add(pan_0, BorderLayout.NORTH) ;
		
		pan_1.add(jsp);
		
		this.add(pan_1) ;
		
		pan_2.add(b_retour) ;		
		this.add(pan_2, BorderLayout.SOUTH) ;
	} 
	

}
