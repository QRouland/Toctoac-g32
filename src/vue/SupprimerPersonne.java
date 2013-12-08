package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vue.AjoutPersonne.validListener;

/*
 * Classe permettant de supprimant une personne dans le club
 * 
 * Doit afficher la liste des inscrits dans la base de donnees suivant les droits appeles par les methodes filles
 */

public class SupprimerPersonne extends JDialog
{
	JPanel	bas;
	JButton	valid;
	JButton annul;
	
	public SupprimerPersonne(String title, int larg, int haut)
	{
		setTitle(title);
		setModal(true);
		this.setSize(larg, haut);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		valid = new JButton("Valider");
		annul = new JButton("Annuler");
		bas = new JPanel();
		this.add(bas, BorderLayout.SOUTH);
		bas.add(annul, BorderLayout.WEST);
		bas.add(valid, BorderLayout.EAST);
		valid.addActionListener(new validListener());
		annul.addActionListener(new annulListener());
	}

	class validListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//supprime de la base de donn�es
		}
	}
	
	class annulListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//ferme la fenetre sans envoyer
		}
	}
}
