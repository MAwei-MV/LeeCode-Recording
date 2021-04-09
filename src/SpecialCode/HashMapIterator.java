package SpecialCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
//����HashMap�ı����������¼��ַ�����
	//ͨ��ForEachѭ�����б���
	public void First() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		// Iterating entries using a For Each loop
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	// ForEach������ֵ�Է�ʽ
	public void second() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		// ������
		for (Integer key : map.keySet()) {
			System.out.println("Key = " + key);
		}
		// ����ֵ
		for (Integer value : map.values()) {
			System.out.println("Value = " + value);
		}
	}

	// ʹ�ô����͵ĵ��������б���
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

	// ʹ�ò������͵ĵ��������б���
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

	// ͨ��Java8 Lambda���ʽ����
	public void fifth() throws IOException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
	}
}
