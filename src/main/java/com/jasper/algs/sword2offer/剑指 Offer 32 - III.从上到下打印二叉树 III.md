<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 32 - III. 从上到下打印二叉树 III

[刷题](qu032iii/solu/Solution.java)

### 问题描述

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

提示：

* 节点总数 \\(\le 1000\\)

### 模板代码

``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

    }
}
```

### 解决方案

#### 1. 层序遍历 + 双端队列

[层序遍历 + 双端队列](qu032iii/solu1/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(N)\\)

#### 2. 层序遍历 + 双端队列（奇偶层逻辑分离）

[层序遍历 + 双端队列（奇偶层逻辑分离）](qu032iii/solu2/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(N)\\)

#### 3. 层序遍历 + 倒序

[层序遍历 + 倒序](qu032iii/solu3/Solution.java)

时间复杂度：\\(\mathcal{O}(N)\\)

空间复杂度：\\(\mathcal{O}(N)\\)
