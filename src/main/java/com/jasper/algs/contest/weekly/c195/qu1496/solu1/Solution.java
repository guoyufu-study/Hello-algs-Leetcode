package com.jasper.algs.contest.weekly.c195.qu1496.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 1496.判断路径是否相交
 * 
 * <p>辅助字典
 */
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<Integer>();

        int x = 0, y = 0;
        vis.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N': --x; break;
                case 'S': ++x; break;
                case 'W': --y; break;
                case 'E': ++y; break;
            }
            int hashValue = getHash(x, y);
            if (!vis.add(hashValue)) {
                return true;
            }
        }

        return false;
    }

    public int getHash(int x, int y) {
        return x * 20001 + y;
    }
}