package leetcode;

public class longestPalindrome {
	public static void main(String args[]) {
		longestPalindrome longestPalindrome=new longestPalindrome();
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(longestPalindrome.longestPalindrome(s));
		System.out.println(s.length());
	}

    public String longestPalindrome(String s) {
        int length=s.length();
        if(length==0)return "";
        StringBuilder result=new StringBuilder("");
        StringBuilder reverse=new StringBuilder(s).reverse();
        int max=0;
        int pos=0;
        int []table=new int[length];
        for(int i=0;i<length;i++){
            if(s.charAt(0)==reverse.charAt(i)){
                table[i]=1;
                max=table[i];
                pos=i;
            }
        }
        for(int i=1;i<length;i++){
            for(int j=0;j<length;j++){
                if(j==0&&reverse.charAt(j)==s.charAt(i)){
                    table[j]=1;
                }else{
            
                if(reverse.charAt(j)==s.charAt(i))
                {
                    table[j]=table[j-1]+1;
                    if(table[j]>max){
                        max=table[j];
                        pos=j;}
                }else{
                    table[j]=0;
                }
                }
            }
        }
        for(int i=0;i<max;i++){
            result=result.append(s.charAt(pos-max+1+i));
        }
        return result.toString();
    }

}
