<script src="https://cdn.bootcss.com/mathjax/2.7.7/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>


## Mathjax基本教程和参考

[Mathjax基本教程和参考](https://www.dazhuanlan.com/2020/01/06/5e129614e5742/)


[Mathjax语法总结](https://blog.csdn.net/ajacker/article/details/80301378)

[Mathjax与LaTex公式简介](https://www.cnblogs.com/linxd/p/4955530.html)

## 等式换行对齐

$$\begin{aligned}
\sqrt{37} & = \sqrt{ \frac{73^2-1}{12^2}} \\\\
& = \sqrt{ \frac{73^2}{12^2} \cdot \frac{73^2-1}{73^2}} \\\\
& = \sqrt{ \frac{73^2}{12^2}}\sqrt{ \frac{73^2-1}{73^2}} \\\\
& = \frac{73}{12} \sqrt{1 - \frac{1}{73^2}} \\\\
& \approx \frac{73}{12} \left(1 - \frac{1}{2 \cdot73^2} \right)
\end{aligned}$$


## 分支等式

$$
f(n) =
\begin{cases}
n/2,  & \text{if $n$ is even} \\\\
3n+1, & \text{if $n$ is odd}
\end{cases}
$$

## 取整

向下取整 \\(\lfloor x \rfloor\\)

向上取整 \\(\lceil x \rceil\\)


## 分式

有三种实现方式。

使用frac分割两个数，例如`\\(\frac ab\\)`，显示为 \\(\frac ab\\) ；

更复杂的分子和分母，使用`{...}`，例如` \\(\frac{a+1}{b+1}\\) `，显示为 \\(\frac{a+1}{b+1}\\) ；

使用over分割组内分数，例如`\\({a+1 \over b+1}\\)` ，显示为 \\({a+1 \over b+1}\\) ；

使用cfrac命令对于连续的分数，例如`\\(\cfrac{a}{b+1}\\)` ，显示为 \\(\cfrac{a}{b+1}\\) 。

## 逻辑运算符



| 含义 |   表达式   |     显示结果     |
| :--: | :--------: | :--------------: |
| 因为 |  \because  |  \\(\because\\)  |
| 所以 | \therefore | \\(\therefore\\) |
|  与  |   \land    |   \\(\land\\)    |
|  或  |    \lor    |    \\(\lor\\)    |
|  非  |   \lnot    |   \\(\lnot\\)    |



$$\forall \exists \top \bot \vdash \vDash$$