package com.test;

import java.util.Scanner;

public class dayTest 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
		String dateStr = scanner.nextLine();
		int num = getDayNum(dateStr);
		System.out.println("您输入的日期为当年的第" + num + "天");
    }
    
    public static int getDayNum(String dateStr){
    	int num = 0;
    	try {
			String[] str = dateStr.split("-");
			int year = Integer.parseInt(str[0]);
			int month = Integer.parseInt(str[1]);
			int day = Integer.parseInt(str[2]); 
			for(int i = 1; i < month; i++){
				if((i==1) || (i==3) || (i==5) || (i==7) || (i==8) || (i==12)){
					num += 31;
				} else if((i==4) || (i==6) || (i==9) || (i==11)){
					num += 30;
				} else if(i == 2){
					if(leapYear(year)){
						num += 29;
					}else{
						num += 28;
					}
				}
			}
			num += day;
		} catch (NumberFormatException e) {
			System.out.println("请输入正确的日期格式！");
//			e.printStackTrace();
		}
    	return num;
    }
    
    public static boolean leapYear(int year){
    	if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
}
