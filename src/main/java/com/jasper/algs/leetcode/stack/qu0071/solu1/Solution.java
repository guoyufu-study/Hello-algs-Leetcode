package com.jasper.algs.leetcode.stack.qu0071.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 辅助列表
 * @author 123
 *
 */
class Solution {
    public String simplifyPath(String path) {
        // 结果
    	StringBuilder ans = new StringBuilder(path.length());
    	
    	// 填充辅助列表
    	List<String> helper = new ArrayList<>();
    	String prefix = "/";
		int toffset = 0;
		while(path.startsWith(prefix , toffset)) {
			int endIndex = path.indexOf('/', toffset+1);
			if(endIndex==-1) endIndex = path.length();  // 结尾
			
			String sub = path.substring(toffset, endIndex);// 内容
			if("/..".equals(sub)) {
				if(!helper.isEmpty())
					helper.remove(helper.size()-1);
			} else if("/.".equals(sub) || "/".equals(sub)) {
				// nothing to do
			} else {
				helper.add(sub);
			}
			
			toffset = endIndex;
		}
    	
		// 路径
		for (String sub : helper) {
			ans.append(sub);
		}
		
		if(helper.isEmpty()) return prefix;
    	return ans.toString();
    }
    
    
    public static void main(String[] args) {
//		String path = "/home/";
		String path = "/../";
		
		String simplifyPath = new Solution().simplifyPath(path);
		System.out.println(simplifyPath);
	}
}