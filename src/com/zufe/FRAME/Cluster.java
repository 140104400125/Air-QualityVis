package com.zufe.FRAME;
import java.util.ArrayList;
import java.util.List;


public class Cluster implements Cloneable,Comparable{
    private List<DataPoint> dataPoints = new ArrayList<DataPoint>(); // 类簇中的样本点
    private String clusterName;
    public float startAngle,angleWidth,startHeight,angleHeight;
    public Object clone(){
    	Cluster c=null;
    	try{
    		c=(Cluster)super.clone();
    	}catch(CloneNotSupportedException e){
    		e.printStackTrace();
    	}
		return c;
    	
    }
    
    @Override
    public int compareTo(Object o)
    {

    	Cluster sdto = (Cluster)o;

           float startHeight1 = sdto.startHeight;
          // note: enum-type's comparation depend on types' list order of enum method
          // so, if compared property is enum-type ,then its comparationfollow ObjEnum.objType order

           Float startHeight2=startHeight1;
           Float startHeight=this.startHeight;
          return startHeight.compareTo(startHeight2);
    }
    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

}