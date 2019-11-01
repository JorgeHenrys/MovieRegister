package henrys.com.br.MovieRegister;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MovieTableModel extends AbstractTableModel implements TableModelListener{
	
	
	
	private static final long serialVersionUID = 1L;
	private MovieDAO dao;
	private List<String> columns;
	private List<Movie> movies;
	
	
	public MovieTableModel(MovieDAO dao) throws SQLException {
		this.dao = dao;
		this.movies = dao.recoversMovie();
		columns = Arrays.asList("Title", "Year", "Genre", "Id");
		this.addTableModelListener(this);
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int i) {
		return columns.get(i);
	}

	public int getRowCount() {
		return movies.size();
	}

	public Object getValueAt(int j, int h) {
		
		Movie movie = movies.get(j);
		switch (h) {
		case 0: return movie.getTitle();
		case 1: return movie.getYear();
		case 2: return movie.getGenre();
		case 3: return movie.getId();
		
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int j, int h) {
		return true;
	}
	
	
	public void setValueAt(Object aValue, int j, int h) {
		Movie movie = movies.get(j); 
		
		switch (h) {
		case 0: 
			movie.setTitle((String)aValue);
			break;
		case 1:
			movie.setYear((String)aValue);
			break;
		case 2:
			movie.setGenre((String)aValue);
			break;
		case 3:
			movie.setId((Integer)aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		fireTableCellUpdated(j,h); 
	}

	public void tableChanged(TableModelEvent ev) {
		try {
			int i = ev.getFirstRow();
			Movie movie = movies.get(i);
			System.out.println(i);
			dao.updateMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}