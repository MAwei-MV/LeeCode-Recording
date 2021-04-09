package DailyPractice;

/*java.io.BufferedReader和java.io.BufferedWriter类各拥有8192字符的缓冲区。
 * 当BufferedReader在读取文本文件时，会先尽量从文件中读入字符数据并置入缓冲区，
 * 而之后若使用read()方法，会先从缓冲区中进行读取。
 * 如果缓冲区数据不足，才会再从文件中读取，使用BufferedWriter时，写入的数据并不会先输出到目的地，而是先存储至缓冲区中。
 * 如果缓冲区中的数据满了，才会一次对目的地进行写出。
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JZ2 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * System.in是一个位流，为了转换为字符流， 可使用InputStreamReader为其进行字符转换，
		 * 然后再使用BufferedReader为其增加缓冲功能。
		 */
		String str = " ";
		while ((str = bf.readLine()) != null) {
			System.out.println(str.replaceAll(" ", "%20"));
		}
		bf.close();
	}
}
