import java.awt.*;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */

    public static void main(String[] args){


    }


    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null){
            return null;
        }

        copyNext(head);
        copyRandom(head);

        return splitList(head);

    }


    public void copyNext(RandomListNode head){

        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.random = cur.random;
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
    }

    public void copyRandom(RandomListNode head){

        RandomListNode cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
    }

    //最難的部分,要小心,1.head必須跟newhead一起移動 2.temp放的位置
    public RandomListNode splitList(RandomListNode head){

        RandomListNode cur = head;
        head = cur.next;
        while(cur != null){
            RandomListNode temp = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        return head;
    }

}