package DailyPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
//双端队列，优先级队列，大顶堆，comparator、comparable区别
public class JZ642 {
	public static void main(String args[]) {
		JZ642 j =new JZ642();
		int a[] = {32,71,54,70,20,8,9,15,22,25,91,18};
		System.out.println(j.maxInWindows(a, 4));
	}
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
     //思路时=是，一个双向链表存储小标，当当前元素比下标小时，入队列，大时，遍历队列，比该元素小时就舍弃，然后入队列
        //begin记录滑动窗口左边
        ArrayList<Integer> res= new ArrayList<>();
        if(num==null||size==0||num.length<size){
            return res;
        }
        int begin=0;
        //ArrayDeque是双端队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            begin=i-size+1;//代表滑动窗口的起点
            if(queue.isEmpty()){
                queue.add(i);
               //peekFirst()是队首元素，peekLast是队尾元素
            }else if(begin>queue.peekFirst()){
                queue.pollFirst();
            }
          
            while(!queue.isEmpty()&&num[i]>= num[queue.peekLast()]){
                queue.pollLast();
            }
             
           queue.add(i);
            if(begin>=0){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}