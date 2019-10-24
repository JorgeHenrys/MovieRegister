package henrys.com.br.MovieRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/movie_rental?user=root&password=machado231296&useTimezone=true&serverTimezone=UTC";
	
	
	
	public MovieDAO() {
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connected!");
		}catch(SQLException exp) {
			throw new RuntimeException(exp);
		}
	}
	
	public void closeConnection () throws SQLException {
		try {
			conn.close();
			System.out.println("Unplugged!");
		}catch(SQLException exp) {
			exp.printStackTrace();
		}
	}
	
	public void addMovie(Movie m) {
		String sql = "insert into movies(title, yearr, genre, id) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, m.getTitle());
			stmt.setString(2, m.getYear());
			stmt.setString(3, m.getGenre());
			stmt.setInt(4, m.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException exp){
			throw new RuntimeException(exp);
			
		}
		
	}
	
	public List<Movie> recoversMovie() {
		
		try {
			List<Movie> list = new ArrayList<Movie>();
			String sql = "select * from movies";
			stmt = conn.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				list.add(new Movie(res.getString("title"), res.getString("yearr"), res.getString("genre"), res.getInt("id")));
			}
			
			return list;
			
		}catch(SQLException exp) {
			exp.printStackTrace();
		}
		
		return null;
	}
	
}