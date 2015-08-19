package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class CodeJam {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Downloads/A-small-attempt11.in"));
		int caseNum=scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int N=scanner.nextInt();
			int count=1;
			int incre=0;
			while (count<=N) {
				String tmp=String.valueOf(count);
				StringBuilder reverse=new StringBuilder(tmp).reverse();
				String newreverse=reverse.toString();
				int newcount=newreverse!=""?Integer.parseInt(newreverse):0;
			count=recursiveAction(count+1,N,incre)<recursiveAction(newcount+1,N,incre)?count+1:newcount+1;
			incre++;
			}
			System.out.println("Case #"+(i+1)+": "+incre);
		}
		scanner.close();
	}

	private static int recursiveAction(int count,int N,int cre) {
		String tmp=String.valueOf(count);
		StringBuilder reverse=new StringBuilder(tmp).reverse();
		String newreverse=reverse.toString();
		int newcount=newreverse!=""?Integer.parseInt(newreverse):0;
		if(newcount<count){
			cre++;
			return cre;
		}else{
			if(newcount<=N){
				int cre1=recursiveAction(newcount+1,N,cre);
				int cre2=recursiveAction(count+1,N,cre);
				cre=cre1<cre2?cre1:cre2;
			}else{
				cre++;
				return cre;
			}
		}
		return cre;
	}
}
