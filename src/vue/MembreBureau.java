package vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Fenetre principale d'un membre du bureau permettant de choisir au choix de creer ou 
 * supprimer quelqu'un de la base de donn�es 
 */

public class MembreBureau extends JDialog
{
	JButton		amembre;
	JButton		smembre;
	JButton		adesk;
	JButton		sdesk;
	JButton		aentraineur;
	JButton		sentraineur;
	JPanel		ajout;
	JPanel		supression;
	GridLayout	grille;
	GridLayout	grille2;
	
	/*
	 * Creation de la fenetre principal et des boutons
	 * Par bloc :
	 *  + creation : 
	 * 		- de la fenetre
	 * 		- des Grilles pour les boutons
	 * 		- des boutons
	 * 		- de panel pour placer les boutons
	 *  + ajout :
	 *  	- des grilles sur le panel
	 *  	- des panels dans la fenetre
	 *  	- des boutons dans les panels
	 *  + abonnements sur les boutons
	 */
	
	public MembreBureau(String title, int larg, int haut)
	{
		setTitle(title);
		setModal(true);
		this.setSize(larg, haut);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		grille = new GridLayout(3, 1);
		grille2 = new GridLayout(3, 1);
		amembre = new JButton("Ajout d'un membre");
		smembre = new JButton("Suppression d'un membre");
		aentraineur = new JButton("Ajout d'un entraineur");
		sentraineur = new JButton("Suppression d'un entraineur");
		adesk = new JButton("Ajout d'un membre du bureau");
		sdesk = new JButton("Suppression d'un membre du bureau");
		ajout = new JPanel();
		supression = new JPanel();
		ajout.setLayout(grille);
		supression.setLayout(grille2);
		this.add(ajout, BorderLayout.EAST);
		this.add(supression, BorderLayout.WEST);
		ajout.add(amembre, BorderLayout.NORTH);
		supression.add(smembre, BorderLayout.NORTH);
		ajout.add(aentraineur, BorderLayout.CENTER);
		supression.add(sentraineur, BorderLayout.CENTER);
		ajout.add(adesk, BorderLayout.SOUTH);
		supression.add(sdesk, BorderLayout.SOUTH);
		amembre.addActionListener(new amembreListener());
		aentraineur.addActionListener(new aentraineurListener());
		adesk.addActionListener(new adeskListener());
		smembre.addActionListener(new smembreListener());
		sentraineur.addActionListener(new sentraineurListener());
		sdesk.addActionListener(new sdeskListener());
	}

	/*
	 * Fonction d'ecoute des boutons, chacun lance une fenetre associee
	 */
	
	class amembreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AjoutMembre test = new  AjoutMembre("Ajout d'un membre", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}

	class aentraineurListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AjoutEntraineur test = new  AjoutEntraineur("Ajout d'un entraineur", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}
	
	class adeskListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AjoutMembreBureau test = new  AjoutMembreBureau("Ajout d'un membre du bureau", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}

	class smembreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			SupprimerMembre test = new  SupprimerMembre("Suppression d'un membre", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}

	class sentraineurListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			SupprimerEntraineur test = new  SupprimerEntraineur("Suppression d'un entraineur", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}

	class sdeskListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			SupprimerDesk test = new  SupprimerDesk("Suppression d'un membre du bureau", 600, 300);
			test.setVisible(true);
			test.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		}
	}
	
	public static void main(String[] argv)
	{
		MembreBureau	essai;
		AjoutMembre		test;
		essai = new  MembreBureau("Membre du Bureau", 450, 150);
		essai.setVisible(true);
		essai.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	  }
}