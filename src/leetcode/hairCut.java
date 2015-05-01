package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.Position;
class baber{
	long num;
	long timeRemain;
	public baber(long num,
			long timeRemain) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.timeRemain=timeRemain;
	}
}
public class hairCut {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("/Users/zhuangli/Downloads/B-large-practice.in"));
		int caseNum=scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			
			
		long barbers=scanner.nextLong();
		long postion=scanner.nextLong();
		
		ArrayList<baber> barList=new ArrayList<>();
		long effi[]=new long[(int) barbers];
		for (int j = 0; j < barbers; j++) {
			long tmp=scanner.nextInt();
			baber babertmp=new baber(j+1,0 );
			
			barList.add(babertmp);
			effi[j]=tmp;
		}
		if (barbers>=postion) {
			System.out.println("Case #"+(i+1)+": "+postion);
			continue;
		}
		long comd=lcm(effi);
		long result=0;
		for (int j = 0; j < effi.length; j++) {
			result=comd/effi[j]+result;
		}
		postion=postion%result;
		if(postion==0){
			postion=result;
			}
		if (barbers>=postion) {
			System.out.println("Case #"+(i+1)+": "+postion);
			continue;
		}
		System.out.println("Case #"+(i+1)+": "+pickbarber(barList,postion,barbers,effi));
		
		}
	}
	public static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	public static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	    	long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	public static long lcm(long[] input)
	{
		long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
    
	private static long pickbarber(ArrayList<baber> barList, long postion, long barbers, long[] effi) {
		long free=0;
		long i=0;
		while (i<postion) {
			long min=Long.MAX_VALUE;
			for (int j = 0; j < barbers; j++) {
				if (min>barList.get(j).timeRemain) {
					min=barList.get(j).timeRemain;
					free=barList.get(j).num;
				}
			}
			for (int j = 0; j < barbers; j++) {
				if ((j+1)==free) {
					barList.get(j).timeRemain=effi[j];
					i++;
					if(i==postion){
						return free;
					}
				}else{
				barList.get(j).timeRemain=barList.get(j).timeRemain-min;
				if (barList.get(j).timeRemain==0) {
					barList.get(j).timeRemain=effi[j];
					free=barList.get(j).num;
					i++;
					
					if(i==postion){
						return free;
					}
				}
				}
				//System.out.println(barList.get(j).timeRemain);
				
			}
		}
		return free;
	}
}
