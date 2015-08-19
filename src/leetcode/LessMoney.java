package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LessMoney {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Desktop/codeJam"));
		int caseNUM=scanner.nextInt();
		for (int i = 0; i < caseNUM; i++) {
			int C=scanner.nextInt();
			int D=scanner.nextInt();
			int V=scanner.nextInt();
			int coin[]=new int[D];
			for (int j = 0; j < D; j++) {
				coin[j]=scanner.nextInt();
			}
			boolean target[]=new boolean[V];
			LinkedList<Integer> queue= new LinkedList<>();
			int len=0;
			queue.add(coin[0]);
			queue.add(0);
			while (len<D) {
				int size=queue.size();
				for (int j = 0; j < size; j++) {
					int L=queue.poll();
					if(L<=V&&L!=0){
						target[L-1]=true;
						}
					if((len+1)==D){
						continue;
					}
					queue.add(L+coin[len+1]);
					queue.add(L);
				}
				len++;
			}
			int count=0;
			int count1=0;
			for (int j = 0; j < target.length; j++) {
				if(target[j]==true){
					count++;
				}else{
					count1++;
				}
			}
			if (count==target.length) {
				System.out.println("Case #"+(i+1)+": "+0);
			}else{

				System.out.println("Case #"+(i+1)+": "+count1);
			
			}
			
		}
	}
}
