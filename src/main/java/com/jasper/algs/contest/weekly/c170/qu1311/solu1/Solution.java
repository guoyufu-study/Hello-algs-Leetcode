package com.jasper.algs.contest.weekly.c170.qu1311.solu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1311. 获取你好友已观看的视频
 * 
 * <p> BFS + 统计频次 + 排序
 */
class Solution {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        // BFS 找出 id 的 level级好友
        int n = friends.length;
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        boolean[] used = new boolean[n];
        used[id] = true;
        while(!queue.isEmpty()) {
        	level--;
        	if(level==-1) break;
        	int m = queue.size();
        	for (int i = 0; i < m; i++) {
				int me = queue.poll();
				for(int f : friends[me]) {
					if(!used[f]) {
						used[f] = true;
						queue.offer(f);
					}
				}
			}
        }
        
        // 统计影片频次
        Map<String, Integer> videos = new HashMap<String, Integer>();
        while(!queue.isEmpty()) {
        	int f = queue.poll();
        	List<String> list = watchedVideos.get(f);
        	for(String video : list) {
              videos.put(video, videos.getOrDefault(video, 0)+1);
          }
        }
        // 统计所有影片
        List<String> ans = new ArrayList<String>();
        ans.addAll(videos.keySet());
        
        // 排序
        Collections.sort(ans, (a, b) -> {
        	int compareTo = videos.get(a).compareTo(videos.get(b));
        	if(compareTo==0) 
        		compareTo =  a.compareTo(b);
        	return compareTo;
        });
        
        return ans;
    }
    
    @SuppressWarnings("serial")
	public static void main(String[] args) {
    	
    	List<List<String>> watchedVideos = new ArrayList<>();
    	watchedVideos.add(new ArrayList<String>() {{add("A"); add("B");}});
    	watchedVideos.add(new ArrayList<String>() {{add("C"); }});
    	watchedVideos.add(new ArrayList<String>() {{add("B"); add("C");}});
    	watchedVideos.add(new ArrayList<String>() {{add("D"); }});
    	
    	int[][] friends = new int[][] {{1,2},{0,3},{0,3},{1,2}};
    	int id = 0;
    	
    	// [B, C]
//    	int level = 1;
    	
    	// [D]
    	int level = 2;
    	
    	System.out.println(new Solution().watchedVideosByFriends(watchedVideos, friends, id, level));
	}
}