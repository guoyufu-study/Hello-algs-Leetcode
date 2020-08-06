package com.jasper.algs.leetcode.maths.qu0007.solu2;

/*
 * 0007. 反转十进制整数
 *
 * <p简化溢出检查
 * <p>
 * ans == Integer.MAX_VALUE / 10时，pop > 7不可能出现。
 * <p>
 * ans == Integer.MIN_VALUE / 10时，pop < -8不可能出现。
 */
public class Solution {

	public int reverse(int x) {
        int ans = 0;// answer 答案
        while (x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) //溢出检查
                return 0;
            ans = ans * 10 + x % 10;//弹出、推入
            x /= 10;//迭代更新
        }
        return ans;
    }
}
