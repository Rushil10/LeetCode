/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    int n;
    int index;
    List<Integer> li;
    
    public void inorder(TreeNode root,List<Integer> li){
        if(root==null){
            return;
        }
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right,li);
    }

    public BSTIterator(TreeNode root) {
        li=new ArrayList<>();
        inorder(root,li);
        index=-1;
        n=li.size();
    }
    
    public int next() {
        index++;
        return li.get(index);
    }
    
    public boolean hasNext() {
        if(index<n-1){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */