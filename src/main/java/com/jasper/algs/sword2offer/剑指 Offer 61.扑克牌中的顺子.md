<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 61. 扑克牌中的顺子

[刷题](qu061/solu/Solution.java)

### 问题描述

从扑克牌中随机抽 `5` 张牌，判断是不是一个顺子，即这5张牌是不是连续的。`2～10` 为数字本身，`A` 为 `1`，`J` 为 `11`，`Q` 为 `12`，`K` 为 `13`，而大、小王为  `0` ，可以看成任意数字。`A` 不能视为 `14`。

限制：

* 数组长度为 `5` 

* 数组的数取值为 `[0, 13]` .

### 模板代码

``` java
class Solution {
    public boolean isStraight(int[] nums) {

    }
}
```

### 解决方案

注意：大小王 `jacker` 数量可以超过 `2`。

* 除大小王之外，牌面不可重复。

* 除大小王外，`max - min < 5`。

#### 1. 辅助字典

[辅助字典](qu061/solu1/Solution.java)

时间复杂度：\\(\mathcal{O}(1)\\)

空间复杂度：\\(\mathcal{O}(1)\\)

#### 2. 排序

[排序](qu061/solu2/Solution.java)

时间复杂度：\\(\mathcal{O}(1)\\)

空间复杂度：\\(\mathcal{O}(1)\\)
