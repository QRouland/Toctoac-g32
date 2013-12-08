package vue;

/*
 * Classe permettant de supprimant une personne dans le club etant un simple membre
 */

public class SupprimerMembre extends SupprimerPersonne
{
	int	droit;
	
	public SupprimerMembre(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 2;
	}
}