package vue;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DlgLogin extends JFrame
{
	// Attributs pour les compsants de la fenêtre
	
	int x, y, h, l ;
	private JLabel l_title, l_login, l_mdp ;
	private JTextField t_login ;
	private JPanel pan_0, pan_1, pan_2 ;
	private JButton b_valider, b_annuler ;
	private JPasswordField p_mdp ;

	public DlgLogin (String title)
	{
		super(title);
		
		// Définir  la fenêtre elle-même		
		
		this.setBounds (x, y, l, h);
		this.setResizable(false);
		this.setTitle(title) ;
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		    
	    // Créer des composants et les insérer dans la fenêtre
	    
		
		this.l_title = new JLabel("<html> Identifiez-vous ! <br> <br>") ;
		this.l_login = new JLabel("Login : ") ;
		this.l_mdp = new JLabel("Mot de passe : ") ;
		this.t_login = new JTextField(50) ;
		this.p_mdp = new JPasswordField(50) ;
		this.b_valider = new JButton("Valider") ;
		this.b_annuler = new JButton("Annuler") ;
		
		this.pan_0 = new JPanel() ;
		this.pan_1 = new JPanel() ;
		this.pan_2 = new JPanel() ;
		
		
		// Mise en place des composants
		
		pan_0.add(l_title) ;
		
		this.add(pan_0, BorderLayout.NORTH) ;
		
		pan_1.setLayout(new GridLayout(2, 2));
		pan_1.add(l_login);
		pan_1.add(t_login) ;
		pan_1.add(l_mdp) ;
		pan_1.add(p_mdp) ;
		
		this.add(pan_1) ;
		
		pan_2.setLayout(new GridLayout(1,2)) ;
		pan_2.add(b_valider) ;
		pan_2.add(b_annuler) ;
		
		this.add(pan_2, BorderLayout.SOUTH) ;
	} 
	

}
