package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	public static void main(String args[]) {
		String beginWord="ta";
		String endWord="if";
		Set<String> wordDict=new HashSet<>();
		wordDict.add("ca");
		wordDict.add("cf");
		wordDict.add("if");
		//wordDict.add("dot");
		//wordDict.add("dog");
		System.out.println(ladderLength(beginWord, endWord, wordDict));
	}
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(!wordDict.contains(endWord))return 0;
        if(beginWord.equals(endWord))return 1;
        wordDict.remove(beginWord);
        LinkedList<String> queue=new LinkedList<>();
        String iniintermediate=beginWord;
        queue.add(iniintermediate);
        int len=1;
        while(!queue.isEmpty()){
        String intermediate=queue.poll();
        Iterator iterator=(Iterator)wordDict.iterator();
        int min=Integer.MAX_VALUE;
        String minString="";
        while(iterator.hasNext()){
            String tmp=(String)iterator.next();
            int count=0;
            for(int i=0;i<tmp.length();i++){
                if(!(tmp.charAt(i)==intermediate.charAt(i))){
                    count++;
                }
            }
            if(count==1){
                int countToEnd=0;
                for(int i=0;i<tmp.length();i++){
                if(!(tmp.charAt(i)==endWord.charAt(i))){
                    countToEnd++;
                    
                }
                if(min>countToEnd){
                    min=countToEnd;
                    minString=tmp;
                }
            }
    
            }
        }
        len++;
        if(minString.equals(endWord)){
            return len;
        }
        if(!minString.equals("")){
        queue.add(minString);
        wordDict.remove(minString);
        }
        }
        return 0;
    }

}
