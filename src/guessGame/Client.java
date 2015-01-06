package guessGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Client extends JFrame {

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private final JPanel upperPanel;
	private final JPanel lowerPanel;
	private JButton button;

	public Client(JPanel upperPanel, JPanel lowerPanel) throws ClassNotFoundException {

		this.setTitle("Client Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(800, 600);

		this.upperPanel = upperPanel;
		this.upperPanel.setPreferredSize(new Dimension(800, 600));
		this.add(upperPanel, BorderLayout.NORTH);

		this.lowerPanel = lowerPanel;
		lowerPanel.setPreferredSize(new Dimension(800, 100));
		this.add(lowerPanel, BorderLayout.SOUTH);

		this.setVisible(true);
		Socket socket;
		try {
			socket = new Socket("localhost", 8080);
			System.out.println("Connection Established");
			in = new ObjectInputStream(socket.getInputStream());
			System.out.println("reached");

			lowerPanel = (JPanel) in.readObject();
			this.add(lowerPanel, BorderLayout.SOUTH);
			this.repaint();

			JOptionPane.showMessageDialog(null, lowerPanel != null);
			System.out.println("boo");

		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] main) throws UnknownHostException, IOException, ClassNotFoundException {

		final TaskFactory task = new TaskFactory();

		new Client(task.getUpperPanel(), task.getLowerPanel());
	}
}
