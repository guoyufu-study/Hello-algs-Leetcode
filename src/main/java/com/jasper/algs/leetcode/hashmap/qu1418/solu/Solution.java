package com.jasper.algs.leetcode.hashmap.qu1418.solu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1418. 点菜展示表
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
    	List<List<String>> ans = new ArrayList<>();
    	
    	Map<String, Integer> items = new HashMap<>();// 菜品字典
    	int[] tables = new int[501];// 餐桌字典
    	
    	for (int i = 0; i < orders.size(); i++) {
    		String itemsKey = orders.get(i).get(2);//统计菜品
    		if(!items.containsKey(itemsKey)) 
				items.put(itemsKey, 0); 
    		
    		int tableIndex = Integer.parseInt(orders.get(i).get(1)); // 统计餐桌，并排序
			tables[tableIndex] += 1; 
		}
    	
    	// 构造标题行
    	List<String> title = new ArrayList<String>();
    	title.add("Table");
    	int itemIndex = 1;
    	
    	String[] itemsArray = items.keySet().toArray(new String[items.size()]);
    	Arrays.sort(itemsArray);
    	for (String item : itemsArray) {
    		title.add(item);//标题
    		items.put(item, itemIndex++);//标记菜品索引
		}
    	ans.add(title);
    	
    	// 构造内容行
    	int tableIndex = 1;
    	for (int i = 1; i < tables.length; i++) {
			if(tables[i]>0) {
				List<String> list = new ArrayList<String>();
				list.add(i+"");// 餐桌号
				for (int j = 0; j < items.size(); j++) {//初始化菜品数量
					list.add("0");
				}
				ans.add(list);
				tables[i] = tableIndex++;//标记餐桌索引
			}
		}
    	
    	// 统计
    	for (int i = 0; i < orders.size(); i++) {
			List<String> order = orders.get(i);
			int table = tables[Integer.parseInt(order.get(1))];// 餐桌号 -> 餐桌索引
			List<String> whichTable = ans.get(table);
			
			int item = items.get(order.get(2));//菜品 -> 菜品索引
			int count = Integer.parseInt(whichTable.get(item));
			whichTable.set(item, (++count)+"");
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	
    	
    	String[][] array = new String[][] {
    		{"David","3","Ceviche"},
    		{"Corina","10","Beef Burrito"},
    		{"David","3","Fried Chicken"},
    		{"Carla","5","Water"},
    		{"Carla","5","Ceviche"},
    		{"Rous","3","Ceviche"},
    	};
    	List<List<String>> orders = new ArrayList<>();
    	
    	for (int i = 0; i < array.length; i++) {
    		orders.add(Arrays.asList(array[i]));
		}
    	
    	
    	new Solution().displayTable(orders);
	}
}