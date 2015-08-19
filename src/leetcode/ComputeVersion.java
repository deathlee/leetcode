package leetcode;

public class ComputeVersion {
	public static void main(String args[]) {
		String version1="1.0";
		String version2="1";
		System.out.println(compareVersion(version1, version2));
	}
    public static int compareVersion(String version1, String version2) {
        String ver1[]=version1.split("\\.");
        String ver2[]=version2.split("\\.");
        int len=(ver1.length>ver2.length)?ver2.length:ver1.length;
        for(int i=0;i<len;i++){
            if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i])){
                return 1;
            }else if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i])) {
                return -1;
            }else{
                continue;
            }
        }
        if(ver1.length==ver2.length){
            return 0;
        }else if(ver1.length>ver2.length){
            for(int i=ver2.length;i<ver1.length;i++){
            if(Integer.parseInt(ver1[i])>0){
                return 1;
            }else{
                continue;
            }
        }
            return 0;
        }else{
            for(int i=ver1.length;i<ver2.length;i++){
            if(Integer.parseInt(ver2[i])>0){
                return -1;
            }else{
                continue;
            }
        }
            return 0;
        }
    }

}
