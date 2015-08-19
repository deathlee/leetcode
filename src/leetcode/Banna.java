package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Banna {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Desktop/codeJam"));
		int caseNUm=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < caseNUm; i++) {
			String KLS1=scanner.nextLine();
			String[] KLS = KLS1.split("\\s+");
			int K=Integer.valueOf(KLS[0]);
			int L=Integer.valueOf(KLS[1]);
			int S=Integer.valueOf(KLS[2]);
			String types = scanner.nextLine();
			String target =scanner.nextLine();
			HashSet<Character> set=new HashSet<>();
			char type[]=new char[K];
			char newtype[]=new char[L];
			for (int j = 0; j < types.length(); j++) {
				set.add(types.charAt(j));
				type[j]=types.charAt(j);
			}
			int count=0;
			HashSet<Character> targetset=new HashSet<>();
			for (int j = 0; j < target.length(); j++) {
				newtype[j]=target.charAt(j);
				targetset.add(newtype[j]);
			}
			Iterator< Character> iterator=targetset.iterator();
			while (iterator.hasNext()) {
				if (set.contains((char)iterator.next())) {
					count++;
				}
			}
			if(count==targetset.size()){
				int amount=maxmun(newtype,S);
				
			}else{
				System.out.println("Case #"+(i+1)+": "+0.0);
			}
			
		}
	}

	private static int maxmun(char[] newtype, int s) {
		// TODO Auto-generated method stub
		int count=0;
			for (int j = 0; j < newtype.length; j++) {
				if (newtype[count]==newtype[j]) {
					for (int i = j+1; i < newtype.length; i++) {
						count++;
						if(newtype[count]==newtype[j+1]){
							
						}
					}
				}
			}
		return 0;
	}
}
