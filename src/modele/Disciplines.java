package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Disciplines {
	//attributs
	
	//constructueurs
	public Disciplines(){}
	
	//methodes
	/**
	 * permet de saisir une discipline pour un entrainement donné
	 * @param pIdEntrainement
	 * @param pNomDiscipline
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setDiscipline(int pIdEntrainement, String pNomDiscipline) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//insertion nouveau membres
		Statement  statement = connexion.createStatement() ;
		statement.executeUpdate("INSERT INTO Disciplines (nomDiscipline, idEntrainement)"
				+ "VALUES ('"+ pIdEntrainement +"', '"+ pIdEntrainement  );
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		connexion.close();
	}
	
	/**
	 * permet d'obtenir la discipline pour un entrainement donnée
	 * @param pIdEntrainement
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public  String getDiscipline (int pIdEntrainement) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
		
		statement = connexion.createStatement();
		resultat = statement.executeQuery("SELECT nomDiscipline FROM membres WHERE" +
				"idEvenement =" + pIdEntrainement);
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat.getString("nomDiscipline");
	
	}

}
