package leetcode;

public class ConvertString {
		public static void main(String args[]) {
			convert("A", 1);
		}

	    public static String convert(String s, int nRows) {
	        if(s==null||s.length()==0)return "";
	        char c[]=s.toCharArray();
	        int len=s.length();
	        StringBuffer res[]=new StringBuffer[nRows];
	        int i=0;
	        while(i<len){
	            for(int idx=0;idx<nRows&&i<len;idx++){
	                res[idx].append(c[i++]);
	            }
	            for(int idx=nRows-1;idx>=0&&i<len;idx--){
	                res[idx].append(c[i++]);
	            }
	        }
	        for(int j=1;j<res.length;j++){
	            res[0].append(res[j]);
	        }
	        return res[0].toString();
	    }

}
