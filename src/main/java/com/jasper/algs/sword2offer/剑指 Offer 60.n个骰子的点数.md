<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 60. n个骰子的点数

[刷题](qu060/solu/Solution.java)

### 问题描述

把 `n` 个骰子扔在地上，所有骰子朝上一面的点数之和为 `s`。输入 `n`，打印出 `s` 的所有可能的值出现的概率。

你需要用一个浮点数数组返回答案，其中第 `i` 个元素代表这 `n` 个骰子所能掷出的点数集合中第 `i` 小的那个的概率。

限制：

* \\(1 \le n \le 11\\)

### 模板代码

``` java
class Solution {
    public double[] twoSum(int n) {

    }
}
```

### 解决方案

#### 2. 动态规划（推荐）

\\(dp(i,j)\\) ，表示投掷完 `i` 枚骰子后，点数 `j` 的出现次数。 \\(dp(n,j)\\) 表示最后一个阶段点数 `j` 出现的次数。

$$
dp(n,j) = \sum_{i=1}^6 dp(n-1,j-i);
$$

`n` 表示阶段，`j` 表示投掷完 `n` 枚骰子后的点数和，`i` 表示第 `n` 枚骰子会出现的六个点数。

[动态规划](qu060/solu2/Solution.java)

时间复杂度：\\(\mathcal{O}(n^2)\\)，空间复杂度：\\(\mathcal{O}(n^2)\\)。

[动态规划：空间压缩](qu060/solu3/Solution.java)

时间复杂度：\\(\mathcal{O}(n^2)\\)，空间复杂度：\\(\mathcal{O}(n)\\)。
