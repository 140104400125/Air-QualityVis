package com.zufe.FRAME;

public class DataPoint {
    int dataPointName; // ��������
    Cluster cluster; // �������������
    private double dimensioin[]; // �������ά��
    double dis;
    public DataPoint(int dataPointName){
    	this.dataPointName=dataPointName;
    }

    public DataPoint(double[] dimensioin,int dataPointName){
         this.dataPointName=dataPointName;
         this.dimensioin=dimensioin;
    }
    public DataPoint() {
		// TODO �Զ����ɵĹ��캯�����
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
