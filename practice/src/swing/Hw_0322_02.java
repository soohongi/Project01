package swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Mine implements MouseListener {
	Hw_0322_02 mainGame;
	Mine[] nearMine = new Mine[8]; // ÀÌ¿ô ¸¶ÀÎ
	Button gridBtn = new Button();
	boolean isOpen = false;
	boolean haveMine = false;
	boolean checkMine = false;

	public Mine(Hw_0322_02 mainGame) {
		this.mainGame = mainGame;
		gridBtn.addMouseListener(this);
	}

	void reset() {
		isOpen = false;
		haveMine = false;
		checkMine = false;
		gridBtn.setEnabled(true);
		gridBtn.setBackground(Color.WHITE);
		gridBtn.setLabel("");
	}

	void checkMine() {
		checkMine = !checkMine;
		update();
	}

	void open() {
		if (isOpen)
			return;

		isOpen = true;
		update();
	}

	void gameOver() {
		if (haveMine)
			gridBtn.setLabel("*");
		gridBtn.setEnabled(false);
	}

	void update() {
		if (isOpen) {
			if (haveMine) {
				mainGame.gameOver();
				return;
			}
			int nearMineCount = 0;
			for (int i = 0; i < 8; i++) {
				if (nearMine[i] != null) {
					if (nearMine[i].haveMine)
						nearMineCount++;
				}
			}
			if (nearMineCount > 0)
				gridBtn.setLabel("" + nearMineCount);
			else {
				for (int i = 0; i < 8; i++) {
					if (nearMine[i] != null)
						nearMine[i].open();
				}
			}
			gridBtn.setBackground(Color.GRAY);
			gridBtn.setEnabled(false);
		} else {
			if (checkMine) {
				gridBtn.setLabel("r");
			} else {
				gridBtn.setLabel("");
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (!isOpen)
				open();
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			checkMine();
			mainGame.checkGame();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

public class Hw_0322_02 extends Frame {

	final int cellCount = 15;
	final int mineCount = 20;
	Mine[][] mines = new Mine[cellCount][cellCount];

	public Hw_0322_02() {
		super("Mine");
		setBounds(100, 100, 800, 600);
		setLayout(new GridLayout(cellCount, cellCount));
		for (int i = 0; i < cellCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				mines[i][j] = new Mine(this);
				add(mines[i][j].gridBtn);
			}
		}
		// ÀÌ¿ô »çÃÌ µî·Ï
		for (int i = 0; i < cellCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				if (i - 1 >= 0 && j - 1 >= 0)
					mines[i][j].nearMine[0] = mines[i - 1][j - 1];

				if (i - 1 >= 0)
					mines[i][j].nearMine[1] = mines[i - 1][j];

				if (i - 1 >= 0 && j + 1 < cellCount)
					mines[i][j].nearMine[2] = mines[i - 1][j + 1];

				if (j + 1 < cellCount)
					mines[i][j].nearMine[3] = mines[i][j + 1];

				if (i + 1 < cellCount && j + 1 < cellCount)
					mines[i][j].nearMine[4] = mines[i + 1][j + 1];

				if (i + 1 < cellCount)
					mines[i][j].nearMine[5] = mines[i + 1][j];

				if (i + 1 < cellCount && j - 1 >= 0)
					mines[i][j].nearMine[6] = mines[i + 1][j - 1];

				if (j - 1 >= 0)
					mines[i][j].nearMine[7] = mines[i][j - 1];
			}
		}
		shuffle();
		setVisible(true);

		addWindowListener(new FrameClose());
	}

	void endDlg(String str) {
		Dialog gameOver = new Dialog(this, str, true);
		gameOver.setBounds(0, 0, 300, 200);
		gameOver.addWindowListener(new FrameClose());
		Button newGame = new Button("newGame");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < cellCount; i++) {
					for (int j = 0; j < cellCount; j++) {
						mines[i][j].reset();
					}
				}
				shuffle();
				((Dialog) ((Button) e.getSource()).getParent()).dispose();
			}
		});
		gameOver.add(newGame);
		gameOver.setVisible(true);
	}

	void gameOver() {
		for (int i = 0; i < cellCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				mines[i][j].gameOver();
			}
		}
		endDlg("GameOver");

	}

	void checkGame() {
		int count = 0;
		for (int i = 0; i < cellCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				if (!mines[i][j].checkMine && !mines[i][j].isOpen)
					return;

				if (mines[i][j].checkMine && mines[i][j].haveMine)
					count++;
			}
		}
		if (count == mineCount)
			endDlg("Å¬¸®¾î");
	}

	void shuffle() {
		int count = 0;
		while (true) {
			int rand = (int) (Math.random() * cellCount * cellCount);
			if (!mines[rand / cellCount][rand % cellCount].haveMine) {
				mines[rand / cellCount][rand % cellCount].haveMine = true;
				count++;
			}
			if (count == mineCount)
				break;
		}

	}

	public static void main(String[] args) {
		new Hw_0322_02();
	}
}