<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 14- I. 剪绳子

[刷题](qu014i/solu/Solution.java)

与 [0343.整数拆分](../leetcode/greedy/0343.整数拆分.md) 完全相同

### 问题描述

给你一根长度为 `n` 的绳子，请把绳子剪成整数长度的 `m` 段（`m`、`n`都是整数，\\(n>1\\)并且\\(m \gt 1\\)），每段绳子的长度记为 \\(k[0], k[1], \ldots, k[m-1]\\) 。请问 \\(k[0] \times k[1] \times \ldots \times k[m-1]\\) 可能的最大乘积是多少？

例如，当绳子的长度是`8`时，我们把它剪成长度分别为`2`、`3`、`3`的三段，此时得到的最大乘积是`18`。

提示：

* \\(2 \le n \le 58\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int integerBreak(int n) {

    }
}
```

### 解决方案

#### 1. 动态规划

[动态规划](qu014i/solu1/Solution.java)

时间复杂度：\\(\mathcal{O}(N^2)\\)

空间复杂度：\\(\mathcal{O}(N)\\)

#### 2. 贪心算法

切分规则：

* 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 `0,1,2` 三种情况。
* 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 `1+1` 。
* 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 `3 + 1` 替换为 `2 + 2`，因为 \\(2 \times 2 > 3 \times 1\\)。

[贪心算法](qu014i/solu2/Solution.java)

时间复杂度：\\(\mathcal{O}(1)\\)

空间复杂度：\\(\mathcal{O}(1)\\)
