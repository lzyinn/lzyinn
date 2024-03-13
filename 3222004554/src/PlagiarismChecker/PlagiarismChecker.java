package PlagiarismChecker;

import java.io.BufferedReader;
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlagiarismChecker {
	public static void main(String args[]) throws IOException {
			/*提醒用户输入两篇文本的绝对路径*/
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("请输入原文本绝对路径:");
			String originalPath = reader.readLine();
			System.out.print("请输入对比文本绝对路径:");
			String comparePath = reader.readLine();
			
			/*调用FiletoString(),将文本转换成字符串*/
			String originalTXT = FiletoString(originalPath);
			String compareTXT = FiletoString(comparePath);
			
			/*计算simHash*/
			long originalSimHash = calSimHash(originalTXT);
			long compareSimHash = calSimHash(compareTXT);
			
			/*计算海明距离*/
			int hammingDistance = calHammingDistance(originalSimHash,compareSimHash);
			
			/*计算相似度*/
			double result = 1-(hammingDistance/64.0);
			
			/*将相似度输出到文件中*/
			System.out.print("请输入存储相似度结果的文件绝对路径:");
			String resultPath = reader.readLine();
			ResulttoFile(result,resultPath);
			
			
	}
	
	/*将文本转换为字符串*/
	public static String FiletoString(String Path) {
		
		return Path;
	}
	
	/*计算simHash*/
	public static long calSimHash(String TXT) {
		return 0;
	}
	
	/*计算海明距离*/
	public static int calHammingDistance(long simHash1,long simHash2) {
		return 0;
	}
	
	/*将结果存储到文件中*/
	public static void ResulttoFile(double result,String Path) {
		
	}
}
