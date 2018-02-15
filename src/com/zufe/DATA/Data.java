package com.zufe.DATA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.zufe.POSITION.PositionName;

public class Data {
	public static AirInfor[][] air = new AirInfor[11][123124];
	PositionName pName = new PositionName();
	@SuppressWarnings("unused")
	private String fileName;
	public static boolean isLoadData = false;

	public void getFileName(String name) {
		fileName = name;
	}

	public void LoadData() {
		try {
			for(int i=0;i<11;i++){
				for(int j=0;j<123124;j++){
					AirInfor tempAir = new AirInfor();
					air[i][j]=tempAir;
				}
			}
			FileReader fr = new FileReader("src\\Air20140601-20150531.csv");
			BufferedReader reader = new BufferedReader(fr);

			String line;
			while ((line = reader.readLine()) != null) {
				String[] str = line.split(",");
				// get the index of province
				//int index = Integer.parseInt(str[0]) % 150000 * 100;
				int index = 0;
				if(Integer.parseInt(str[0])<150000){
					index = Integer.parseInt(str[0]) % 140000 * 100;
				}
				else if(Integer.parseInt(str[0])>150000){
					index = Integer.parseInt(str[0]) % 150000 * 100;
				}
				for(int i = 0; i < 24; ++ i) {
					for(int j = 2; j <= 16; ++ j) {
						if(str[j + 15 * i].length() == 0) str[j + 15 * i] = "0";
					}
				}
				for (int i = 0; i < 24; i++) {
					AirInfor tempAir = new AirInfor();
					PositionName p = new PositionName();
					String subString = str[1].substring(0, str[1].length() - 1);
					int id = Integer.parseInt(subString) - 1223;
					tempAir.AQI = Double.parseDouble(str[2 + i * 15]);
					tempAir.PM25 = Double.parseDouble(str[3 + i * 15]);
					tempAir.PM25_24h = Double.parseDouble(str[4 + i * 15]);
					tempAir.PM10 = Double.parseDouble(str[5 + i * 15]);
					tempAir.PM10_24h = Double.parseDouble(str[6 + i * 15]);
					tempAir.SO2 = Double.parseDouble(str[7 + i * 15]);
					tempAir.SO2_24h = Double.parseDouble(str[8 + i * 15]);
					tempAir.NO2 = Double.parseDouble(str[9 + i * 15]);
					tempAir.NO2_24h = Double.parseDouble(str[10 + i * 15]);
					tempAir.O3 = Double.parseDouble(str[11 + i * 15]);
					tempAir.O3_24h = Double.parseDouble(str[12 + i * 15]);
					tempAir.O3_8h = Double.parseDouble(str[13 + i * 15]);
					tempAir.O3_8h_24h = Double.parseDouble(str[14 + i * 15]);
					tempAir.CO = Double.parseDouble(str[15 + i * 15]);
					tempAir.CO_24h = Double.parseDouble(str[16 + i * 15]);
					air[id][index + i] = tempAir;
				}

			}
			isLoadData = true;
		} catch (Exception e) {
			isLoadData = false;
			e.printStackTrace();
		}

	}

	public static int getAirNum() {
		return air.length;
	}

}
