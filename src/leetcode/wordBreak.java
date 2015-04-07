package leetcode;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {
	public static void main(String args[]) {
		wordBreak wordBreak=new wordBreak();
		HashSet<String> dict =new HashSet<>();
		dict.add("a");
		String s ="a";
		wordBreak.wordBreak(s, dict);
	}
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null)return false;
        boolean table[]=new boolean[s.length()+1];
        table[0]=true;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(dict.contains(s.substring(i,j+1))&&table[i]==true){
                    table[j+1]=true;
                }
        }
        }
        return table[s.length()];
    }

}
