package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MushroomMonster {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Downloads/A-small-attempt0.in"));
		int caseNum=scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int times=scanner.nextInt();
			int mush[]=new int[times];
			for (int j = 0; j < times; j++) {
				mush[j]=scanner.nextInt();
			}

			System.out.println("Case #"+(i+1)+": "+firstway(mush)+" "+secondWay(mush));
			//System.out.println(secondWay(mush));
		
		}
	}

	private static int secondWay(int[] mush) {
		// TODO Auto-generated method stub
		int result=0;
		int max=Integer.MIN_VALUE;
		for (int i = 1; i < mush.length; i++) {
			if(-(mush[i]-mush[i-1])>0&&-(mush[i]-mush[i-1])>max)
			{
				max=-(mush[i]-mush[i-1]);
			}
		}
		if (max==-2147483648) {
			return 0;
		}
		for (int i = 0; i < mush.length-1; i++) {
			if (mush[i]<max) {
				result=result+mush[i];
			}else{
				result=result+max;
			}
		}
		return result;
	}

	private static int firstway(int[] mush) {
		// TODO Auto-generated method stub
		int result=0;
		for (int i = 1; i < mush.length; i++) {
			if(mush[i]-mush[i-1]<0){
			result=result+mush[i]-mush[i-1];
			}
		}
		return -result;
	}
}
