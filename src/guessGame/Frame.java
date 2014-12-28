package guessGame;

import guessGame.paint.message.ClearMessage;
import guessGame.paint.message.PaintMessage;
import guessGame.tasks.Task;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.swing.JFrame;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

public class Frame extends JFrame {

	private UpperPanel upperPanel;
	private LowerPanel lowerPanel;

	public Frame() throws Exception {

		this.setTitle("Client Game");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(800, 600);

		Connection conn = new Connection();
		
		//create and add upper panel
		this.upperPanel = new UpperPanel();
		this.upperPanel.setPreferredSize(new Dimension(600, 600));
		this.add(upperPanel, BorderLayout.NORTH);
		
		//create and add lower panel
		this.lowerPanel = new LowerPanel(this, conn);			
		lowerPanel.setPreferredSize(new Dimension(600, 100));
		this.add(lowerPanel, BorderLayout.SOUTH);
		
		//setVisible(true); // take this out, just used for testing

		readInTask(conn.getClient());
	}

	public void readInTask(HttpClient client) throws InterruptedException, ExecutionException, TimeoutException {
		this.upperPanel.repaint(new ClearMessage());
		ContentResponse response = client.GET("http://localhost:8080");
		System.out.println(response.getRequest().getAttributes());
		System.out.println(response.getRequest().getAttributes());
		Object m = response.getHeaders();
		Object obj = null;
		
		try {
			ObjectInputStream inStream = new ObjectInputStream(
					new ByteArrayInputStream(response.getContent()));
			obj = inStream.readObject();

			addPaintTask(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	public void addPaintTask(Object obj) {
		this.upperPanel.removeAll();
		Task g = (Task) obj;
		PaintMessage h = (PaintMessage) g.getChallenge();
		String answer = g.getAnswer();
		this.lowerPanel.setAnswer(answer);
		this.upperPanel.repaint(h);
		this.repaint();
	}

	public void addTask(Object obj) {
		// TODO Auto-generated method stub
		Task g = (Task) obj;
		PaintMessage h = (PaintMessage) g.getChallenge();
	}
	
	

	public static void main(String[] main) throws UnknownHostException,
			IOException, ClassNotFoundException {

		try {
			Frame c = new Frame();
			c.setVisible(true);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
