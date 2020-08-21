package com.jasper.algs.contest.weekly.c165.qu1276.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    @SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
    	if(tomatoSlices%2==1 || cheeseSlices*4<tomatoSlices || cheeseSlices*2>tomatoSlices)
    		return new ArrayList<Integer>();
    	
    	int first = (tomatoSlices - (cheeseSlices*2) ) / 2;
    	
    	return new LinkedList() {{add(first); add(cheeseSlices-first);}};
    }
}