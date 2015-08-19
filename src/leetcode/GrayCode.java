package leetcode;

public class GrayCode {
	public static void main(String args[]){
		GrayCode grayCode=new GrayCode();
		grayCode.getGrayCode(2);
	}
	public void getGrayCode(int bitNum){  
	    for(int i = 0; i < (int)Math.pow(2, bitNum); i++){  
	    	
	        int grayCode = (i/2) ^ i;  
	        System.out.println(grayCode);
	        System.out.println(i>>1);
	        //System.out.println(num2Binary(grayCode, bitNum));
	    }  
	}  
	public String num2Binary(int num, int bitNum){  
	    String ret = "";  
	    for(int i = bitNum-1; i >= 0; i--){  
	        ret += (num >> i) & 1;  
	    }  
	    return ret;  
	}  
}
