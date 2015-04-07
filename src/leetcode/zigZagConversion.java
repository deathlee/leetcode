package leetcode;

public class zigZagConversion {
	public static void main(String args[]) {
		zigZagConversion zigZagConversion=new zigZagConversion();
		System.out.println(zigZagConversion.convert("A", 1));
	}

    public String convert(String s, int nRows) {
    	StringBuilder result =new StringBuilder();
    	int len=s.length();
    	for (int i = 0; i < nRows; i++) {
			for (int j = i; j <len ; j+=2*(nRows-1)) {
				result.append(s.charAt(j));
				if(nRows==1)j++;
				if(i==0||i==nRows-1)continue;
				if(j+2*(nRows-1)-2*i<len)
				result.append(s.charAt(j+2*(nRows-1)-2*i));
			}
		}
    	return result.toString();
    }

}
