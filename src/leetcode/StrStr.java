package leetcode;

public class StrStr {
	public static void main(String args[]) {
		
		StrStr str2=new StrStr();
		String haystack="abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba";
		String needle="bbbbbbaa";
		System.out.println(str2.strStr(haystack, needle));
	}

    public int strStr(String haystack, String needle) {
        if(needle.length()==0&&haystack.length()==0)
        	{
        	return 0;
        	}else if(haystack.length()==0){
        		return -1;
        	}
        int []table=failureFunction(needle.toCharArray());
        int m=0;
        int i=0;
        while(m+i<haystack.length()){
            if(needle.charAt(i)==haystack.charAt(m+i)){
                if(i==needle.length()-1){
                    return m;
                }
                i++;
            }else{
                if(i>1&&table[i-1]>0){
                m=m+i-table[i-1];
                i=table[i-1];
                }else{
                m++;
                i=0;
                }
            }
        }
        return -1;
    }
    private int[] failureFunction(char[] str) {
        int table[]=new int[str.length];
        table[0]=0;
        int p=1;
        int i=0;
        for (; p < str.length; p++) 
			{
        	while (i>0&&str[p]!=str[i]) {
            	i=table[i];
            	if(table[i]==i){
            		i=0;
            		break;
            	}
            }
            if(str[p]==str[i]){
                i++;
      
            }
            
            table[p]=i;
            
            
        }
        return table;
    }
}
