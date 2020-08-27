package com.jasper.algs.contest.weekly.c203.qu1562.solu2;

/**
 * 1562. 查找大小为 M 的最新分组
 * 
 * <p> 反操作查找
 */
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        int[][] segments = new int[1][2];
        segments[0][0] = 1;
        segments[0][1] = n;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < segments.length; ++j) {
                int[] s = segments[j];
                if (arr[i] == s[0]) { // 更新左边界
                    s[0] = arr[i] + 1;
                    if (s[1] - s[0] + 1 == m) {// 找到长度m的1子串
                        return i;
                    }
                } else if (arr[i] == s[1]) {// 更新右边界
                    s[1] = arr[i] - 1;
                    if (s[1] - s[0] + 1 == m) {// 找到长度m的1子串
                        return i;
                    }
                } else if (s[0] < arr[i] && arr[i] < s[1]) { // 重分片段
                    if (arr[i] - s[0] == m || s[1] - arr[i] == m) { // 找到长度m的1子串
                        return i;
                    } else {
                        if (arr[i] - s[0] > m && s[1] - arr[i] > m) { // 一分为二，都留
                            int[][] ns = new int[segments.length + 1][2];
                            int k;
                            for (k = 0; k < j; ++k) {
                                ns[k] = segments[k];
                            }
                            ns[k++] = new int[]{s[0], arr[i] - 1};
                            ns[k++] = new int[]{arr[i] + 1, s[1]};
                            for (; k < ns.length; ++k) {
                                ns[k] = segments[k - 1];
                            }
                            segments = ns;
                        } else if (arr[i] - s[0] > m) {// 一分为二留左
                            s[1] = arr[i] - 1;
                        } else if (s[1] - arr[i] > m) {// 一分为二留右
                            s[0] = arr[i] + 1;
                        } else { // 一分为二都不留
                            if (segments.length == 1) {
                                return -1;
                            }
                            int[][] ns = new int[segments.length - 1][2];
                            int k;
                            for (k = 0; k < ns.length; ++k) {
                                if (k < j) {
                                    ns[k] = segments[k];
                                } else {
                                    ns[k] = segments[k + 1];
                                }
                            }
                            segments = ns;
                        }
                    }
                } else {
                    continue;
                }
                break;
            }
        }
        return -1;
    }
}