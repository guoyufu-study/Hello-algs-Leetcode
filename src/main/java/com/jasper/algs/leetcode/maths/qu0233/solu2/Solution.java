package com.jasper.algs.leetcode.maths.qu0233.solu2;

/**
 * 暴力求解：双层遍历
 */
public class Solution {

	public int countDigitOne(int n) {
		if(n<=0) return 0;
		
		int ans=0;
		int tmp=n, count=0, bit = 1;
		while(tmp!=0) {
			int yy = count*(bit/10)*(tmp%10);//222 =>0 ~ 200 中不计算当前位时，1的数量
			int xx = tmp%10==0?0:tmp%10==1?(n%bit)+1:bit;//当前位为1
			ans+=xx+yy;
			
			count++;
			bit = bit*10;
			tmp/=10;
			
		}
		return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
	// 2        1
	// 22 1*2+1+10=13
	//222 20*2+13+100=153        
	//2222 300*2 +153+1000 = 1753
	
	//     0位     10位取模                  10位>=2额外
	// 99=> 1 * (9+1)        +    10         =>20
	
	//999=> 20 * (9+1)       +     100       =>300
}
