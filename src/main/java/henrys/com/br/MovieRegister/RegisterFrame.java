package henrys.com.br.MovieRegister;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblYear, lblGenre, lblId;
	private JTextField txtTitle, txtYear, txtGenre, txtId;
	private JButton btnRegister, btnClean, btnExit, btnView;
	private JPanel jpnTitle, jpnYear, jpnGenre, jpnId, jpnButtons;
	
	
	private MovieDAO doc = new MovieDAO();
	
	Font font = new Font ("Courier", Font.ITALIC, 15);
	
	private void btnExitActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(this,
				"Do you really want to close the application?",
				"Exit - Confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
				);
		if (confirm == JOptionPane.YES_OPTION) {
			try {
				doc.closeConnection();
				System.exit(1);
			} catch (SQLException exp) {
				exp.printStackTrace();
			}
		}
		
		
	}
	
	private void btnRegisterActionPerformed() {
		JOptionPane.showMessageDialog(null,
				"Registration successfully completed!", 
				"Faculty Registration",
				JOptionPane.PLAIN_MESSAGE
				);
	}
	
	/*	
	private String viewAux() {
		List<Movie> jj = doc.recoversMovie();
		String movies = "";
		for (Movie m : jj) {
			movies = movies + "Title: " + m.getTitle() + ", Year: " + m.getYear() + ", Genre: " + m.getGenre() + ", Id: " + String.valueOf(m.getId() + "\n");
		}
		return movies;
	}
	
	private void btnViewActionPerformed() {
		JOptionPane.showMessageDialog(null,
				this.viewAux(),
				"View Records",
				JOptionPane.PLAIN_MESSAGE);
	}
	*/
	
	public RegisterFrame() {
		
		
		setTitle("Movies Register");
		setSize(600,300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		
		lblTitle = new JLabel("Title: ");
		txtTitle = new JTextField(15);
		
		lblYear = new JLabel("Year: ");
		txtYear = new JTextField(15);
		
		lblGenre = new JLabel("Genre: ");
		txtGenre = new JTextField(16);
		
		lblId = new JLabel("Id: ");
		txtId = new JTextField(14);
		
		btnRegister = new JButton("Register");
		btnClean = new JButton("Clean");
		btnExit = new JButton("Exit");
		btnView = new JButton("View Records");
		
		
		btnRegister.setFont(font);
		btnClean.setFont(font);
		btnExit.setFont(font);
		btnView.setFont(font);
		lblTitle.setFont(font);
		txtTitle.setFont(font);
		lblYear.setFont(font);
		txtYear.setFont(font);
		lblGenre.setFont(font);
		txtGenre.setFont(font);
		lblId.setFont(font);
		txtId.setFont(font);
		
		jpnTitle = new JPanel();
		jpnYear = new JPanel();
		jpnGenre = new JPanel();
		jpnId = new JPanel();
		jpnButtons = new JPanel();
		
		
		jpnTitle.add(lblTitle);
		jpnTitle.add(txtTitle);
		jpnYear.add(lblYear);
		jpnYear.add(txtYear);
		jpnGenre.add(lblGenre);
		jpnGenre.add(txtGenre);
		jpnId.add(lblId);
		jpnId.add(txtId);
		jpnButtons.add(btnRegister);
		jpnButtons.add(btnClean);
		jpnButtons.add(btnExit);
		jpnButtons.add(btnView);
		
		add(jpnTitle);
		add(jpnYear);
		add(jpnGenre);
		add(jpnId);
		add(jpnButtons);
		
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnExitActionPerformed();
			}
		});
		
		
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				txtTitle.setText("");
				txtYear.setText("");
				txtGenre.setText("");
				txtId.setText("");
			}
		});
		
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				MovieDAO movie = new MovieDAO();
				movie.addMovie(new Movie(txtTitle.getText(), txtYear.getText(), txtGenre.getText(), Integer.parseInt(txtId.getText())));
				btnRegisterActionPerformed();
			}
		});
		
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					FrameTable frame = new FrameTable();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}

