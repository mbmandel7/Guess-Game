package guessGame;

import java.util.ArrayList;

import javax.swing.JPanel;

public class TaskFactory {

	private final JPanel upperPanel;
	private final JPanel lowerPanel;

	ArrayList<JPanel> upperPanels;
	ArrayList<JPanel> lowerPanels;

	public TaskFactory() {
		/*
		 * create a function that will go through the folder to pick all the
		 * panels by name
		 * 
		 * //this.upperPanel = upperPanels.get(r.nextInt(upperPanels.size()));
		 * //this.lowerPanel = lowerPanels.get(r.nextInt(lowerPanels.size()));
		 */

		this.upperPanel = new UpperPanel_1();
		this.lowerPanel = new LowerPanel_1();

		// upperPanels.add(this.upperPanel);
		// lowerPanels.add(this.lowerPanel);

		// final Random r = new Random();

	}

	public JPanel getUpperPanel() {
		return upperPanel;
	}

	public JPanel getLowerPanel() {
		return lowerPanel;
	}

}
