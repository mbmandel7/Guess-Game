package guessGame;

import java.awt.Graphics;

public class UpperPanel_1 extends UpperPanel {

	private final String answer = "rectangle";

	@Override
	protected void paintComponent(Graphics g) {
		g.drawRect(20, 20, 100, 100);
	}

	/*
	 * public boolean getAnswer(String answer) {
	 * 
	 * if (this.answer.equals(answer)) { return true; } else { return false; } }
	 */

	@Override
	public String getAnswer() {
		return answer;
	}

}