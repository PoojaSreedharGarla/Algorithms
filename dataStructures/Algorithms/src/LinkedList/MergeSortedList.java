package LinkedList;

public class MergeSortedList {
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (l1 == null && l2 == null) return null;
	        
	        if (l1 == null) return l2;
	        if (l2 == null) return l1;
	        
	        ListNode l3 = new ListNode();
	        ListNode head = l3;
	        
	        while (l1 != null && l2 != null) {
	            if (l1.val <= l2.val) {
	                l3.val = l1.val;            
	                l1 = l1.next;
	            } else {
	                l3.val = l2.val;
	                l2 = l2.next;
	            }
	            
	            l3.next = new ListNode();
	            l3 = l3.next;
	        }
	        
	        if (l1 != null) {
	            l3.val = l1.val;
	            l3.next = l1.next;
	        } else if (l2 != null) {
	            l3.val = l2.val;
	            l3.next = l2.next;
	        }
	        return head;
	    }
}



//Time Complexity: O(m+n)
//Space Complexity: O(m+n)

/**
Interviewers will be looking at your approach to questions as much as the answer:
Are you listening carefully and comprehending the question? yes

Are you asking the correct questions before proceeding? (important!)
yes

Is brute force used to solve a problem? (not good!)
yes

Are things assumed without first checking? (not good!)
yes

Do you enjoy finding multiple solutions before choosing the best one?
yes

Are you inventive and flexible in your solutions and open to new ideas?


Are hints heard and heeded?
Are you taking excess time to comprehend / solve problems? (not good!)

Are new ideas and methods of tackling a problem sought?

Can you handle questions that lead to more complex problem solving?


we are assuming that all the lists can fit in one machine/host.

it is guaranteed that two input lists are already sorted and are integer/decimal/another object

if the object compareTo(obj o) method can be defined, then irrespective of the inout data type this algorithm should be extensible

Soln Approach:

Brute force approach - why? we are not making using of the info that lsits are already Sorted

Create a new Linked List and then add all the elments from 1 st and 2nd list in sequential order
Sort this new big list.

Time complexity:  O(m+n) log(m+n)
Space complexity: O(m+n) 

I beliver we can achieve in linear time becasue the lists are sorted and using smart indexing/pointer technique the run time complexity can be reduced.

public ListNode mergeTwoLists(ListNode l1, ListNode l2)

1-> 2 -> 4
1 -> 3 -> 4

Does this soln work fr all test cases/inputs?
the algo should not return NPE for any use case


Time complexity:  O(m+n)

**/
