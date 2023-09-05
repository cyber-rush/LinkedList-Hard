/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node temp = head;
        //Creation of deepCopyNodes and placing it just after the original nodes
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        //Linking of Random pointers in deepCopyNodes
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            
            temp = temp.next.next;
        }
        
        //Removal of next pointer connection between deep and original
        temp = head;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(temp != null){
            Node front = temp.next.next;
            curr.next = temp.next;
            temp.next = front;
            curr = curr.next;
            temp = front;
        }
        return dummy.next;
    }
}