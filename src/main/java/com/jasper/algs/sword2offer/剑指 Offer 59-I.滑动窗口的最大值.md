<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 59 - I. 滑动窗口的最大值

与 [0239.维护滑动窗口最大值](../leetcode/twopointers/0239.维护滑动窗口最大值.md) 完全相同

本题允许 **空数组** 和 `k=0`。

### 问题描述

给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。

示例:

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```
 

提示：

* 你可以假设 `k` 总是有效的，在输入数组不为空的情况下，\\(1 \le k \le\\) 输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
### 模板代码

``` java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    }
}
```
