package guessGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LowerPanel_1 extends JPanel implements Serializable {

	private JTextField typeAnswer;
	private JLabel laber;
	private JButton button;
	
	public LowerPanel_1(){
		this.typeAnswer = new JTextField (50);
		this.typeAnswer.setText("Type your answer here");
		this.laber = new JLabel("Type in your answer");
		this.button = new JButton ("Submit");
		this.button.addActionListener(new CheckAnswerListener());
		
		
		this.add(laber, BorderLayout.NORTH);
		this.add(typeAnswer, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
	}
	
	private class CheckAnswerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "I should be checking the answer");
			
		}
		
	}
}
