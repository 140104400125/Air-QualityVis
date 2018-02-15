package com.zufe.FRAME;

import mdsj.MDSJ;
import geomerative.RG;
import geomerative.RPoint;
import geomerative.RShape;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

import com.zufe.DATA.AirInfor;
import com.zufe.DATA.Data;
import com.zufe.POSITION.PositionName;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
public class FrameMap extends PApplet{
	
	Site[] sites;
	 
	static int NUM_SITES = 8;
	static int SITE_MAX_VEL = 2;
	static int SITE_MARKER_SIZE = 6;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸 
	PImage hangzhouMap;
	PositionName pName = new PositionName();
	String StrWeek[] = { "Mon", "Tue", "Wen",
			"Thu", "Fri", "Sat", "Sun"};
	String StrYear[] = { "Jan", "Feb", "Mar",
			"Apr", "May", "June","July", "Aug","Sep","Oct","Nov","Dec"};
	String cityName[] = { "滨江", "卧龙桥", "朝晖五区",
			"和睦小学", "下沙", " 浙江农大", " 临平镇", " 城厢镇", "西溪",
			"云栖","千岛湖" };
	String weekname[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	String monthname[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
	double drex[]={160,140,50,200,130,20,150,140,200,190,120};
	double drey[]={150,100,180,70,100,110,90,80,20,100,180};
	double min[]=new double[15];
	double max[]=new double[15];
	String EnglishName[]={"Binjiang","Wolongqiao","Zhaohuiwuqu","Hemuxiaoxue","Xiasha","Zhejiangnongda","Linpingzhen","Chengxiangzhen","Xixi","Yunqi","Qiandaohu"};
	 
	AirInfor air[][] = new AirInfor[11][123124];
	
	int sk=0,sk1=-1;
	//static double p[][]=new double[7][11];
	double p1[][]=new double[7][24];
	
	String name[]={"AQI","PM2.5","PM2.5_24h","PM10","PM10_24h","SO2","SO2_24h","NO2","NO2_24h","O3","O3_24h","O3_8h","O3_8h_24h","CO","CO_24h"};
	double q[][][]=new double[15][11][24];
	
	double q1[][][]=new double[15][11][24];
	
	
	double input1[][]=new double[11][11];
	double input3[][]=new double[11][11];
	double input4[][]=new double[11][11];
	
	double output1[][]=new double[11][11];
	
	double output4[][]=new double[11][11];
	double output5[][]=new double[11][11];
	
	double input2[][]=new double[24][24];
	double output2[][]=new double[24][24];
	double output3[][]=new double[11][11];
	double location[][]=new double[2][24];
	double location1[][]=new double[2][24];
	double location2[][]=new double[2][24];
	double pos1[][]=new double[2][24];
	
	double output_m[][][]=new double[24][2][11];
	double output_w[][][]=new double[7][2][11];
	double output_y[][][]=new double[12][2][11];
	double output_Month[][][];
	double output_Month1[][][]=new double[31][2][11];
	
	
	int month=9,date=5;
	int year=2014;
	static int hour=0;
	int hour1=1,hour2=2;
	
	int hour3=1,hour4=1,hour5=1,hour6=1;
	double dis1=0;

	double dis2=0,dis3=0,dis4=0;
	
    int y1=0,y2=150;
    
    int red[]={0,269,29,116,204,94,279,33,60,200,0};
    int green[]={39,60,100,72,82,40,16,56,40,26,88};
    int blue[]={98,60,100,62,70,91,83,99,100,89,89};
    
    
    int red1[]={347,3,14,29,44,73,87,118,145,151};
    int green1[]={100,81,72,61,43,9,26,44,61,67};
    int blue1[]={64,84,95,99,99,93,85,74,59,40};
    
    int red2[]={347,3,14,29,43,192,196,203,214,237};
    int green2[]={100,81,72,61,45,41,51,47,82,100};
    int blue2[]={64,84,95,99,99,97,91,81,70,58};
   /* int red[]={15,237,166,269,31,104,311,31,32,353,68};
	int green[]={30,30,30,30,30,30,30,30,30,30,30};
	int blue[]={91,91,91,91,91,91,91,91,91,91,91};*/

	
	/*int red[]={344,330,1,31,49,120,64,70,81,81,81};
	int green[]={64,70,81,81,81,100,344,330,1,31,49};
	int blue[]={57,67,100,100,97,100,344,330,1,31,49};*/
	
	int sk11=1,sk12=2,sk13=3,sk14=4,sk15=5,sk16=6;
	int skt[]=new int[7];
	
	
	int mywidth=1000,myheight=710;
	
	int type=1;
	int city=0;
	int city1=-1,city2=-1;
	int k1=-1,i1=-1,j1=-1;
	ArrayList<Integer> choosencity = new ArrayList<Integer>(); 
	List<FloatList> Floatlist=new ArrayList<FloatList> ();
	List<FloatList> Floatlist1=new ArrayList<FloatList> ();
	List<intList> cityList = new ArrayList<intList>();
	List<intList> cityList1 = new ArrayList<intList>();
	
	ArrayList<DataPoint> dpoints = new ArrayList<DataPoint>();// 类族中点集链表
	ArrayList<DataPoint> dpoints1 = new ArrayList<DataPoint>();// 类族中点集链表
	ArrayList<DataPoint> dpoints2 = new ArrayList<DataPoint>();// 类族中点集链表
	ArrayList<DataPoint> dpoints3 = new ArrayList<DataPoint>();// 类族中点集链表
	ArrayList<DataPoint> dpoints4 = new ArrayList<DataPoint>();// 类族中点集链表
	ArrayList<DataPoint> dpoints5 = new ArrayList<DataPoint>();// 类族中点集链表
	
	List<Cluster> clusters = new ArrayList<Cluster>();// 类族链表
	List<Cluster> clusters1 = new ArrayList<Cluster>();// 类族链表
	List<Cluster> clusters2 = new ArrayList<Cluster>();// 类族链表
	
	List<area> clustersArea = new ArrayList<area>();// 类族链表
	
	List<ClustersCity> clusterList=new ArrayList<ClustersCity>();
	List<ClustersCity> clusterList2=new ArrayList<ClustersCity>();
	List<Cluster> listClu;
	List<Cluster> listClu1;
	ClustersCity clusterList1[]=new ClustersCity[11];
	
	ClustersCity clustersCity[]=new ClustersCity[24];
	ClustersCity clustersWeek[]=new ClustersCity[7];
	ClustersCity clustersYear[]=new ClustersCity[12];
	ClustersCity clustersMonth[];
	ClustersCity listCluster[]=new ClustersCity[14];
	double ClusterDis = 0; // 聚类终止条件欧几里德距离
	
	int timecluster[]=new int[24];
	int lengh[]=new int [24];
	PFont myFont;
	double clus1[][]=new double[2][24];
	double clus2[][]=  new double[2][24];
	int t=0;
	int kt=0;
	int kt1=0;
	boolean flag=false;
	static int now=-1;
	static int nowclu[][]=new int[24][24];
	double rwidth[]=new double[24];
	DateChooser dc;
	int opt[]={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	int sum;
	int sum1;
	boolean flagchose=true;
	boolean flagchose1=true;
	boolean flagchose2=true;
	boolean flagchose3=true;
	boolean flagchose4=true;
	
	double angle=0,area=1.0;
	double angle1,area1;
	
	boolean typeFlag=false;
	int mouseOnIt1=100;
	int mouseOn=100;
	int first=0;
	int qwer;
	int sliderhour=0;

	//double AirYear[][][][]=new double[365][7][11][24];
	double bar[][]=new double[2][11];
	
	int cityClu[]=new int[11]; 
	int width1=512;
	int height1=512;
	float[]distance=new float[11];
	int Preon=100;
	int Preon1=0;
	double citytime[][]=new double[24][11];
	double[] a=new double[5];
	int[] b=new int[5];
	
	double[][] a_sort=new double[24][11];
	int[][] b_sort=new int[24][11];
	
	double[][][] a_sort1=new double[24][11][11];
	int[][][] b_sort1=new int[24][11][11];
	
	double[][] week1_sort=new double[7][11];
	int[][] week2_sort=new int[7][11];
	
	double[][][] week1_sort1=new double[7][11][11];
	int[][][] week2_sort1=new int[7][11][11];
	 
	double[][] year1_sort=new double[12][11];
	int[][] year2_sort=new int[12][11];
	
	double[][][] year1_sort1=new double[12][11][11];
	int[][][] year2_sort1=new int[12][11][11];
	
	double[][] month1_sort;
	int[][] month2_sort;
	
	double[][][] month1_sort1;
	int[][][] month2_sort1;

	
	
	int[] mon=new int[8];
	int[] day=new int[8];
	
	double week[][][]=new double[15][7][11];
	double Year[][][]=new double[15][12][11];
	double Month[][][];
	
	float[][] cityWeek=new float[7][11];
	float[][] cityYear=new float[12][11];
	float[][] cityMonth;
	
	int[] year1=new int[13];
	int[][][] clusterDay=new int[24][11][11];
	int[][] clusterNow=new int[11][11];
	
	float[] clusterHour=new float[24];
	
	
	
	float[][] clusterHour1=new float[24][11];
	float[][] clusterHour2=new float[24][11];
	float[][] clusterHour3=new float[24][11];
	
	int[][][] clusterWeek=new int[7][11][11];
	float[] clusterWeek1=new float[7];
	
	float[][] clusterWeek2=new float[7][11];
	float[][] clusterWeek3=new float[7][11];
	float[][] clusterWeek4=new float[7][11];
	
	int[][][] clusterYear=new int[12][11][11];
	int[][][] clusterMonth;
	
	float[] clusterYear1=new float[12];
	float[][] clusterYear2=new float[12][11];
	float[][] clusterYear3=new float[12][11];
	float[][] clusterYear4=new float[12][11];
	
	float[] clusterMonth1;
	float[][] clusterMonth2;
	float[][] clusterMonth3;
	float[][] clusterMonth4;
	
	final DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
	
	JLabel labelTime= new JLabel();
	
	public FrameMap(DateChooser dc) {
		this.dc = dc;
	}
	int[] clusterFlag=new int[11];
	int[] clusterFlag1=new int[11];
	double[][][] nomaWeek=new double[15][7][11];
	double[][][] nomaYear=new double[15][12][11];
	int citySum=1;
	int mouseOn1=100;
	int x;
	int choseAttribute=100;
	int choosecity=100;
	float[] hourWidth=new float[24];
	int radiotype=1;
	boolean First=true;
	int color=color(red[1],green[1],blue[1]);
	
	int daynum=0;
	int chosehour=0;
	
	int chooseTimeType=0;
	int MDS=1;
	int monthflag,dayflag;
	public FrameMap() {
		// TODO 自动生成的构造函数存根
	}
	
	public int[] sort1(double[] a,int[]arr,int length){
		
	    for(int i=0;i<length-1;i++){ 
	        for(int j=i+1;j<length;j++){
	            if(a[i]<a[j]){
	              int temp=arr[i];
	              arr[i]=arr[j];
	              arr[j]=temp;
	              
	              double temp1=a[i];
	              a[i]=a[j];
	              a[j]=temp1;
	            }
	        }
	    }
	    return arr;
	}
	public void setup() {
		RG.init(this);
		air=Data.air;
		size(1350, 704);
		hangzhouMap = loadImage("..\\src\\map.png");
		Font font = new Font("宋体", Font.PLAIN, 12);
		myFont = createFont("黑体", 12);
		colorMode(HSB,360);
		this.setFont(font);
		//image(hangzhouMap, 0, 10, 350, 200);
		typeFlag=false;
		//LoadYearData();
		//loadData();
		int month3=month;
		int date3=date;
		for(int i=0;i<15;i++){
			max[i]=-100;
			min[i]=100000;
		}
		
	}

	public void draw() {
		colorbar();
		
		System.out.println(width);
		System.out.println(height);
		
		/*dateChooser1.register(labelTime);
		dateChooser1.update(null);*/
		
		
		
		
		//AirInfor air[][] = Data.air;
		
		
		//year=dc.getSelectYear();
		month=dc.getSelectMonth()+1;
		System.out.println("month"+month);
		date=dc.getSelectDay();
		if(month!=monthflag||date!=dayflag){
			flagchose=true;
			flagchose1=true;
			flagchose2=true;
			flagchose3=true;
			flagchose4=true;
			monthflag=month;
			dayflag=date;
		}
		
		loadData();
		Calendar c = Calendar.getInstance(java.util.Locale.CHINA);
		c.set(Calendar.YEAR,year);
		c.set(Calendar.MONTH,month-1);
		c.set(Calendar.DATE,date);
		int wd = c.get(Calendar.DAY_OF_WEEK);
		x = 0;
		switch(wd){
			case 1:x=7;break;
			case 2:x=1;break;
			case 3:x=2;break;
			case 4:x=3;break;
			case 5:x=4;break;
			case 6:x=5;break;
			case 7:x=6;break;
		}
		
		int month1=month;
		int date1=date;
		int month2=month;
		int date2=date;
		int month3=month;
		int date3=date;
		for(int i=x-1;i>0;i--){
			if(date2==1){
				if(month2==5||month2==7||month2==8||month2==10||month2==12){
					mon[i]=month2-1;
					month2=month2-1;
					day[i]=30;
					date2=30;
				}
				if(month2==2||month2==4||month2==6||month2==9||month2==11){
					mon[i]=month2-1;
					month2=month2-1;
					day[i]=31;
					date2=31;
				}
				if(month==3){
					mon[i]=month2-1;
					month2=month2-1;
					day[i]=28;
					date2=28;
				}
				if(month==1){
					mon[i]=12;
					month2=12;
					day[i]=31;
					date2=31;
				}
			}
			else{
				mon[i]=month2;
				day[i]=date2-1;
				date2=date2-1;
			}
		}
		mon[x]=month1;
		day[x]=date1;
		for(int i=x+1;i<8;i++){
			if(date1==28&&month1==2){
				mon[i]=month1+1;
				month1=month1+1;
				day[i]=1;
				date1=1;
			}
			else if(date1==31&&(month1==1||month1==3||month1==5||month1==7||month1==8||month1==10||month1==12)){
				mon[i]=month1+1;
				month1=month1+1;
				day[i]=1;
				date1=1;
			}
			else if(date1==30&&(month1==4||month1==6||month1==9||month1==11)){
				mon[i]=month1+1;
				month1=month1+1;
				day[i]=1;
				date1=1;
			}
			else{
				mon[i]=month1;
				day[i]=date1+1;
				date1=date1+1;
			}
		}
		
		
		
		
		
		
		for(int i=1;i<13;i++){
			if(i==2&&(date3==29||date3==30||date3==31)){
				year1[i]=28;
			}
			else if((i==4||i==6||i==9||i==11)&&date3==31){
				year1[i]=30;
			}
			else
				year1[i]=date3;
		}
		chosehour=hour;
		loadWeek(mon,day);
		loadYear(year1);
		loadMonth(month);
		System.out.println("year "+year1);
		//System.out.println(air[0][2*10000+4*100 + hour].getAQI());
		smooth();
		strokeWeight((float) 0.5);
		colorMode(HSB,360,100,100,100);
		background(0,0,100);
		//image(hangzhouMap, 5, 5, width*2/5, height/2);
		
		if(first<=2)
		{
			typeFlag=false;
			first=first+1;
		}
		
		for(int i = 0; i < 11; ++ i) {
			textAlign(RIGHT);
			textFont(myFont);
			//text(cityName[i],(float)drex[i]+20,(float)drey[i]);
		}
		stroke(0,0,0);
		drawCircle();
		similarCityMatrix();
		CluserMonth();
		CluserWeek();
		CluserYear();
		drawline();
		
		
		int stratX=1000;
		int stratY=500;
		
		if(mouseOn1!=100){
			strokeWeight((float) 0);
			stroke(0);
			fill(238,57,62);
			fill(60,20,100);
			rect((float)mouseX+20,(float)mouseY,EnglishName[mouseOn1].length()*8,20);
			fill(0);
			textSize(12);
			textAlign(LEFT);
			text(EnglishName[mouseOn1],(float)mouseX+25,(float)mouseY+14);
			fill(255);
			
		}
		if(mouseOnIt1!=100){
			strokeWeight((float) 0.5);
			stroke(0);
			fill(238,57,62);
			fill(60,20,100);
			rect((float)mouseX+20,(float)mouseY,EnglishName[mouseOnIt1].length()*8,20);
			fill(0);
			textSize(12);
			textAlign(LEFT);
			text(EnglishName[mouseOnIt1],(float)mouseX+25,(float)mouseY+14);
			fill(255);
			
		}
		if(choosecity!=100){
			strokeWeight((float)0.5);
			stroke(0);
			fill(60,20,100);
			textAlign(LEFT);
			textSize(12);
			strokeWeight(1);
			
			rect((float)mouseX+10,(float)mouseY-5,EnglishName[choosecity].length()*8,15);
			fill(0);
				
			text(EnglishName[choosecity],mouseX+15,mouseY+7);
			
			fill(255);
			
		}
		for(int i=0;i<11;i++){
			if(clusterFlag[i]==1){
				strokeWeight(1);
				fill(60,20,100);
				rect((float)drex[i]+20,(float)drey[i],EnglishName[i].length()*8,20);
				fill(0);
				textSize(12);
				textAlign(LEFT);
				text(EnglishName[i],(float)drex[i]+25,(float)drey[i]+14);
			}
		}
		//drawCharts();
		//Colorbar();
		//showAttribute();
	}

	public void showAttribute(){
		
			String  message="PM2.5";
			String bank=" ";
			
			//System.out.println("111111111111111111111"+bank+bank+"1");
			for(int i=1;i<14;i++){
				float num=PI/14*205-textWidth(name[i])/2+PI/14*205-textWidth(name[i+1])/2;
				int num1=(int) (num/6);
				if(i==3)
					num1++;
				if(i==9||i==10)
					num1++;
				if(i==12)
					num1++;
				for(int j=0;j<num1;j++){
					message=message+bank;
				}
				
				message=message+name[i+1];
			}
			float r=202;
			translate(mywidth/2,myheight/2);
			float arclength = 0;
			  // For every box
			for (int i = 0; i < message.length(); i++){
			    // The character and its width
			    char currentChar = message.charAt(i);
			    float w = textWidth(currentChar);
			    // Each box is centered so we move half the width
			    arclength+=w/2;
			    // Angle in radians is the arclength divided by the radius
			    // Starting on the left side of the circle by adding PI
			    float theta = PI/14-textWidth("PM2.5")/2/r + arclength / r;
			    
			    pushMatrix();
			    // Polar to cartesian coordinate conversion
			    translate(r*cos(theta), r*sin(theta));
			    // Rotate the box
			    rotate(theta + PI/2); // rotation is offset by 90 degrees
			    // Display the character
			    fill(0);
			    text(currentChar,0,0);
			    popMatrix();
			    // Move halfway again
			    arclength+=w/2;
			}
		
	}
	public void drawCharts(){
		stroke(0,0,50);
		fill(100,0,100);
		strokeWeight(1);
		int wid=23;
		rect(950,510,150,wid);
		
		
		rect(1100,510,150,wid);
		int hei=510+wid;
		for(int i=0;i<7;i++){
			rect(950,hei,75,wid);
			rect(1025,hei,75,wid);
			rect(1100,hei,75,wid);
			rect(1175,hei,75,wid);
			hei=hei+wid;
		}
		if(city!=100){
			fill(0,0,0);
			textSize(12);
			textAlign(LEFT);
			text("Area:",970,525);
			text(EnglishName[city],1015,525);
			
			text("AQI:",1120,525);
			text(q[0][city][hour]+"",1160,525);
			
			text("Attributes",960,548);
			text("Value",1045,548);
			text("24h",1130,548);
			text("8h",1205,548);
			
			
			text("PM2.5",960,573);
			text("PM10",960,596);
			text("SO2",960,619);
			text("NO2",960,642);
			text("O3",960,665);
			text("CO",960,687);
			
			text(q[1][city][hour]+"",1045,573);
			text(q[3][city][hour]+"",1045,596);
			text(q[5][city][hour]+"",1045,619);
			text(q[7][city][hour]+"",1045,642);
			text(q[9][city][hour]+"",1045,665);
			text(q[13][city][hour]+"",1045,687);
			
			text(q[2][city][hour]+"",1130,573);
			text(q[4][city][hour]+"",1130,596);
			text(q[6][city][hour]+"",1130,619);
			text(q[8][city][hour]+"",1130,642);
			text(q[10][city][hour]+"",1130,665);
			text(q[14][city][hour]+"",1130,687);
			
			text(q[11][city][hour]+"",1205,665);
		}
	}
	
	public void NomaWeek(){
		double[] max=new double[15];
		double[] min=new double[15];
		for(int j=0;j<11;j++){
			for(int i = 0; i < 7; ++ i) {
				for(int k=0;k<15;k++){
					if(week[k][i][j]>max[k])
						max[k]=week[k][i][j];
					if(week[k][i][j]<min[k])
						min[k]=week[k][i][j];
				}
			}
		}
		
		for(int j=0;j<7;j++){
			for(int i = 0; i < 11; ++ i) {
				for(int k=0;k<15;k++){
					nomaWeek[k][j][i]= (week[k][j][i]-min[k])/(max[k]-min[k]);
				}
				
			} 
		}
	}
	
	public void NomaYear(){
		double[] max=new double[15];
		double[] min=new double[15];
		for(int j=0;j<11;j++){
			for(int i = 0; i < 12; ++ i) {
				for(int k=0;k<15;k++){
					if(Year[k][i][j]>max[k])
						max[k]=Year[k][i][j];
					if(Year[k][i][j]<min[k])
						min[k]=Year[k][i][j];
				}
			}
		}
		
		for(int j=0;j<12;j++){
			for(int i = 0; i < 11; ++ i) {
				for(int k=0;k<15;k++){
					nomaYear[k][j][i]= (Year[k][j][i]-min[k])/(max[k]-min[k]);
				}
			}
		}
	}
	
	public void loadMonth(int month1){
		
		if(month1==1||month1==3||month1==5||month1==7||month1==8||month1==10||month1==12){
			daynum=31;
		}
		if(month1==4||month1==6||month1==9||month1==11){
			daynum=30;
		}
		if(month1==2){
			daynum=28;
		}
		Month=new double[15][daynum][11];
		output_Month=new double[daynum][2][11];
		clustersMonth= new ClustersCity[daynum];
		clusterMonth=new int[daynum][11][11];
		month1_sort=new double[daynum][11];
		month2_sort=new int[daynum][11];
		
		month1_sort1=new double[daynum][11][11];
		month2_sort1=new int[daynum][11][11];
		
		cityMonth=new float[daynum][11];
		clusterMonth1=new float[daynum];
		clusterMonth2=new float[daynum][11];
		clusterMonth3=new float[daynum][11];
		clusterMonth4=new float[daynum][11];
		
		
		for(int j=1;j<daynum+1;j++){
			for(int i=0;i<11;i++){
				Month[0][j-1][i]=air[i][month1*10000+j*100 + hour].getAQI();
				Month[1][j-1][i]=air[i][month1*10000+j*100 + hour].getPM25();
				Month[2][j-1][i]=air[i][month1*10000+j*100 + hour].getPM25_24h();
				Month[3][j-1][i]=air[i][month1*10000+j*100 + hour].getPM10();
				Month[4][j-1][i]=air[i][month1*10000+j*100 + hour].getPM10_24h();
				Month[5][j-1][i]=air[i][month1*10000+j*100 + hour].getSO2();
				Month[6][j-1][i]=air[i][month1*10000+j*100 + hour].getSO2_24h();
				Month[7][j-1][i]=air[i][month1*10000+j*100 + hour].getNO2();
				Month[8][j-1][i]=air[i][month1*10000+j*100 + hour].getNO2_24h();
				Month[9][j-1][i]=air[i][month1*10000+j*100 + hour].getO3();
				Month[10][j-1][i]=air[i][month1*10000+j*100 + hour].getO3_24h();
				Month[11][j-1][i]=air[i][month1*10000+j*100 + hour].getO3_8h();
				Month[12][j-1][i]=air[i][month1*10000+j*100 + hour].getO3_8h_24h();
				Month[13][j-1][i]=air[i][month1*10000+j*100 + hour].getCO();
				Month[14][j-1][i]=air[i][month1*10000+j*100 + hour].getCO_24h();
			}
		}
	}
	
	
	private void loadYear(int[] year12) {
		// TODO 自动生成的方法存根
		for(int j=1;j<13;j++){
			for(int i=0;i<11;i++){
				Year[0][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getAQI();
				Year[1][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getPM25();
				Year[2][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getPM25_24h();
				Year[3][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getPM10();
				Year[4][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getPM10_24h();
				Year[5][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getSO2();
				Year[6][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getSO2_24h();
				Year[7][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getNO2();
				Year[8][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getNO2_24h();
				Year[9][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getO3();
				Year[10][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getO3_24h();
				Year[11][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getO3_8h();
				Year[12][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getO3_8h_24h();
				Year[13][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getCO();
				Year[14][j-1][i]=air[i][j*10000+year12[j]*100 + hour].getCO_24h();
			}
		}
	}
	public void drawRegions()
	{
	  loadPixels(); // must call before using pixels[]
	  
	  for(int x=555; x<900; x++)
	  {
	    for(int y=10; y<345; y++)
	    {
	    //if(((x-mywidth/2)*(x-mywidth/2)+(y-myheight/2)*(y-myheight/2))<200*200){
	      float minDist = width+height;
	      //System.out.println(width+"        "+height);
	      int closest = 0;
	      for(int i=0; i<sites.length; i++)
	      {
	        Site s = sites[i];
	        float d = dist(x,y, s.x, s.y);
	        distance[i]=d;
	        if (d<minDist)
	        {
	          closest = i;
	          minDist = d;
	        }
	      }
	      /*stroke(red[closest],green[closest],blue[closest]);
	      point(x,y);*/
	      /*distance=sort(distance);
	      int  min=(int) distance[0];
	      int  secmin=(int) distance[1];
	      if(abs(secmin-min)==0){
	          stroke(255,255,255);
	          point(x,y);
	        }*/
	      /* the naive, slow way */
	      stroke(sites[closest].c);
	      point(x,y);
	 
	      /* set() is about 3x faster in P2D mode (just as slow as stroke/point in JAVA2D) */
	      //set(x,y,sites[closest].c);
	 
	      /* pixels[] is about 10x faster in P2D and 4x faster in JAVA2D */
	      if(MDS==1)
	    	  pixels[y*width+x] = sites[closest].c;
	      //pixels[y*width+x] = sites[closest].c;
	    //}
	    }
	  }
	  updatePixels(); // must call after using pixels[]
	}
	 
	public void drawSites()
	{
	  for(int i=0; i<sites.length; i++)
	  {
	    Site s = sites[i];
	    //fill(255, 128);
	    int nn=getType((int)q1[0][i][hour]);
	    
		fill(red1[nn],green1[nn],blue1[nn]);
	    stroke(0);
	    if(mouseOnIt1==i)
	    	ellipse(s.x, s.y, 15, 15);
	    else
	    	ellipse(s.x, s.y, 10, 10);
	  }
	}
	class Site
	{
	  float x, y;
	  int c;
	  Site(int x,int y)
	  {
	    this.x =x; 
	    this.y =y; 
	    //c = color(random(128), random(128,192), random(128,255));
	    //vel = new PVector(random(-SITE_MAX_VEL,SITE_MAX_VEL), random(-SITE_MAX_VEL,SITE_MAX_VEL));
	  }
	  public void setcolor(int red,int green,int blue){
		  c = color(red, green, blue);
	  }
	}

	
	public double[][] Normalized(double enter[][],int n){
		double min1,max1,min2,max2;
		boolean a=false;
		boolean b=false;

		/*for(int i=0;i<n;i++)
			System.out.println("0:"+enter[0][i]+" "+"1:"+enter[1][i]);*/
		max1=min1=enter[1][0];
		max2=min2=enter[0][0];
		for(int i1=0;i1<n;i1++){
			if(max1<enter[1][i1])
				max1=enter[1][i1];
			if(min1>enter[1][i1])
				min1=enter[1][i1];
		}
		for(int i1=0;i1<n;i1++){
			if(max2<enter[0][i1])
				max2=enter[0][i1];
			if(min2>enter[0][i1])
				min2=enter[0][i1];
		}
		for(int i1=0;i1<n;i1++){
			pos1[0][i1]=(enter[0][i1]-min2)/(max2-min2);
			pos1[1][i1]=(enter[1][i1]-min1)/(max1-min1);
		}
		/*for(int i=0;i<n;i++){
			location1[0][i]=map((float)pos1[0][i],0,1,585,1010);
			location1[1][i]=map((float)pos1[1][i],0,1,280,10);
		}*/
		for(int i=0;i<n;i++){
			location1[0][i]=map((float)pos1[0][i],0,1,570,890);
			location1[1][i]=map((float)pos1[1][i],0,1,20,315);
		}
		return location1;
	}
	
	public void mousePressed() {
		for(int i=0;i<11;i++){
			if(mouseX>drex[i]-10&&mouseX<drex[i]+10&&mouseY>drey[i]-10&&mouseY<drey[i]+10){
				city=i;
				mouseOn=i;
				break;
			}
		}
		
		int i1;
		for(i1=0;i1<11;i1++){
			if(mouseX>location[0][i1]-5&&mouseX<location[0][i1]+5&&mouseY>location[1][i1]-5&&mouseY<location[1][i1]+5){
				mouseOn=i1;
				break;
			}
		}
		/*if(i1==11)
			mouseOn=100;*/
		
		float minDist=width+height;
		int i=0;
		for(i=0; i<sites.length; i++)
	    {
			if(mouseX>555&&mouseX<900&&mouseY>10&&mouseY<345){
		        Site s = sites[i];
		        float d = dist(mouseX,mouseY, s.x, s.y);
		        if (d<minDist)
		        {
		        	minDist=d;
		        	Preon=i;
		        	Preon1=i;
		        }
		       
			}
	    }
		if(mouseX<1155&&mouseY<550&&((mouseX-1155)*(mouseX-1155)+(mouseY-550)*(mouseY-550)<130*130)){
			chooseTimeType=0;
		}
		if(mouseX>1155&&mouseY<550&&((mouseX-1155)*(mouseX-1155)+(mouseY-550)*(mouseY-550)<130*130)){
			chooseTimeType=1;
		}
		if(mouseX>1155&&mouseY>550&&((mouseX-1155)*(mouseX-1155)+(mouseY-550)*(mouseY-550)<130*130)){
			chooseTimeType=2;
		}
		if(mouseX<1155&&mouseY>550&&((mouseX-1155)*(mouseX-1155)+(mouseY-550)*(mouseY-550)<130*130)){
			chooseTimeType=3;
		}
	}
	public void mouseReleased(){
		Preon=100;
		mouseOn=100;
		for(int i=0;i<11;i++){
			clusterFlag[i]=0;
		}
	} 
	public void mouseMoved() {	
		//定位
		int t=0;
		int chooseflag=0;
		for(t=0;t<15;t++){
	        ClustersCity clus= clusterList.get(clusterList.size()-1);
	        for(Cluster cl:clus.clusters){
	        	if(t<5){
		        	cl.startAngle=920;
		        	cl.startHeight=10+t*75;
	        	}else if(4<t&&t<10){
	        		cl.startAngle=1060;
		        	cl.startHeight=10+(t-5)*75;
	        	}else{
	        		cl.startAngle=1200;
		        	cl.startHeight=10+(t-10)*75;
	        	}
	        	cl.angleWidth=130;
	        	cl.angleHeight=44;
	        }
	        
	        if(clusterList.size()>=2){
	        	int cutflag=0;
		        for(int i=clusterList.size()-1;i>0;i--){
			        ClustersCity clus1= clusterList.get(i);
			        ClustersCity clus2= clusterList.get(i-1);
			        for(Cluster cl1:clus1.clusters){
			    		List<DataPoint> tempDps1=cl1.getDataPoints();
			    		float startAngle=cl1.startAngle;
			    		float angleWidth=cl1.angleWidth;
			    		float startHeight=cl1.startHeight;
			    		float angleHeight=cl1.angleHeight;
			    		
			    		float a=0;
			    		
			    		for(Cluster cl2:clus2.clusters){
			    			
			    			int flag=0;
			        		List<DataPoint> tempDps2=cl2.getDataPoints();
			        		for(DataPoint tempdp1:tempDps1){
			        			for(DataPoint tempdp2:tempDps2){
				        			if(tempdp1.getDataPointName()==tempdp2.getDataPointName()){
				        				flag=1;
				        			}
				        		}
			        		}
			        		if(flag==1){
			        			strokeWeight(0);
			        			stroke(0,0,50);
			        			if(cutflag==0){
				        			cl2.startAngle=startAngle+a;
				        			cl2.angleWidth=angleWidth*tempDps2.size()/tempDps1.size();
				        			cl2.startHeight=startHeight;
				        			cl2.angleHeight=angleHeight;				
				        			a=a+angleWidth*tempDps2.size()/tempDps1.size();
				   
			        			}
			        			else{
			        				cl2.startAngle=startAngle;
				        			cl2.angleWidth=angleWidth;
				        			cl2.startHeight=startHeight+a;
				        			cl2.angleHeight=angleHeight*tempDps2.size()/tempDps1.size();				        			
				        			a=a+angleHeight*tempDps2.size()/tempDps1.size();
			        			}
			        		}
			        	}
			    		
			    	}
			        //System.out.println("cutflag:"+cutflag);
			        if(cutflag==0){
			    		cutflag=1;
			   		}else{
			   			cutflag=0;;
			   		}
		        }
	        }
	        listClu = clusterList.get(0).clusters;
	        Collections.sort(listClu);
	        int num=0;
	        

	        /*for(Cluster cl:listClu){
	        	System.out.println(num+"  "+cl.startHeight);
	        	num++;
	        	
	        }*/
	        for(int i=listClu.size()-1;i>=0;i--){
	        	Cluster cl=listClu.get(i);
	        	float startAngle=cl.startAngle;
	    		float angleWidth=cl.angleWidth;
	    		float startHeight=cl.startHeight;
	    		float angleHeight=cl.angleHeight;
	    		if(mouseX>startAngle&&mouseX<startAngle+angleWidth&&mouseY>startHeight&&mouseY<startHeight+angleHeight){
		    		List<DataPoint> tempDps=cl.getDataPoints();
		    		for(DataPoint tempdp:tempDps){
		    			choosecity=tempdp.getDataPointName();
	    				chooseflag=1;
	    				break;
	        		}
	        
	    		}
	    		//rect(startAngle,startHeight,angleWidth,angleHeight);
	        	
	        }
	        if(chooseflag==1)
	        	break;
        }
		
		if(t==15&&chooseflag==0){
			choosecity=100;
		}
		
		
		
		int i=0;
		//System.out.println("choseAttribute"+choseAttribute);
		if(mouseX>mywidth||mouseY>myheight)
			return;
		
		
		for(i=0;i<11;i++){
			if(mouseX>drex[i]-10&&mouseX<drex[i]+10&&mouseY>drey[i]-10&&mouseY<drey[i]+10){
				mouseOnIt1=i;
				break;
			}
		}
		if(i==11){
			mouseOnIt1=100;
		}
		
		int i1;
		for(i1=0;i1<11;i1++){
			if(mouseX>location[0][i1]-5&&mouseX<location[0][i1]+5&&mouseY>location[1][i1]-5&&mouseY<location[1][i1]+5){
				mouseOn1=i1;
				break;
			}
		}
		if(i1==11)
			mouseOn1=100;
	}
	
	public double[][][] Noma(double array[][][]){
		double max=0,min=10000;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				for(int k=0;k<array[i][j].length;k++){
					if(array[i][j][k]>max)
						max=array[i][j][k];
					if(array[i][j][k]<min)
						min=array[i][j][k];
				}
			}
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				for(int k=0;k<array[i][j].length;k++){
					array[i][j][k]=(array[i][j][k]-min)/(max-min);
				}
			}
		}
		return array;
	}
	public double[][] Noma1(double array[][]){
		double max=0,min=10000;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				if(array[i][j]>max)
					max=array[i][j];
				if(array[i][j]<min)
					min=array[i][j];
				
			}
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
					array[i][j]=(array[i][j]-min)/(max-min);
				
			}
		}
		return array;
	}
	public void drawCircle(){
		drawTimeMds();
		
		
		fill(0,0,100);
		//ellipse(mywidth/2,myheight/2,400,400);
		for(int i=0;i<11;i++){
			fill(249,50,100);
			if(mouseOnIt1==i)
				ellipse((float)location[0][i],(float)location[1][i],25,25);
			else
				ellipse((float)location[0][i],(float)location[1][i],15,15);
		}
		/*for(Cluster cl:clusters){	
			 List<DataPoint> tempDps=cl.getDataPoints();
			 double px = 0, py = 0;
			 int len = 0;
	         for(DataPoint tempdp:tempDps){
	        	 px += tempdp.getDimensioin()[0];
				 py += tempdp.getDimensioin()[1];
				 len++;
	         }
	         double disR = 0;
			px /= len;
			py /= len;
			for(DataPoint tempdp:tempDps){
				fill(0, 0, 0);
				//ellipse((float) (px), (float) py, 5, 5); // 聚类圈中心点
				stroke(100, 0, 50); // 聚类中连线的颜色
				// 点之间的连线
				line((float) ( px), (float) py, (float) (tempdp.getDimensioin()[0]),
						(float) tempdp.getDimensioin()[1]);
				double tmpDis = Math.sqrt((tempdp.getDimensioin()[0] - px) * (tempdp.getDimensioin()[0] - px)
						+ (tempdp.getDimensioin()[1] - py) * (tempdp.getDimensioin()[1] - py));
				if (disR < tmpDis) {
					disR = tmpDis;
				}
			}
			fill(200, 100, 90, 40);
			ellipse((float) (px), (float) py, (float) disR * 2 + 25, (float) disR * 2 + 25);
		}*/
		strokeWeight(1);
		fill(0,0,100);
		rect(5,5,540,350,5);
		image(hangzhouMap, 10, 10,531,335);
        for(int i = 0; i < 11; ++ i) {
			
			double x = (float)PositionName.positionName[i].getX();
			x = (x - 119.8993)/(120.4671-119.8993)*530+10;
			double y = (float)PositionName.positionName[i].getY();
			y = (1-(y-30.1570)/(30.4321-30.1570))*320+10;
			if(i==10){
				x=20;
				y=200;
			}
			String name = cityName[i];
			double colorNum=q1[0][i][hour];
			//System.out.println("colorNum: "+colorNum+"  "+hour);
			strokeWeight((float) 0.5);
			int nn=getType((int)colorNum);
			//fill(map((float)colorNum,0,1,1,0)*120,100,100);
			
			fill(red1[nn],green1[nn],blue1[nn]);
			stroke(300,100,17);
			if(i==mouseOn1)
				ellipse((float)x, (float)y, 25, 25);
			else
				ellipse((float)x, (float)y, 15, 15);
			drex[i]=x;
			drey[i]=y;
			fill(0);
		
		}
    	fill(0,0,100);
		rect(550,5,355,350,5);
		fill(60,15,100);
		rect(555,10,345,335);
		drawRegions();
        drawSites();
        
        int l=0;
        if(Preon!=100){
        	fill(sites[Preon].c);
        	color=sites[Preon].c;
        }else{
        	fill(color);
        }
        //rect(10,10,530,20);
        fill(0,0,100);
        drawBar();
        for(Cluster cl:clusters){	
			 List<DataPoint> tempDps=cl.getDataPoints();			
			if(Preon!=100){
				for(DataPoint tempdp:tempDps){
					int c=color(red[l],green[l],blue[l]);
					if(sites[tempdp.getDataPointName()].c==sites[Preon].c){
						clusterFlag[tempdp.getDataPointName()]=1;
						//System.out.println("clusters  "+tempdp.getDataPointName());
						strokeWeight(2);
						//stroke(red[l],green[l],blue[l],70);
						stroke(238,40,62);
						noFill();
						//bezier((float)drex[tempdp.getDataPointName()],(float)drey[tempdp.getDataPointName()],(float)drex[tempdp.getDataPointName()],(float)(drey[tempdp.getDataPointName()]-(drey[tempdp.getDataPointName()]-20)*0.75),270,(float)(drey[tempdp.getDataPointName()]-(drey[tempdp.getDataPointName()]-20)*0.25),270,20);
					}
		         }
			}
			l++;
		}
        strokeWeight(1);
        int start=310;
        for(int i=9;i>=0;i--){
        	fill(red1[i],green1[i],blue1[i]);
        	rect(start,365,20,20);
        	start=start+20;
        }
        fill(0);
        textSize(15);
        textAlign(CENTER);
        text("low",295,380);
        text("high",530,380);
	}
	public void CluserMonth(){
		if(flagchose4==true||ClusterDis!=dis4||hour6!=hour){
			flagchose4=false;
			dis4=ClusterDis;
			hour6=hour;
			for(int l=0;l<daynum;l++){
				for(int i=0;i<11;i++){
					for(int j=0;j<11;j++){
						double num=0;
						for(int k=0;k<15;k++){
							if(opt[k]==1)
								num=num+Math.pow((Month[k][l][i]-Month[k][l][j]),2); 
							
						}
						input4[i][j]=Math.sqrt(num);
					}
				}
				output5=MDSJ.classicalScaling(input4);
				double numtext[][]=new double[2][11];
				numtext=Normalized(output5,11);
				for(int n=0;n<11;n++){
					output_Month[l][0][n]=numtext[0][n];
					output_Month[l][1][n]=numtext[1][n];
				}
			}
			for(int l=0;l<daynum;l++){
				for(int n=0;n<11;n++){
					output_Month1[l][0][n]=output_Month[l][0][n];
					output_Month1[l][1][n]=output_Month[l][1][n];
				}
			}
		}
		
		for(int i=0;i<daynum;i++){
			dpoints2.clear();
			for(int j=0;j<11;j++){
				double[] tmp = {output_Month1[i][0][j],output_Month1[i][1][j] };
				dpoints2.add(new DataPoint(tmp, j));
			}
			ClusterAnalysis ca1 = new ClusterAnalysis();
			clusters2 = ca1.startAnalysis(dpoints2); // 开始聚类
			ClustersCity clustersCity1=new ClustersCity();
			clustersCity1.clusters=clusters2;
			clustersMonth[i]=clustersCity1;
		}
		
		/*for(int i=0;i<daynum;i++){
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(j);
				List<DataPoint> tempDps=cl.getDataPoints();
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(k);
					System.out.println(tempdp.getDataPointName()+"Month");
				}
				
			}
			System.out.println("end");
		}*/
		if(radiotype==1||radiotype==3){
			for(int i=0;i<daynum;i++){
				for(int j=0;j<clustersMonth[i].clusters.size();j++){
					Cluster cl=clustersMonth[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						num=num+Month[0][i][tempdp.getDataPointName()];
						
						/*year1_sort1[i][j][k]=q1[0][tempdp.getDataPointName()][i];
						year2_sort1[i][j][k]=k;*/
						if(radiotype==1)
							month1_sort1[i][j][k]=+Month[0][i][tempdp.getDataPointName()];
						else if(radiotype==3)
							month1_sort1[i][j][k]=tempdp.getDataPointName();
						month2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					month1_sort[i][j]=num;
					month2_sort[i][j]=j;
				}
			}
		}
		else{
			for(int i=0;i<daynum;i++){
				for(int j=0;j<clustersMonth[i].clusters.size();j++){
					Cluster cl=clustersMonth[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						num=num+tempdp.getDataPointName();
						month1_sort1[i][j][k]=tempdp.getDataPointName();
						month2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					month1_sort[i][j]=num;
					month2_sort[i][j]=j;
				}
			}
		}
		for(int i=0;i<daynum;i++){
			sort1(month1_sort[i],month2_sort[i],clustersMonth[i].clusters.size());
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				//System.out.println(i+"   "+b_sort[i][j]);
			}
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(j);
				List<DataPoint> tempDps=cl.getDataPoints();
				sort1(month1_sort1[i][j],month2_sort1[i][j],tempDps.size());
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][j][k]);
					//System.out.println(j+"    "+k+" k  "+b_sort1[i][j][k]);
				}
			}
		}
		for(int i=0;i<daynum;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					clusterMonth[i][j][k]=0;
				}
			}
		}
		for(int i=0;i<daynum;i++){
			int len=255;
			int sumNum=0;
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(month2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				len=len+tempDps.size()*1*2/2;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][month2_sort[i][j]][k]);
					cityMonth[i][tempdp.dataPointName]=len;
					 len=len+4;
					 clusterMonth[i][month2_sort[i][j]][tempdp.getDataPointName()]=1;
				}
				len=len+tempDps.size()*1*2/2;
				sumNum++;
			}
		}
		
		for(int i=0;i<daynum;i++){
			double num=0;
			for(int l=0;l<clusters.size();l++){
				for(int k=0;k<clustersMonth[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterMonth[i][k][m]==clusterDay[hour][l][m]&&clusterMonth[i][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						
						Cluster cl=clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				
			}
		
			clusterMonth1[i]=(float) num/clusters.size();
			//System.out.println("num:"+num);
		}
		for(int i=0;i<daynum-1;i++){
			for(int l=0;l<clustersMonth[i+1].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersMonth[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterMonth[i][k][m]==clusterMonth[i+1][l][m]&&clusterMonth[i+1][l][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersMonth[i+1].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterMonth2[i+1][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		float max1=-1000,min1=1000;
		for(int i=0;i<daynum;i++){
			for(int j=0;j<11;j++){
				if(clusterMonth2[i][j]>max1)
					max1=clusterMonth2[i][j];
				if(clusterMonth2[i][j]<min1)
					min1=clusterMonth2[i][j];
			}
		}
		for(int i=0;i<daynum;i++){
			for(int j=0;j<11;j++){
				clusterMonth2[i][j]=(clusterMonth2[i][j]-min1)/(max1-min1);
				boolean a=false;
				a=Double.isNaN(clusterMonth2[i][j]);
				if(a==true)
					clusterMonth2[i][j]=0;
			}
		}
		
		
		
		for(int i=0;i<daynum-1;i++){
			for(int l=0;l<clustersMonth[i].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersMonth[i+1].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterMonth[i][l][m]==clusterMonth[i+1][k][m]&&clusterMonth[i+1][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersMonth[i].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterMonth3[i][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		
		float max=-100,min=1000;
		for(int i=0;i<daynum;i++){
			if(clusterMonth1[i]>max)
				max=clusterMonth1[i];
			if(clusterMonth1[i]<min)
				min=clusterMonth1[i];
		}
		for(int i=0;i<daynum;i++){
			clusterMonth1[i]=(clusterMonth1[i]-min)/(max-min);
			boolean a=false;
			a=Double.isNaN(clusterMonth1[i]);
			if(a==true)
				clusterMonth1[i]=0;
			
		}
		
		
		
		float an=35;
		float anw=840/(daynum-1);
		
		strokeWeight((float) 0.5);
		stroke(0,0,0);
		
		
		
		if(chooseTimeType==2){
			fill(12,0,100);
			rect(5,400,900,300,5);
			System.out.println(chooseTimeType+"  chooseTimeType");
		for(int i=0;i<daynum;i++){
			strokeWeight(0);
			if(i==date-1){
				fill(0,0,90);
				rect(an-anw*3/14,430,anw*3/7,250);
			}
			strokeWeight((float) 0.5);
			stroke(0,0,0);
			line(an,420,an,680);
			fill(0);
			textAlign(CENTER);
			text(i+1+"",an,690);
			/*if(clusterMonth1[i]>0.5)
				fill(284,map(clusterMonth1[i],(float) 0.5,1,(float) 0.1,1)*100,100);
			else
				fill(60,map(clusterMonth1[i],0,(float)0.5,1,(float)0.1)*100,100);
			if(i==month-1)
				fill(0,100,100);*/
			int nn=getcolor(clusterMonth1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			ellipse(an,420,15,15);
			
			an=an+anw;
		}
		float an2=35;
		float anw2=840/(daynum-1);
		float LineWidth=5;
		
		for(int i=0;i<daynum;i++){
			float len=440;
			float blankwidth=150/(clustersMonth[i].clusters.size());
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(month2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][month2_sort[i][j]][k]);
					strokeWeight((float)0);
					clusterMonth4[i][tempdp.getDataPointName()]=clusterMonth3[i][month2_sort[i][j]];
					//int nn=getcolor(clusterMonth2[i][month2_sort[i][j]]);
					//fill((float)(120*clusterMonth2[i][month2_sort[i][j]]),100,100);
					//fill(red2[nn],green2[nn],blue2[nn]);
					cityMonth[i][tempdp.getDataPointName()]=len+LineWidth/2;
					//rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		
		float max2=-1000,min2=1000;
		for(int i=0;i<daynum;i++){
			for(int j=0;j<11;j++){
				if(clusterMonth4[i][j]>max2)
					max2=clusterMonth4[i][j];
				if(clusterMonth4[i][j]<min2)
					min2=clusterMonth4[i][j];
			}
		}
		for(int i=0;i<daynum;i++){
			for(int j=0;j<11;j++){
				clusterMonth4[i][j]=(clusterMonth4[i][j]-min2)/(max2-min2);
				boolean a=false;
				a=Double.isNaN(clusterMonth4[i][j]);
				if(a==true)
					clusterMonth4[i][j]=0;
			}
		}
		
		
		for(int j=0;j<11;j++){
			float an1=35+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<daynum-1;i++){
					noFill();
					strokeWeight(5);
					//stroke(120*clusterMonth4[i][j],100,100);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
						}else{
							stroke(0,0,90);
						}
					}else{
						int nn=getcolor(clusterMonth4[i][j]);
						stroke(red2[nn],green2[nn],blue2[nn]);
					}
					/*int nn=getcolor(clusterMonth4[i][j]);
					stroke(red2[nn],green2[nn],blue2[nn]);*/
					bezier(an1,cityMonth[i][j],an1+anw2*2/7,cityMonth[i][j],an1+anw2*2/7,cityMonth[i+1][j],an1+anw2*4/7,cityMonth[i+1][j]);
					an1=an1+anw;
	 			}
			
		}
		for(int j=0;j<11;j++){
			float an1=35+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<daynum-1;i++){
					noFill();
					strokeWeight(5);
					//stroke(120*clusterMonth4[i][j],100,100);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
							bezier(an1,cityMonth[i][j],an1+anw2*2/7,cityMonth[i][j],an1+anw2*2/7,cityMonth[i+1][j],an1+anw2*4/7,cityMonth[i+1][j]);

						}
					}
					
					an1=an1+anw;
	 			}
			
		}
		an2=35;
		
		for(int i=0;i<daynum;i++){
			float len=440;
			float blankwidth=150/(clustersMonth[i].clusters.size());
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(month2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][month2_sort[i][j]][k]);
					strokeWeight((float)0);
					//clusterMonth4[i][tempdp.getDataPointName()]=clusterMonth3[i][month2_sort[i][j]];
					//int nn=getcolor(clusterMonth2[i][month2_sort[i][j]]);
					//fill((float)(120*clusterMonth2[i][month2_sort[i][j]]),100,100);
					//fill(red2[nn],green2[nn],blue2[nn]);
					//cityMonth[i][tempdp.getDataPointName()]=len+LineWidth/2;
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
						}else{
							fill(0,0,90);
						}
					}else{
						int nn=getcolor(clusterMonth2[i][month2_sort[i][j]]);
						fill(red2[nn],green2[nn],blue2[nn]);
					}
					rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		an2=35;
		
		for(int i=0;i<daynum;i++){
			float len=440;
			float blankwidth=150/(clustersMonth[i].clusters.size());
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(month2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][month2_sort[i][j]][k]);
					strokeWeight((float)0);
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
							rect(an2-anw2*3/14,len,anw2*3/7,5);
						}
					}
					
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		an2=35;
		for(int i=0;i<daynum;i++){
			float len=440;
			float blankwidth=150/(clustersMonth[i].clusters.size());
			for(int j=0;j<clustersMonth[i].clusters.size();j++){
				Cluster cl=clustersMonth[i].clusters.get(month2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(month2_sort1[i][month2_sort[i][j]][k]);
					if(mouseX>an2-anw2*3/14&&mouseX<an2+anw2*3/14&&mouseY>len&&mouseY<len+5){
						
						fill(60,20,100);
						rect((float)mouseX+20,(float)mouseY,EnglishName[tempdp.getDataPointName()].length()*8,20);
						textSize(14);
						textAlign(LEFT);
						fill(0);
						text(EnglishName[tempdp.getDataPointName()],mouseX+25,mouseY+14);
					}
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		
		
		}
	}
	
	public void CluserYear(){
		if(flagchose2==true||ClusterDis!=dis2||hour4!=hour){
			flagchose2=false;
			dis2=ClusterDis;
			hour4=hour;
			for(int l=0;l<12;l++){
				for(int i=0;i<11;i++){
					for(int j=0;j<11;j++){
						double num=0;
						for(int k=0;k<15;k++){
							if(opt[k]==1)
								num=num+Math.pow((Year[k][l][i]-Year[k][l][j]),2); 
							
						}
						input3[i][j]=Math.sqrt(num);
					}
				}
				output4=MDSJ.classicalScaling(input3);
				double numtext[][]=new double[2][11];
				numtext=Normalized(output4,11);
				for(int n=0;n<11;n++){
					output_y[l][0][n]=numtext[0][n];
					output_y[l][1][n]=numtext[1][n];
				}
			}
		}
		for(int i=0;i<12;i++){
			dpoints2.clear();
			for(int j=0;j<11;j++){
				double[] tmp = {output_y[i][0][j],output_y[i][1][j] };
				dpoints2.add(new DataPoint(tmp, j));
			}
			ClusterAnalysis ca1 = new ClusterAnalysis();
			clusters2 = ca1.startAnalysis(dpoints2); // 开始聚类
			ClustersCity clustersCity1=new ClustersCity();
			clustersCity1.clusters=clusters2;
			clustersYear[i]=clustersCity1;
		}
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					clusterYear[i][j][k]=0;
				}
			}
		}
		if(radiotype==1||radiotype==3){
			for(int i=0;i<12;i++){
				for(int j=0;j<clustersYear[i].clusters.size();j++){
					Cluster cl=clustersYear[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						num=num+Year[0][i][tempdp.getDataPointName()];
						
						/*year1_sort1[i][j][k]=q1[0][tempdp.getDataPointName()][i];
						year2_sort1[i][j][k]=k;*/
						if(radiotype==1)
							year1_sort1[i][j][k]=Year[0][i][tempdp.getDataPointName()];
						else if(radiotype==3)
							year1_sort1[i][j][k]=tempdp.getDataPointName();
						year2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					year1_sort[i][j]=num;
					year2_sort[i][j]=j;
				}
			}
		}
		else{
			for(int i=0;i<12;i++){
				for(int j=0;j<clustersYear[i].clusters.size();j++){
					Cluster cl=clustersYear[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						num=num+tempdp.getDataPointName();
						year1_sort1[i][j][k]=tempdp.getDataPointName();
						year2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					year1_sort[i][j]=num;
					year2_sort[i][j]=j;
				}
			}
		}
		for(int i=0;i<12;i++){
			sort1(year1_sort[i],year2_sort[i],clustersYear[i].clusters.size());
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				//System.out.println(i+"   "+b_sort[i][j]);
			}
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(j);
				List<DataPoint> tempDps=cl.getDataPoints();
				sort1(year1_sort1[i][j],year2_sort1[i][j],tempDps.size());
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][j][k]);
					//System.out.println(j+"    "+k+" k  "+b_sort1[i][j][k]);
				}
			}
		}
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					clusterYear[i][j][k]=0;
				}
			}
		}
		
		
		for(int i=0;i<12;i++){
			int len=255;
			int sumNum=0;
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(year2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				len=len+tempDps.size()*1*2/2;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][year2_sort[i][j]][k]);
					cityYear[i][tempdp.dataPointName]=len;
					 len=len+4;
					 clusterYear[i][year2_sort[i][j]][tempdp.getDataPointName()]=1;
				}
				len=len+tempDps.size()*1*2/2;
				sumNum++;
			}
		}
		
		for(int i=0;i<12;i++){
			double num=0;
			for(int l=0;l<clusters.size();l++){
				for(int k=0;k<clustersYear[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterYear[i][k][m]==clusterDay[hour][l][m]&&clusterYear[i][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						
						Cluster cl=clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				
			}
		
			clusterYear1[i]=(float) num/clusters.size();
			//System.out.println("num:"+num);
		}
		for(int i=0;i<11;i++){
			for(int l=0;l<clustersYear[i+1].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersYear[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterYear[i][k][m]==clusterYear[i+1][l][m]&&clusterYear[i+1][l][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersYear[i+1].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
						if(num<0)
							System.out.println(n1+"  n1   "+tempDps.size()+"  tempDps.size()");
					}
				}
				clusterYear2[i+1][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		float max1=-1000,min1=1000;
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				if(clusterYear2[i][j]>max1)
					max1=clusterYear2[i][j];
				if(clusterYear2[i][j]<min1)
					min1=clusterYear2[i][j];
			}
		}
		
		System.out.println(max1+"  "+min1+"  cluter");
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				clusterYear2[i][j]=(clusterYear2[i][j]-min1)/(max1-min1);
				boolean a=false;
				a=Double.isNaN(clusterYear2[i][j]);
				if(a==true)
					clusterYear2[i][j]=0;
			}
		}
		
		
		
		
		
		
		for(int i=0;i<11;i++){
			for(int l=0;l<clustersYear[i].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersYear[i+1].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterYear[i][l][m]==clusterYear[i+1][k][m]&&clusterYear[i+1][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersYear[i].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterYear3[i][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		
		float max=-100,min=1000;
		for(int i=0;i<12;i++){
			if(clusterYear1[i]>max)
				max=clusterYear1[i];
			if(clusterYear1[i]<min)
				min=clusterYear1[i];
		}
		for(int i=0;i<12;i++){
			clusterYear1[i]=(clusterYear1[i]-min)/(max-min);
			boolean a=false;
			a=Double.isNaN(clusterYear1[i]);
			if(a==true)
				clusterYear1[i]=0;
			
		}
		
		
		
		
		float an=35;
		float anw=840/11;
		
		strokeWeight((float) 0.5);
		stroke(0,0,0);
		
	
		
		if(chooseTimeType==3){
			fill(12,0,100);
			rect(5,400,900,300,5);
		for(int i=0;i<12;i++){
			strokeWeight(0);
			if(i==month-1){
				fill(0,0,90);
				rect(an-anw*3/14,430,anw*3/7,250);
			}
			strokeWeight((float) 0.5);
			stroke(0,0,0);
			line(an,420,an,680);
			fill(0);
			textAlign(CENTER);
			text(monthname[i],an,690);
			/*if(clusterYear1[i]>0.5)
				fill(284,map(clusterYear1[i],(float) 0.5,1,(float) 0.1,1)*100,100);
			else
				fill(60,map(clusterYear1[i],0,(float)0.5,1,(float)0.1)*100,100);*/
			int nn=getcolor(clusterYear1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			//System.out.println(clusterYear1[i]+"   year");
			//line(1125,550,1125+(float)(140*clusterYear1[i]*Math.cos(PI/13+PI/13*i)),(float)(550+140*clusterYear1[i]*Math.sin(PI/13+PI/13*i)));
			
			ellipse(an,420,15,15);
			
			an=an+anw;
		}
		float an2=35;
		float anw2=840/11;
		float LineWidth=5;
		
		for(int i=0;i<12;i++){
			float len=440;
			float blankwidth=150/(clustersYear[i].clusters.size());
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(year2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][year2_sort[i][j]][k]);
					strokeWeight((float)0);
					clusterYear4[i][tempdp.getDataPointName()]=clusterYear3[i][year2_sort[i][j]];
					//int nn=getcolor(clusterYear2[i][year2_sort[i][j]]);
					//fill(red2[nn],green2[nn],blue2[nn]);
					//fill((float)(120*clusterYear2[i][year2_sort[i][j]]),100,100);
					cityYear[i][tempdp.getDataPointName()]=len+LineWidth/2;
					//rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		float max2=-1000,min2=1000;
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				if(clusterYear4[i][j]>max2)
					max2=clusterYear4[i][j];
				if(clusterYear4[i][j]<min2)
					min2=clusterYear4[i][j];
			}
		}
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				clusterYear4[i][j]=(clusterYear4[i][j]-min2)/(max2-min2);
				boolean a=false;
				a=Double.isNaN(clusterYear4[i][j]);
				if(a==true)
					clusterYear4[i][j]=0;
			}
		}
		
		for(int j=0;j<11;j++){
			float an1=35+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<11;i++){
					noFill();
					strokeWeight(5);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
						}else{
							stroke(0,0,90);
						}
					}else{
						int nn=getcolor(clusterYear4[i][j]);
						stroke(red2[nn],green2[nn],blue2[nn]);
					}
					/*int nn=getcolor(clusterYear4[i][j]);
					stroke(red2[nn],green2[nn],blue2[nn]);*/
					//stroke(120*clusterYear4[i][j],100,100);
					bezier(an1,cityYear[i][j],an1+anw2*2/7,cityYear[i][j],an1+anw2*2/7,cityYear[i+1][j],an1+anw2*4/7,cityYear[i+1][j]);
					an1=an1+anw;
	 			}
			
		}
		
		for(int j=0;j<11;j++){
			float an1=35+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<11;i++){
					noFill();
					strokeWeight(5);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
							bezier(an1,cityYear[i][j],an1+anw2*2/7,cityYear[i][j],an1+anw2*2/7,cityYear[i+1][j],an1+anw2*4/7,cityYear[i+1][j]);

						}
					}
					/*int nn=getcolor(clusterYear4[i][j]);
					stroke(red2[nn],green2[nn],blue2[nn]);*/
					//stroke(120*clusterYear4[i][j],100,100);
					an1=an1+anw;
	 			}
			
		}
		an2=35;
		for(int i=0;i<12;i++){
			float len=440;
			float blankwidth=150/(clustersYear[i].clusters.size());
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(year2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][year2_sort[i][j]][k]);
					strokeWeight((float)0);
					//clusterYear4[i][tempdp.getDataPointName()]=clusterYear3[i][year2_sort[i][j]];
					
					//fill((float)(120*clusterYear2[i][year2_sort[i][j]]),100,100);
					//cityYear[i][tempdp.getDataPointName()]=len+LineWidth/2;
					/*if(clusterFlag[tempdp.getDataPointName()]==1){
						fill(sites[tempdp.getDataPointName()].c);
					}else{
						int nn=getcolor(clusterYear2[i][year2_sort[i][j]]);
						fill(red2[nn],green2[nn],blue2[nn]);
					}*/
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
						}else{
							fill(0,0,90);
						}
					}else{
						int nn=getcolor(clusterYear2[i][year2_sort[i][j]]);
						fill(red2[nn],green2[nn],blue2[nn]);
					}
					rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		an2=35;
		for(int i=0;i<12;i++){
			float len=440;
			float blankwidth=150/(clustersYear[i].clusters.size());
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(year2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][year2_sort[i][j]][k]);
					strokeWeight((float)0);
					
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
							rect(an2-anw2*3/14,len,anw2*3/7,5);
						}
					}
					
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		an2=35;
		for(int i=0;i<12;i++){
			float len=440;
			float blankwidth=150/(clustersYear[i].clusters.size());
			for(int j=0;j<clustersYear[i].clusters.size();j++){
				Cluster cl=clustersYear[i].clusters.get(year2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(year2_sort1[i][year2_sort[i][j]][k]);
					strokeWeight((float)0);				
					if(mouseX>an2-anw2*3/14&&mouseX<an2+anw2*3/14&&mouseY>len&&mouseY<len+5){
						fill(60,20,100);
						rect((float)mouseX+20,(float)mouseY,EnglishName[tempdp.getDataPointName()].length()*8,20);
						textSize(14);
						textAlign(LEFT);
						fill(0);
						text(EnglishName[tempdp.getDataPointName()],mouseX+25,mouseY+14);
					}
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		}
	}
	
	public int getcolor(double num){
		if(num>=0&&num<0.1){
			return 9;
		}else if(num>=0.1&&num<0.2){
			return 8;
		}else if(num>=0.2&&num<0.3){
			return 7;
		}else if(num>=0.3&&num<0.4){
			return 6;
		}else if(num>=0.4&&num<0.5){
			return 5;
		}else if(num>=0.5&&num<0.6){
			return 4;
		}else if(num>=0.6&&num<0.7){
			return 3;
		}else if(num>=0.7&&num<0.8){
			return 2;
		}else if(num>=0.8&&num<0.9){
			return 1;
		}else{
			return 0;
		}
	}
	public void drawline(){
		strokeWeight(1);
		stroke(0);
		fill(0,0,100);
		rect(970,390,370,310,5);
		int startcolor=425;
		for(int i=0;i<10;i++){
			fill(red2[i],green2[i],blue2[i]);
			rect(925,startcolor,25,25);
			startcolor=startcolor+25;
		}
		fill(0);
		textSize(15);
		textAlign(CENTER);
		text("high",(float)937.5,420);
		text("low",(float)937.5,690);
		
		ellipse(1155,550,260,260);
		//圆环
		float start=PI;
		for(int i=0;i<24;i++){
			int nn=getcolor(clusterHour[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			arc(1155,550,260,260,start,start+PI/48,PIE);
			start=start+PI/48;
		}
		
		
		start=PI*3/2;
		for(int i=0;i<7;i++){
			int nn=getcolor(clusterWeek1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			arc(1155,550,260,260,start,start+PI/14,PIE);
			start=start+PI/14;
		}
		start=0;
		for(int i=0;i<daynum;i++){
			int nn=getcolor(clusterMonth1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			arc(1155,550,260,260,start,start+PI/2/daynum,PIE);
			start=start+PI/2/daynum;
		}
		start=PI/2;
		for(int i=0;i<12;i++){
			int nn=getcolor(clusterYear1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			arc(1155,550,260,260,start,start+PI/24,PIE);
			start=start+PI/24;
		}
		
		
		fill(0,0,100);
		ellipse(1155,550,230,230);
		float a=PI;
		for(int i=0;i<4;i++){
			if(i==chooseTimeType)
				fill(60,30,100);
			else{
				fill(0,0,100);
			}
			arc(1155,550,230,230,a,a+PI/2);
			a=a+PI/2;
		}
		line(1025,550,1285,550);
		line(1155,420,1155,680);
		
		fill(0,0,70);
		textSize(30);
		text("Day",(float) (1010),(float)(430));
		text("Week",(float) (1300),(float) (430));
		text("Year",(float) (1010),(float) (680));
		text("Month",(float) (1300),(float) (680));
		
		//名字
		textSize(18);
		fill(0);
		text("0",(float)(1155+135*Math.cos(PI)),(float)(550+135*Math.sin(PI)));
		text("5",(float)(1155+135*Math.cos(PI*9/8)),(float)(550+135*Math.sin(PI*9/8)));
		text("11",(float)(1155+135*Math.cos(PI*5/4)),(float)(550+135*Math.sin(PI*5/4)));
		//text("17",(float)(1155+135*Math.cos(PI*11/8)),(float)(550+135*Math.sin(PI*11/8)));
		text("20",(float)(1155+135*Math.cos(PI*20/14)),(float)(550+135*Math.sin(PI*20/14)));
		
		text(StrWeek[0],(float)(1155+135*Math.cos(PI*11/7)),(float)(550+135*Math.sin(PI*11/7)));
		text(StrWeek[3],(float)(1155+145*Math.cos(PI*25/14)),(float)(550+145*Math.sin(PI*25/14)));
		text(StrWeek[6],(float)(1155+150*Math.cos(-PI/56)),(float)(550+150*Math.sin(-PI/56)));
		
		text("1",(float)(1155+135*Math.cos(PI/2/daynum)),(float)(550+135*Math.sin(PI/2/daynum)));
		text("15",(float)(1155+145*Math.cos(PI*15/2/daynum)),(float)(550+145*Math.sin(PI*15/2/daynum)));
		text(daynum+"",(float)(1155+145*Math.cos(PI*(daynum-1)/2/daynum)),(float)(550+145*Math.sin(PI*(daynum-1)/2/daynum)));
		
		text(StrYear[2],(float)(1155+140*Math.cos(PI*29/48)),(float)(550+140*Math.sin(PI*29/48)));
		text(StrYear[5],(float)(1155+150*Math.cos(PI*18/24)),(float)(550+150*Math.sin(PI*18/24)));
		text(StrYear[8],(float)(1155+150*Math.cos(PI*41/48)),(float)(550+150*Math.sin(PI*41/48)));
		
		strokeWeight(3);
		smooth();
		noFill();
		beginShape();
		clusterHour[0]=map(clusterHour[0],0,1,(float)0.2,(float)0.9);
		curveVertex(1155+(float)(110*clusterHour[0]*Math.cos(PI*51/50)), (float)(550+110*clusterHour[0]*Math.sin(PI*51/50)));
		System.out.println(clusterMonth1[daynum-1]+"  clusterHour[0]");
		for(int i=0;i<24;i++){
			if(i!=0)
				clusterHour[i]=map(clusterHour[i],0,1,(float)0.2,(float)0.9);
			//line(1155,550,1155+(float)(100*clusterHour[i]*Math.cos(PI*51/50+PI/50*i)),(float)(550+100*clusterHour[i]*Math.sin(PI*51/50+PI/50*i)));
			curveVertex(1155+(float)(110*clusterHour[i]*Math.cos(PI*51/50+PI/50*i)),(float)(550+110*clusterHour[i]*Math.sin(PI*51/50+PI/50*i)));
		}
		for(int i=0;i<7;i++){
			clusterWeek1[i]=map(clusterWeek1[i],0,1,(float)0.2,(float)0.9);
			//line(1155,550,1155+(float)(110*clusterWeek1[i]*Math.cos(PI*25/16+PI/16*i)),(float)(550+110*clusterWeek1[i]*Math.sin(PI*25/16+PI/16*i)));
			curveVertex(1155+(float)(110*clusterWeek1[i]*Math.cos(PI*25/16+PI/16*i)),(float)(550+110*clusterWeek1[i]*Math.sin(PI*25/16+PI/16*i)));
		}
		for(int i=0;i<daynum;i++){
			clusterMonth1[i]=map(clusterMonth1[i],0,1,(float)0.2,(float)0.9);
			//line(1155,550,1155+(float)(110*clusterMonth1[i]*Math.cos(PI/2/(daynum+1)+PI/2/(daynum+1)*i)),(float)(550+110*clusterMonth1[i]*Math.sin(PI/2/(daynum+1)+PI/2/(daynum+1)*i)));
			curveVertex(1155+(float)(110*clusterMonth1[i]*Math.cos(PI/2/(daynum+1)+PI/2/(daynum+1)*i)),(float)(550+110*clusterMonth1[i]*Math.sin(PI/2/(daynum+1)+PI/2/(daynum+1)*i)));
		}
		for(int i=0;i<12;i++){
			clusterYear1[i]=map(clusterYear1[i],0,1,(float)0.2,(float)0.9);
			//line(1155,550,1155+(float)(110*clusterYear1[i]*Math.cos(PI*14/26+PI/26*i)),(float)(550+110*clusterYear1[i]*Math.sin(PI*14/26+PI/26*i)));
			curveVertex(1155+(float)(110*clusterYear1[i]*Math.cos(PI*14/26+PI/26*i)),(float)(550+110*clusterYear1[i]*Math.sin(PI*14/26+PI/26*i)));
		}
		curveVertex(1155+(float)(110*clusterHour[0]*Math.cos(PI*51/50)), (float)(550+110*clusterHour[0]*Math.sin(PI*51/50)));
		curveVertex(1155+(float)(110*clusterHour[0]*Math.cos(PI*51/50)), (float)(550+110*clusterHour[0]*Math.sin(PI*51/50)));
		 endShape();
	}
	public void CluserWeek(){
		if(flagchose1==true||ClusterDis!=dis1||hour3!=hour){
			flagchose1=false;
			dis1=ClusterDis;
			hour3=hour;
			for(int l=0;l<7;l++){
				for(int i=0;i<11;i++){
					for(int j=0;j<11;j++){
						double num=0;
						for(int k=0;k<15;k++){
							if(opt[k]==1)
								num=num+Math.pow((week[k][l][i]-week[k][l][j]),2); 
							
						}
						input3[i][j]=Math.sqrt(num);
					}
				}
				output4=MDSJ.classicalScaling(input3);
				double numtext[][]=new double[2][11];
				numtext=Normalized(output4,11);
				for(int n=0;n<11;n++){
					output_w[l][0][n]=numtext[0][n];
					output_w[l][1][n]=numtext[1][n];
				}
			}
			
		}
		for(int i=0;i<7;i++){
			dpoints2.clear();
			for(int j=0;j<11;j++){
				double[] tmp = {output_w[i][0][j],output_w[i][1][j] };
				dpoints2.add(new DataPoint(tmp, j));
			}
			ClusterAnalysis ca1 = new ClusterAnalysis();
			clusters2 = ca1.startAnalysis(dpoints2); // 开始聚类
			ClustersCity clustersCity1=new ClustersCity();
			clustersCity1.clusters=clusters2;
			clustersWeek[i]=clustersCity1;
		}
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					clusterWeek[i][j][k]=0;
				}
			}
		}
		if(radiotype==1||radiotype==3){
			for(int i=0;i<7;i++){
				for(int j=0;j<clustersWeek[i].clusters.size();j++){
					Cluster cl=clustersWeek[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						//num=num+q1[0][tempdp.getDataPointName()][i];
						num=num+week[0][i][tempdp.getDataPointName()];
						if(radiotype==1)
							week1_sort1[i][j][k]=q1[0][tempdp.getDataPointName()][i];
						else if(radiotype==3)
							week1_sort1[i][j][k]=tempdp.getDataPointName();
						week2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					week1_sort[i][j]=num;
					week2_sort[i][j]=j;
				}
			}
		}
		else{
			for(int i=0;i<7;i++){
				for(int j=0;j<clustersWeek[i].clusters.size();j++){
					Cluster cl=clustersWeek[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					double num=0;
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(k);
						//num=num+q1[0][tempdp.getDataPointName()][i];
						num=num+tempdp.getDataPointName();
						
						week1_sort1[i][j][k]=tempdp.getDataPointName();
						week2_sort1[i][j][k]=k;
					}
					num=num/tempDps.size();
					week1_sort[i][j]=num;
					week2_sort[i][j]=j;
				}
			}
		}
		for(int i=0;i<7;i++){
			sort1(week1_sort[i],week2_sort[i],clustersWeek[i].clusters.size());
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				//System.out.println(i+"   "+b_sort[i][j]);
			}
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(j);
				List<DataPoint> tempDps=cl.getDataPoints();
				sort1(week1_sort1[i][j],week2_sort1[i][j],tempDps.size());
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][j][k]);
					//System.out.println(j+"    "+k+" k  "+b_sort1[i][j][k]);
				}
			}
		}
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					clusterWeek[i][j][k]=0;
				}
			}
		}
		
		for(int i=0;i<7;i++){
			float len=255;
			int sumNum=0;
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(week2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				len=(float) (len+tempDps.size()*1*2/2);
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][week2_sort[i][j]][k]);
					cityWeek[i][tempdp.dataPointName]=len;
					 len=len+4;
					 clusterWeek[i][week2_sort[i][j]][tempdp.getDataPointName()]=1;
					//System.out.println(j+"    "+k+" k  "+b_sort1[i][j][k]);
				}
				len=(float) (len+tempDps.size()*1*2/2);
				sumNum++;
			}
		}
		
		for(int i=0;i<7;i++){
			double num=0;
			for(int l=0;l<clusters.size();l++){
				for(int k=0;k<clustersWeek[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterWeek[i][k][m]==clusterDay[hour][l][m]&&clusterWeek[i][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						Cluster cl=clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
						
					}
				}
				
			}
			clusterWeek1[i]=(float) num/clusters.size();
		}
		for(int i=0;i<6;i++){
			for(int l=0;l<clustersWeek[i+1].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersWeek[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterWeek[i][k][m]==clusterWeek[i+1][l][m]&&clusterWeek[i+1][l][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersWeek[i+1].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterWeek2[i+1][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		float max1=-1000,min1=1000;
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				if(clusterWeek2[i][j]>max1)
					max1=clusterWeek2[i][j];
				if(clusterWeek2[i][j]<min1)
					min1=clusterWeek2[i][j];
			}
		}
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				clusterWeek2[i][j]=(clusterWeek2[i][j]-min1)/(max1-min1);
				boolean a=false;
				a=Double.isNaN(clusterWeek2[i][j]);
				if(a==true)
					clusterWeek2[i][j]=0;
			}
		}
		for(int i=0;i<6;i++){
			for(int l=0;l<clustersWeek[i].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersWeek[i+1].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterWeek[i][l][m]==clusterWeek[i+1][k][m]&&clusterWeek[i+1][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersWeek[i].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterWeek3[i][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		
		float max=-100,min=1000;
		for(int i=0;i<7;i++){
			if(clusterWeek1[i]>max)
				max=clusterWeek1[i];
			if(clusterWeek1[i]<min)
				min=clusterWeek1[i];
		}
		for(int i=0;i<7;i++){
			clusterWeek1[i]=(clusterWeek1[i]-min)/(max-min);
			boolean a=false;
			a=Double.isNaN(clusterWeek1[i]);
			if(a==true)
				clusterWeek1[i]=0;
			
		}
		
		
		float an=50;
		float anw=810/6;
		
		strokeWeight((float) 0.5);
		stroke(0,0,0);
		
		
		if(chooseTimeType==1){
			fill(12,0,100);
			rect(5,400,900,300,5);
		for(int i=0;i<7;i++){
			System.out.println();
			strokeWeight(0);
			if(i==x-1){
				fill(0,0,90);
				rect(an-anw*3/14,430,anw*3/7,250);
			}
			
			strokeWeight((float) 0.5);
			stroke(0,0,0);
			line(an,420,an,680);
			textAlign(CENTER);
			fill(0);
			text(weekname[i],an,690);
			
			/*if(clusterWeek1[i]>0.5)
				fill(284,map(clusterWeek1[i],(float) 0.5,1,(float) 0.1,1)*100,100);
			else
				fill(60,map(clusterWeek1[i],0,(float)0.5,1,(float)0.1)*100,100);
			if(i==month-1)
				fill(0,100,100);*/
			
			int nn=getcolor(clusterWeek1[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			ellipse(an,420,15,15);
			
			an=an+anw;
		}
		float an2=50;
		float anw2=810/6;
		float LineWidth=5;
		
		for(int i=0;i<7;i++){
			float len=440;
			float blankwidth=150/(clustersWeek[i].clusters.size());
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(week2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][week2_sort[i][j]][k]);
					strokeWeight((float)0);
					clusterWeek4[i][tempdp.getDataPointName()]=clusterWeek3[i][week2_sort[i][j]];
					//int nn=getcolor(clusterWeek2[i][week2_sort[i][j]]);
					//fill(red2[nn],green2[nn],blue2[nn]);
					//fill((float)(120*clusterWeek2[i][week2_sort[i][j]]),100,100);
					cityWeek[i][tempdp.getDataPointName()]=len+LineWidth/2;
					//rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth;
			}
			an2=an2+anw2;
		}
		float max2=-1000,min2=1000;
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				if(clusterWeek4[i][j]>max2)
					max2=clusterWeek4[i][j];
				if(clusterWeek4[i][j]<min2)
					min2=clusterWeek4[i][j];
			}
		}
		for(int i=0;i<7;i++){
			for(int j=0;j<11;j++){
				clusterWeek4[i][j]=(clusterWeek4[i][j]-min2)/(max2-min2);
				boolean a=false;
				a=Double.isNaN(clusterWeek4[i][j]);
				if(a==true)
					clusterWeek4[i][j]=0;
			}
		}
		for(int j=0;j<11;j++){
			float an1=50+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<6;i++){
					noFill();
					strokeWeight(5);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
						}else{
							stroke(0,0,90);
						}
					}else{
						int nn=getcolor(clusterWeek4[i][j]);
						stroke(red2[nn],green2[nn],blue2[nn]);
					}
					/*int nn=getcolor(clusterWeek4[i][j]);
					stroke(red2[nn],green2[nn],blue2[nn]);*/
					//stroke(120*clusterHour3[i][j],100,100);
					bezier(an1,(float)cityWeek[i][j],an1+anw2*2/7,(float)cityWeek[i][j],an1+anw2*2/7,(float)cityWeek[i+1][j],an1+anw2*4/7,(float)cityWeek[i+1][j]);
					an1=an1+anw;
	 			}
			
		}
		for(int j=0;j<11;j++){
			float an1=50+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<6;i++){
					noFill();
					strokeWeight(5);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
							bezier(an1,(float)cityWeek[i][j],an1+anw2*2/7,(float)cityWeek[i][j],an1+anw2*2/7,(float)cityWeek[i+1][j],an1+anw2*4/7,(float)cityWeek[i+1][j]);

						}
					}
					an1=an1+anw;
	 			}
			
		}
		an2=50;
		for(int i=0;i<7;i++){
			float len=440;
			float blankwidth=150/(clustersWeek[i].clusters.size());
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(week2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][week2_sort[i][j]][k]);
					strokeWeight((float)0);
					//clusterWeek4[i][tempdp.getDataPointName()]=clusterWeek3[i][week2_sort[i][j]];
					//int nn=getcolor(clusterWeek2[i][week2_sort[i][j]]);
					//fill(red2[nn],green2[nn],blue2[nn]);
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
						}else{
							fill(0,0,90);
						}
					}else{
						int nn=getcolor(clusterWeek2[i][week2_sort[i][j]]);
						fill(red2[nn],green2[nn],blue2[nn]);
					}
					//fill((float)(120*clusterWeek2[i][week2_sort[i][j]]),100,100);
					//cityWeek[i][tempdp.getDataPointName()]=len+LineWidth/2;
					rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth;
			}
			an2=an2+anw2;
		}
		an2=50;
		for(int i=0;i<7;i++){
			float len=440;
			float blankwidth=150/(clustersWeek[i].clusters.size());
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(week2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][week2_sort[i][j]][k]);
					strokeWeight((float)0);
					//clusterWeek4[i][tempdp.getDataPointName()]=clusterWeek3[i][week2_sort[i][j]];
					//int nn=getcolor(clusterWeek2[i][week2_sort[i][j]]);
					//fill(red2[nn],green2[nn],blue2[nn]);
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
							rect(an2-anw2*3/14,len,anw2*3/7,5);
						}
					}
					//fill((float)(120*clusterWeek2[i][week2_sort[i][j]]),100,100);
					//cityWeek[i][tempdp.getDataPointName()]=len+LineWidth/2;
					
					len=len+LineWidth+2;
				}
				len=len+blankwidth;
			}
			an2=an2+anw2;
		}
		an2=50;
		for(int i=0;i<7;i++){
			float len=440;
			float blankwidth=150/(clustersWeek[i].clusters.size());
			for(int j=0;j<clustersWeek[i].clusters.size();j++){
				Cluster cl=clustersWeek[i].clusters.get(week2_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(week2_sort1[i][week2_sort[i][j]][k]);
					if(mouseX>an2-anw2*3/14&&mouseX<an2+anw2*3/14&&mouseY>len&&mouseY<len+5){
						fill(60,20,100);
						rect((float)mouseX+20,(float)mouseY,EnglishName[tempdp.getDataPointName()].length()*8,20);
						textSize(14);
						textAlign(LEFT);
						fill(0);
						text(EnglishName[tempdp.getDataPointName()],mouseX+25,mouseY+14);
					}
					len=len+LineWidth+2;
				}
				len=len+blankwidth;
			}
			an2=an2+anw2;
		}
		
		
		
		}
	}
	
	
	
	
	
	
	
	public void similarCityMatrix(){
		if(flagchose3==true||ClusterDis!=dis3||hour5!=hour){
			flagchose3=false;
			dis3=ClusterDis;
			hour5=hour;
			for(int l=0;l<24;l++){
				for(int i=0;i<11;i++){
					for(int j=0;j<11;j++){
						double num=0;
						for(int k=0;k<15;k++){
							if(opt[k]==1)
								num=num+Math.pow((q1[k][i][l]-q1[k][j][l]),2); 
							
						}
						input1[i][j]=Math.sqrt(num);
					}
				}
				output3=MDSJ.classicalScaling(input1);
				double numtext[][]=new double[2][11];
				numtext=Normalized(output3,11);
				for(int n=0;n<11;n++){
					output_m[l][0][n]=numtext[0][n];
					output_m[l][1][n]=numtext[1][n];
				}
				//output_m[l]=Normalized(output3,11);
			}
		}
			for(int i=0;i<24;i++){
				dpoints1.clear();
				for(int j=0;j<11;j++){
					double[] tmp = {output_m[i][0][j],output_m[i][1][j] };
					dpoints1.add(new DataPoint(tmp, j));
				}
				ClusterAnalysis ca1 = new ClusterAnalysis();
				clusters1 = ca1.startAnalysis(dpoints1); // 开始聚类
				ClustersCity clustersCity1=new ClustersCity();
				clustersCity1.clusters=clusters1;
				clustersCity[i]=clustersCity1;
			}
			for(int i=0;i<24;i++){
				for(int j=0;j<11;j++){
					for(int k=0;k<11;k++){
						clusterDay[i][j][k]=0;
					}
				}
			}
			if(radiotype==1||radiotype==3){
	 			for(int i=0;i<24;i++){
					for(int j=0;j<clustersCity[i].clusters.size();j++){
						Cluster cl=clustersCity[i].clusters.get(j);
						List<DataPoint> tempDps=cl.getDataPoints();
						double num=0;
						for(int k=0;k<tempDps.size();k++){
							DataPoint tempdp=tempDps.get(k);
							num=num+q1[0][tempdp.getDataPointName()][i];
							if(radiotype==1)
								a_sort1[i][j][k]=q1[0][tempdp.getDataPointName()][i];
							else if(radiotype==3)
								a_sort1[i][j][k]=tempdp.getDataPointName();
							b_sort1[i][j][k]=k;
							clusterDay[i][j][tempdp.getDataPointName()]=1;
						}
						num=num/tempDps.size();
						a_sort[i][j]=num;
						b_sort[i][j]=j;
					}
				}
			}
			else{
				for(int i=0;i<24;i++){
					for(int j=0;j<clustersCity[i].clusters.size();j++){
						Cluster cl=clustersCity[i].clusters.get(j);
						List<DataPoint> tempDps=cl.getDataPoints();
						double num=0;
						for(int k=0;k<tempDps.size();k++){
							DataPoint tempdp=tempDps.get(k);
							num=num+tempdp.getDataPointName();
							a_sort1[i][j][k]=tempdp.getDataPointName();
							b_sort1[i][j][k]=k;
							clusterDay[i][j][tempdp.getDataPointName()]=1;
						}
						num=num/tempDps.size();
						a_sort[i][j]=num;
						b_sort[i][j]=j;
					}
				}
			}
		
			for(int i=0;i<24;i++){
				sort1(a_sort[i],b_sort[i],clustersCity[i].clusters.size());
				for(int j=0;j<clustersCity[i].clusters.size();j++){
					//System.out.println(i+"   "+b_sort[i][j]);
				}
				for(int j=0;j<clustersCity[i].clusters.size();j++){
					Cluster cl=clustersCity[i].clusters.get(j);
					List<DataPoint> tempDps=cl.getDataPoints();
					sort1(a_sort1[i][j],b_sort1[i][j],tempDps.size());
					for(int k=0;k<tempDps.size();k++){
						DataPoint tempdp=tempDps.get(b_sort1[i][j][k]);
						//System.out.println(j+"    "+k+" k  "+b_sort1[i][j][k]);
					}
				}
			}
			
			
			for(int i=0;i<24;i++){
				double num=0;
				for(int l=0;l<clusters.size();l++){
					
					for(int k=0;k<clustersCity[i].clusters.size();k++){
						int n1=0;
						for(int m=0;m<11;m++){
							if(clusterDay[i][k][m]==clusterDay[hour][l][m]&&clusterDay[i][k][m]==1){
								n1++;
							}
							
						}
						if(n1!=0){
							Cluster cl=clusters.get(l);
							List<DataPoint> tempDps=cl.getDataPoints();					
							num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
						
						}
					}
					
				}
			
				clusterHour[i]=(float) num;
			}
		
			
			
			
		for(int i=0;i<23;i++){
			for(int l=0;l<clustersCity[i+1].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersCity[i].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterDay[i][k][m]==clusterDay[i+1][l][m]&&clusterDay[i+1][l][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersCity[i+1].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterHour1[i+1][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		
			/*for(int l=0;l<clustersCity[0].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersYear[11].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterDay[0][l][m]==clusterYear[11][k][m]&&clusterDay[0][l][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersCity[0].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterHour1[0][l]=(float) num;
				//System.out.println(l+"   "+num);
			}*/
			
		
		
		
		for(int i=0;i<23;i++){
			for(int l=0;l<clustersCity[i].clusters.size();l++){
				double num=0;
				for(int k=0;k<clustersCity[i+1].clusters.size();k++){
					int n1=0;
					for(int m=0;m<11;m++){
						if(clusterDay[i][l][m]==clusterDay[i+1][k][m]&&clusterDay[i+1][k][m]==1){
							n1++;
						}
						
					}
					if(n1!=0){
						//System.out.println("x"+"   "+n1);
						Cluster cl=clustersCity[i].clusters.get(l);
						List<DataPoint> tempDps=cl.getDataPoints();					
						num=num-n1*1.0/tempDps.size()*Math.log(n1*1.0/tempDps.size())/Math.log(2);
					
					}
				}
				clusterHour2[i][l]=(float) num;
				//System.out.println(l+"   "+num);
			}
			
		}
		float max=-100,min=1000;
		for(int i=0;i<24;i++){
			if(clusterHour[i]>max)
				max=clusterHour[i];
			if(clusterHour[i]<min)
				min=clusterHour[i];
		}
		for(int i=0;i<24;i++){
			clusterHour[i]=(clusterHour[i]-min)/(max-min);
			boolean a=false;
			a=Double.isNaN(clusterHour[i]);
			if(a==true)
				clusterHour[i]=0;
			
		}
		
		float an=40;
		float anw=840/23;
		
		strokeWeight((float) 0.5);
		stroke(0,0,0);
		
		
		
		
		if(chooseTimeType==0){
			fill(12,0,100);
			rect(5,400,900,300,5);
			
		for(int i=0;i<24;i++){
			strokeWeight(0);
			if(i==hour){
				fill(0,0,90);
				rect(an-anw*3/14,430,anw*3/7,250);
			}
			strokeWeight((float) 0.5);
			stroke(0,0,0);
			textAlign(CENTER);
			line(an,420,an,680);
			fill(0);
			text(i+"",an,690);
			
			/*if(clusterHour[i]>0.5){
				fill(284,map(clusterHour[i],(float) 0.5,1,(float) 0.1,1)*100,100);
			}
			else
				fill(60,map(clusterHour[i],0,(float)0.5,1,(float)0.1)*100,100);
			
			if(i==hour)
				fill(0,100,100);*/
			int nn=getcolor(clusterHour[i]);
			fill(red2[nn],green2[nn],blue2[nn]);
			
			ellipse(an,420,15,15);
			
			an=an+anw;
		}
		float an2=40;
		float anw2=840/23;
		float LineWidth=5;
		
		/*for(int i=0;i<24;i++){
			float len=440;
			float blankwidth=150/(clustersCity[i].clusters.size());
			for(int j=0;j<clustersCity[i].clusters.size();j++){
				Cluster cl=clustersCity[i].clusters.get(b_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(b_sort1[i][b_sort[i][j]][k]);
					strokeWeight((float)0);
					clusterHour3[i][tempdp.getDataPointName()]=clusterHour2[i][b_sort[i][j]];
					int nn=getcolor(clusterHour1[i][b_sort[i][j]]);
					fill(red2[nn],green2[nn],blue2[nn]);
					//fill((float)(120*clusterHour1[i][b_sort[i][j]]),100,100);
					citytime[i][tempdp.getDataPointName()]=len+LineWidth/2;
					rect(an2-anw2*3/14,len,anw2*3/7,8);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}*/
		
		for(int i=0;i<24;i++){
			float len=440;
			float blankwidth=150/(clustersCity[i].clusters.size());
			for(int j=0;j<clustersCity[i].clusters.size();j++){
				Cluster cl=clustersCity[i].clusters.get(b_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(b_sort1[i][b_sort[i][j]][k]);
					clusterHour3[i][tempdp.getDataPointName()]=clusterHour2[i][b_sort[i][j]];
					citytime[i][tempdp.getDataPointName()]=len+LineWidth/2;
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		for(int j=0;j<11;j++){
			float an1=40+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<23;i++){
					noFill();
					strokeWeight(5);
					//stroke(120*clusterHour3[i][j],100,100);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
						}else{
							stroke(0,0,90);
						}
					}else{
						int nn=getcolor(clusterHour3[i][j]);
						stroke(red2[nn],green2[nn],blue2[nn]);
					}
					/*int nn=getcolor(clusterHour3[i][j]);
					stroke(red2[nn],green2[nn],blue2[nn]);*/
					bezier(an1,(float)citytime[i][j],an1+anw2*2/7,(float)citytime[i][j],an1+anw2*2/7,(float)citytime[i+1][j],an1+anw2*4/7,(float)citytime[i+1][j]);
					an1=an1+anw;
	 			}
			
		}
		for(int j=0;j<11;j++){
			float an1=40+anw2*3/14;
			//if(j==mouseOn||clusterFlag[j]==1){
				stroke(238,57,62);
				for(int i=0;i<23;i++){
					noFill();
					strokeWeight(5);
					//stroke(120*clusterHour3[i][j],100,100);
					if(Preon!=100){
						if(clusterFlag[j]==1){
							stroke(sites[j].c);
							bezier(an1,(float)citytime[i][j],an1+anw2*2/7,(float)citytime[i][j],an1+anw2*2/7,(float)citytime[i+1][j],an1+anw2*4/7,(float)citytime[i+1][j]);

						}
					}
					
					an1=an1+anw;
	 			}
			
		}
		an2=40;
		for(int i=0;i<24;i++){
			float len=440;
			float blankwidth=150/(clustersCity[i].clusters.size());
			for(int j=0;j<clustersCity[i].clusters.size();j++){
				Cluster cl=clustersCity[i].clusters.get(b_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(b_sort1[i][b_sort[i][j]][k]);
					strokeWeight((float)0);
					//clusterHour3[i][tempdp.getDataPointName()]=clusterHour2[i][b_sort[i][j]];
					//int nn=getcolor(clusterHour1[i][b_sort[i][j]]);
					//fill(red2[nn],green2[nn],blue2[nn]);
					//fill((float)(120*clusterHour1[i][b_sort[i][j]]),100,100);
					//citytime[i][tempdp.getDataPointName()]=len+LineWidth/2;
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
						}else{
							fill(0,0,90);
						}
					}else{
						int nn=getcolor(clusterHour1[i][b_sort[i][j]]);
						fill(red2[nn],green2[nn],blue2[nn]);
					}
					rect(an2-anw2*3/14,len,anw2*3/7,5);
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		an2=40;
		for(int i=0;i<24;i++){
			float len=440;
			float blankwidth=150/(clustersCity[i].clusters.size());
			for(int j=0;j<clustersCity[i].clusters.size();j++){
				Cluster cl=clustersCity[i].clusters.get(b_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(b_sort1[i][b_sort[i][j]][k]);
					strokeWeight((float)0);
					if(Preon!=100){
						if(clusterFlag[tempdp.getDataPointName()]==1){
							fill(sites[tempdp.getDataPointName()].c);
							rect(an2-anw2*3/14,len,anw2*3/7,5);
						}
						
					}
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		an2=40;
		for(int i=0;i<24;i++){
			float len=440;
			float blankwidth=150/(clustersCity[i].clusters.size());
			for(int j=0;j<clustersCity[i].clusters.size();j++){
				Cluster cl=clustersCity[i].clusters.get(b_sort[i][j]);
				List<DataPoint> tempDps=cl.getDataPoints();
				noFill();
				double c=0;
				for(int k=0;k<tempDps.size();k++){
					DataPoint tempdp=tempDps.get(b_sort1[i][b_sort[i][j]][k]);
					if(mouseX>an2-anw2*3/14&&mouseX<an2+anw2*3/14&&mouseY>len&&mouseY<len+5){
						fill(60,20,100);
						rect((float)mouseX+20,(float)mouseY,EnglishName[tempdp.getDataPointName()].length()*8,20);
						textSize(14);
						textAlign(LEFT);
						fill(0);
						text(EnglishName[tempdp.getDataPointName()],mouseX+25,mouseY+14);
					}
					len=len+LineWidth+2;
				}
				len=len+blankwidth+2;
			}
			an2=an2+anw2;
		}
		
		
		
		
		}
		
		
	}
	@SuppressWarnings("unchecked")
	
	public void cir(){
		int t=0;
		dpoints3.clear();
		for(int i=0;i<11;i++){
			if(clusterFlag1[i]==1){
				//System.out.println("clusterFlag1 "+clusterFlag1[i]);
				double[] tmp = {location[0][i],location[1][i] };
				dpoints3.add(new DataPoint(tmp, i));
				t++;
			}
		}
		//System.out.println("dpoints "+dpoints3.size());
		List<Cluster> finalClusters1 = new ArrayList<Cluster>();

		List<Cluster> originalClusters1 = initialCluster(dpoints3); // 初始化类族
		finalClusters1 = originalClusters1;
		
		boolean flag=true;
		cityList.clear();
		clusterList.clear();
		int l=0;
		while(flag){
			double min = Double.MAX_VALUE;
			int mergeIndexA = 0;
			int mergeIndexB = 0;
			for (int i = 0; i < finalClusters1.size(); i++) {
				for (int j = 0; j < finalClusters1.size(); j++) {
					if (i != j) {

						Cluster clusterA = finalClusters1.get(i);
						Cluster clusterB = finalClusters1.get(j);

						List<DataPoint> dataPointsA = clusterA
								.getDataPoints();
						List<DataPoint> dataPointsB = clusterB
								.getDataPoints();

						double tmpAx = 0, tmpAy = 0; // 类A重心坐标
						double tmpBx = 0, tmpBy = 0; // 类B重心坐标
						for (int m = 0; m < dataPointsA.size(); m++) {
							DataPoint dpA = dataPointsA.get(m);
							double[] dimA = dpA.getDimensioin();
							tmpAx += dimA[0];
							tmpAy += dimA[1];
						}
						tmpAx /= dataPointsA.size();
						tmpAy /= dataPointsA.size();

						for (int m = 0; m < dataPointsB.size(); m++) {
							DataPoint dpB = dataPointsB.get(m);
							double[] dimB = dpB.getDimensioin();
							tmpBx += dimB[0];
							tmpBy += dimB[1];
						}
						tmpBx /= dataPointsB.size();
						tmpBy /= dataPointsB.size();

						double tempDis = Math.sqrt((tmpAx - tmpBx)
								* (tmpAx - tmpBx)
								+ ((tmpAy - tmpBy) * (tmpAy - tmpBy)));
						if (tempDis < min) {
							min = tempDis;
							mergeIndexA = i;
							mergeIndexB = j;
							flag = false;
						}
						if (min > ClusterDis) // 两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束
						{
							flag = false;
						} else {
							flag = true;
						}
						/*
						 * for(int m=0;m<dataPointsA.size();m++){ for(int
						 * n=0;n<dataPointsB.size();n++){ double
						 * tempDis=getDistance
						 * (dataPointsA.get(m),dataPointsB.get(n));
						 * if(tempDis<min){ min=tempDis; mergeIndexA=i;
						 * mergeIndexB=j; } } } if(min > ClusterDis)
						 * //两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束 {flag=false; }
						 * else {flag=true; }
						 */
					}
				} // end for j
			}// end for i
			// 合并cluster[mergeIndexA]和cluster[mergeIndexB]
			if (flag == false)
				break;
			intList intlist1 = new intList();
			if(l==0){
				intList intlist2 = new intList();
				for(Cluster cl:finalClusters1){	
					 List<DataPoint> tempDps=cl.getDataPoints();
					 intlist2.intlist.add(tempDps.size());
					// System.out.print(tempDps.size()+"  ");
					 for(DataPoint tempdp:tempDps){
						 //System.out.println("name "+tempdp.getDataPointName());
					 }
				}
				cityList.add(intlist2);
				
				ClustersCity clu2=new ClustersCity();
				List<Cluster> finalclu2 = new ArrayList<Cluster>();
				for(Cluster cl:finalClusters1){
					List<DataPoint> tempDps=cl.getDataPoints();
					Cluster cl1=new Cluster();
					List<DataPoint> tempDps1=new ArrayList<DataPoint>();
					for(DataPoint tempdp:tempDps){
						DataPoint tempdp1=new DataPoint();
						tempdp1=tempdp;
						tempDps1.add(tempdp1);
					}
					cl1.setDataPoints(tempDps1);
					finalclu2.add(cl1);
				}
				clu2.clusters=finalclu2;
				clusterList.add(clu2);
				
				l++;
			}
			finalClusters1 = mergeCluster1(finalClusters1, mergeIndexA,
					mergeIndexB);
			ClustersCity clu1=new ClustersCity();
			List<Cluster> finalclu = new ArrayList<Cluster>();
			
			for(Cluster cl:finalClusters1){
				List<DataPoint> tempDps=cl.getDataPoints();
				Cluster cl1=new Cluster();
				List<DataPoint> tempDps1=new ArrayList<DataPoint>();
				for(DataPoint tempdp:tempDps){
					DataPoint tempdp1=new DataPoint();
					tempdp1=tempdp;
					tempDps1.add(tempdp1);
				}
				cl1.setDataPoints(tempDps1);
				finalclu.add(cl1);
			}
			clu1.clusters=finalclu;
			clusterList.add(clu1);
			
			
			//System.out.println("temp");
			
			
			for(Cluster cl:finalClusters1){	
				 List<DataPoint> tempDps=cl.getDataPoints();
				 intlist1.intlist.add(tempDps.size());
				// System.out.print(tempDps.size()+"  ");
				 for(DataPoint tempdp:tempDps){
					// System.out.println("name "+tempdp.getDataPointName());
				 }
			}
			cityList.add(intlist1);
			//System.out.println();
			
			choosencity.clear();
			for(Cluster cl:finalClusters1){	
				 List<DataPoint> tempDps=cl.getDataPoints();
				 
				 for(DataPoint tempdp:tempDps){
					 choosencity.add(tempdp.getDataPointName());
				 }
			}
			
			if(finalClusters1.size() == 1) 
				break;
		}
	}
	
	
	
	public void CluBar(){
		int t=0;
		dpoints4.clear();
		for(int i=0;i<11;i++){
			//System.out.println("clusterFlag1 "+clusterFlag1[i]);
			double[] tmp = {location[0][i],location[1][i] };
			dpoints4.add(new DataPoint(tmp, i));
			t++;
			
		}
		//System.out.println("dpoints "+dpoints4.size());
		List<Cluster> finalClusters1 = new ArrayList<Cluster>();

		List<Cluster> originalClusters1 = initialCluster(dpoints4); // 初始化类族
		finalClusters1 = originalClusters1;
		
		boolean flag=true;
		cityList1.clear();
		clusterList2.clear();
		int l=0;
		while(flag){
			double min = Double.MAX_VALUE;
			int mergeIndexA = 0;
			int mergeIndexB = 0;
			for (int i = 0; i < finalClusters1.size(); i++) {
				for (int j = 0; j < finalClusters1.size(); j++) {
					if (i != j) {

						Cluster clusterA = finalClusters1.get(i);
						Cluster clusterB = finalClusters1.get(j);

						List<DataPoint> dataPointsA = clusterA
								.getDataPoints();
						List<DataPoint> dataPointsB = clusterB
								.getDataPoints();

						double tmpAx = 0, tmpAy = 0; // 类A重心坐标
						double tmpBx = 0, tmpBy = 0; // 类B重心坐标
						for (int m = 0; m < dataPointsA.size(); m++) {
							DataPoint dpA = dataPointsA.get(m);
							double[] dimA = dpA.getDimensioin();
							tmpAx += dimA[0];
							tmpAy += dimA[1];
						}
						tmpAx /= dataPointsA.size();
						tmpAy /= dataPointsA.size();

						for (int m = 0; m < dataPointsB.size(); m++) {
							DataPoint dpB = dataPointsB.get(m);
							double[] dimB = dpB.getDimensioin();
							tmpBx += dimB[0];
							tmpBy += dimB[1];
						}
						tmpBx /= dataPointsB.size();
						tmpBy /= dataPointsB.size();

						double tempDis = Math.sqrt((tmpAx - tmpBx)
								* (tmpAx - tmpBx)
								+ ((tmpAy - tmpBy) * (tmpAy - tmpBy)));
						if (tempDis < min) {
							min = tempDis;
							mergeIndexA = i;
							mergeIndexB = j;
							flag = false;
						}
						if (min > ClusterDis) // 两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束
						{
							flag = false;
						} else {
							flag = true;
						}
						/*
						 * for(int m=0;m<dataPointsA.size();m++){ for(int
						 * n=0;n<dataPointsB.size();n++){ double
						 * tempDis=getDistance
						 * (dataPointsA.get(m),dataPointsB.get(n));
						 * if(tempDis<min){ min=tempDis; mergeIndexA=i;
						 * mergeIndexB=j; } } } if(min > ClusterDis)
						 * //两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束 {flag=false; }
						 * else {flag=true; }
						 */
					}
				} // end for j
			}// end for i
			// 合并cluster[mergeIndexA]和cluster[mergeIndexB]
			if (flag == false)
				break;
			intList intlist1 = new intList();
			if(l==0){
				intList intlist2 = new intList();
				for(Cluster cl:finalClusters1){	
					 List<DataPoint> tempDps=cl.getDataPoints();
					 intlist2.intlist.add(tempDps.size());
					// System.out.print(tempDps.size()+"  ");
					 for(DataPoint tempdp:tempDps){
						 //System.out.println("name "+tempdp.getDataPointName());
					 }
				}
				cityList1.add(intlist2);
				
				ClustersCity clu2=new ClustersCity();
				List<Cluster> finalclu2 = new ArrayList<Cluster>();
				for(Cluster cl:finalClusters1){
					List<DataPoint> tempDps=cl.getDataPoints();
					Cluster cl1=new Cluster();
					List<DataPoint> tempDps1=new ArrayList<DataPoint>();
					for(DataPoint tempdp:tempDps){
						DataPoint tempdp1=new DataPoint();
						tempdp1=tempdp;
						tempDps1.add(tempdp1);
					}
					cl1.setDataPoints(tempDps1);
					finalclu2.add(cl1);
				}
				clu2.clusters=finalclu2;
				clusterList2.add(clu2);
				
				l++;
			}
			finalClusters1 = mergeCluster1(finalClusters1, mergeIndexA,
					mergeIndexB);
			ClustersCity clu1=new ClustersCity();
			List<Cluster> finalclu = new ArrayList<Cluster>();
			
			for(Cluster cl:finalClusters1){
				List<DataPoint> tempDps=cl.getDataPoints();
				Cluster cl1=new Cluster();
				List<DataPoint> tempDps1=new ArrayList<DataPoint>();
				for(DataPoint tempdp:tempDps){
					DataPoint tempdp1=new DataPoint();
					tempdp1=tempdp;
					tempDps1.add(tempdp1);
				}
				cl1.setDataPoints(tempDps1);
				finalclu.add(cl1);
			}
			clu1.clusters=finalclu;
			clusterList2.add(clu1);
			
			
			//System.out.println("temp");
			
			
			for(Cluster cl:finalClusters1){
				 List<DataPoint> tempDps=cl.getDataPoints();
				 intlist1.intlist.add(tempDps.size());
				// System.out.print(tempDps.size()+"  ");
				 for(DataPoint tempdp:tempDps){
					 //System.out.println("name "+tempdp.getDataPointName());
				 }
			}
			cityList1.add(intlist1);
			//System.out.println();
			
			choosencity.clear();
			for(Cluster cl:finalClusters1){	
				 List<DataPoint> tempDps=cl.getDataPoints();
				 
				 for(DataPoint tempdp:tempDps){
					 choosencity.add(tempdp.getDataPointName());
				 }
			}
			
			if(finalClusters1.size() == 1) 
				break;
		}
		//System.out.println(clusterList2.size());
	}
	
	
	
	
	private List<Cluster> mergeCluster1(List<Cluster> clusters,
			int mergeIndexA, int mergeIndexB) {
		// TODO 自动生成的方法存根
		if (mergeIndexA != mergeIndexB) {
			// 将cluster[mergeIndexB]中的DataPoint加入到 cluster[mergeIndexA]
			Cluster clusterA = clusters.get(mergeIndexA);
			Cluster clusterB = clusters.get(mergeIndexB);

			List<DataPoint> dpA = clusterA.getDataPoints();
			List<DataPoint> dpB = clusterB.getDataPoints();

			for (DataPoint dp : dpB) {
				DataPoint tempDp = new DataPoint();
				tempDp.setDataPointName(dp.getDataPointName());
				tempDp.setDimensioin(dp.getDimensioin());
				tempDp.setCluster(clusterA);
				dpA.add(tempDp);
			}

			clusterA.setDataPoints(dpA);

			// List<Cluster> clusters中移除cluster[mergeIndexB]
			clusters.remove(mergeIndexB);
		}

		return clusters;
	}

	private List<Cluster> initialCluster(ArrayList<DataPoint> dpoints32) {
		// TODO 自动生成的方法存根
		List<Cluster> originalClusters = new ArrayList<Cluster>();
		for (int i = 0; i < dpoints32.size(); i++) {
			DataPoint tempDataPoint = dpoints32.get(i);
			List<DataPoint> tempDataPoints = new ArrayList<DataPoint>();
			tempDataPoints.add(tempDataPoint);

			Cluster tempCluster = new Cluster();
			tempCluster.setClusterName("Cluster " + String.valueOf(i));
			tempCluster.setDataPoints(tempDataPoints);

			tempDataPoint.setCluster(tempCluster);
			originalClusters.add(tempCluster);
		}

		return originalClusters;
	}

	public void drawTimeMds(){
		
		noStroke();
		noFill();
		fill(0,0,100);
		stroke(0,100,0);
		strokeWeight(0);
		fill(0,0,100);
		//rect(585,5,460,320);
		if(hour1!=hour||flag==true||flagchose==true||sum1!=sum||typeFlag==false){
			hour1=hour;
			
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
					double num=0;
					for(int k=0;k<15;k++){
						if(opt[k]==1)
							num=num+Math.pow((q1[k][i][hour]-q1[k][j][hour]),2); 
						
					}
					input1[i][j]=Math.sqrt(num);
				}
			}
			output1=MDSJ.classicalScaling(input1);
			for(int i=0;i<11;i++){
				System.out.println("output1:"+output1[0][i]+"  "+output1[1][i]);
			}
		}
		Drawing(output1,11);
		//location2=Normalized(output1,11);
		for(int i=0;i<11;i++){
			location2[0][i]=mywidth/2+(float)(Math.cos(location[0][i])*location[1][i]*180);
			location2[1][i]=myheight/2-50+(float)(Math.sin(location[0][i])*location[1][i]*180);
		}
		
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				clusterNow[i][j]=0;
			}
		}
		
		
		startCluster(11);
		lenghupdate();
		float clu=0;
		int k=0;
		int sumNum=0;
		/*for(Cluster cl:clusters){	
			 List<DataPoint> tempDps=cl.getDataPoints();
			 arc(mywidth/2,myheight/2,500,500,2*PI/11*clu,2*PI/11*(clu+tempDps.size()),PIE);
			 clu=clu+tempDps.size();
	         for(DataPoint tempdp:tempDps){
	        	cityClu[k]=tempdp.getDataPointName();
	        	k++;
	        	clusterNow[sumNum][tempdp.getDataPointName()]=1;
	         }
	         sumNum++;
		}*/
		/*for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				System.out.print(clusterNow[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		//ellipse(mywidth/2,myheight/2,400,400);
		//ellipse(mywidth/2,myheight/2,500,500);
		//ellipse(mywidth/2,myheight/2,450,450);
		
		sites = new Site[11];
		for(int i=0; i<sites.length; i++)
		{
		  sites[i] = new Site((int)location[0][i],(int)location[1][i]);
		}
		for(int i=0;i<11;i++){
	        clusterFlag1[i]=0;
	    }
		strokeWeight(1);
        stroke(0,0,0);
        double qwer=bar[0][0]-20;
		int l=0;
		for(Cluster cl:clusters){	
			 List<DataPoint> tempDps=cl.getDataPoints();
	         for(DataPoint tempdp:tempDps){
	        	 sites[tempdp.getDataPointName()].setcolor(red[l], green[l], blue[l]);
	         }
			l++;
		}
		l=0;
        for(Cluster cl:clusters){
        	List<DataPoint> tempDps=cl.getDataPoints();
        	for(DataPoint tempdp:tempDps){
        		int c=color(red[l],green[l],blue[l]);
        		if(c==sites[Preon1].c){
        			clusterFlag1[tempdp.getDataPointName()]=1;
        		}
	         }
        	l++;
        }
        citySum=0;
        for(int i=0;i<11;i++){
        	if(clusterFlag1[i]==1)
        		citySum++;
        }
      
        cir();
       // System.out.println(clusterList.size());
        CluBar();
       
        
       /* for(intList in:cityList1){
			ArrayList<Integer> in1=in.getIntList();
			for(int x:in1){
				System.out.print(x+" ");
			}
			System.out.println("end");
		}*/
      
        /*for(intList in:cityList){
			ArrayList<Integer> in1=in.getIntList();
			for(int x:in1){
				System.out.print(x+" ");
			}
			System.out.println();
		}*/
        if(clusterList2.size()!=0){
	        ClustersCity clu2=new ClustersCity();
			List<Cluster> finalclu2 = new ArrayList<Cluster>();
			Cluster cl12=new Cluster();
			List<DataPoint> tempDps12=new ArrayList<DataPoint>();
			for(Cluster cl:clusterList2.get(0).clusters){
				List<DataPoint> tempDps=cl.getDataPoints();
				for(DataPoint tempdp:tempDps){
					DataPoint tempdp1=new DataPoint();
					tempdp1=tempdp;
					tempDps12.add(tempdp1);
				}
				
			}
			cl12.setDataPoints(tempDps12);
			finalclu2.add(cl12);
			clu2.clusters=finalclu2;
			clusterList2.add(clu2);
        }
		//中间半圆
        /*for(int i=0;i<clusterList2.size();i++){
        	ClustersCity clus= clusterList2.get(i);
        	for(Cluster cl:clus.clusters){
        		List<DataPoint> tempDps=cl.getDataPoints();
        		System.out.println(tempDps.size());
        		for(DataPoint tempdp:tempDps){
        			System.out.println("clusterList2   "+tempdp.getDataPointName());
        		}
        	}
        	System.out.println("end");
        }*/
        int t=0;
        rect(910,5,430,380,5);
        for(t=0;t<15;t++){
	        ClustersCity clus= clusterList.get(clusterList.size()-1);
	        for(Cluster cl:clus.clusters){
	        	if(t<5){
		        	cl.startAngle=920;
		        	cl.startHeight=10+t*75;
	        	}else if(4<t&&t<10){
	        		cl.startAngle=1060;
		        	cl.startHeight=10+(t-5)*75;
	        	}else{
	        		cl.startAngle=1200;
		        	cl.startHeight=10+(t-10)*75;
	        	}
	        	cl.angleWidth=130;
	        	cl.angleHeight=44;
	        }
	        
	        if(clusterList.size()>=2){
	        	int cutflag=0;
		        for(int i=clusterList.size()-1;i>0;i--){
			        ClustersCity clus1= clusterList.get(i);
			        ClustersCity clus2= clusterList.get(i-1);
			        for(Cluster cl1:clus1.clusters){
			    		List<DataPoint> tempDps1=cl1.getDataPoints();
			    		float startAngle=cl1.startAngle;
			    		float angleWidth=cl1.angleWidth;
			    		float startHeight=cl1.startHeight;
			    		float angleHeight=cl1.angleHeight;
			    		
			    		float a=0;
			    		
			    		for(Cluster cl2:clus2.clusters){
			    			
			    			int flag=0;
			        		List<DataPoint> tempDps2=cl2.getDataPoints();
			        		for(DataPoint tempdp1:tempDps1){
			        			for(DataPoint tempdp2:tempDps2){
				        			if(tempdp1.getDataPointName()==tempdp2.getDataPointName()){
				        				flag=1;
				        			}
				        		}
			        		}
			        		if(flag==1){
			        			strokeWeight(0);
			        			stroke(0,0,50);
			        			if(cutflag==0){
				        			cl2.startAngle=startAngle+a;
				        			cl2.angleWidth=angleWidth*tempDps2.size()/tempDps1.size();
				        			cl2.startHeight=startHeight;
				        			cl2.angleHeight=angleHeight;				
				        			a=a+angleWidth*tempDps2.size()/tempDps1.size();
				   
			        			}
			        			else{
			        				cl2.startAngle=startAngle;
				        			cl2.angleWidth=angleWidth;
				        			cl2.startHeight=startHeight+a;
				        			cl2.angleHeight=angleHeight*tempDps2.size()/tempDps1.size();				        			
				        			a=a+angleHeight*tempDps2.size()/tempDps1.size();
			        			}
			        		}
			        	}
			    		
			    	}
			        //System.out.println("cutflag:"+cutflag);
			        if(cutflag==0){
			    		cutflag=1;
			   		}else{
			   			cutflag=0;;
			   		}
		        }
	        }
	        listClu = clusterList.get(0).clusters;
	        Collections.sort(listClu);
	        int num=0;
	        

	        /*for(Cluster cl:listClu){
	        	System.out.println(num+"  "+cl.startHeight);
	        	num++;
	        	
	        }*/
	        for(int i=listClu.size()-1;i>=0;i--){
	        	Cluster cl=listClu.get(i);
	        	float startAngle=cl.startAngle;
	    		float angleWidth=cl.angleWidth;
	    		float startHeight=cl.startHeight;
	    		float angleHeight=cl.angleHeight;
	    		List<DataPoint> tempDps=cl.getDataPoints();
	    		for(DataPoint tempdp:tempDps){
	    			int nn=getType((int)q1[t][tempdp.getDataPointName()][hour]);
	    			fill(red1[nn],green1[nn],blue1[nn]);
	    			
        		}
	        	
	    		strokeWeight(1);
	    		stroke(0);
	    		rect(startAngle,startHeight,angleWidth,angleHeight);
	        	
	        }
        
        }
      
		fill(100,0,100);
		//ellipse(mywidth/2,myheight/2,420,420);
		
	}
	
	public int getType(int n){
		if(n>=0&&n<100){
			return 9;
		}else if(n>=100&&n<200){
			return 8;
		}else if(n>=200&&n<300){
			return 7;
		}else if(n>=300&&n<400){
			return 6;
		}else if(n>=400&&n<500){
			return 5;
		}else if(n>=500&&n<600){
			return 4;
		}else if(n>=600&&n<700){
			return 3;
		}else if(n>=700&&n<800){
			return 2;
		}else if(n>=800&&n<900){
			return 1;
		}else{
			return 0;
		}
	}
	public void drawBar(){
		//System.out.println(clusterList2.size()+"+++++++++++++++++++++++++");
		//System.out.println(clusterList.size());
		if(clusterList2.size()!=0){
			ClustersCity clus= clusterList2.get(clusterList2.size()-1);
	        for(Cluster cl:clus.clusters){	
	        	cl.startAngle=10;
		        cl.startHeight=10;
	        	cl.angleWidth=530;
	        	cl.angleHeight=20;
	        }
	        
	        if(clusterList2.size()>=2){
	        	int cutflag=0;
		        for(int i=clusterList2.size()-1;i>0;i--){
			        ClustersCity clus1= clusterList2.get(i);
			        ClustersCity clus2= clusterList2.get(i-1);
			        for(Cluster cl1:clus1.clusters){
			    		List<DataPoint> tempDps1=cl1.getDataPoints();
			    		float startAngle=cl1.startAngle;
			    		float angleWidth=cl1.angleWidth;
			    		float startHeight=cl1.startHeight;
			    		float angleHeight=cl1.angleHeight;
			    		
			    		int numclu=0;
			    		for(Cluster cl2:clus2.clusters){
			    			int flag=0;
			    			List<DataPoint> tempDps2=cl2.getDataPoints();
			        		for(DataPoint tempdp1:tempDps1){
			        			for(DataPoint tempdp2:tempDps2){
				        			if(tempdp1.getDataPointName()==tempdp2.getDataPointName()){
				        				flag=1;
				        			}
				        		}
			        		}
			        		if(flag==1)
			        			numclu++;
			    		}
			    		
			    		
			    		float a=0;
			    		for(Cluster cl2:clus2.clusters){
			    			
			    			int flag=0;
			        		List<DataPoint> tempDps2=cl2.getDataPoints();
			        		for(DataPoint tempdp1:tempDps1){
			        			for(DataPoint tempdp2:tempDps2){
				        			if(tempdp1.getDataPointName()==tempdp2.getDataPointName()){
				        				flag=1;
				        			}
				        		}
			        		}
			        		if(flag==1){
			        			strokeWeight(0);
			        			stroke(0,0,50);			   
				        		cl2.startAngle=startAngle+a;
				        		cl2.angleWidth=angleWidth/numclu;
				        		cl2.startHeight=startHeight;
				        		cl2.angleHeight=angleHeight;				
				        		a=a+angleWidth/numclu;
				        		//System.out.println(angleWidth/numclu+"  "+"width");
			        		}
			        	}
			    		
			    	}
		        }
	        }
	        listClu1 = clusterList2.get(0).clusters;
	        //Collections.sort(listClu1);
	        int num=0;
	        

	        for(int i=listClu1.size()-1;i>=0;i--){
	        	Cluster cl=listClu1.get(i);
	        	float startAngle=cl.startAngle;
	    		float angleWidth=cl.angleWidth;
	    		float startHeight=cl.startHeight;
	    		float angleHeight=cl.angleHeight;
	    		List<DataPoint> tempDps=cl.getDataPoints();
	    		
	    		if(Preon!=100){
		    		for(DataPoint tempdp:tempDps){
		    			if(sites[tempdp.getDataPointName()].c==sites[Preon].c){
		    				strokeWeight(4);
							//stroke(red[l],green[l],blue[l],70);
		    				stroke(291,100,29);
							noFill();
							bezier((float)drex[tempdp.getDataPointName()],(float)drey[tempdp.getDataPointName()],(float)drex[tempdp.getDataPointName()],(float)(drey[tempdp.getDataPointName()]-(drey[tempdp.getDataPointName()]-30)*0.75),startAngle+angleWidth/2,(float)(drey[tempdp.getDataPointName()]-(drey[tempdp.getDataPointName()]-30)*0.25),startAngle+angleWidth/2,30);
		    			}
		    		}
	    		}
	    		for(DataPoint tempdp:tempDps){
	    			fill(sites[tempdp.getDataPointName()].c);
	    		}
	            strokeWeight(1);
	            stroke(0);
	            //fill(0,0,100);
	            rect(startAngle,startHeight,angleWidth,angleHeight);
	        	
	        }
		}
		else{
			float rectwidth=530/11;
			float[] rectw=new float[11];
			rectw[0]=10;
			for(int i=1;i<11;i++){
				rectw[i]=rectw[i-1]+rectwidth;
			}
			for(int i=0;i<11;i++){
				fill(red[i],green[i],blue[i]);
				rect(rectw[i],10,rectwidth,20);
			}
			if(Preon!=100){
				for(int i=0;i<11;i++){
					int c=color(red[i],green[i],blue[i]);
					if(c==sites[Preon].c){
						strokeWeight(4);
						noFill();
						stroke(291,100,29);
						bezier((float)drex[i],(float)drey[i],(float)drex[i],(float)(drey[i]-(drey[i]-30)*0.75),rectw[i]+rectwidth/2,(float)(drey[i]-(drey[i]-30)*0.25),rectw[i]+rectwidth/2,30);
					}
				}
    		}
		}
	}
	public void startCluster(int cnt) {
		dpoints.clear(); // 类族每次选取之前先清空

		for (int i = 0; i < cnt; i++) // pos数组读入
		{
			double[] tmp = {location[0][i],location[1][i] };// System.out.println(tmp[0] + "  " + tmp[1]);
			dpoints.add(new DataPoint(tmp, i));
		}

		ClusterAnalysis ca = new ClusterAnalysis();
		clusters = ca.startAnalysis(dpoints); // 开始聚类
	}
	
	/*public void drawDreMds(){
		//fill(0,0,100);
		stroke(0,100,0);
		strokeWeight(0);
		fill(0,0,100);
		rect(585,5,460,320);
		if(city1!=city||flag==true||flagchose==true||angle1!=angle||typeFlag==false){
			city1=city;
			
			for(int i=0;i<24;i++){
				for(int j=0;j<24;j++){
					double num=0;
					for(int k=1;k<7;k++){
						if(opt[k-1]==1){
							num=num+Math.pow((q1[k][city][i]-q1[k][city][j]),2); 
						}
					}
					input2[i][j]=Math.sqrt(num);
				}
			}
			for(int i=0;i<24;i++){
				for(int j=0;j<24;j++){
					double temp=0;
					for(int k=1;k<6;k++){
						if(opt[k-1]==1)
							temp=temp+qt12[k][city][i][j];
					}
					input2[i][j]=temp;
				}
			}
			output2=MDSJ.classicalScaling(input2);
		}
		Drawing(output2,24);
		
		startCluster(24);
		int t=0;
		for(Cluster cl:clusters){
			 int len = 0;
			 List<DataPoint> tempDps=cl.getDataPoints();
	           for(DataPoint tempdp:tempDps){
	        	   len++;
	          
	           }
	           if(len!=0)
	           lengh[t]=len;
	           t++;
		}
		kt1=0;
		for(Cluster cl:clusters){
	           //System.out.println("------"+cl.getClusterName()+"------");
	           double px = 0, py = 0;// 类族点集重心坐标
	           int len = 0;
	           List<DataPoint> tempDps=cl.getDataPoints();
	           for(DataPoint tempdp:tempDps){
	        	   	px += tempdp.getDimensioin1(0);
					py += tempdp.getDimensioin1(1);
					len++;
	        	  timecluster[tempdp.getDataPointName()]=1;
	        	  nowclu[kt1][tempdp.getDataPointName()]=1;
	           }
	           px /= len;
	           py /= len;
	           clus2[0][kt1]=px;
	           clus2[1][kt1]=py;
	           
	           strokeWeight(1);
	           stroke(0,0,50);
	           int max=0;
	           int min=100;
	           for(int i=0;i<t;i++){
	        	   if(lengh[i]<min)
	        		   min=lengh[i];
	        	   if(lengh[i]>max)
	        		   max=lengh[i];
	           }
	           float r1;
	           if(max==min)
	        	   r1=0;
	           else
	        	   r1=(len-min)/(max-min);
	           float r2=map(r1,0,1,20,40);
	           rwidth[kt1]=r2;
	           kt1++;
	           for(int i=23;i>=0;i--){
	        		   if(i>=12){
	        			   fill(60,20,100);
	        			   arc((float)px,(float)py,2*r2+4,2*r2+4,PI*17/12+(i%12)*PI/6,PI*17/12+(i%12+1)*PI/6-PI/25,PIE);
	        		   }else{
	        				   fill(60,20,100);
	        			   arc((float)px,(float)py,4*r2/3,4*r2/3,PI*17/12+(i%12)*PI/6,PI*17/12+(i%12+1)*PI/6-PI/25,PIE);
	        		   }
	        		   if(i==12)
	        		   {
	        			   fill(0,0,100);
	        			   ellipse((float)px, (float)py, 4*r2/3+4, 4*r2/3+4);
	        		   }
	        	  }
	           
	           for(int i=23;i>=12;i--){
	        	   if(timecluster[i]==1){  
	        		   fill(300,100,33);
	        			arc((float)px,(float)py,2*r2+4,2*r2+4,PI*17/12+(i%12)*PI/6,PI*17/12+(i%12+1)*PI/6-PI/25,PIE);
	        	   }
	        	  }
	           fill(0,0,100);
			   ellipse((float)px, (float)py,(float)(4*r2/3+4),(float)(4*r2/3+4));
	           for(int i=11;i>=0;i--){
		        	   fill(240,0,100);
	    			   arc((float)px,(float)py,4*r2/3,4*r2/3,PI*17/12+(i%12)*PI/6,PI*17/12+(i%12+1)*PI/6-PI/25,PIE);
	        	   
	           }
	           for(int i=11;i>=0;i--){
	        	   if(timecluster[i]==1){  
	        		   fill(300,100,33);
	    			   arc((float)px,(float)py,4*r2/3,4*r2/3,PI*17/12+(i%12)*PI/6,PI*17/12+(i%12+1)*PI/6-PI/25,PIE);
	        	   }
	           }
	           fill(0,0,100);
	          
	           ellipse((float)px,(float)py,(float)(2*r2/3-5),(float)(2*r2/3-5));
	           timeupdate();
	       }
		
	}
	*/
	public void lenghupdate(){
		for(int i=0;i<24;i++)
			lengh[i]=0;
	}
	public void Drawing(double enter[][],int n){
		if((hour!=hour2||flag==true||flagchose==true||sum1!=sum||angle1!=angle||typeFlag==false)&&n==11)
		{
			hour2=hour;
			flag=false;
			flagchose=false;
			sum1=sum;
			angle1=angle;
			typeFlag=true;
			double min1,max1,min2,max2;
			boolean a=false;
			boolean b=false;
			/*for(int i=0;i<n;i++)
				System.out.println("0:"+enter[0][i]+" "+"1:"+enter[1][i]);*/
			max1=min1=enter[1][0];
			max2=min2=enter[0][0];
			for(int i1=0;i1<n;i1++){
				if(max1<enter[1][i1])
					max1=enter[1][i1];
				if(min1>enter[1][i1])
					min1=enter[1][i1];
			}
			for(int i1=0;i1<n;i1++){
				if(max2<enter[0][i1])
					max2=enter[0][i1];
				if(min2>enter[0][i1])
					min2=enter[0][i1];
			}
			for(int i1=0;i1<n;i1++){
				pos1[0][i1]=(enter[0][i1]-min2)/(max2-min2);
				pos1[1][i1]=(enter[1][i1]-min1)/(max1-min1);
			}
			for(int i=0;i<n;i++){
				location[0][i]=map((float)pos1[0][i],0,1,(float)(570),(float)(890));
				location[1][i]=map((float)pos1[1][i],0,1,20,(float)(315));
			}
			/*for(int i=0;i<n;i++){
				location[0][i]=map((float)pos1[0][i],0,1,PI,2*PI);
				location[1][i]=pos1[1][i];
			}*/
		}
	else if(n==24&&(city2!=city||flag==true||flagchose==true||angle1!=angle||typeFlag==false)){
			city2=city;
			flag=false;
			flagchose=false;
			angle1=angle;
			typeFlag=true;
			double min1,max1,min2,max2;
			boolean a=false;
			boolean b=false;
			for(int i=0;i<n;i++){
				a= Double.isNaN(enter[0][i]);
				b = Double.isNaN(enter[1][i]);
				if(a==true)
					enter[0][i]=0.0;
				if(b==true)
					enter[1][i]=0.0;
			}
			max1=min1=enter[1][0];
			max2=min2=enter[0][0];
			for(int i1=0;i1<n;i1++){
				if(max1<enter[1][i1])
					max1=enter[1][i1];
				if(min1>enter[1][i1])
					min1=enter[1][i1];
			}
			for(int i1=0;i1<n;i1++){
				if(max2<enter[0][i1])
					max2=enter[0][i1];
				if(min2>enter[0][i1])
					min2=enter[0][i1];
			}
			for(int i1=0;i1<n;i1++){
				pos1[0][i1]=(enter[0][i1]-min2)/(max2-min2);
				pos1[1][i1]=(enter[1][i1]-min1)/(max1-min1);
			}
			for(int i=0;i<n;i++){
				location[0][i]=map((float)pos1[0][i],0,1,705,1000);
				location[1][i]=map((float)pos1[1][i],0,1,270,10);
			}
			for(int i=0;i<n;i++){
				if(a==true)
					location[0][i]=155;
				if(b==true)
					location[1][i]=465;
			}
		}
		
	}
	public void loadWeek(int mon[],int day[]){
		
		for(int j=0;j<7;j++){
			for(int i=0;i<11;i++){
				if(mon[j+1]>12)
					mon[j+1]=1;
				//System.out.println(mon[j+1]+"  "+day[j+1]);
				week[0][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getAQI();
				week[1][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getPM25();
				week[2][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getPM25_24h();
				week[3][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getPM10();
				week[4][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getPM10_24h();
				week[5][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getSO2();
				week[6][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getSO2_24h();
				week[7][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getNO2();
				week[8][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getNO2_24h();
				week[9][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getO3();
				week[10][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getO3_24h();
				week[11][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getO3_8h();
				week[12][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getO3_8h_24h();
				week[13][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getCO();
				week[14][j][i]=air[i][mon[j+1]*10000+day[j+1]*100 + hour].getCO_24h();
			}
		}
	}
	public void loadData() {
		// TODO Auto-generated method stub
		double max[]=new double[15];
		double min[]=new double[15];
		for(int i=0;i<15;i++){
			max[i]=-1000000000;
			min[i]=1000000000;
		}
		for(int j=0;j<11;j++){
			for(int i = 0; i < 24; ++ i) {
				//q[0][j][i]= air[j][month*10000+date*100 + i].getAQI();
				q[0][j][i]= air[j][month*10000+date*100 + i].getAQI();
				q[1][j][i]= air[j][month*10000+date*100 + i].getPM25();
				q[2][j][i]= air[j][month*10000+date*100 + i].getPM25_24h();
				q[3][j][i]= air[j][month*10000+date*100 + i].getPM10();
				q[4][j][i]= air[j][month*10000+date*100 + i].getPM10_24h();
				q[5][j][i]= air[j][month*10000+date*100 + i].getSO2();
				q[6][j][i]= air[j][month*10000+date*100 + i].getSO2_24h();
				q[7][j][i]= air[j][month*10000+date*100 + i].getNO2();
				q[8][j][i]= air[j][month*10000+date*100 + i].getNO2_24h();
				q[9][j][i]= air[j][month*10000+date*100 + i].getO3();
				q[10][j][i]= air[j][month*10000+date*100 + i].getO3_24h();
				q[11][j][i]= air[j][month*10000+date*100 + i].getO3_8h();
				q[12][j][i]= air[j][month*10000+date*100 + i].getO3_8h_24h();
				q[13][j][i]= air[j][month*10000+date*100 + i].getCO();
				q[14][j][i]= air[j][month*10000+date*100 + i].getCO_24h();
			}
		}
		
		//System.out.println("千岛湖："+q[0][0][0]);
		for(int j=0;j<11;j++){
			for(int i = 0; i < 24; ++ i) {
				for(int k=0;k<15;k++){
					if(q[k][j][i]>max[k])
						max[k]=q[k][j][i];
					if(q[k][j][i]<min[k])
						min[k]=q[k][j][i];
						
				}
			}
		}
		System.out.println("千岛湖："+max[0]+"  "+min[0]);
		for(int j=0;j<11;j++){
			for(int i = 0; i < 24; ++ i) {
				for(int k=0;k<15;k++){
					q1[k][j][i]= (q[k][j][i]-0)/(max[k]-0);
				}
			}
		}
	
		for(int j=0;j<11;j++){
			for(int i = 0; i < 24; ++ i) {
				for(int k=0;k<15;k++){
					q1[k][j][i]=q1[k][j][i]*1000;
				}
			}
		}
		System.out.println("千岛湖++++++++++++++："+q1[0][0][0]+"  "+month+"  "+date);
	}
	
	public void changeValue(int h) {
		hour = h;
		//System.out.println(hour);
		redraw();
	}
	

	public void chose(int type1) {
		
		// TODO 自动生成的方法存根
		if(type!=type1)
		{
			type=type1;
			typeFlag=false;
		}
		//System.out.println(type);
	}

	public void getid(int sk2) {
		// TODO 自动生成的方法存根
		city=sk2;
	}
	public void timeupdate(){
		for(int i=0;i<24;i++)
			timecluster[i]=0;
	}
	public void Colorbar(){
		noStroke();
		noFill();
		fill(0);
		
		/*for(int i=1100;i<=1330;i++){
			for(int j=215;j<=230;j++){
				float k=map(i,1100,1330,1,0);
				stroke(120*k,100,100);
				point(i,j);
			}
		}*/
		text("Air pollution",35,590);
		for(int i=600;i<620;i++){
			for(int j=30;j<130;j++){
				float k=map(j,30,130,1,(float) 0.1);
				stroke(120,k*70,100);
				point(j,i);
			}
		}
		for(int i=600;i<620;i++){
			for(int j=130;j<230;j++){
				float k=map(j,130,230,(float) 0.1,1);
				stroke(0,k*70,100);
				point(j,i);
			}
		}
		text("Signal light",35,640);
		for(int i=650;i<670;i++){
			for(int j=30;j<130;j++){
				float k=map(j,30,130,1,(float) 0.1);
				stroke(60,k*70,100);
				point(j,i);
			}
		}
		for(int i=650;i<670;i++){
			for(int j=130;j<230;j++){
				float k=map(j,130,230,(float) 0.1,1);
				stroke(284,k*70,100);
				point(j,i);
			}
		}
		
		
		/*for(int i=80;i<100;i++){
			for(int j=600;j>500;j--){
				float k=map(j,500,600,(float) 0,1);
				stroke(60,k*100,100);
				point(i,j);
			}
		}
		for(int i=80;i<100;i++){
			for(int j=500;j>400;j--){
				float k=map(j,400,500,1,(float) 0);
				stroke(284,k*100,100);
				point(i,j);
			}
		}*/
		
		/*for(int i=600;i<=1130;i++){
			for(int j=215;j<=230;j++){
				float k=map(i,1100,1330,1,0);
				stroke(120*k,100,100);
				point(i,j);
			}
		}*/
	}
	
	public class ClusterAnalysis {

		public List<Cluster> startAnalysis(List<DataPoint> dataPoints) {
			List<Cluster> finalClusters = new ArrayList<Cluster>();

			List<Cluster> originalClusters = initialCluster(dataPoints); // 初始化类族
			finalClusters = originalClusters;
			boolean flag = true; // 聚类终止标记符
			while (flag) {
				double min = Double.MAX_VALUE;
				int mergeIndexA = 0;
				int mergeIndexB = 0;
				for (int i = 0; i < finalClusters.size(); i++) {
					for (int j = 0; j < finalClusters.size(); j++) {
						if (i != j) {

							Cluster clusterA = finalClusters.get(i);
							Cluster clusterB = finalClusters.get(j);

							List<DataPoint> dataPointsA = clusterA
									.getDataPoints();
							List<DataPoint> dataPointsB = clusterB
									.getDataPoints();

							double tmpAx = 0, tmpAy = 0; // 类A重心坐标
							double tmpBx = 0, tmpBy = 0; // 类B重心坐标
							for (int m = 0; m < dataPointsA.size(); m++) {
								DataPoint dpA = dataPointsA.get(m);
								double[] dimA = dpA.getDimensioin();
								tmpAx += dimA[0];
								tmpAy += dimA[1];
							}
							tmpAx /= dataPointsA.size();
							tmpAy /= dataPointsA.size();

							for (int m = 0; m < dataPointsB.size(); m++) {
								DataPoint dpB = dataPointsB.get(m);
								double[] dimB = dpB.getDimensioin();
								tmpBx += dimB[0];
								tmpBy += dimB[1];
							}
							tmpBx /= dataPointsB.size();
							tmpBy /= dataPointsB.size();

							double tempDis = Math.sqrt((tmpAx - tmpBx)
									* (tmpAx - tmpBx)
									+ ((tmpAy - tmpBy) * (tmpAy - tmpBy)));
							if (tempDis < min) {
								min = tempDis;
								mergeIndexA = i;
								mergeIndexB = j;
								flag = false;
							}
							if (min > ClusterDis) // 两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束
							{
								flag = false;
							} else {
								flag = true;
							}
							/*
							 * for(int m=0;m<dataPointsA.size();m++){ for(int
							 * n=0;n<dataPointsB.size();n++){ double
							 * tempDis=getDistance
							 * (dataPointsA.get(m),dataPointsB.get(n));
							 * if(tempDis<min){ min=tempDis; mergeIndexA=i;
							 * mergeIndexB=j; } } } if(min > ClusterDis)
							 * //两两类族之间最接近的点的欧几里德距离如果＜阈值，则聚类结束 {flag=false; }
							 * else {flag=true; }
							 */
						}
					} // end for j
				}// end for i
					// 合并cluster[mergeIndexA]和cluster[mergeIndexB]
				if (flag == false)
					break;
				finalClusters = mergeCluster(finalClusters, mergeIndexA,
						mergeIndexB);
				if(finalClusters.size() == 1) break;
			}// end while

			return finalClusters;
		}

		private List<Cluster> mergeCluster(List<Cluster> clusters,
				int mergeIndexA, int mergeIndexB) {
			if (mergeIndexA != mergeIndexB) {
				// 将cluster[mergeIndexB]中的DataPoint加入到 cluster[mergeIndexA]
				Cluster clusterA = clusters.get(mergeIndexA);
				Cluster clusterB = clusters.get(mergeIndexB);

				List<DataPoint> dpA = clusterA.getDataPoints();
				List<DataPoint> dpB = clusterB.getDataPoints();

				for (DataPoint dp : dpB) {
					DataPoint tempDp = new DataPoint();
					tempDp.setDataPointName(dp.getDataPointName());
					tempDp.setDimensioin(dp.getDimensioin());
					tempDp.setCluster(clusterA);
					dpA.add(tempDp);
				}

				clusterA.setDataPoints(dpA);

				// List<Cluster> clusters中移除cluster[mergeIndexB]
				clusters.remove(mergeIndexB);
			}

			return clusters;
		}

		// 初始化类簇
		private List<Cluster> initialCluster(List<DataPoint> dataPoints) {
			List<Cluster> originalClusters = new ArrayList<Cluster>();
			for (int i = 0; i < dataPoints.size(); i++) {
				DataPoint tempDataPoint = dataPoints.get(i);
				List<DataPoint> tempDataPoints = new ArrayList<DataPoint>();
				tempDataPoints.add(tempDataPoint);

				Cluster tempCluster = new Cluster();
				tempCluster.setClusterName("Cluster " + String.valueOf(i));
				tempCluster.setDataPoints(tempDataPoints);

				tempDataPoint.setCluster(tempCluster);
				originalClusters.add(tempCluster);
			}

			return originalClusters;
		}

		// 计算两个样本点之间的欧几里得距离
		/*private double getDistance(DataPoint dpA, DataPoint dpB) {
			double distance = 0;
			double[] dimA = dpA.getDimensioin();
			double[] dimB = dpB.getDimensioin();

			if (dimA.length == dimB.length) {
				for (int i = 0; i < dimA.length; i++) {
					double temp = Math.pow((dimA[i] - dimB[i]), 2);
					distance = distance + temp;
				}
				distance = Math.pow(distance, 0.5);
			}

			return distance;
		}*/
	}

	
	public void changeValuedate(int d) {
		date = d;
		//System.out.println(date);
		redraw();
	}
	public void changeValuemonth(int m) {
		month = m;
		//System.out.println(month);
		redraw();
	}
	public void changeValue1(int thresholdhour) {
		// TODO 自动生成的方法存根
		ClusterDis=thresholdhour;
	}
	public void send(int[] options) {
		sum=0;
		// TODO Auto-generated method stub
		for(int i=0;i<15;i++)
		{
			if(opt[i]!=options[i]){
				flagchose=true;
				flagchose1=true;
				flagchose2=true;
				flagchose3=true;
			}
			opt[i]=options[i];
			System.out.println(opt[i]);
			sum=sum+opt[i];
		}
	}
	public void colorbar(){
		for(int i=900;i<950;i++){
			for(int j=300;j<200;j--){
				stroke(351,map(j,200,300,(float)0.3,1)*100,74);
			}
		}
		for(int i=900;i<950;i++){
			for(int j=200;j<100;j--){
				stroke(145,map(j,100,200,1,(float)0.3)*100,56);
			}
		}
	}

	
	public void changeValuehour(int hour) {
		// TODO 自动生成的方法存根
		sliderhour=hour;
		DrawParallel.gethour(sliderhour);
	}
	public class ClustersCity{
		public List<Cluster> clusters = new ArrayList<Cluster>();// 类族链表
		
	}
	public class intList{
		public ArrayList<Integer> intlist = new ArrayList<Integer>();
		public ArrayList<Integer> getIntList(){
			return intlist;
		}
	}
	public class FloatList{
		
		public ArrayList<Float> floatlist = new ArrayList<Float>();
		public ArrayList<Float> getFloatList(){
			return floatlist;
		}
	}
	class MyComparator implements Comparator<Integer>{
		     @Override
		     public int compare(Integer o1, Integer o2) {
		         //如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
		         //这样颠倒一下，就可以实现反向排序了
		         if(o1 < o2) { 
		             return 1;
		         }else if(o1 > o2) {
		             return -1;
		         }else {
		             return 0;
		         }
		     }
		     
		 }
	class area{
		public float startangle;
		public float endangle;
		public float startWidth;
		public float endWidth;
	}
	public void getRadioType(int radio){
		radiotype=radio;
	}
	public void getMDS(int m){
		MDS=m;
	}
}
