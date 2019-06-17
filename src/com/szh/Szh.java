package com.szh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Szh {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(4);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
