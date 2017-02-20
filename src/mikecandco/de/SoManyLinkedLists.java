package mikecandco.de;

import java.util.LinkedList;

/**
 * Created by mikehuff on 2/19/17.
 */
public class SoManyLinkedLists {
  class Node {
    Node(int data) {
      this.data = data;
    }

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    int data;
    Node next;
  }

  //Print the Elements of a Linked List
  void print(Node head) {
    if (head == null) {
      return;
    }

    Node after = head.next;
    System.out.println(head.data);
    while (after != null) {
      head = after;
      after = after.next;
      System.out.println(head.data);
    }
    return;
  }

  /* Function to reverse the linked list */
  Node reverse(Node node) {
    Node prev = null;
    Node current = node;
    Node aft = null;
    while (current != null) {
      aft = current.next;
      current.next = prev;
      prev = current;
      current = aft;
    }
    node = prev;
    return node;
  }

  Node insertEnd(Node head, int data) {
      // handle first case
      if (head == null) {
        return new Node(data);
      }

      Node penultimate = head;
      // walk to the end of the linked list
      while (penultimate.next != null) {
        penultimate = penultimate.next;
      }

      //penultimate.next was previously null, so we plop our new end in there.
      Node newEnd = new Node(data);
      penultimate.next = newEnd;
      return head;
  }

}
