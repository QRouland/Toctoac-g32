package vue;

/*
 * Classe permettant de definir le role de la personne ajout�e en tant que membre du bureau 
 */

public class AjoutMembreBureau extends AjoutPersonne
{
	int	droit;
	
	public AjoutMembreBureau(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 0;
	}
}