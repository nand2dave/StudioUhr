
//STEP 1. Import required packages
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.widgets.Table;



public class DBConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://db4free.net:3306/baindatabase";

	// Database credentials
	static final String USER = "student1";
	static final String PASSWORD = "bain13a";

  	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

	/*
	 * int[] position = new int[5]; //index ist "anzhalZeilen" !!! String[]
	 * inhalt = new String[5]; String[] typ = new String[5]; String[]
	 * beitragszeit = new String[5]; String[] bemerkung = new String[5];
	 */
	String[][] dbinhalt = new String[100][5];//[zeilen][spalten]

	
	Connection conn = null;
	Statement stmt = null;
	
	public void openDatabaseConnection(){
		
		
	}
	
	DBConnection save;
	public void prepareTable(Table table){
		//System.out.print("Spaltenanzahl: "+table.getItemCount()+"\n");		
				for(int i = 0; i< table.getItemCount();i++)
				{				
					save.saveTable(table.getItem(i).getText(1),
							table.getItem(i).getText(2),
							table.getItem(i).getText(3),
							table.getItem(i).getText(4));
					System.out.println("in datenbank geschrieben: "+
							table.getItem(i).getText(1)+
							table.getItem(i).getText(2)+
							table.getItem(i).getText(3)+
							table.getItem(i).getText(4));
					}
				}
	
	public static void saveTable(String inhalt, String typ, String Dauer, String notes){
		Connection conn = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		if(conn != null)
		{
			
				// Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
				String sql = "INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) " +
				"VALUES( ?, ?, ?, ?)";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				// Erstes Fragezeichen durch "position" Parameter ersetzen
				preparedStatement.setString(1, inhalt);
				preparedStatement.setString(2, typ);
				preparedStatement.setString(3, Dauer);
				preparedStatement.setString(4, notes);
				preparedStatement.executeUpdate();
			}
			if (conn != null)
				conn.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {				
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
			
	}
	
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
			int anzahlZeilen = 3; // !!!!je nachdem wieviele zeilen im editor
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

	
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	java.util.Date serverTime;
	long zwischen;
	String serverTimeString;

	
	public void setTime() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			stmt = conn.createStatement();

			stmt.executeUpdate("DELETE FROM echtzeit"); //vorherige Einträge leeren
			// Table neu indizieren: 
			stmt.executeUpdate("ALTER TABLE echtzeit DROP id");
			stmt.executeUpdate("ALTER TABLE echtzeit ADD id INT NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (id), AUTO_INCREMENT=1");
			stmt.executeUpdate("INSERT INTO echtzeit(zeit) VALUES(CURTIME())");
			ResultSet rs = stmt.executeQuery("SELECT zeit FROM echtzeit");   
						
			//setze die Server-Zeit auf date-Variable
			if (rs.next()){
			
			//hole Server Zeit
			Time time = rs.getTime("zeit");	
			System.out.println("Zeit auf DBConnection:");
			if (time != null)
			    serverTime = new java.util.Date(time.getTime());
		  //	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
	        serverTimeString = rs.getString("zeit");
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

	
	String currentTime = "";
	public void timerConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT zeit FROM echtzeit");   
						
			//setze die Server-Zeit auf date-Variable
			if (rs.next()){
			
			//hole Server Zeit
			Time time = rs.getTime("zeit");	
			System.out.println("Zeit auf DBConnection:");
			if (time != null)
			    serverTime = new java.util.Date(time.getTime());
		  	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
	        currentTime = hms.format(serverTime);
	        System.out.println(currentTime);
	       // System.out.println(rs.getString("zeit"));  <--- abkürzung, gibt direkt die Zeit im String-Format aus...
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
	
	
	
	String beitragsZeit = "";
	java.util.Date serverBeitragsZeit;
	Date x = new Date();
	String test = "";
	
	public String getBeitragsZeit(){	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Beitragszeit FROM daten WHERE position = 1");			
			
			if (rs.next()){

				Time time = rs.getTime("Beitragszeit");	
				if (time != null)
				    serverBeitragsZeit = new java.util.Date(time.getTime());
			  	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
		        beitragsZeit = hms.format(serverBeitragsZeit);
		        System.out.println("beitragsZeit: " + beitragsZeit);
			}

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
		return beitragsZeit;
	}

	
	//Gibt die aktuelle Zeit auf dem Server aus, ohne diese in irgendeiner Tabelle zu speichern
	java.util.Date curTime;
	public String getCurtime(){	
		String curtime = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT CURTIME()");	
			
			if (rs.next()){			
				curtime = rs.getString(1);
				Time time = rs.getTime(1);	
				System.out.println("Zeit auf DBConnection:");
				if (time != null)
				    curTime = new java.util.Date(time.getTime());
				System.out.println("curTime Date-Objekt: "+hms.format(curTime));
			}
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
		return curtime;

	}

	//Löscht die erst Zeile aus der Tabelle "daten"
	public void deleteFirstRow(){	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM daten WHERE position = 1;");
			//Primary Key neu durchnummerieren, von 1 beginnend
			stmt.executeUpdate("ALTER TABLE daten DROP position;");
			stmt.executeUpdate("ALTER TABLE daten ADD position INT NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (position), AUTO_INCREMENT=1;");
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
	}
	
	
	public void deleteRow(int rowIndex){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement(); 
			stmt.executeUpdate("DELETE FROM daten WHERE position = " + rowIndex + ";");

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
	}
	
	public void restartDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement(); 
			stmt.executeUpdate("DELETE FROM daten;");
			stmt.executeUpdate("ALTER TABLE daten DROP position;");
			stmt.executeUpdate("ALTER TABLE daten ADD position INT NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (position), AUTO_INCREMENT=1;");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 1','Intro', '00:00:10','test')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 2','Haupt-Teil', '00:00:15','test 2')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 3','Bsp.-Teil 3', '00:00:15','test 3')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 4','Bsp.-Teil 4', '00:00:15','test 4')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 5','Bsp.-Teil 5', '00:00:15','test 5')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 6','Bsp.-Teil 6', '00:00:15','test 6')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 7','Bsp.-Teil 7', '00:00:15','test 7')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 8','Bsp.-Teil 8', '00:00:15','test 9')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 9','Bsp.-Teil 9', '00:00:15','test 9')");
			stmt.executeUpdate("INSERT INTO daten(Inhalt, Typ, Beitragszeit, Bemerkung) VALUES('Bsp.-Inhalt 10','Oureo', '00:00:10','test 10')");




			System.out.println("Fertig!");
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
		
	}
	
	
	public String getServerZeit(){
		String zeit = "";
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		zeit = format.format(serverBeitragsZeit);
		return zeit;
	}
}// end DBConnection