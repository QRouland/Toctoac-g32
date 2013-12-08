package vue;

/*
 * Classe permettant de definir le role de la personne ajout�e en tant que simple membre
 */

public class AjoutMembre extends AjoutPersonne
{
	int	droit;
	
	public AjoutMembre(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 2;
	}
}
