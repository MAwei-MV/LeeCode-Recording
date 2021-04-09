package DailyPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
//˫�˶��У����ȼ����У��󶥶ѣ�comparator��comparable����
public class JZ642 {
	public static void main(String args[]) {
		JZ642 j =new JZ642();
		int a[] = {32,71,54,70,20,8,9,15,22,25,91,18};
		System.out.println(j.maxInWindows(a, 4));
	}
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
     //˼·ʱ=�ǣ�һ��˫������洢С�꣬����ǰԪ�ر��±�Сʱ������У���ʱ���������У��ȸ�Ԫ��Сʱ��������Ȼ�������
        //begin��¼�����������
        ArrayList<Integer> res= new ArrayList<>();
        if(num==null||size==0||num.length<size){
            return res;
        }
        int begin=0;
        //ArrayDeque��˫�˶���
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            begin=i-size+1;//���������ڵ����
            if(queue.isEmpty()){
                queue.add(i);
               //peekFirst()�Ƕ���Ԫ�أ�peekLast�Ƕ�βԪ��
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