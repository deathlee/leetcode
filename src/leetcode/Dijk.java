package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijk {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(
				"/Users/zhuangli/Downloads/C-large.in"));
		int caseNum = scanner.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int len = scanner.nextInt();
			long repNum = scanner.nextLong();
			
			String tmp = scanner.next();
			if(fitRuleOrNot1(tmp).equals("1")) {
				System.out.println("Case #"+(i+1)+": NO");
				continue;
			}
			repNum=Math.min(repNum, repNum%4+12);
			
			StringBuilder string = new StringBuilder(tmp);
			for (int j = 1; j < repNum; j++) {
				string.append(tmp);
			}
			if(checkIfPass(string.toString())){
				System.out.println("Case #"+(i+1)+": YES");
			}else {
				System.out.println("Case #"+(i+1)+": NO");
			}
		}
		scanner.close();
	}

	private static boolean checkIfPass(String string) {
		int len = string.length();
		if (len < 3)
			return false;
		if (!fitRuleOrNot1(string).equals("-1")) {
			return false;
		}
		boolean arc1[]=new boolean[len];
		checkArc(1,len-2,arc1,string,2);
		boolean arc[]=new boolean[len];
		checkArc1(len,arc,string,0);
		for (int i=1; i <= len-2; i++) {
			if (arc1[i-1]==true) {
				
			for (int j = i+1; j <= len-1; j++) {
				if(arc[j]==false)continue;
				if (fitRuleOrNot(string.substring(i,j), 1)) {
					if (arc[j]==true) {
						return true;
					}
			}else {
				continue;
			}
			}
			}else {
				continue;
			}
		}

		return false;

	}


	private static void checkArc1(int len, boolean[] arc, String string, int level) {
		for (int k = len-1; k >=2; k--) {
			if (fitRuleOrNot(string.substring(k,len), level)) {
				arc[k]=true;
			}else {
				arc[k]=false;
			}
		}
	
	}

	private static void checkArc(int i, int j,boolean []arc, String string,int level) {
		// TODO Auto-generated method stub
		for (int k = i; k <= j; k++) {
			if (fitRuleOrNot(string.substring(i-1,k), level)) {
				arc[k-1]=true;
			}else {
				arc[k-1]=false;
			}
		}
	}

	private static boolean fitRuleOrNot(String string, int i2) {
		int[][] ruleMatrix = { { 0, 1, 2, 3, 4 }, { 1, 1, 2, 3, 4 },
				{ 2, 2, -1, 4, -3 }, { 3, 3, -4, -1, 2 }, { 4, 4, 3, -2, -1 } };
		// '1'=1
		// 'i'=2
		// 'j'=3
		// 'k'=4
		int flag = 0;
		if (i2 == 2) {
			flag = 2;
		} else if (i2 == 1) {
			flag = 3;
		} else if (i2 == 0) {
			flag = 4;
		} else {
			flag = -1;
		}
		String var = String.valueOf(string.charAt(0));
		int tmp = mapChar(var);
		for (int i = 1; i < string.length(); i++) {
			int tmp2 = mapChar(String.valueOf(string.charAt(i)));
			if (tmp > 0 && tmp2 > 0) {
				tmp = ruleMatrix[tmp][tmp2];
			} else if (tmp < 0 && tmp2 < 0) {
				tmp = ruleMatrix[-tmp][-tmp2];
			} else if (tmp < 0) {
				tmp = ruleMatrix[-tmp][tmp2];
				tmp = -tmp;
			} else if (tmp2 < 0) {
				tmp = ruleMatrix[tmp][-tmp2];
				tmp = -tmp;
			} else {
				return false;
			}
			var = reMap(tmp);
		}
		if (tmp > 0 && tmp == flag) {
			return true;
		} else {
			return false;
		}
	}

	private static String fitRuleOrNot1(String string) {
		int[][] ruleMatrix = { { 0, 1, 2, 3, 4 }, { 1, 1, 2, 3, 4 },
				{ 2, 2, -1, 4, -3 }, { 3, 3, -4, -1, 2 }, { 4, 4, 3, -2, -1 } };
		// '1'=1
		// 'i'=2
		// 'j'=3
		// 'k'=4
		String var = String.valueOf(string.charAt(0));
		int tmp = mapChar(var);
		for (int i = 1; i < string.length(); i++) {
			int tmp2 = mapChar(String.valueOf(string.charAt(i)));
			if (tmp > 0 && tmp2 > 0) {
				tmp = ruleMatrix[tmp][tmp2];
			} else if (tmp < 0 && tmp2 < 0) {
				tmp = ruleMatrix[-tmp][-tmp2];
			} else if (tmp < 0) {
				tmp = ruleMatrix[-tmp][tmp2];
				tmp = -tmp;
			} else if (tmp2 < 0) {
				tmp = ruleMatrix[tmp][-tmp2];
				tmp = -tmp;
			} 
			var = reMap(tmp);
		}
		return var;
	}
	private static String reMap(int tmp) {
		// TODO Auto-generated method stub
		if (tmp == 1) {
			return "1";
		} else if (tmp == 2) {
			return "i";
		} else if (tmp == 3) {
			return "j";
		} else if (tmp == 4) {
			return "k";
		} else if (tmp == -1) {
			return "-1";
		} else if (tmp == -2) {
			return "-i";
		} else if (tmp == -3) {
			return "-j";
		} else if (tmp == -4) {
			return "-k";
		}
		return null;
	}

	private static int mapChar(String s) {
		// TODO Auto-generated method stub

		if (s.equals("1")) {
			return 1;
		} else if (s.equals("i")) {
			return 2;
		} else if (s.equals("j")) {
			return 3;
		} else if (s.equals("k")) {
			return 4;
		} else if (s.equals("-1")) {
			return -1;
		} else if (s.equals("-i")) {
			return -2;
		} else if (s.equals("-j")) {
			return -3;
		} else if (s.equals("-k")) {
			return -4;
		}
		return -1;
	}
}
