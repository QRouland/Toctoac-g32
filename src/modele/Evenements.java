package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Evenements {

	//attributs
	
	
	//Constuctueurs
	public Evenements(){};
	
	//méthodes
	public void setEvenement(String pDate, int pType, String pLieu) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//insertion nouveau membres
		Statement  statement = connexion.createStatement() ;
		statement.executeUpdate("INSERT INTO Evenements (type, dateE, lieu)"
				+ "VALUES ('"+ pType +"', '"+ pDate +"', '"+ pLieu +"')" );
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		connexion.close();
	}
	
	/**
	 * 
	 * @param pIdEvenement
	 * @return un resultSet contenant le ou les infos evenements
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getEvenement(int pIdEvenement) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Statement statement;
		ResultSet resultat;
		//connexion à la base
		Connection connexion = null;
		Class.forName("org.hsqldb.jdbcDriver" ).newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:file:bd", "sa",  "" );
		
		//récupération infos dans la bases
		if(pIdEvenement == -1)
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM evenements ");
			
		}
		else
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM evenements WHERE idEvenement =" + pIdEvenement);
		}
		
		//fermeture base 
		statement = connexion.createStatement();
		statement.executeQuery("SHUTDOWN");
		statement.close();
		
		return resultat;	
	}
}
