package SpecialCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
//关于HashMap的遍历，有以下几种方法：
	//通过ForEach循环进行遍历
	public void First() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		// Iterating entries using a For Each loop
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	// ForEach迭代键值对方式
	public void second() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		// 迭代键
		for (Integer key : map.keySet()) {
			System.out.println("Key = " + key);
		}
		// 迭代值
		for (Integer value : map.values()) {
			System.out.println("Value = " + value);
		}
	}

	// 使用带泛型的迭代器进行遍历
	public void third() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);

		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	// 使用不带泛型的迭代器进行遍历
	public void forth() {
		Map map = new HashMap();
		map.put(1, 10);
		map.put(2, 20);
		Iterator<Map.Entry> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			Integer key = (Integer) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println("Key = " + key + ", Value = " + value);
		}

	}

	// 通过Java8 Lambda表达式遍历
	public void fifth() throws IOException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
	}
}
