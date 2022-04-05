package lotto_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener{
	
	JButton startButton;
	int[] lottoNumbers = new int[6];
	
	public LottoFrame() {
		setSize(600, 400);
		setBackground(Color.lightGray);
		setVisible(true);
		startButton = new JButton("로또");
		add(startButton, BorderLayout.SOUTH);
		startButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = getLotto();
		// 그림을 다시 그려라
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		Font font = new Font("굴림체", Font.BOLD, 20);
		g.setFont(font);
		
		if(lottoNumbers[0] == 0) {
			g.drawString("로또 버튼을 클릭하세요", 200, 200);
			return;
		}
		
		// lottoNumbers[0] 값이 있다면 (6개 번호를 생성 한 후)
		// 여기서 번호를 그려 봅니다
		
		g.setColor(new Color(0, 255, 0));
		g.drawString(lottoNumbers[0] +"", 150, 200);
		g.setColor(new Color(255, 0, 0));
		g.drawString(lottoNumbers[1] +"", 200, 200);
		g.setColor(new Color(0, 0, 255));
		g.drawString(lottoNumbers[2] +"", 250, 200);
		g.setColor(new Color(0, 0, 0));
		g.drawString(lottoNumbers[3] +"", 300, 200);
		g.setColor(new Color(255, 255, 0));
		g.drawString(lottoNumbers[4] +"", 350, 200);
		g.setColor(new Color(255, 0, 255));
		g.drawString(lottoNumbers[5] +"", 400, 200);
		System.out.println();
	}
	
	public static void main(String[] args) {
		new LottoFrame();
	}
	
	public int[] getLotto() {
		
		int[] lotto = new int[6];
		Random random = new Random();
		for(int i = 0; i < 6; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			for(int e = 0; e < i; e++) {
				if(lotto[i] == lotto[e]) {
					i--;
					break;
				}
			}
		}
		
		// 정렬 문제 해결
		Arrays.sort(lotto);
		
		for (int i : lotto) {
			System.out.print(i + "\t");
		}
		
		//System.out.println(lotto.toString());
		
		return lotto;
	}
	
	
}
