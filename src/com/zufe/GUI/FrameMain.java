package com.zufe.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

import com.zufe.DATA.Data;
import com.zufe.FRAME.*;
import com.zufe.POSITION.PositionName;

@SuppressWarnings("serial")
public class FrameMain extends JFrame implements ActionListener,
		ChangeListener, WindowListener {
	Data data = new Data();
	
	private Calendar select;
	private Date initDate;
	PositionName pName = new PositionName();
	JComboBox box;
	JComboBox box1;
	JComboBox box2;
	JComboBox box3;
	JComboBox box4;
	JComboBox box5;
	JComboBox box6;
	JLabel label;
	JLabel label1;
	JCheckBox checkBox[] = new JCheckBox[15];
	
	JCheckBox checkBox0 = new JCheckBox("AQI");
	JCheckBox checkBox1 = new JCheckBox("PM25");
	JCheckBox checkBox2 = new JCheckBox("PM25_24h");
	JCheckBox checkBox3 = new JCheckBox("PM10");
	JCheckBox checkBox4 = new JCheckBox("PM10_24h");
	JCheckBox checkBox5 = new JCheckBox("SO2");
	JCheckBox checkBox6 = new JCheckBox("SO2_24h");
	JCheckBox checkBox7 = new JCheckBox("NO2");
	JCheckBox checkBox8 = new JCheckBox("NO2_24h");
	JCheckBox checkBox9 = new JCheckBox("O3");
	JCheckBox checkBox10 = new JCheckBox("O3_24h");
	JCheckBox checkBox11 = new JCheckBox("O3_8h");
	JCheckBox checkBox12 = new JCheckBox("O3_8h_24h");
	JCheckBox checkBox13 = new JCheckBox("CO");
	JCheckBox checkBox14 = new JCheckBox("CO_24h");
	
	JLabel hourJLabel = new JLabel();
	JLabel ThresholdJLabel = new JLabel();
	JSlider sliderHour = new JSlider(JSlider.HORIZONTAL, 0, 23, 0);
	JSlider Threshold = new JSlider(JSlider.HORIZONTAL, 0,280, 0);
	
	JSlider SliderAlpha = new JSlider(JSlider.HORIZONTAL, 0,100,75);
	JSlider SliderBeta = new JSlider(JSlider.HORIZONTAL, 0,100,75);
	
	int skt[]={0,1,2,3,4,5,6};
	int sk1,sk2,sk3,sk4,sk5,sk6;
	JLabel labelHourStart = new JLabel(" 0 ");
	JLabel labelThresholdStart = new JLabel(" 0 ");
	
	JLabel labelAlphaStart = new JLabel(" 0.75 ");
	JLabel labelBetaStart = new JLabel(" 0.75 ");
	
	JLabel labelTime = new JLabel("选择时间");
	
	int hour,month=6,day=1;
	String natureName[] = {"AQI","PM25", "PM10", "SO2",
			"NO2", "O3", "CO"};		
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	JButton buttonOK;
	int judge=0;
	int judge1=1;
	int options[]=new int[15];
	int value[]=new int[2];
	
	int type=1;
	JMenuBar menuBar;
	JMenu  menuFile,menuLook,menuSet,menuOperate;
	JMenuItem menuItemlooktime,menuItemlookarea,menuItemLoadData, menuItemCloseFile, menuItemExpotFile,menuItemVoronoi,menuItemMDS;
	JMenuItem menuItemTime=new JMenuItem("设置时间");
	final DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
	FrameMap framemap = new FrameMap(dateChooser1);
	Color bgColor=new Color(255,255,255);
	FrameMain(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addSlider();
		addSlider1();
		//addAlpha();
		//addBeta();
		//addBox();
		this.setBounds(0, 0, 1200, 800);
		addmenu();
		addcheck();
		//addRedioButton();
		//addLabel();
		this.setBackground(Color.WHITE);
		this.add(framemap);
		framemap.init();
		framemap.start();
		sliderHour.addChangeListener(this);
		Threshold.addChangeListener(this);
		SliderAlpha.addChangeListener(this);
		SliderBeta.addChangeListener(this);
		
		data.LoadData();
	}
	public void addRedioButton(){
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(40, 28));
		panel1.setBackground(bgColor);
		panel1.setBounds(50, 50,100,100);
		radioButton1 = new JRadioButton("AQI排序");
		radioButton1.setBackground(bgColor);
		radioButton1.setPreferredSize(new Dimension(100, 25));
		radioButton1.addActionListener(this);
		radioButton1.setSelected(true);
		radioButton2 = new JRadioButton("编号排序");
		radioButton2.setBackground(bgColor);
		radioButton2.setPreferredSize(new Dimension(100, 25));
		radioButton2.addActionListener(this);
		
		radioButton3 = new JRadioButton("外部AQI内部编号");
		radioButton3.setBackground(bgColor);
		radioButton3.setPreferredSize(new Dimension(100, 25));
		radioButton3.addActionListener(this);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		panel1.add(radioButton1);
		panel1.add(radioButton2);
		panel1.add(radioButton3);
		panel1.setBackground(bgColor);
		this.add(panel1);
		this.setBackground(bgColor);
	}
	
	public void addcheck(){
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		panel.setBounds(915, 55, 420, 22);
		panel2.setBounds(915, 130, 420, 22);
		panel3.setBounds(915, 205, 420, 22);
		panel4.setBounds(915, 280, 420, 22);
		panel5.setBounds(915, 355, 420, 22);
		
		checkBox[0] = new JCheckBox("AQI");
		checkBox[1] = new JCheckBox("PM25");
		checkBox[2] = new JCheckBox("PM25_24h");
		checkBox[3] = new JCheckBox("PM10");
		checkBox[4] = new JCheckBox("PM10_24h");
		checkBox[5] = new JCheckBox("SO2");
		checkBox[6] = new JCheckBox("SO2_24h");
		checkBox[7] = new JCheckBox("NO2");
		checkBox[8] = new JCheckBox("NO2_24h"); 
		checkBox[9] = new JCheckBox("O3");
		checkBox[10] = new JCheckBox("O3_24h");
		checkBox[11] = new JCheckBox("O3_8h");
		checkBox[12] = new JCheckBox("O3_8h_24h");
		checkBox[13] = new JCheckBox("CO");
		checkBox[14] = new JCheckBox("CO_24h");
		
		for(int i=0;i<15;i=i+5){
			checkBox[i].addActionListener(this);
			checkBox[i].setSelected(true);
			checkBox[i].setPreferredSize(new Dimension(135, 20));
			checkBox[i].setBackground(bgColor);
			panel.add(checkBox[i]);
		}
		
		for(int i=1;i<15;i=i+5){
			checkBox[i].addActionListener(this);
			checkBox[i].setSelected(true);
			checkBox[i].setPreferredSize(new Dimension(135, 20));
			checkBox[i].setBackground(bgColor);
			panel2.add(checkBox[i]);
		}
		for(int i=2;i<15;i=i+5){
			checkBox[i].addActionListener(this);
			checkBox[i].setSelected(true);
			checkBox[i].setPreferredSize(new Dimension(135, 20));
			checkBox[i].setBackground(bgColor);
			panel3.add(checkBox[i]);
		}
		for(int i=3;i<15;i=i+5){
			checkBox[i].addActionListener(this);
			checkBox[i].setSelected(true);
			checkBox[i].setPreferredSize(new Dimension(135, 20));
			checkBox[i].setBackground(bgColor);
			panel4.add(checkBox[i]);
		}
		for(int i=4;i<15;i=i+5){
			checkBox[i].addActionListener(this);
			checkBox[i].setSelected(true);
			checkBox[i].setPreferredSize(new Dimension(135, 20));
			checkBox[i].setBackground(bgColor);
			panel5.add(checkBox[i]);
		}
		
		panel.setBackground(bgColor);
		panel2.setBackground(bgColor);
		panel3.setBackground(bgColor);
		panel4.setBackground(bgColor);
		panel5.setBackground(bgColor);
		this.add(panel);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		for(int i=0;i<15;i++)
			options[i]=1;
		
	}
	public void addSlider() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel panel1 = new JPanel();
		JLabel labelHour = new JLabel(" Hour: ");
		panel1.add(labelHour);
		panel1.add(labelHourStart);
		panel1.add(sliderHour);
		panel1.setBounds(8, 365, 278, 20);
		labelHour.setBackground(bgColor);
		panel1.setBackground(bgColor);
		//hourJLabel.setBackground(bgColor);
		labelHourStart.setBackground(bgColor);
		sliderHour.setPreferredSize(new Dimension(200, 20));
		sliderHour.setBackground(bgColor);
		this.setBackground(bgColor);
		this.add(panel1);
		this.setBackground(bgColor);
	}
	public void addAlpha() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel panel1 = new JPanel();
		JLabel labelAlpha = new JLabel(" Alpha: ");
		panel1.add(labelAlpha);
		panel1.add(labelAlphaStart);
		panel1.add(SliderAlpha);
		panel1.setBounds(950, 400, 310, 20);
		labelAlpha.setBackground(bgColor);
		panel1.setBackground(bgColor);
		//hourJLabel.setBackground(bgColor);
		labelAlphaStart.setBackground(bgColor);
		SliderAlpha.setPreferredSize(new Dimension(215, 20));
		SliderAlpha.setBackground(bgColor);
		this.setBackground(bgColor);
		this.add(panel1);
		this.setBackground(bgColor);
	}
	public void addBeta() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel panel1 = new JPanel();
		JLabel labelBeta = new JLabel(" Beta:   ");
		panel1.add(labelBeta);
		panel1.add(labelBetaStart);
		panel1.add(SliderBeta);
		panel1.setBounds(950, 425, 310, 20);
		labelBeta.setBackground(bgColor);
		panel1.setBackground(bgColor);
		hourJLabel.setBackground(bgColor);
		labelBetaStart.setBackground(bgColor);
		SliderBeta.setPreferredSize(new Dimension(215, 20));
		SliderBeta.setBackground(bgColor);
		this.setBackground(bgColor);
		this.add(panel1);
		this.setBackground(bgColor);
	}
	public void addLabel(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		final JPanel panel1 = new JPanel();
		//panel1.add(labelTime);
		panel1.setBounds(950, 45, 300, 160);
		panel1.setBackground(bgColor);
		dateChooser1.register(panel1);
		panel1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me) {
				//dateChooser1.register(panel1);
				dateChooser1.update(null);
			}
		});
		
		this.setBackground(bgColor);
		this.add(panel1);
		this.setBackground(bgColor);
	}
	public void addmenu(){
		
		menuBar = new JMenuBar();
		menuFile=new JMenu("File");
		menuItemLoadData = new JMenuItem("LoadData");
		menuItemCloseFile = new JMenuItem("CloseFile");
		menuItemExpotFile = new JMenuItem("ExpotFile");
		menuFile.add(menuItemLoadData);
		menuFile.add(menuItemCloseFile);
		menuFile.add(menuItemExpotFile);
		menuBar.add(menuFile);
		menuSet = new JMenu("SetTime");
		menuOperate=new JMenu("Operate");
		menuItemVoronoi=new JMenuItem("Voronoi");
		menuItemMDS=new JMenuItem("MDS");
		menuOperate.add(menuItemVoronoi);
		menuOperate.add(menuItemMDS);
		
		menuItemTime=new JMenuItem("SetTime");
		
		dateChooser1.register(menuItemTime);
		
		menuSet.add(menuItemTime);
		menuBar.add(menuSet);
		menuBar.add(menuOperate);
		menuItemTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser1.update(null);
				
				int year=dateChooser1.getSelectYear();
				int month=dateChooser1.getSelectMonth();
				int day=dateChooser1.getSelectDay();
				//System.out.println("year:"+year+" "+"month:"+month);
			}
		});
		menuItemVoronoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framemap.getMDS(1);
			}
		});
		menuItemMDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framemap.getMDS(0);
			}
		});
		this.setJMenuBar(menuBar);
	}
	public void addSlider1() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel panel1 = new JPanel();
		JLabel labelThreshold= new JLabel("Threshold: ");
		//Color bg=new Color(188,193,187);
		JLabel labelThresholdEnd = new JLabel(" 250 ");
		panel1.setBackground(bgColor);
		labelThresholdEnd.setBackground(bgColor);
		panel1.add(labelThreshold);
		panel1.add(labelThresholdStart);
		panel1.add(Threshold);
		Threshold.setBackground(bgColor);
		//Threshold.setPreferredSize(new Dimension(170, 20));
		panel1.setBounds(555, 365, 350, 20);
		Threshold.setPreferredSize(new Dimension(245, 20));
		this.setBackground(bgColor);
		this.add(panel1);
	}
	
	public static void main(String[] args) {
		FrameMain frameMain = new FrameMain();
		frameMain.setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
		System.out.println("changdu"+screenSize.width);
		frameMain.setSize(screenSize.width,screenSize.height);
		frameMain.setVisible(true);
		frameMain.getContentPane().setLayout(null);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) { 
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {

		// TODO Auto-generated method stub

		if (e.getSource() == sliderHour) {
			hour = (int) sliderHour.getValue();
			framemap.changeValue(hour);
			framemap.changeValuehour(hour);
			String show = new String("");
			for (int i = 0; i < hour; ++i) {
				show +="";
			}
			labelHourStart.setText("" + hour);
		}else if (e.getSource() == Threshold) {
			int Thresholdhour = (int) Threshold.getValue();
			framemap.changeValue1(Thresholdhour);
			labelThresholdStart.setText("" + Thresholdhour);
		}else if (e.getSource() == SliderAlpha) {
			int Thresholdhour = (int) SliderAlpha.getValue();
			//framemap.changeValue1(Thresholdhour);
			labelAlphaStart.setText("" + Thresholdhour*1.0/100);
		}else if (e.getSource() == SliderBeta) {
			int Thresholdhour = (int) SliderBeta.getValue();
			//framemap.changeValue1(Thresholdhour);
			labelBetaStart.setText("" + Thresholdhour*1.0/100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemLoadData) {
			JFileChooser fileChooser = new JFileChooser();
			try {
				fileChooser.showOpenDialog(null);
				File file = fileChooser.getSelectedFile();
				String filePath = file.getPath();
				filePath = filePath.replace("\\", "/");
				//data.LoadData(filePath);
			} catch (Exception error) {
				error.printStackTrace();
			}
		}else if (e.getSource() == menuItemCloseFile) {
			System.exit(0);
		}else if(e.getSource() == menuItemlookarea){
			int type =2;
			framemap.chose(type); 	
		}
		
		/*if(e.getSource()==radioButton1){
			if (radioButton1.isSelected()) {
				type =1;
				framemap.chose(type); 
			}
			
		}else if(e.getSource()==radioButton2){
			if (radioButton2.isSelected()) {
				type = 2;
				framemap.chose(type);
			}
		}*/
		
		for(int i=0;i<15;i++){
			if(e.getSource()==checkBox[i])
			{
				if (checkBox[i].isSelected()) {
					options[i] = 1;
				} else
					options[i] = 0;
				framemap.send(options);
			}
		}
		if(e.getSource()==radioButton1){
			framemap.getRadioType(1);
		}else if(e.getSource()==radioButton2){
			framemap.getRadioType(2);
		}else if(e.getSource()==radioButton3){
			framemap.getRadioType(3);
		}
		
	}
	public void getSalact(Calendar select){
		select=select;
		System.out.println("year:"+select.get(Calendar.YEAR)+" "+"month:"+select.get(Calendar.MONTH));
	}
	
}
