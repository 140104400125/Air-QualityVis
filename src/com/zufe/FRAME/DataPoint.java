package com.zufe.FRAME;

public class DataPoint {
    int dataPointName; // 样本点名
    Cluster cluster; // 样本点所属类簇
    private double dimensioin[]; // 样本点的维度
    double dis;
    public DataPoint(int dataPointName){
    	this.dataPointName=dataPointName;
    }

    public DataPoint(double[] dimensioin,int dataPointName){
         this.dataPointName=dataPointName;
         this.dimensioin=dimensioin;
    }
    public DataPoint() {
		// TODO 自动生成的构造函数存根
	}

	public double getDis(){
    	return dis;
    }
    public double[] getDimensioin() {
        return dimensioin;
    }

    public double getDimensioin1(int i) {
        return dimensioin[i];
    }

    public void setDimensioin(double[] dimensioin) {
        this.dimensioin = dimensioin;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public int getDataPointName() {
        return dataPointName;
    }

    public void setDataPointName(int dataPointName) {
        this.dataPointName = dataPointName;
    }
}
