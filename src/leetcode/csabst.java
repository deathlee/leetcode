package leetcode;


  class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class csabst {

	public static void main(String args[]) {
		csabst csabst=new csabst();
		int num[]={1,3};
		csabst.sortedArrayToBST(num);
	}
    public TreeNode sortedArrayToBST(int[] num) {
            
            int begin=0;
            int end=num.length-1;
            TreeNode node=recursiveNode(num,begin,end);
            return node;
    }
    public TreeNode recursiveNode(int[] num,int begin,int end){
        TreeNode node=null;
        if(begin==end)
            {
                node=new TreeNode(num[begin]);
                return node;
            }else if(begin>end){
            	return null;
            }else{
                node=new TreeNode(num[(begin+end)/2]);
            }
        
        node.left=recursiveNode(num,begin,(begin+end)/2-1);
        node.right=recursiveNode(num,(begin+end)/2+1,end);
        return node;
    }

}
