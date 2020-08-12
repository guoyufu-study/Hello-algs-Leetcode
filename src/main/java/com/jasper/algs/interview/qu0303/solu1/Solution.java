package com.jasper.algs.interview.qu0303.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class StackOfPlates {

    List<Deque<Integer>> list;
    int cap;
    int a, b;

    public StackOfPlates(int cap) {
        list = new ArrayList<Deque<Integer>>();
        this.cap = cap;
    }
    
    public void push(int val) {
        if(b==0) {
            list.add(new LinkedList<Integer>());
        } else if(b==cap) {
            list.add(new LinkedList<Integer>());
            a++;
            b = 0;
        }
        b++;
        list.get(a).push(val);
    }
    
    public int pop() {
        if(a==0 && b==0) {
            return -1;
        }
        Deque<Integer> stack = list.get(a);
        int ans = stack.pop();
        b--;
        if(b == 0) {
            list.remove(a);
            b = a==0 ? 0 : list.get(a-1).size();
            a += a==0 ? 0 : -1;
        }

        return ans;
    }
    
    public int popAt(int index) {
        if(index > a || index < 0)
            return -1;
        if(index==a)
            return pop();

        Deque<Integer> stack = list.get(index);
        int ans = stack.pop();
        if(stack.size() == 0) {
            list.remove(index);
            a--;
        }
        return ans;
    }
    
    
    public static void main(String[] args) {
		StackOfPlates stackOfPlates = new StackOfPlates(1);
		stackOfPlates.push(1);
		stackOfPlates.push(2);
		System.out.println(stackOfPlates.popAt(1));
		System.out.println(stackOfPlates.pop());
		System.out.println(stackOfPlates.pop());
	}

}