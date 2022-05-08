package com.greatlearning.dsa.lab4.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SkyScraperBuilding {
	Stack<Integer> stack = new Stack<>();
	Queue<List<Integer>> queue = new LinkedList<>();
	int height;

	void construction(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (height == arr[i]) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				int x = arr[i];
				while (!stack.isEmpty() && stack.peek() == --x) {

					list.add(stack.pop());
				}

				queue.add(list);
				height = height - list.size();

			} else {

				stack.push(arr[i]);
				queue.add(new ArrayList<>());
			}
		}

	}

	public static void main(String[] args) {

		SkyScraperBuilding ssb = new SkyScraperBuilding();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Enter total no of floor in the Building:");
		int j = sc.nextInt();
		ssb.height = j;
		int a[] = new int[j];

		for (int i = 0; i < j; i++) {

			System.out.println("\n Enter the Floor size given on day:" + (i + 1));
			a[i] = sc.nextInt();
		}
		ssb.construction(a);
		System.out.println("\n The order of construction is as follows:");
		for (int i = 1; i <= j; i++) {

			System.out.println("Day:" + i);
			System.out.println(ssb.queue.poll());
		}
	}

}
