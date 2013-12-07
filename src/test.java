
import java.sql.ResultSet;
import java.sql.SQLException;


import modele.Evenements;
import modele.Membres;

public class test {
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		
		Membres m;
		Evenements e;
		ResultSet r;
	  	
		m = new Membres();
		e = new Evenements();
		
		e.setEvenement("2013-10-12", 0, "lol");
		
		//m.setInfo("g", "lo", "2000-05-08", "0568025855", "lol", 1, "2013-05-20", "pp");
		 r = e.getEvenement(-1);
		
		
		while(r.next())
		{
			String str[]=r.getString("dateE").split("-");
			System.out.println(str[0]);
			System.out.println(str[1]);
			System.out.println(str[2]);
			System.out.println(r.getDate("dateE"));
		}
		System.out.println("fin");
	}
	
	

}


