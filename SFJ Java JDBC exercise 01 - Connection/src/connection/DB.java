package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	
		final String JDBC_DRIVER ="org.apache.derby.jdbc.EmbeddedDriver";  //Driver ami a hidat iranyitja
		final String URL ="jdbc:derby:sampleDB;create=true";
		final String USERNAME ="";
		final String PASSWORD ="";
		Connection conn = null; 
		Statement createStatement = null;
		PreparedStatement preparedStatement = null;
		
		public DB() {
			
			
			//Letrehozzuk a Kapcsolaltot , Megprobaljuk eletre kelteni
			try {          
				 conn = DriverManager.getConnection(URL);
				System.out.println("A hid letrejott");
			} catch (SQLException e) {
				System.out.println("Valami baj van a Connection letrehozasanal");
				e.printStackTrace();
			}
			
			
			           // Ha eletre kell csinalunk egy megpakolhato tehrautot
			if(conn != null) {
				try {              
					 createStatement = conn.createStatement(); 
				} catch (SQLException e) {
					System.out.println("Valami baj a createStatement(teherAuto) letrehozasanal");
					e.printStackTrace();
				}
			}
				// Megnezzuk , hogy ures e az adatbazis, Letezik e az adot adattabla
			DatabaseMetaData dbmd = null;	
			 try {
				dbmd = conn.getMetaData();
			} catch (SQLException e) {
				System.out.println("Valami baj az adatbazis leiras letrehozasanal");
				e.printStackTrace();
			}
				
			try {
				ResultSet rs1 = dbmd.getTables(null, "APP", "USERS", null);
				if(!rs1.next())
				{
					createStatement.execute("create table users(name varchar(20),address varchar(20))");
				}
			} catch (SQLException e) {
				System.out.println("Valami baj az uj user tabla letrehozasanal");
				e.printStackTrace();
			}	

		}
		
		public void addUserSimpleStatement(String name , String address) {
			
			try {
				String execute = "insert into users values ('"+name+"','"+address+"')";
				createStatement.execute(execute);
			} catch (SQLException e) {
				System.out.println("Valami baj van az uj user hozzaadasanal simple statement metodussal");
				e.printStackTrace();
			}
		}
		
		public void addUserPreparedStatement(String name , String address) {
			
			try {
				 String execute = "insert into users values ('?','?')";
				 preparedStatement = conn.prepareStatement(execute);
				 preparedStatement.setString(1, name);
				 preparedStatement.setString(2, address);
				 preparedStatement.execute();
			} catch (SQLException e) {
				System.out.println("Valami baj van az uj user hozzaadasanal prepared statement metodussal");
				e.printStackTrace();
			}
		}
		
		public void  showAllUsers() {
			String sql = "select * from users";
			try {
				ResultSet rs = createStatement.executeQuery(sql);
				while(rs.next()) {
					String name = rs.getString("name");
					String address = rs.getString("address");
					System.out.println(name +" | "+ address);
								}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasasakor");
				e.printStackTrace();
			}
		}
		
		public void showUsersMeta () {
			String sql = "select * from users";
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			
			try {
				rs = createStatement.executeQuery(sql);
				rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for(int i = 1 ; i<= columnCount; i++)
					System.out.print(rsmd.getColumnName(i) + " | ");
			} catch (SQLException e) {
				System.out.println("Valami baj van a User tabla metaadat kiolvasasaval");
				e.printStackTrace();
			}System.out.println();
		}
		
		public  ArrayList <User> getAllUsers(){
			String sql = "select * from users";
			ArrayList<User> users = null;
			try {
				ResultSet rs = createStatement.executeQuery(sql);
				users = new ArrayList<>();
				while(rs.next()) {
					User actualUser = new User(rs.getString("name"),rs.getString("address"));
					users.add(actualUser);
					}
			} catch (SQLException e) {
				System.out.println("Valami baj van a userek kiolvasasakor");
				e.printStackTrace();
			}
			return users;
		}
		
		public void addUserObjectt(User user) {
					
					try {
						 String execute = "insert into users values ('?','?')";
						 preparedStatement = conn.prepareStatement(execute);
						 preparedStatement.setString(1, user.getName());
						 preparedStatement.setString(2, user.getAddress());
						 preparedStatement.execute();
					} catch (SQLException e) {
						System.out.println("Valami baj van az uj user hozzaadasanal prepared statement metodussal");
						e.printStackTrace();
					}
				}
}
