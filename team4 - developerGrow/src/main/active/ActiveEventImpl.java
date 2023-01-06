package main.active;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import main.MainFrame;

public class ActiveEventImpl implements ActiveEvent {

	private int count;
	private SwingWorker<Void, Integer> swingWorker;
	
	private MainFrame mainFrame;
	private Characters characters;
	
	public ActiveEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		characters = new Characters(mainFrame);
	}
	
	private JLabel character;
	private JLabel active;
	
	public void defaultCharacter() {
		character = new JLabel();
		active = new JLabel();
		character.setIcon(characters.getDefaultImage());
		character.setBounds(211, 392, 210, 300);
		characters.setCharacterlbl(character);
		characters.setActivelbl(active);
		mainFrame.add(character);	
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void clearlbl() {
		if (character != null) {
			mainFrame.remove(character);
		}
		if (active != null) {
			mainFrame.remove(active);
		}
		mainFrame.revalidate();
		mainFrame.repaint();		
	}

	@Override
	public void showActiveCharacter(int time) {
		
		character = characters.getCharacterlbl();
		active = characters.getActivelbl();
		
		swingWorker = new SwingWorker<Void, Integer>() {

			@Override
			protected Void doInBackground() throws Exception {
				
				count = 0;
				
				for (int i = 0; i < time; i++) {
					
					publish(count);
					
					System.out.println(count);
					count++;
					Thread.sleep(250);
				}
				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				super.process(chunks);
				if (count >= time) {
					mainFrame.remove(character);
					mainFrame.remove(active);
					defaultCharacter();
				}
			}

			@Override
			protected void done() {
				super.done();
			}
		};
	}
	
	public SwingWorker<Void, Integer> getSwingWorker() {
		return swingWorker;
	}

	public Characters getCharacters() {
		return characters;
	}
}