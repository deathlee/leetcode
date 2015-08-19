package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ladderLength {
	public static void main(String args[]){
		ladderLength ladderLength=new ladderLength();
		HashSet<String> wordDict=new HashSet<>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		System.out.println(ladderLength.ladderLength("hit", "cog", wordDict));
	}
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        int res=wordDict.contains(beginWord)?0:1;
        while(!queue.isEmpty()){
        	int level=queue.size();
            for(int j=0;j<level;j++){
            String node=queue.poll();
            char[] t = node.toCharArray();
            for (int i = 0; i < beginWord.length(); i++) {
			
            for(char c='a';c<='z';c++){
            	 char temp = t[i];
                 t[i] = c;
                 String s = String.copyValueOf(t);
                 t[i] = temp;
                 if(s.equals(endWord)){
                     return res+1;
                 }
                 if(wordDict.contains(s)){
                	 queue.add(s);
                     wordDict.remove(s);
                 }
            }
            }
        
        }
        res++;
        }
        return 0;
    }
	private boolean terminCon(String node, String endWord) {
		// TODO Auto-generated method stub
		 int count=0;
         for(int i=0;i<endWord.length();i++){
             if(!(endWord.charAt(i)==node.charAt(i))){
                 count++;
             }
         }
         return count==1;
	}

}
