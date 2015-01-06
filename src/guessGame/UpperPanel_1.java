package guessGame;

import java.awt.Graphics;

import javax.swing.JPanel;

public class UpperPanel_1 extends JPanel {

	private final String answer = "rectangle";

	@Override
	protected void paintComponent(Graphics g) {
		g.drawRect(20, 20, 100, 100);
	}

	public boolean getAnswer(String answer) {

		if (this.answer.equals(answer)) {
			return true;
		} else {
			return false;
		}
	}
}