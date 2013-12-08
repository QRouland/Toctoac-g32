package vue;


/*
 * Classe permettant de definir le role de la personne ajout�e en tant qu'entraieneur
 */

public class AjoutEntraineur extends AjoutPersonne
{
	int	droit;
	
	public AjoutEntraineur(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 1;
	}
}
