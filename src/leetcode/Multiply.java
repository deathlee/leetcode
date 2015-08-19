package leetcode;

public class Multiply {
		public static void main(String args[]) {
			multiply("0", "0");
		}

	    public static String multiply(String num1, String num2) {
	        char []num1Array=num1.toCharArray();
	        char []num2Array=num2.toCharArray();
	        int m=num1Array.length;
	        int n=num2Array.length;
	        int []product=new int[m+n];
	        for(int i=m-1;i>=0;i--){
	            for(int j=n-1;j>=0;j--){
	                int idx=i+j+1;
	                product[idx]+=(num1Array[i]-'0')*(num2Array[j]-'0');
	            }
	        }
	        int carry=0;
	        for(int i=m+n-1;i>=0;i--){
	            int tmp=product[i]+carry;
	            product[i]=tmp%10;
	            carry=tmp/10;
	        }
	        
	        StringBuffer res=new StringBuffer();
	        if(carry!=0){
	            res.append(carry);
	        }
	        int i=0;
	        while(i<m+n){
	             if(product[i]!=0){
	                 break;
	             }
	            i++;
	        }
	        if(i==m+n)return "0";
	        while(i<m+n){
	            res.append(product[i]);
	            i++;
	        }
	        return res.toString();
	    }

}
