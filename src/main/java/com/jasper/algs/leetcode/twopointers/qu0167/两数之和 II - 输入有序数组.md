# 两数之和 II - 输入有序数组

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

```
    返回的下标值（index1 和 index2）不是从零开始的。
    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
```

示例:

```
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解决方案
### 1. 暴力求解：双层循环

时间复杂度O(n^2)，空间复杂度O(1)

### 2. 双指针

时间复杂度O(nlog(n))，空间复杂度O(1)

``` java
public int[] twoSum(int[] nums, int target) {
	// 每个输入只对应唯一的答案 => 不会有重复元素 => 不用考虑去重问题
	int L=0, R=nums.length-1;
	while(L<R) {
		int sum = nums[L]+nums[R];//求和，不考虑溢出问题
		if(sum==target) return new int[] {L+1,R+1};
		else if(sum<target) L++;//小了
		else R--;//大了
	}
	throw new IllegalArgumentException("No two sum solution");
}
```

#### 3. 两遍哈希表：先存再找

时间复杂度O(n)，空间复杂度O(n)

#### 4. 一遍哈希表：找不到就存

时间复杂度O(n)，空间复杂度O(n)

