package vue;

/*
 * Classe permettant de supprimant une personne etant membre du bureau
 */

public class SupprimerDesk extends SupprimerPersonne
{
	int	droit;
	
	public SupprimerDesk(String title, int larg, int haut)
	{
		super(title, larg, haut);
		droit = 0;
	}
}