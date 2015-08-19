package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
	public static void main(String args[]) {
		IPAddress ipAddress=new IPAddress();
		ipAddress.restoreIpAddresses("010010");
	}
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<String>();
        for(int i=0;i<3&&i<s.length()-1;i++){
            int dotnum=0;
            String num=s.substring(0,i+1);
            String ipAddr="";
            if(ifFit(num)){
                ipAddr=num+".";
                dotnum++;
                searchForward(s,i+1,dotnum,result,ipAddr);
            }
        }
        return result;
    }
    void searchForward(String s,int idx,int dotnum,List<String> result,String ipAddr){
        if(dotnum==3){
            
            if(ifFit(s.substring(idx,s.length()))){
                ipAddr+=s.substring(idx,s.length());
                result.add(ipAddr);
                return;
            }else{
                return;
            }
        }else{
            for(int i=idx;i<idx+3&&i<s.length()-1;i++){
            String num=s.substring(idx,i+1);
            if(ifFit(num)){
                String newipAddr=ipAddr+num+".";
                dotnum++;
                searchForward(s,i+1,dotnum,result,newipAddr);
                
            }
        }
        }
    }
    boolean ifFit(String numStr){
        if(numStr.length()>3)return false;
        int num=Integer.parseInt(numStr);
        if(numStr.substring(0,1).equals("0")&&numStr.length()>1)return false;
        if(num<=255||num>=0){
            return true;
        }else{
            return false;
        }
    }


}
