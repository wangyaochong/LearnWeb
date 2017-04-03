package test.interview.去哪网;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【20:41】.
 */
class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Main1FiniSh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count=in.nextLine();
        String preOrder=in.nextLine();
        String midOrder=in.nextLine();
        String[] preOrderArr = preOrder.split(" ");
        String[] midOrderArr = midOrder.split(" ");
        int[] preOrderNumArr=new int[preOrderArr.length];
        int[] midOrderNumArr=new int[preOrderArr.length];
        for(int i=0;i<preOrderArr.length;i++){
            preOrderNumArr[i]=Integer.parseInt(preOrderArr[i]) ;
            midOrderNumArr[i]=Integer.parseInt(midOrderArr[i]);
        }
        TreeNode treeNode = buildTree(preOrderNumArr, midOrderNumArr);
        ArrayList<ArrayList<Integer>> arrayLists = levelDisplay(treeNode);
        for(int i=0;i<arrayLists.size();i++){
            for(int j=0;j<arrayLists.get(i).size();j++){
                System.out.print(arrayLists.get(i).get(j)+" ");
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> levelDisplay(TreeNode root) {
        List<TreeNode> cacheList=new LinkedList<TreeNode>();
        cacheList.add(root);
        cacheList.add(new TreeNode(Integer.MAX_VALUE));
        ArrayList<ArrayList<Integer>> levels=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return levels;
        }
        while(cacheList.size()>1){//当不是只有标志位
            ArrayList<Integer> level=new ArrayList<Integer>();
            while(cacheList.get(0).val!=Integer.MAX_VALUE){//当没有到标志位
                TreeNode tmp=cacheList.get(0);
                level.add(tmp.val);
                if(tmp.left!=null){
                    cacheList.add(tmp.left);
                }
                if(tmp.right!=null){
                    cacheList.add(tmp.right);
                }
                cacheList.remove(0);//移除第一个元素
            }
            cacheList.remove(0);//到了标志位后，移除标志位，进行下一层
            levels.add(level);//添加一层的结果
            cacheList.add(new TreeNode(Integer.MAX_VALUE));//添加标志位
        }
        return levels;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null|| preorder.length==0){
            return null;
        }
        // write 1your code here
        TreeNode head=new TreeNode(preorder[0]);
        int inLoc=findLoc(inorder,preorder[0]);
        getChild(preorder,inorder,0,inLoc-1,head,0);
        getChild(preorder,inorder,inLoc+1,inorder.length,head,1);
        return head;
    }
    //从一部分候选找到第一个从前序遍历出现的，返回的是前序遍历的数组的下标
    public static int findFirstCandidateFromMidPartInPre(int[] preArr, int[] midArr,int start,int end){
        for(int i=0;i<preArr.length;i++){
            for(int j=start;j<=end;j++){
                if(j!=midArr.length&& preArr[i]==midArr[j]){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int findLoc(int [] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(target==arr[i])return i;
        }
        return -1;
    }
    //前序遍历的序列，中序遍历的序列，如果type是0，构造左孩子，type是1构造右孩子
    public static void getChild(int[] preorder,int[] inorder,int start,int end, TreeNode head,int type){
        if (start == end && start != inorder.length) {
            TreeNode node = new TreeNode(inorder[start]);
            if (type == 0)
                head.left = node;
            else if (type == 1) {
                head.right = node;
            }
        } else {
            int preLoc = findFirstCandidateFromMidPartInPre(preorder, inorder, start, end);
            if (preLoc != -1) {
                TreeNode node = new TreeNode(preorder[preLoc]);
                if(type==0){
                    head.left = node;
                }else{
                    head.right=node;
                }
                getChild(preorder, inorder, start, findLoc(inorder, preorder[preLoc]) - 1, node, 0);
                getChild(preorder, inorder, findLoc(inorder, preorder[preLoc]) + 1, end, node, 1);
            }
        }
    }
}
