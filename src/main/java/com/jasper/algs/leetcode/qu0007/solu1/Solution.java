package com.jasper.algs.leetcode.qu0007.solu1;

public class Solution {

	public int reverse(int x) {
        int ans = 0;// answer 答案
        while (x != 0) {
            int pop = x % 10;//弹出
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) //溢出检查
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;
            ans = ans * 10 + pop;//推入
            x /= 10;//迭代更新
        }
        return ans;
    }

}
