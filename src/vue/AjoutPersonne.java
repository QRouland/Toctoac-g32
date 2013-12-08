package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vue.MembreBureau.amembreListener;

/*
 * Classe permettant de creer une personne dans le club en definissant nom, prenom, adresse, date de naissance,
 * numero de telephone, date d'adhesion, et mot de passe
 */

public class AjoutPersonne extends JDialog
{
	JLabel		Nom;
	JLabel		Prenom;
	JLabel		Adresse;
	JLabel		dtn;
	JLabel		num;
	JLabel		addhesions;
	JLabel		pwd;
	JPanel		bas;
	JPanel		gauche;
	JPanel		droite;
	JButton		valid;
	JButton		annul;
	GridLayout	text;
	GridLayout	entrance;
	JTextField	t_nom;
	JTextField	t_prenom;
	JTextField	t_adresse;
	JTextField	t_dtn;
	JTextField	t_num;
	JTextField	t_addhesion;
	JTextField	t_pwd;
	
	public AjoutPersonne(String title, int larg, int haut)
	{
		setTitle(title);
		setModal(true);
		this.setSize(larg, haut);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		text = new GridLayout(7, 1);
		entrance = new GridLayout(7, 1);
		gauche = new JPanel();
		droite = new JPanel();
		bas = new JPanel();
		droite.setLayout(text);
		gauche.setLayout(entrance);
		Nom = new JLabel("Nom : ");
		Prenom = new JLabel("Prenom : ");
		Adresse = new JLabel("Adresse : ");
		dtn = new JLabel("Date de naissance : ");
		num = new JLabel("Nunmero de telephone : ");
		addhesions = new JLabel("Date d'adhesion : ");
		pwd = new JLabel("Mot de passe : ");
		t_nom = new JTextField(30);
		t_prenom = new JTextField(30);
		t_adresse = new JTextField(30);
		t_dtn = new JTextField(30);
		t_num = new JTextField(30);
		t_addhesion = new JTextField(30);
		t_pwd = new JTextField(30);
		valid = new JButton("Valider");
		annul = new JButton("Annuler");
		gauche.add(Nom);
		gauche.add(Prenom);
		gauche.add(Adresse);
		gauche.add(dtn);
		gauche.add(num);
		gauche.add(addhesions);
		gauche.add(pwd);
		droite.add(t_nom);
		droite.add(t_prenom);
		droite.add(t_adresse);
		droite.add(t_dtn);
		droite.add(t_num);
		droite.add(t_addhesion);
		droite.add(t_pwd);
		bas.add(annul, BorderLayout.WEST);
		bas.add(valid, BorderLayout.EAST);
		this.add(bas, BorderLayout.SOUTH);
		this.add(gauche, BorderLayout.WEST);
		this.add(droite, BorderLayout.EAST);
		valid.addActionListener(new validListener());
		annul.addActionListener(new annulListener());
	}
	
	class validListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//envoie dans la base de donn�es
			// et ferme la fenetre
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