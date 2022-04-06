package addressBook;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private JFrame mainFrame = this; // this가 mainFrame
	private Container backGroundPanel; // new 해줄 필요 X
	private JPanel topPanel, menuPanel, listPanel;
	private JButton homeButton, frButton, coButton, scButton, faButton, addButton;

	//backGroundPanel= getContentPane();

	// new 패널
	topPanel=new JPanel();menuPanel=new JPanel();listPanel=new JPanel();

	// new 버튼
	homeButton = new JButton("주소록 전체");
	frButton = new JButton("친구");
	coButton = new JButton("회사");
	scButton = new JButton("학교");
	faButton = new JButton("가족");
	addButton = new JButton("추가");

	listModel=new DefaultListModel<>();

	userList=new JList<>(listModel); // listModel에 데이터 집어넣어주면 된다.
}

	public MainFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("주소록 메인");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setInitLayout() {
		setVisible(true);
		// 2. 패널세팅
		backGroundPanel.setLayout(new BorderLayout());
		topPanel.setLayout(new GridLayout(2, 1)); // 2행
		menuPanel.setLayout(new GridLayout(1, 4)); // 4열
		listPanel.setLayout(new BorderLayout());

		// 3. 디자인
		//userList.setFixedCellHeight(50); // 리스트 각각의 높이
		topPanel.setPreferredSize(new Dimension(0, 100)); // 그리드레이아웃이기 때문에 높이만 적용됨

		// 4. 패널(컨테이너)에 컴포넌트 추가

		menuPanel.add(frButton);
		menuPanel.add(coButton);
		menuPanel.add(scButton);
		menuPanel.add(faButton);

		topPanel.add(homeButton);
		topPanel.add(menuPanel);

		backGroundPanel.add(topPanel, BorderLayout.NORTH);
		backGroundPanel.add(listPanel, BorderLayout.CENTER);
		backGroundPanel.add(addButton, BorderLayout.SOUTH);
	}

	private void addEventListener() {

	}

}