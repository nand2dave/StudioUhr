import java.sql.SQLException;

public class RestartDatabase {
	
	public void run(){		
		DBConnection dbconnection = new DBConnection();
		dbconnection.restartDatabase();
	}
	
	public static void main(String[] args) {
		new RestartDatabase().run();
	}
}
