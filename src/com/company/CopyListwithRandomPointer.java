package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dai on 2017/5/31.
 */

public class CopyListwithRandomPointer {

    ////��Ŀ����������ĸ���
    // A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    // Return a deep copy of the list.
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) { this.label = x; }
    }

    public static void main(String[] srgs){
        CopyListwithRandomPointer test=new CopyListwithRandomPointer();

        RandomListNode root=new RandomListNode(-1);
        RandomListNode node1=new RandomListNode(2);
        RandomListNode node2=new RandomListNode(3);
        RandomListNode node3=new RandomListNode(4);
        RandomListNode node4=new RandomListNode(5);
        root.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        root.random=node1;
        node1.random=root;
        node3.random=node1;

        RandomListNode result=test.copyRandomList2(root);
        RandomListNode node=result;
        while(node != null) {
            System.out.println(node.label);
            node=node.next;
        }
    }

    //����һ����<N,N'>�������Ϣ����һ����ϣ����
    //time com:O(n),space time:O(n)
    //Runtime: 6 ms��beats 38.43 %
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        //�����½ڵ㣬�ù�ϣ���Ŷ�Ӧ��ϵ
        Map<RandomListNode, RandomListNode> map=new HashMap<>();
        RandomListNode node=head;
        while(node!=null){
            map.put(node, new RandomListNode(node.label));
            node=node.next;
        }
        //�����½ڵ��next��random
        node=head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }

        return map.get(head);
    }

    //����������N'���ӵ�N�ĺ���
    //time com:O(n),space com:O(n)
    //Runtime: 2 ms, beats 72.08 %
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head==null) return null;
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
    //����ԭʼ���������ڵ�N�������½ڵ�N�������ӵ�N�ĺ���
    public void cloneNodes(RandomListNode head){
        RandomListNode node=head;
        while(node!=null){
            RandomListNode clone=new RandomListNode(node.label);
            clone.next=node.next;
            clone.random=null;

            node.next=clone;

            node=clone.next;
        }
    }
    //���ø��Ƴ����Ľڵ�N����random
    public void connectRandomNodes(RandomListNode head){
        RandomListNode node=head;
        RandomListNode clone;
        while(node!=null){
            clone=node.next;
            if(node.random!=null){
                clone.random=node.random.next;
            }

            node=clone.next;
        }
    }
    //�ѳ������ֳ���������
    public RandomListNode reconnectNodes(RandomListNode head){
        RandomListNode node=head;
        RandomListNode cloneHead=null;
        RandomListNode clone=null;

        if(node!=null){
            cloneHead=clone=node.next;
            node.next=clone.next;
            node=node.next;
        }

        while(node!=null){
            clone.next=node.next;
            clone=clone.next;
            node.next=clone.next;
            node=node.next;
        }

        return cloneHead;
    }
}
