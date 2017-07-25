//Binary Tree Traversal 二叉树的遍历
/*遍历树的数据结构中最常见的操作， 可以说大部分关于树的题目都是围绕遍历进行变体来解决的。 
一般来说面试中遇到树的题目是用递归来解决的， 不过如果直接考察遍历， 那么一般递归的解法就过于简单了， 
面试官一般还会问更多问题， 比如非递归实现， 或者空间复杂度分析以及能否优化等等。
*/
//***************************************************************************************************
//144. Binary Tree Preorder Traversal   先序遍历
/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3]. 
*/
//方法一：递归
//time com:O(logn),space con:O(1),Runtime: 1 ms, beats 28.32 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}

//方法二：迭代，使用stack
//time com:O(n),space com:O(logn),Runtime: 2 ms, beats 1.81 % 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        if(root == null) return list;
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        
        return list;
    }
}

//方法三：迭代，使用Deque
//time com:O(n),space com:O(logn),Runtime: 1 ms， beats 28.32 % 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                list.add(node.val);
                node=node.left;
            }else{
                node=stack.pop();
                node=node.right;
            }
        }
        
        return list;
    }


//***************************************************************************
//94. Binary Tree Inorder Traversal   中序遍历
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
//方法一：递归
//time com:O(logn),space com:O(1)，Runtime: 1 ms， beats 33.73 % 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private List<Integer> list=new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        
        return list;
    }
}

//方法二：迭代，使用stack
//time com:O(n),space com:O(logn),Runtime: 1 ms, beats 33.73 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        if(root==null) return list;
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            list.add(node.val);
            node=node.right;
        }
        
        return list;
    }
}

//方法三：迭代，使用Deque
//time com:O(n),space com:O(logn),Runtime: 1 ms， beats 33.73 % 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<Integer>();
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                list.add(node.val);
                node=node.right;
            }
        }
        
        return list;
    }
}

//*************************************************************
//145. Binary Tree Postorder Traversal 后序遍历
/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

*/ 
//方法一：递归
//time com:O(logn),space con:O(1)，Runtime: 1 ms， beats 48.98 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private List<Integer> list=new LinkedList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}

//方法二：迭代，使用ArrayDeque
//time com:O(n),space com:O(logn),Runtime: 1 ms， beats 48.98 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                list.addFirst(node.val); // Reverse the process of preorder
                node=node.right; // Reverse the process of preorder
            }else{
                node=stack.pop();
                node=node.left; // Reverse the process of preorder
            }
        }
        
        return list;
    }
}


//******************************************************************************
//层序遍历：即每一层从左向右输出
//******************************************************************************
//102. Binary Tree Level Order Traversal  自顶向下层序
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
*/
//方法：代码基本就是图的广度优先搜索，思路就是维护一个队列存储上一层的结点，逐层访问
//time com:O(n), space com:O(n),Runtime: 2 ms, beats 36.18 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        if(root==null) return list;
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();//一层的结点数
            List<Integer> subList=new LinkedList<Integer>();//一层的节点
            for(int i=0; i<levelNum; i++){//循环取出一层的节点，并加入子结点
                TreeNode node=queue.poll();
                subList.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            list.add(subList);
        }
        
        return list;
    }
}

//*******************************************************************
//107. Binary Tree Level Order Traversal II  自底向上层序
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
*/
//方法：把Binary Tree Level Order Traversal得到的层放入数据结构然后reverse过来
//time com:O(n), space com:O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();//注意声明为LinkedList，还不是List
        if(root==null) return list;
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();//一层的结点数
            List<Integer> subList=new LinkedList<Integer>();//一层的节点
            for(int i=0; i<levelNum; i++){//循环取出一层的节点，并加入子结点
                TreeNode node=queue.poll();
                subList.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            list.addFirst(subList);//在linkedlist前插入
        }
        
        return list;
    }
}

//******************************************************************************
//103. Binary Tree Zigzag Level Order Traversal  锯齿层序遍历
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
*/
//方法：把Binary Tree Level Order Traversal得到的偶数层reverse过来
//time com:O(n), space com:O(n)，Runtime: 2 ms， beats 36.88 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        if(root==null) return list;
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int even=1; //当前层
        while(!queue.isEmpty()){
            int levelNum=queue.size();//一层的结点数
            LinkedList<Integer> subList=new LinkedList<Integer>();//一层的节点,注意声明为LinkedList
            for(int i=0; i<levelNum; i++){//循环取出一层的节点，并加入子结点
                TreeNode node=queue.poll();
                if(even%2 == 0) subList.addFirst(node.val);//偶数层反转
                else subList.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            list.add(subList);
            even++;
        }
        
        return list;
    }
}

//******************************************************************************************
//331. Verify Preorder Serialization of a Binary Tree 题意：给定二叉树的前序遍历，要你在不构造树的情况下，判断树是否合法。
/*
One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false*/

//方法一：栈
//time com:O(n), space con:O(n), Runtime: 20 ms, beats 17.89 %	
/*
已例子一为例，：”9,3,4,#,#,1,#,#,2,#,6,#,#” 遇到x # #的时候，就把它变为 #
模拟一遍过程：
    9,3,4,#,# => 9,3,# 继续读
    9,3,#,1,#,# => 9,3,#,# => 9,# 继续读
    9,#2,#,6,#,# => 9,#,2,#,# => 9,#,# => #
合法的情况最后一定是一个#，*/
public class Solution {
    public boolean isValidSerialization(String preorder) {
        //栈：不断砍掉叶子节点，看最后能不能全部砍掉
        if(preorder==null || preorder.length()==0) 
            return false;
        String[] pre=preorder.split(",");
        Stack<String> stack=new Stack<>();
        for(String node : pre){
            while(node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(node);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
}

//方法二：入度和出度的差
//time com:O(n), space con:O(1),Runtime: 10 ms，beats 76.04 %
/*
对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有

    所有的非空节点提供2个出度和1个入度（根除外）
    所有的空节点但提供0个出度和1个入度

我们在遍历的时候，计算diff = outdegree – indegree. 当一个节点出现的时候，
diff – 1，因为它提供一个入度；当节点不是#的时候，diff+2(提供两个出度) 如果序列式合法的，
那么遍历过程中diff >=0 且最后结果为0.
*/
public class Solution {
    public boolean isValidSerialization(String preorder) {
        //入度和出度的差, 0
        if(preorder==null || preorder.length()==0) 
            return false;
        String[] pre=preorder.split(",");
        int diff=1; //diff = outdegree - indegree
        for(String node : pre){
            --diff; //每个节点提供一个indegree;
            if(!node.equals("#")){//非叶子节点提供两个outdegree
                diff+=2;
            }
        }
        return diff==0;
    }
}

//****************************************************************************************
//114. Flatten Binary Tree to Linked List 
/*
 Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

click to show hints.
Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/
//方法：前序遍历，直接修改，递归
//time com:O(logn)，space com:O(1), Runtime: 1 ms,beats 25.16 %
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        //前序遍历，直接修改，递归
        if(root==null)
            return;
        
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}