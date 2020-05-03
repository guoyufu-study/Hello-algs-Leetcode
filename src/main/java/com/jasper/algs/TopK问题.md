<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

## TopK问题

### 常规算法

#### 排序

时间复杂度：\\(\mathrm{O}(NlogN)\\)

#### 最小堆/最大堆

使用现成API：`PriorityQueue`

时间复杂度：\\(\mathrm{O}(NlogK)\\)

#### 快排

通过快排切分排好第 K 小的数，，那么它左边的数就是比它小的另外 K-1 个数。

时间复杂度：\\(\mathrm{O}(N)\\)

### 特殊输入

#### 数据范围有限

数据范围有限，可以使用计数排序。