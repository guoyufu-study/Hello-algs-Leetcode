package com.jasper.algs.leetcode.greedy.qu0860.solu1;

/**
 * 0860. 柠檬水找零
 * 
 * <p> 贪心算法
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {

    	int a=0,b=0;
    	for (int bill : bills) {
			switch (bill) {
			case 5:
				a++;
				break;
			case 10:
				// 无法找零
				if(a<=0) {
					return false;
				} 
				// 10美元账单找零
				a--;
				b++;
				break;

			default:
				// 20美元账单找零
				if(b>0 && a>0) {
					b--;
					a--;
				} else if(a>=3) {// b=0,a>=3
					a-=3;
				} 
				// 无法找零
				else {// b=0,a<3 或者 b>0,a=0
					return false;
				}
				break;
			}
		}
    	
    	// 所有账单找零成功
    	return true;
    }
    
    public static void main(String[] args) {
    	// true
//		int[] bills = new int[] {5,5,5,10,20};
		
		// true
//		int[] bills = new int[] {5,5,10};
		
		// false
//		int[] bills = new int[] {10,10};
		
		// false
		int[] bills = new int[] {5,5,10,10,20};
		
		
		System.out.println(new Solution().lemonadeChange(bills));
	}
}