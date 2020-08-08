<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 1558.剑指 Offer 06. 从尾到头打印链表

[刷题](qu1558/solu/Solution.java)

### 问题描述

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

```
输入：head = [1,3,2]
输出：[2,3,1]
```

限制：

* \\(0 \le 链表长度 \le 10000\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int[] reversePrint(ListNode head) {

    }
}
```

### 解决方案

递归、辅助栈、反转、直接计数

#### 1. 辅助栈

[辅助栈](qu1558/solu1/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(N)\\)

#### 2. 直接计数

[直接计数](qu1558/solu2/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(1)\\)