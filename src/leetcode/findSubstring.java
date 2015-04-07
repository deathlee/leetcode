package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findSubstring {

	public static void main(String args[]) {
		findSubstring findSubstring=new findSubstring();
		String S="abababab";
		String L[]={"a", "b","a"};
		System.out.println(findSubstring.findSubstring(S, L));
	}
    public List<Integer> findSubstring(String S, String[] L) {
        int len=S.length();
        int llen=L[0].length();
        int res=L.length;
        List<Integer> list=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<String,Integer> countmap=new HashMap<>();
        for(int i=0;i<L.length;i++){
            if(map.containsKey(L[i])){
                map.put(L[i],map.get(L[i])+1);
            }else{
                map.put(L[i],1);
            }
        }
        int count=0;
        for(int i=0;i<llen;i++){
            int left=i;
        for(int j=i;j<len-llen+1;j+=llen){
            String tmp=S.substring(j,j+llen);
            if(map.containsKey(tmp)){
                count++;
                if(countmap.containsKey(tmp)){
                    if(countmap.get(tmp)==map.get(tmp)){
                        if(S.substring(left,left+llen).equals(tmp)){
                            left=left+llen;
                            count--;
                        }else{
                            count=1;
                            countmap.clear();
                            countmap.put(tmp,1);
                            left=j;
                        }
                    }else{
                        countmap.put(tmp,countmap.get(tmp)+1);
                        
                    }
                }else{
                    countmap.put(tmp,1);
                }
            }else{
                count=0;
                countmap.clear();
                left=j+llen;
            }
            if(res==count){
                list.add(left);
                countmap.put(S.substring(left,left+llen), countmap.get(S.substring(left,left+llen))-1);
                left=left+llen;
                count--;
            }
        }

        count=0;
        countmap.clear();
        }
        return list;
    }

}
