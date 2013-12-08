package vue;

/*
 * Classe permettant de supprimant une personne dans le club etant un entraineur
 */

public class SupprimerEntraineur extends SupprimerPersonne
{
	int	droit;
	
	public SupprimerEntraineur(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 1;
	}
}