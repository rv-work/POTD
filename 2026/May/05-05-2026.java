

class Solution {

     ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; 
            curr.next = prev;             
            prev = curr;                   
            curr = nextNode;              
        }
        return prev;
    }

    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        
        k = k % n;
        if (k == 0) return head;

        head = reverseList(head);

        ListNode part1Head = head;
        ListNode part1Tail = head;
        
        for (int i = 1; i < k; i++) {
            part1Tail = part1Tail.next;
        }
        
        ListNode part2Head = part1Tail.next;
        part1Tail.next = null; 

        part1Head = reverseList(part1Head);
        part2Head = reverseList(part2Head);

        ListNode newTail = part1Head;
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        
        newTail.next = part2Head;

        return part1Head;
    }
}