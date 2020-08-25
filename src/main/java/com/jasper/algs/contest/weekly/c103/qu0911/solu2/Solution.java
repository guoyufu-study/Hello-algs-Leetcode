package com.jasper.algs.contest.weekly.c103.qu0911.solu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0911. 在线选举
 * 
 * <p>
 * 预处理 + 二分搜索
 *
 */
class TopVotedCandidate {

	List<Vote> A;

	public TopVotedCandidate(int[] persons, int[] times) {
		A = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();
		int leader = -1; // current leader
		int m = 0; // current number of votes for leader

		for (int i = 0; i < persons.length; ++i) {
			int p = persons[i], t = times[i];
			int c = count.getOrDefault(p, 0) + 1;
			count.put(p, c);

			if (c >= m) {
				if (p != leader) { // lead change
					leader = p;
					A.add(new Vote(leader, t));
				}

				if (c > m)
					m = c;
			}
		}
	}

	public int q(int t) {
		int lo = 1, hi = A.size();
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (A.get(mi).time <= t)
				lo = mi + 1;
			else
				hi = mi;
		}

		return A.get(lo - 1).person;
	}
}

class Vote {
	int person, time;

	Vote(int p, int t) {
		person = p;
		time = t;
	}
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times); int param_1 =
 * obj.q(t);
 */