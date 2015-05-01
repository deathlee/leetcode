package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class infiteNum {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Downloads/B-large.in"));
		int caseNum=scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int nonEmPlate=scanner.nextInt();
			int max=Integer.MIN_VALUE;
			int data[]=new int[nonEmPlate];
			
			for (int j = 0; j < nonEmPlate; j++) {
				int num=scanner.nextInt();
				data[j]=num;
				if(num>max){
					max=num;
				}
			}
			int min=max;
			for(int k=1;k<max;k++){
				int result=k;
				for (int j = 0; j < data.length; j++) {
					if (data[j]%k==0) {
						result+=data[j]/k-1;
					}else {
						result+=data[j]/k;
					}
				}
				min=Math.min(result, min);
			}
			System.out.println("Case #"+(i+1)+": "+min);
		}
		scanner.close();
	}
}
