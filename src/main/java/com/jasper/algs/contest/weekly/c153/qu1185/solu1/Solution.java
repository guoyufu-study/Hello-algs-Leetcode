package com.jasper.algs.contest.weekly.c153.qu1185.solu1;

/**
 * 1185. 一周中的第几天
 * 
 * <p>
 * 基姆拉尔森算法
 */
class Solution {
	
	private static final String[] DAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday" };
	
	public String dayOfTheWeek(int day, int month, int year) {
		
		return DAYS[getDayIndex(day, month, year)];
	}

	public int getDayIndex(int day, int month, int year) {
		if (month < 3) {
			month += 12;
			year--;
		}
		return (day +
				2*month+3*(month+1)/5 + 
				year+year/4-year/100+year/400)
				%7;
	}
}