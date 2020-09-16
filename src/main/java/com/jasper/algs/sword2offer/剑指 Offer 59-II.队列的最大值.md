<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## 剑指 Offer 59 - II. 队列的最大值

[刷题](qu059ii/solu/Solution.java)

### 问题描述

请定义一个队列并实现函数 `max_value` 得到队列里的最大值，要求函数 `max_value`、`push_back` 和 `pop_front` 的**均摊时间复杂度**都是\\(\mathrm{O}(1)\\)。

若队列为空，`pop_front` 和 `max_value` 需要返回 `-1`

示例 1：

```
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
```

示例 2：

```
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
```
 

限制：

* \\(1 <= push_back,pop_front,max_value的总操作数 <= 10000\\)
* \\(1 <= value <= 10^5\\)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 模板代码

``` java
class MaxQueue {

    public MaxQueue() {

    }
    
    public int max_value() {

    }
    
    public void push_back(int value) {

    }
    
    public int pop_front() {

    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```

### 解决方案


#### 单调非递增双向队列

[单调非递增双向队列](qu059ii/solu1/Solution.java)