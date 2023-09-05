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
        HashMap<Node,Node> map = new HashMap();
        
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            Node deepNode = map.get(temp);
            Node originalNode = temp;
            deepNode.next = map.get(temp.next);
            deepNode.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
}