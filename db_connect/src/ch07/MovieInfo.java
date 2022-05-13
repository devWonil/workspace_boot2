package ch07;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lombok.Data;

@Data
public class MovieInfo extends JFrame implements ItemListener {

	MovieInfoDao dao;
	
	// 카테고리 검색
	private JPanel searchPanel;
	private TitledBorder categoryBorder;

	// crud
	private JPanel crudPanel;
	private TitledBorder crudBorder;

	private JRadioButton movieName;
	private JRadioButton releaseDate;

	private JTextField searchField;

	private JButton searchButton;

//	private JComboBox comboBox;

	// 영화 조회
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel mainPanel;

	// 영화 테이블
	String schema[] = { "번호", "이름", "개봉년도", "수익", "관객수", "스크린 수", "평점" };
	
	public MovieInfo() {
		
		dao = new MovieInfoDao();

		setBounds(100, 100, 628, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 메인 패널
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);

		// 카테고리로 검색
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		categoryBorder = new TitledBorder("카테고리 검색");
		searchPanel.setBorder(categoryBorder);
		searchPanel.setBounds(10, 80, 592, 60);
		mainPanel.add(searchPanel);

		//
		crudPanel = new JPanel();
		crudPanel.setLayout(null);
		crudBorder = new TitledBorder("crud");
		crudPanel.setBorder(crudBorder);
		crudPanel.setBounds(10, 10, 592, 60);
		mainPanel.add(crudPanel);

		model = new DefaultTableModel(null, schema);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 153, 588, 313);
		scrollPane.setViewportView(table);
		mainPanel.add(scrollPane);

		// 라디오 박스
		movieName = new JRadioButton("이름");
		movieName.setBounds(380, 27, 90, 12);
		searchPanel.add(movieName);

		releaseDate = new JRadioButton("개봉일");
		releaseDate.setBounds(480, 27, 90, 12);
		searchPanel.add(releaseDate);

		searchField = new JTextField("명량");
		searchField.setBounds(20, 20, 230, 26);
		searchPanel.add(searchField);

		searchButton = new JButton("검색");
		searchButton.setBounds(280, 20, 70, 25);
		searchPanel.add(searchButton);

//		searchButton.addActionListener(this);
//        releaseDate.addActionListener(this);

		movieName.addItemListener(this);
		releaseDate.addItemListener(this);

		DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
		defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(defaultTableCellRenderer);
		}
		
		SelectAll();

//        comboBox = new JComboBox();
//        comboBox.setBounds(146, 40, 100, 20);
//        searchPanel.add(comboBox);
//        comboBox.addItem("번호 선택");
//        
//        comboBox.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange() == ItemEvent.SELECTED) {
//					
//				}
//				
//			}
//		});

		setVisible(true);

	}
	
	public void SelectAll() {
//		dao.selectAll();
		for (int i = 0; i < dao.selectAll().size(); i++) {
			model.addRow(new Object[] {
					dao.selectAll().get(i).getMovieNumber(), 
					dao.selectAll().get(i).getMovieName(),
					dao.selectAll().get(i).getReleasedDate(),
					dao.selectAll().get(i).getRevenue(),
					dao.selectAll().get(i).getAudience(),
					dao.selectAll().get(i).getScreen(),
					dao.selectAll().get(i).getStarRating()});
		}
	}

	// 라디오 버튼
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		
		// 영화 제목 버튼 클릭됨
		if (e.getSource() == movieName) {
			releaseDate.setEnabled(false);
			// 영화 쿼리 뿌림
			
			searchButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == searchButton) {
						dao.selectByMovieName(searchField.getText());
						
						if(model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}
						
						for (int i = 0; i < dao.selectByMovieName(searchField.getText()).size(); i++) {
							model.addRow(new Object[] {
									dao.selectByMovieName(searchField.getText()).get(i).getMovieNumber(), 
									dao.selectByMovieName(searchField.getText()).get(i).getMovieName(),
									dao.selectByMovieName(searchField.getText()).get(i).getReleasedDate(),
									dao.selectByMovieName(searchField.getText()).get(i).getRevenue(),
									dao.selectByMovieName(searchField.getText()).get(i).getAudience(),
									dao.selectByMovieName(searchField.getText()).get(i).getScreen(),
									dao.selectByMovieName(searchField.getText()).get(i).getStarRating()
							});
						}
					}
				}
			});
			
			
			
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				releaseDate.setEnabled(true);
			}
		} else if (e.getSource() == releaseDate) {
			movieName.setEnabled(false);
			
				searchButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == searchButton) {
						dao.selectByMovieName(searchField.getText());
						
						if(model.getRowCount() > 0) {
							for (int i = model.getRowCount() - 1; i > -1; i--) {
								model.removeRow(i);
							}
						}
						
						for (int i = 0; i < dao.selectByReleasedYear(searchField.getText()).size(); i++) {
							model.addRow(new Object[] {
									dao.selectByReleasedYear(searchField.getText()).get(i).getMovieNumber(), 
									dao.selectByReleasedYear(searchField.getText()).get(i).getMovieName(),
									dao.selectByReleasedYear(searchField.getText()).get(i).getReleasedDate(),
									dao.selectByReleasedYear(searchField.getText()).get(i).getRevenue(),
									dao.selectByReleasedYear(searchField.getText()).get(i).getAudience(),
									dao.selectByReleasedYear(searchField.getText()).get(i).getScreen(),
									dao.selectByReleasedYear(searchField.getText()).get(i).getStarRating()
							});
						}
					}
				}
			});
			
			
			
			
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				movieName.setEnabled(true);
			}
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getSource() == searchButton) {
//			MovieInfoDao dao = new MovieInfoDao();
//			dao.selectByMovieName(searchField.getText());
//		}
//	}
	

	
	

}
