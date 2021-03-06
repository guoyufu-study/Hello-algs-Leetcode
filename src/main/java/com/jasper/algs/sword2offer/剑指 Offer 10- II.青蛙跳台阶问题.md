<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 10- II.青蛙跳台阶问题

与 [0070.爬楼梯](../leetcode/dynamicprogramming/0070.爬楼梯.md) 完全相同

### 问题描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

```
输入：n = 2
输出：2
```

示例 2：

```
输入：n = 7
输出：21
```

提示：

* \\(0 \le n \le 100\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int numWays(int n) {

    }
}
```


### 解决方案

使用**动态规划**，转换成求**斐波那契数**问题

使用**循环求余法**，防止数据溢出问题

[代码实现](qu010ii/Solution.java)

## 相似题目

[剑指 Offer 10-I. 求斐波那契数列的第n项](剑指 Offer 10-I.求斐波那契数列的第n项.md)