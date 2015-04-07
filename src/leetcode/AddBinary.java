package leetcode;

public class AddBinary {
	public static void main(String args[]) {
		String a="1111";
		String b="1111";
		AddBinary addBinary=new AddBinary();
		System.out.println(addBinary.addBinary(a, b));
	}

    public String addBinary(String a, String b) {
        if(a.length()==0)return b;
        if(b.length()==0)return a;
        if(a.equals("0")&&b.equals("0"))return "0";
        StringBuilder newa=new StringBuilder(a).reverse();
        StringBuilder newb=new StringBuilder(b).reverse();
        int length=0;
        int longlength=0;
        boolean aOrB=false;
        if(a.length()<b.length()){
            aOrB=false;
            length=a.length();
            longlength=b.length();
        }else{
            aOrB=true;
            length=b.length();
            longlength=a.length();
        }
        boolean lastcount=false;
        StringBuilder newString=new StringBuilder();
        for(int i=0;i<length;i++){
            if(lastcount){
            if(newa.charAt(i)=='1'&&newb.charAt(i)=='1'){
                lastcount=true;
                newString.append('1');
            }else if(newa.charAt(i)=='1'||newb.charAt(i)=='1'){
                lastcount=true;
                newString.append('0');
            }else if(newa.charAt(i)=='0'&&newb.charAt(i)=='0'){
                lastcount=false;
                newString.append('1');
                }
            }else{
                
            if(newa.charAt(i)=='1'&&newb.charAt(i)=='1'){
                lastcount=true;
                newString.append('0');
            }else if(newa.charAt(i)=='1'||newb.charAt(i)=='1'){
                lastcount=false;
                newString.append('1');
            }else if(newa.charAt(i)=='0'&&newb.charAt(i)=='0'){
                lastcount=false;
                newString.append('0');
                }
            
            }
        }
        for(int i=length;i<longlength;i++){
            if(aOrB){
                if(lastcount){
                if(newa.charAt(i)=='1'){
                    lastcount=true;
                    newString.append('0');
                    
                }else{
                    
                    lastcount=false;
                    newString.append('1');
                    
                
                }
                    
                }else{
                    
                if(newa.charAt(i)=='1'){
                    lastcount=false;
                    newString.append('1');
                    
                }else{
                    
                    lastcount=false;
                    newString.append('0');
                    
                
                }
                    
                
                }
            }else{
                
                if(lastcount){
                if(newb.charAt(i)=='1'){
                    lastcount=true;
                    newString.append('0');
                    
                }else{
                    
                    lastcount=false;
                    newString.append('1');
                    
                
                }
                    
                }else{
                    
                if(newb.charAt(i)=='1'){
                    lastcount=false;
                    newString.append('1');
                    
                }else{
                    
                    lastcount=false;
                    newString.append('0');
                    
                
                }
                    
                
                }
            
            }
        }
        if(lastcount){
            newString.append('1');
        }
        return newString.reverse().toString();
    }

}
