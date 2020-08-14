<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 53 - II. 0～n-1中缺失的数字

[刷题](qu053ii/solu/Solution.java)

### 问题描述

一个长度为 `n-1` 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 `0～n-1` 之内。在范围 `0～n-1` 内的 `n` 个数字中有且只有一个数字不在该数组中，请找出这个数字。


示例 1:

```
输入: [0,1,3]
输出: 2
```

示例 2:

```
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```
 

限制：

* \\(1 \le 数组长度 \le 10000\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int missingNumber(int[] nums) {

    }
}
```

### 解决方案

查找第一个与数字不相等的索引。

#### 1. 线性查找

时间复杂度： \\(\mathrm{O}(N)\\)

#### 2. 二分查找

时间复杂度： \\(\mathrm{O}(logN)\\)

[二分查找](qu053ii/solu2/Solution.java)
