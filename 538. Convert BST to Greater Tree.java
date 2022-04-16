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
class Solution {
    public void traverseTree(TreeNode root,List<Integer> li){
        if(root==null){
            return;
        }
        li.add(root.val);
        traverseTree(root.left,li);
        traverseTree(root.right,li);
    }
    
    public void putValues(TreeNode root,Map<Integer,Integer> map){
        if(root==null){
            return;
        }
        root.val=map.get(root.val);
        putValues(root.left,map);
        putValues(root.right,map);
    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        traverseTree(root,li);
        Collections.sort(li);
        Map<Integer,Integer> map = new HashMap<>();
        int n = li.size();
        int sum = 0;
        for(int i=n-1;i>=0;i--){
            sum=sum+li.get(i);
            map.put(li.get(i),sum);
        }
        putValues(root,map);
        return root;
    }
}