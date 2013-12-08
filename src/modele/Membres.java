package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Membres {

	//attributs
/*	private String nom;
	private String prenom;
	private String adresse;
	private String dtn;
	private String numTel;
	private String droit;
	private String dateAdhesion;
	private String password;*/
	
	//Constructeurs
	public Membres() {}
	
	//méthode
	/**
	 * Insere dans la base un nouveau membres
	 * @param pNom
	 * @param pPrenom
	 * @param pDtn
	 * @param pNumTel
	 * @param pAdresse
	 * @param pDroit
	 * @param pDateAdhesion
	 * @param pPassword
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setInfo(String pNom, String pPrenom, String pDtn, String pNumTel, String pAdresse,
			int pDroit, String pDateAdhesion,String pPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//insertion nouveau membres
		Statement  statement = connexion.createStatement() ;
		statement.executeUpdate("INSERT INTO membres (nom, prenom, adresse,"
				+" numTel, droit, password, dtn, dateAdhesion )"
				+ "VALUES ('"+ pNom +"', '"+ pPrenom +"', '"+ pAdresse +"'," 
				+"'"+ pNumTel +"', '"+ pDroit +"', '"+ pPassword +"', " 
				+"'"+ pDtn +"', '"+ pDateAdhesion +"')");
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		connexion.close();
	}
	
	/**
	 * idMembres les infos du membre  ou si -1 alors retourne les infos de tout les membres
	 * @param pIdMembres
	 * @return un resultSet contenant le ou les infos membres
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getInfo(int pIdMembre) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
		if(pIdMembre == -1)
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM membres ");
			
		}
		else
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM membres WHERE idMembre =" + pIdMembre);
		}
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat;
	}
	
	/**
	 * Permet de supprimer un membre a partir de don id
	 * @param pIdMembre
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void supprimer(int pIdMembre) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
	
		statement = connexion.createStatement();
		statement.executeUpdate("DROP * WHERE idMembre= " + pIdMembre) ; 
			
	
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
	}
}
