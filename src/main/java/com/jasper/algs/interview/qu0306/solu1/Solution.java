package com.jasper.algs.interview.qu0306.solu1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 03.06. 动物收容所
 *
 * <p>
 * 包装动物
 */
class AnimalShelf {
	private int timeStamp = 0;
	private Queue<TimeStamp> catQueue;
	private Queue<TimeStamp> dogQueue;

	public AnimalShelf() {
		catQueue = new LinkedList<>();
		dogQueue = new LinkedList<>();
	}

	public void enqueue(int[] animal) {
		if (animal[1] == 1) {
			dogQueue.offer(new TimeStamp(animal[0], timeStamp++));
		} else {
			catQueue.offer(new TimeStamp(animal[0], timeStamp++));
		}
	}

	public int[] dequeueAny() {
		TimeStamp cat = catQueue.peek();
		TimeStamp dog = dogQueue.peek();
		if (dog == null && cat == null) {
			return new int[] { -1, -1 };
		}
		if (dog == null) {
			catQueue.poll();
			return new int[] { cat.animal, 0 };
		}
		if (cat == null) {
			dogQueue.poll();
			return new int[] { dog.animal, 1 };
		}
		if (dog.time < cat.time) {
			dogQueue.poll();
			return new int[] { dog.animal, 1 };
		}
		catQueue.poll();
		return new int[] { cat.animal, 0 };
	}

	public int[] dequeueDog() {
		TimeStamp dog = dogQueue.poll();
		if (dog == null) {
			return new int[] { -1, -1 };
		}
		return new int[] { dog.animal, 1 };
	}

	public int[] dequeueCat() {
		TimeStamp cat = catQueue.poll();
		if (cat == null) {
			return new int[] { -1, -1 };
		}
		return new int[] { cat.animal, 0 };
	}

	class TimeStamp {
		int animal;
		int time;

		public TimeStamp(int animal, int time) {
			this.animal = animal;
			this.time = time;
		}
	}
}

/**
 * Your AnimalShelf object will be instantiated and called as such: AnimalShelf
 * obj = new AnimalShelf(); obj.enqueue(animal); int[] param_2 =
 * obj.dequeueAny(); int[] param_3 = obj.dequeueDog(); int[] param_4 =
 * obj.dequeueCat();
 */