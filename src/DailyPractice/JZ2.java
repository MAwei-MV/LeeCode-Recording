package DailyPractice;

/*java.io.BufferedReader��java.io.BufferedWriter���ӵ��8192�ַ��Ļ�������
 * ��BufferedReader�ڶ�ȡ�ı��ļ�ʱ�����Ⱦ������ļ��ж����ַ����ݲ����뻺������
 * ��֮����ʹ��read()���������ȴӻ������н��ж�ȡ��
 * ������������ݲ��㣬�Ż��ٴ��ļ��ж�ȡ��ʹ��BufferedWriterʱ��д������ݲ������������Ŀ�ĵأ������ȴ洢���������С�
 * ����������е��������ˣ��Ż�һ�ζ�Ŀ�ĵؽ���д����
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JZ2 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * System.in��һ��λ����Ϊ��ת��Ϊ�ַ����� ��ʹ��InputStreamReaderΪ������ַ�ת����
		 * Ȼ����ʹ��BufferedReaderΪ�����ӻ��幦�ܡ�
		 */
		String str = " ";
		while ((str = bf.readLine()) != null) {
			System.out.println(str.replaceAll(" ", "%20"));
		}
		bf.close();
	}
}
