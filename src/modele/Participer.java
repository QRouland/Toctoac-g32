package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Participer {
	//attributs
	
	//constructeurs
	public Participer(){};
	
	
	//méthodes
	/**
	 * permet de saisir le role d'un membre lors d'un evenement
	 * @param pIdEvenement
	 * @param pIdMembre
	 * @param role
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setRole(int pIdEvenement, int pIdMembre, int role ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//insertion nouveau membres
		Statement  statement = connexion.createStatement() ;
		statement.executeUpdate("INSERT INTO participer (idEvenement, idMembre, role)"
				+ "VALUES ('"+ pIdEvenement +"', '"+ pIdMembre +"', '"+ role +"')" );
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		connexion.close();
	}
	

	/**
	 * permet d'avoir le role d'un membre lors d'un evenement
	 * @param pIdEvenement
	 * @param pIdMembre
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public int getRole(int pIdEvenement, int pIdMembre) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
	
		statement = connexion.createStatement();
		resultat = statement.executeQuery("SELECT role FROM evenements WHERE idEvenement = " +
		pIdEvenement + " AND idMembre = " + pIdMembre);
			
	
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat.getInt("role");	
	}
	
	/**
	 * permet de se désincrire un membre d'un evenelement
	 * @param pIdEvenement
	 * @param pIdMembre
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setAnnuler(int pIdEvenement, int pIdMembre) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
	
		statement = connexion.createStatement();
		statement.executeUpdate("DROP * WHERE idEvenement = " +
		pIdEvenement + " AND idMembre = " + pIdMembre); 
			
	
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
	}
	
	/**
	 * retourne une liste de participants (id) pour un evenement (id)
	 * @param pIdEvenement
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getListeParticipants(int pIdEvenement) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
	
		statement = connexion.createStatement();
		resultat = statement.executeQuery("SELECT idMembre FROM evenements WHERE idEvenement = " +
		pIdEvenement );
			
	
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat;
	}
	
	/**
	 * permet d'obtenir une liste d'evenements auquel participe un membre (id)
	 * @param pIdMembre
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getListeParticipation (int pIdMembre) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
	
		statement = connexion.createStatement();
		resultat = statement.executeQuery("SELECT idEvenement FROM evenements WHERE idMembre = " +
				pIdMembre );
			
	
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat;
	}

}
