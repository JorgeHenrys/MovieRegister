package henrys.com.br.MovieRegister;


public class Movie {
	private String title, yearr, genre;
	private int id;
	
	public Movie(String t, String y, String g, int i) {
		this.title = t;
		this.yearr = y;
		this.genre = g;
		this.id = i;
	}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getYear() {return yearr;}
	public void setYear(String yearr) {this.yearr = yearr;}
	public String getGenre() {return genre;}
	public void setGenre(String genre) {this.genre = genre;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	
	@Override
	
	public String toString() {
		return " Movie(s) [Title: " + this.getTitle() + ", Year: " + this.getYear() + ", Genre: " + this.getGenre() + ", Id: " + this.getId() + "]";
	}
}