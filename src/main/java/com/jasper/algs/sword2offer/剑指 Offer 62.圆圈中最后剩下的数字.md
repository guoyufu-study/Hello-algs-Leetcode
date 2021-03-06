<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 62. 圆圈中最后剩下的数字

[刷题](qu062/solu/Solution.java)

### 问题描述

\\(0,1, \cdots ,n-1\\) 这 \\(n\\) 个数字排成一个圆圈，从数字 \\(0\\) 开始，每次从这个圆圈里删除第 \\(m\\) 个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字`0`开始每次删除第`3`个数字，则删除的前`4`个数字依次是2、0、4、1，因此最后剩下的数字是3。

示例 1：

```
输入: n = 5, m = 3
输出: 3
```

示例 2：

```
输入: n = 10, m = 17
输出: 2
```

 

限制：

* \\(1 \le n \le 10^5\\)
* \\(1 \le m \le 10^6\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


### 模板代码

``` java
class Solution {
    public int lastRemaining(int n, int m) {

    }
}
```

### 解决方案


约瑟夫环问题


#### 1. 暴力模拟（超时）

[暴力模拟](qu062/solu1/Solution.java)

#### 2. 动态规划（数学公式）

\\(dp(n, m)\\) 表示 \\([0, n-1]\\) 共 \\(n\\) 个数字排成一圈， 每次删除第 \\(m\\) 个数字，最后剩下的数字。

$$
dp(n, m) = 
\begin{cases}
0, & n=1 \\\\
\big( m + dp(n-1, m) \big) \pmod n, & n \ge 2
\end{cases}
$$

##### 递归方案

[递归方案](qu062/solu2/Solution.java)


##### 迭代方案

[迭代方案](qu062/solu3/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(1)\\)
