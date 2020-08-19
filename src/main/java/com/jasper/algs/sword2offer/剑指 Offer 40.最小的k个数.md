<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 40. 最小的k个数

[刷题](qu040/solu/Solution.java)

### 问题描述

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：

```
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
```

示例 2：

```
输入：arr = [0,1,2,1], k = 1
输出：[0]
```

限制：

* \\(0 \leq k \leq arr.length \leq 10000\\)
* \\(0 \leq arr[i] \leq 10000\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

    }
}
```

### 解决方案

#### 1. 最大堆

##### 现成API

[使用PriorityQueue](qu040/solu1/Solution.java)

##### 手写

#### 2. 快排

[ 快排](qu040/solu3/Solution.java)