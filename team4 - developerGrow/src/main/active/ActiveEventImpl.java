package main.active;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import main.MainFrame;

public class ActiveEventImpl implements ActiveEvent {

	private int count;
	private boolean isCoupang = false;
	private SwingWorker<Void, Integer> swingWorker;

	private MainFrame mainFrame;
	private Characters characters;
	
	
	
	public ActiveEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		characters = new Characters(mainFrame);
	}

	private JLabel character;
	private JLabel active;

	public void clearlbl() {
		
		character = characters.getCharacterlbl();
		active = characters.getActivelbl();
		
		if (character != null) {
			mainFrame.remove(character);
		}
		if (active != null) {
			mainFrame.remove(active);
		}
		
		defaultProgressBar();
		
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

					count++;
					Thread.sleep(250);
				}

				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				super.process(chunks);
				
				if (count >= time) {
					if (isCoupang) {
						getPaidCoupang();
						isCoupang = false;
					}
					mainFrame.remove(character);
					mainFrame.remove(active);
					mainFrame.getActivitybtn().setEnabled(true);
					characters.defaultCharacter();
					defaultProgressBar();
					mainFrame.revalidate();
					mainFrame.repaint();
				}
			}

			@Override
			protected void done() {
				super.done();
			}
		};
	}

	@Override
	public void smokeProgressBar() {
		mainFrame.getPb().hpbarDecreas(1000);
		mainFrame.getPb().stressbarDecreas(1000);
		mainFrame.getPb().healthbarDecreas(1500);
	}

	@Override
	public void sleepProgressBar() {
		mainFrame.getPb().hpbarIncrease(1000);
		mainFrame.getPb().stressbarDecreas(1000);
		mainFrame.getPb().healthbarIncrease(1000);
	}

	@Override
	public void playgameProgressBar() {
		mainFrame.getPb().hpbarDecreas(1500);
		mainFrame.getPb().stressbarDecreas(1500);
		mainFrame.getPb().healthbarDecreas(1500);
	}

	@Override
	public void eatProgressBar() {
		mainFrame.getPb().hpbarIncrease(2000);
		mainFrame.getPb().stressbarDecreas(1500);
		mainFrame.getPb().healthbarIncrease(1500);
	}

	@Override
	public void resumeProgressBar() {
		mainFrame.getPb().hpbarDecreas(1500);
		mainFrame.getPb().stressbarIncrease(1000);
		mainFrame.getPb().healthbarDecreas(1000);
	}

	@Override
	public void coupangProgressBar() {
		mainFrame.getPb().hpbarDecreas(500);
		mainFrame.getPb().stressbarIncrease(800);
		mainFrame.getPb().healthbarDecreas(800);
	}
	
	@Override
	public void getPaidCoupang() {
		
		int currentCiga = mainFrame.getCiga();
		int getPaid = currentCiga + 20;
		
		mainFrame.setCiga(getPaid);
		mainFrame.getUserInfo().setCiga(getPaid);
		mainFrame.getNumOfcigalbl().setText(String.valueOf(getPaid));
		
		System.out.println(mainFrame.getCiga());
		System.out.println(mainFrame.getUserInfo().getCiga());
	}

	@Override
	public void defaultProgressBar() {
		mainFrame.getPb().hpbarDecreas(500);
		mainFrame.getPb().stressbarIncrease(1000);
		mainFrame.getPb().healthbarDecreas(1000);
	}

	public SwingWorker<Void, Integer> getSwingWorker() {
		return swingWorker;
	}

	public Characters getCharacters() {
		return characters;
	}

	public void setCoupang(boolean isCoupang) {
		this.isCoupang = isCoupang;
	}
}