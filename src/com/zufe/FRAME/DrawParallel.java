package com.zufe.FRAME;

import geomerative.RG;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class DrawParallel extends PApplet{
	static int mj,mk,now,hour,n,width,mouseon,hour1;
	static int nowclu[][]=new int[24][24];
	static float x[]=new float[7];
	static double p[][]=new double[7][24];
	static double q5[][][][]=new double[7][11][11][24];
	static double q34[][][][]=new double[7][11][11][24];
	static float zx[][]=new float [6][24];
	static float zy[]=new float [24];
	static int hour2=-1;
	public DrawParallel(int n,int mj,int mk,int now,int hour,int width,int nowclu[][],float x[],double p[][],double q5[][][][],double q34[][][][],
			float zx[][],float zy[],int mouseon,int hour1){
		this.n=n;
		this.mj=mj;
		this.mk=mk;
		this.now=now;
		this.hour=hour;
		this.width=width;
		this.nowclu=nowclu;
		this.x=x;
		this.p=p;
		this.q5=q5;
		this.q34=q34;
		this.zx=zx;
		this.zy=zy;
		this.mouseon=mouseon;
		this.hour1=hour1;
	}
	/*public void setup(){
		RG.init(this);
		size(1100, 950);
	}*/
	public void draw(FrameMap frameMap){
		if(n==11){
			frameMap.fill(0);
			frameMap.textAlign(CENTER,TOP);
			for(int j=0;j<n;j++){
				for(int i=1;i<6;i++){
					if(j==mj){
						frameMap.strokeWeight(2);
						frameMap.stroke(30,100,50);
					}else if(j==mk){
						frameMap.strokeWeight(2);
						frameMap.stroke(210,64,64);
					}else if(now!=-1&&nowclu[now][j]==1){
						frameMap.strokeWeight(2);
						frameMap.stroke(300,100,33);
					}else if(mouseon==j){
						frameMap.strokeWeight(2);
						frameMap.stroke(300,100,33);
					}
					else{
						frameMap.strokeWeight(1);
						frameMap.stroke(0,0,70);
					}
					frameMap.line(x[i],(float)p[i][j],x[i+1],(float)p[i+1][j]);
				}
			}
			
			frameMap.colorMode(HSB,360,100,100,100);
			for(int i=1;i<6;i++){
				for(int k=0;k<n;k++){
					for(int j=0;j<k;j++){
						//frameMap.fill(240*map((float) q34[i][j][k][hour],0,1,1,0),100,100);
						if(q5[i][j][k][hour]==1)
							frameMap.fill(240,(float) (100*q34[i][j][k][hour]),100);
						else
							frameMap.fill(0,(float) (100*q34[i][j][k][hour]),100);
						frameMap.stroke(0,0,0);
						frameMap.strokeWeight((float) 0.5);
						frameMap.rect(zx[i][j],zy[k],17,17);
						System.out.println(width);
					}
				}
			}
			
			
			/*for(int i=1;i<6;i++){
				for(int k=0;k<n;k++){
					for(int j=0;j<=k;j++){
						if(j==k)
							continue;
						frameMap.stroke(60,100,100);
						frameMap.strokeWeight(1);
						if(q5[i][j][k][hour]==1){
							frameMap.line(zx[i][j],zy[k]+width,zx[i][j]+width,zy[k]);
						}
						else if(q5[i][j][k][hour]==-1){
							frameMap.line(zx[i][j],zy[k],zx[i][j]+width,zy[k]+width);
						}
					}
				}
			}*/
		}
		else{
			frameMap.fill(0);
			for(int j=0;j<24;j++){
				for(int i=1;i<6;i++){
					frameMap.strokeWeight(1);
					/*if(j==hour){
						frameMap.stroke(240,100,100);
						frameMap.strokeWeight(4);
					}
					else{
						frameMap.stroke(0,0,50);
					}*/
					if(j==mj){
						frameMap.strokeWeight(2);
						frameMap.stroke(30,100,50);
					}else if(j==mk){
						frameMap.strokeWeight(2);
						frameMap.stroke(210,64,64);
					}else if(now!=-1&&nowclu[now][j]==1){
						frameMap.strokeWeight(2);
						frameMap.stroke(300,100,33);
					}else if(j==hour2){
						
						frameMap.stroke(300,100,33);
						frameMap.strokeWeight(2);
						
					}
					else{
						frameMap.strokeWeight(1);
						frameMap.stroke(0,0,70);
					}
					System.out.println("");
					frameMap.line(x[i],(float)p[i][j],x[i+1],(float)p[i+1][j]);
				}
			}
			frameMap.strokeWeight(1);
			for(int k=1;k<6;k++){
				for(int i=0;i<24;i++){
					for(int j=0;j<i;j++){
						frameMap.stroke(0,0,0); 
						frameMap.strokeWeight((float) 0.5);	
						//frameMap.fill(240*map((float) q34[k][hour][j][i],0,1,1,0),100,100);
						if(q5[k][hour][j][i]==1)
							frameMap.fill(240,(float) (100*q34[k][hour][j][i]),100);
						else
							frameMap.fill(0,(float) (100*q34[k][hour][j][i]),100);
						frameMap.rect(zx[k][j],zy[i],8,8);
					}
				}
			}
			
			
			/*for(int k=1;k<6;k++){
				for(int i=0;i<24;i++){
					for(int j=0;j<=i;j++){
						if(j==i)
							continue;
						frameMap.stroke(60,100,100);
						frameMap.strokeWeight(1);
						if(q5[k][hour][j][i]==1){
							frameMap.line(zx[k][j],zy[i]+width,zx[k][j]+width,zy[i]);
						}
						else if(q5[k][hour][j][i]==-1){
							frameMap.line(zx[k][j],zy[i],zx[k][j]+width,zy[i]+width);
						}
					}
				}
			}*/
		}
	}
	public static void gethour(int hour){
		hour2=hour;
	}
}
