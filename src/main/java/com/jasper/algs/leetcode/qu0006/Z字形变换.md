# Z字形变换

## 问题描述

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

```
L   C   I   R
E T O E S I I G
E   D   H   N
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

示例 1:

```
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
```

示例 2:

```
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解决方案

### 先存再读
List存储，再读取追加

``` java
public String convert(String s, int numRows) {
	if(numRows==1) return s;
	
	int len = s.length();
	int cycleLen = 2*numRows-2;
	
	StringBuilder ans = new StringBuilder();
	int index=0;
	for (int k = 0; k < numRows; k++) {
		for (int j = 0; j+k < len; j+=cycleLen) {
			index = j+k;
			ans.append(s.charAt(index));
			index = j+cycleLen-k;
			if(k!=0 && k!=numRows-1 && index<len)
					ans.append(s.charAt(index));
		}
	}
	
	return ans.toString();
}
```


### 直接读

直接计算索引读取追加
