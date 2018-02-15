
package com.zufe.POSITION;

/**
 * 一个辅助类，进行省份的各个内容的相互转换
 * 
 * @author
 * 
 */
public class PositionName {
	public static PositionInfo[] positionName = new PositionInfo[32];

	public PositionName() {
		positionName[0] = new PositionInfo("BinJiang", 30.206803, 120.216885);
		positionName[1] = new PositionInfo("WoLongQiao", 30.25835, 120.123174);
		positionName[2] = new PositionInfo("ZhaoHuiWuQu", 30.298146, 120.176066);
		positionName[3] = new PositionInfo("HeMuXiaoXue", 30.319722, 120.130648);
		positionName[4] = new PositionInfo("XiaSha", 30.323089, 120.369237);
		positionName[5] = new PositionInfo("ZheJiangNongDa", 30.274196, 120.202512);
		positionName[6] = new PositionInfo("LinPingZhen", 30.383422,120.300248);
		positionName[7] = new PositionInfo("ChengXiangZhen", 30.201809, 120.268052);
		positionName[8] = new PositionInfo("XiXi", 30.277813, 120.082355);	
		positionName[9] = new PositionInfo("YunQi", 30.186326,120.090403);
		positionName[10] = new PositionInfo("QianDaoHu", 29.9953371, 119.8212521);
	}

	public String GetpositionName(int index) {
		int len = positionName.length;
		if (index < 0 || index >= len)
			return null;
		return positionName[index].getName();
	}

	public int GetpositionCount() {
		return positionName.length;
	}
}
