package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Omino {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(
				"/Users/zhuangli/Downloads/D-small-attempt3.in"));
		int caseNum = scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int X=scanner.nextInt();
			int R=scanner.nextInt();
			int C=scanner.nextInt();
			if(X>R&&X>C){
				System.out.println("Case #"+(i+1)+": RICHARD");
			}else if(X>R*C){
				System.out.println("Case #"+(i+1)+": RICHARD");
			}else if(X==4&&(R*C<=9)){
				System.out.println("Case #"+(i+1)+": RICHARD");
			}else if((R*C)%X!=0){

				System.out.println("Case #"+(i+1)+": RICHARD");
			
			}else{

				System.out.println("Case #"+(i+1)+": GABRIEL");
			
			}
		}
		scanner.close();
	}
}
