package leetcode;

public class Divide {
	public static void main(String args[]) {
		Divide divide=new Divide();
		int dividend=-1010369383;
		int divisor=-2147483648;
		divide.divide(dividend, divisor);
	}

    public int divide(int dividend, int divisor) {
        boolean ifMinus=(dividend<0&&divisor>0)||(dividend>0&&divisor<0);
        long end=(long)Math.abs(dividend);
        long div=(long)Math.abs(divisor);
        long sub=div;
        long ans=0;
        long c=1;
        while(end>=div){
            if(end>=sub){
                end-=sub;
                ans+=c;
                sub<<=1;
                c<<=1;
            }else{
                sub>>=1;
                c>>=1;
            }
        }
        if(ifMinus){
            ans=-ans;
        }
        return (int)ans;
    }

}
