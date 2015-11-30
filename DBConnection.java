
//STEP 1. Import required packages
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DBConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://db4free.net:3306/baindatabase";

	// Database credentials
	static final String USER = "student1";
	static final String PASSWORD = "bain13a";

	/*
	 * int[] position = new int[5]; //index ist "anzhalZeilen" !!! String[]
	 * inhalt = new String[5]; String[] typ = new String[5]; String[]
	 * beitragszeit = new String[5]; String[] bemerkung = new String[5];
	 */
	String[][] dbinhalt = new String[5][5];

	
	Connection conn = null;
	Statement stmt = null;
	
	
	public void db_query(String query) {
	//	Connection conn = null;
	//	Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			// String sql;
			// sql = "SELECT * FROM daten";
			ResultSet rs = stmt.executeQuery(query);

			// STEP 5: Extract data from result set
			int anzahlZeilen = 2; // !!!!je nachdem wieviele zeilen im editor
									// eingegeben wurden!!!
			for (int i = 0; i < anzahlZeilen; i++) {
				rs.next();

				// Retrieve by column name
				int position = rs.getInt("position");
				String inhalt = rs.getString("Inhalt");
				String typ = rs.getString("Typ");
				String beitragszeit = rs.getString("Beitragszeit");
				String bemerkung = rs.getString("Bemerkung");
				/*
				 * this.position[i] = position; this.inhalt[i] = inhalt;
				 * this.typ[i] = typ; this.beitragszeit[i] = beitragszeit;
				 * this.bemerkung[i] = bemerkung;
				 */
				dbinhalt[i][0] = Integer.toString(position);
				dbinhalt[i][1] = inhalt;
				dbinhalt[i][2] = typ;
				dbinhalt[i][3] = beitragszeit;
				dbinhalt[i][4] = bemerkung;

				// Display values
				System.out.print("Position: " + position);
				System.out.print(", Inhalt: " + inhalt);
				System.out.print(", Typ: " + typ);
				System.out.print(", Beitragszeit: " + beitragszeit);
				System.out.print(", Bemerkung: " + bemerkung);
				System.out.println();
				// System.out.print(", First: " + first);
				// System.out.println(", Last: " + last);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		System.out.println("\nGoodbye!");

	}// end dbQuery(...)

	
	java.util.Date date;
	
	public void setTime() {
		String currentTime = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			stmt = conn.createStatement();

			stmt.executeUpdate("DELETE FROM echtzeit"); //vorherige Einträge leeren
			stmt.executeUpdate("INSERT INTO echtzeit VALUES(CURTIME())");
			ResultSet rs = stmt.executeQuery("SELECT * FROM echtzeit");
		//	currentTime = rs.getTime("zeit");
						
			//setze die Server-Zeit auf date-Variable
			if (rs.next()){
			Time time = rs.getTime("zeit");
			System.out.println("Zeit auf DBConnection:");
			if (time != null)
			    date = new java.util.Date(time.getTime());
			this.date = date;
		  	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
	        currentTime = hms.format(date);
	        System.out.println(currentTime);
			}

			rs.close();
			stmt.close();
			conn.close();
		}

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}//end setTime

	
	
	public String getDauer(){
		String dauer = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Beitragszeit FROM daten");			
			
			if (rs.next()){
				dauer = rs.getString("Beitragszeit");
			}
			System.out.println(dauer);

			rs.close();
			stmt.close();
			conn.close();
		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return dauer;
	}
	
	public String getServerZeit(){
		String zeit = "";
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		zeit = format.format(date);
		return zeit;
	}
}// end DBConnection