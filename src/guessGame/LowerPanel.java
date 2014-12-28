package guessGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LowerPanel extends JPanel {

	private JTextField answerText;
	private JLabel answerLabel;
	private JButton submit;
	private JButton next;
	private String answer;

	public LowerPanel(Frame frame, Connection conn) {
		this.setAnswer("");

		this.answerText = new JTextField(50);
		this.answerText.setText("Type your answer here");

		this.answerLabel = new JLabel("Guess the picture");

		this.submit = new JButton("Submit");
		this.submit.addActionListener(new CheckAnswerListener());

		// next button
		next = new JButton("Next");
		next.addActionListener(new NextTaskListener(frame, conn));

		this.add(answerLabel);
		this.add(answerText);
		this.add(next);
		this.add(submit);

	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private class CheckAnswerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(answer);
			if (answer.equals(answerText.getText())) {

				JOptionPane.showMessageDialog(null, "Correct");
			} else {
				JOptionPane.showMessageDialog(null, "Try Again");
			}

		}

	}

	private class NextTaskListener implements ActionListener {
		
		private Frame frame;
		private Connection conn;

		public NextTaskListener(Frame frame, Connection conn) {
			this.frame = frame;
			this.conn = conn;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				frame.readInTask(conn.getClient());
			} catch (InterruptedException | ExecutionException
					| TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	
}
