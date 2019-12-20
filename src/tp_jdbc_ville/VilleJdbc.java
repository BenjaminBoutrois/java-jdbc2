package tp_jdbc_ville;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VilleJdbc {
	
	private static void modifierVille(String ancien_nom, String nouveau_nom)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/ensup1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "UPDATE `villes_france_free`" + 
						"SET `ville_nom` = '" + nouveau_nom + "'" + 
						"WHERE `ville_nom` = '" + ancien_nom + "'";
			
			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);
			
			System.out.println("Modification de la ville '" + ancien_nom + "' en '" + nouveau_nom + "'.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void supprimerVille(String ville_nom)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/ensup1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "DELETE FROM `villes_france_free` WHERE `ville_nom` = '" + ville_nom + "'";
			
			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);

			System.out.println("Suppression de la ville " + ville_nom + ".");
			System.out.println();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private static void ajouterVille(String ville_nom)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/ensup1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "INSERT INTO `villes_france_free` (`ville_nom`, `ville_code_commune`)"
					+ "VALUES ('" + ville_nom + "', '00000')";
			
			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);
			
			System.out.println("Ajout de la ville '" + ville_nom + "'.");
			System.out.println();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void trouverVille(String nom_ville) {
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/ensup1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM `villes_france_free` WHERE ville_nom = '" + nom_ville + "'";
			
			// Etape 4 : Exécution requête
			result = statement.executeQuery(sql);
			
			System.out.println("Villes correspondant au nom '" + nom_ville + "' :");
			
			// Etape 5 : Parcourir le résultat
			while (result.next())
			{
				System.out.println(result.getString("ville_nom"));
			}

			System.out.println();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void afficherVillesFrance(int limite) {
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/ensup1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM `villes_france_free` LIMIT " + limite;
			
			// Etape 4 : Exécution requête
			result = statement.executeQuery(sql);
			
			System.out.println("Les " + limite + " premières villes :");
			
			// Etape 5 : Parcourir le résultat
			while (result.next())
			{
				System.out.println(result.getString("ville_departement") + " | " + result.getString("ville_nom"));
			}
			System.out.println();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		//ajouterVille("TEST");	// CREATE
		
		trouverVille("TEST");	// RETRIEVE
		
		//modifierVille("TEST", "TOAST");	// UPDATE
		trouverVille("TOAST");
		
		supprimerVille("TOAST");	// DELETE
		trouverVille("TOAST");
		
		afficherVillesFrance(5);	// GetAll (limit)
	}
}
