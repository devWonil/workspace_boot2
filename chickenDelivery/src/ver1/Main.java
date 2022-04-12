package ver1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	/*버튼*/
	static JButton b1=new JButton("배달");
	/*패널1*/
	static JPanel page1=new JPanel() {
		/*이미지*/
		Image background=new ImageIcon("images/kitService2.png").getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, getWidth(), getHeight(), null);//background를 그려줌		
		}
	};
	/*패널2*/
	static JPanel page2=new JPanel() {
		/*이미지*/
		Image background=new ImageIcon("images/delService.png").getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, getWidth(), getHeight(), null);//background를 그려줌		
		}
	};
	public Main() {
		homeframe();//homeframe함수를 실행
		setpanel();//setpanel함수를 실행
		customcursor();//customcursor함수를 실행
		cg();//cg함수를 실행
	}
	/*커서설정*/
	public void customcursor(){
		/*커서만드는중*/
	}
	/*프레임 설정*/
	public void homeframe() {
		setTitle("치킨배달");//타이틀
		setSize(1000,800);//프레임의 크기
		setResizable(true);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);//레이아웃 설정
		setVisible(true);//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}
	/*패널 관련 설정*/
	public void setpanel() {
		/*위치 설정*/
		b1.setBounds(500, 800, 100, 30);//버튼1의 위치 설정
		page1.setBounds(0, 0, 1000, 800);//패널1의 위치 설정
		page2.setBounds(0, 0, 1000, 800);//패널2의 위치 설정
		/*레이아웃 지정*/
		page2.setLayout(null);//레이아웃 설정
		page1.setLayout(null);//레이아웃 설정
		/*visible*/
		page2.setVisible(false);//창이 보이지 않게
		/*패널이나 프레임에 추가*/
		add(page1);//프레임에 패널을 추가
		add(page2);//프레임에 패널을 추가
		page1.add(b1);//패널1에 버튼을 추가
	}
	/*마우스 이벤트*/
	public void cg(){
		b1.addMouseListener(new MouseAdapter() { // 마우스 이벤트 
			@Override public void mouseEntered(MouseEvent e) { // 마우스 들어왔을때 
			} 
			@Override public void mouseExited(MouseEvent e) { // 마우스 나왔을때 	
			}
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때 
				page1.setVisible(false);//창이 보이게
				page2.setVisible(true);//창이 보이게
				System.out.println("눌렀엉");//눌렸는지 확인하려고 넣음.
			} 
		});
	}
	/*메인함수*/
	public static void main(String[] args){
		new Main(); //실행하면 생성자가 실행됨.
	}
}
