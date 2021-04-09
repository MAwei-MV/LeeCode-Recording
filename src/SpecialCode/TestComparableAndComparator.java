package SpecialCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestComparableAndComparator {
	public static void main(String args[]) {
		ArrayList<Dog> list = new ArrayList<>();
		list.add(new Dog(4, "bob"));
		list.add(new Dog(3, "lch:)"));
		list.add(new Dog(6, "alice"));
		list.add(new Dog(1, "ali"));
		list.add(new Dog(1, "klie"));
		System.out.printf("Original sort, list:%s\n", list);
		Collections.sort(list);
		System.out.printf("Original sort, list:%s\n", list);
		// 分割线，以下是comparator用法
		ArrayList<Cat> list2 = new ArrayList<>();
		list2.add(new Cat("mile", 3));
		list2.add(new Cat("lily", 2));
		list2.add(new Cat("liry", 3));
		list2.add(new Cat("llll", 3));
		list2.add(new Cat("bery", 4));
		list2.add(new Cat("andy", 1));
		System.out.printf("Original sort, list:%s\n", list2);
		Collections.sort(list2, new Comparator<Cat>() {
			@Override
			// 按年龄升序，然后按颜色升序
			public int compare(Cat o1, Cat o2) {
				if (o1.age - o2.age > 0)
					return 1;
				else if (o1.age - o2.age < 0)
					return -1;
				else {
					if (o1.Color.compareTo(o2.Color) > 0) {
						return 1;
					} else if (o1.Color.compareTo(o2.Color) < 0)
						return -1;
					else {
						return 0;
					}
				}
			}
		});
		System.out.printf("Original sort, list:%s\n", list2);
	}
}

class Dog implements Comparable<Dog> {
	private int age;
	private String name;

	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	//
	@Override
	public int compareTo(Dog o) {
		return name.compareTo(o.name);
	}
	/*
	 * 字符串比较按姓名降序升序
	 * 
	 * @Override public int compareTo(Dog o) { return o.name.compareTo(name); }
	 */
	/*
	 * 按年龄升序，如果相等，按姓名降序
	 * 
	 * @Override public int compareTo(Dog o) { if(age-o.age<0) return -1; else
	 * if(age-o.age>0) return 1; else { return o.name.compareTo(name); } }
	 */
	/*
	 * 字符串升序，与return name.compareTo(o.name);作用相同。
	 * 
	 * @Override public int compareTo(Dog o) { if(name.compareTo(o.name)>0) { return
	 * 1; }else if(o.name.compareTo(name)>0){ return -1; } else{ return 0; } }
	 */
}

class Cat {
	public String Color;
	public int age;

	public Cat(String color, int age) {
		super();
		Color = color;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [Color=" + Color + ", age=" + age + "]";
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
