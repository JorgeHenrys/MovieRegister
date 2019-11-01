package henrys.com.br.MovieRegister;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame{
	
	
	
	private static final long serialVersionUID = 1L;

	public FrameTable() throws SQLException{
		super("Galeria de Filmes");
		final MovieDAO dao = new MovieDAO();
		JTable t = new JTable(new MovieTableModel(dao));
		
		JScrollPane scroll = new JScrollPane(); 
		scroll.setViewportView(t);
		add(scroll);
		setSize(400,300);
		setLocationRelativeTo(null); 
	}
}