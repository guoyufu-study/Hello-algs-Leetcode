<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 03. 数组中重复的数字

[刷题](qu003/solu/Solution.java)

### 问题描述

找出数组中重复的数字。

在一个长度为 `n` 的数组 `nums` 里的所有数字都在 `0～n-1` 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

限制：

* \\(2 \le n \le 100000\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int findRepeatNumber(int[] nums) {
        
    }
}
```

### 解决方案

#### 1. 暴力枚举


时间复杂度：\\(\mathcal{O}(N^2)\\)

空间复杂度：\\(\mathcal{O}(1)\\)

#### 2. 排序比较相邻

时间复杂度：\\(\mathcal{O}(N \cdot \log N)\\)

空间复杂度：\\(\mathcal{O}(1)\\)

#### 3. 辅助字典

[辅助字典](qu003/solu3/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(N)\\)

#### 4. 原地标识（推荐）

[原地标识](qu003/solu4/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(1)\\)

#### 5. 原地置换（推荐）

[原地置换](qu003/solu5/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(1)\\)
