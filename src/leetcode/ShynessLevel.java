package leetcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ShynessLevel {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Downloads/A-large.in"));
		int caseNum=scanner.nextInt();
		PrintWriter writer = new PrintWriter("/Users/zhuangli/Desktop/codeJam");
		for (int i = 0; i < caseNum; i++) {
			int maxShy=scanner.nextInt();
			int data[]=new int[maxShy+1];
			String tmp=scanner.next();
			for (int j = 0; j < maxShy+1; j++) {
				data[j]=Integer.parseInt(String.valueOf(tmp.charAt(j)));
				
			}
			
			writer.println("Case #"+(i+1)+": "+caculateMin(data));
		}
		writer.close();
		scanner.close();
	}

	private static int caculateMin(int[] data) {
		int result=0;
		int amount=0;
		for (int i = 0; i < data.length; i++) {
			amount=amount+data[i];
			if(i+1>amount){
				result=result+i+1-amount;
				amount=i+1;
			}
			
		}
		return result;
	}
	

}
