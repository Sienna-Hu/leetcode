// A linked list of length n is given such that each node contains an additional
// random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n
// brand new nodes, where each new node has its value set to the value of its
// corresponding original node. Both the next and random pointer of the new
// nodes should point to new nodes in the copied list such that the pointers in
// the original list and copied list represent the same list state. None of the
// pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list,
// where X.random --> Y, then for the corresponding two nodes x and y in the
// copied list, x.random --> y.

// Return the head of the copied linked list.

import java.util.HashMap;

// Time and Space Complexity O(n)
class Solution1 {
  // visited stores all the copied node
  // original -> cloned
  HashMap<Node, Node> visited = new HashMap<>();

  /**
   * [getClonedNode(n)] is the cloned version of n. If [n] is visited, it returns
   * directly from [visited]. Otherwise, it creates a clone of n, put it into
   * visited and return the clone.
   */
  public Node getClonedNode(Node n) {
    if (n != null) {
      if (this.visited.containsKey(n)) {
        return this.visited.get(n);
      } else {
        this.visited.put(n, new Node(n.val));
        return this.visited.get(n);
      }
    }
    return null;
  }

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // original list
    Node oldNode = head;
    // cloned list
    Node newNode = new Node(oldNode.val);

    this.visited.put(oldNode, newNode);

    while (oldNode != null) {
      // set random and next for current newNode
      newNode.random = oldNode.random == null ? null : this.getClonedNode(oldNode.random);
      newNode.next = oldNode.next == null ? null : this.getClonedNode(oldNode.next);

      // move to next node
      oldNode = oldNode.next;
      newNode = newNode.next;
    }

    return this.visited.get(head);
  }

  class Solution {
    public Node copyRandomList(Node head) {
      if (head == null) {
        return null;
      }

      // expand the original list
      Node expand = head;
      while (expand != null) {
        // create a copy of original node
        Node copy = new Node(expand.val);
        // copy.next is the original next node
        copy.next = expand.next;
        // the original node's next should be the copy
        expand.next = copy;
        // move to the original next node
        expand = copy.next;
      }

      // correct random pointer of new list
      Node n4random = head;
      while (n4random != null) {
        n4random.next.random = n4random.random == null ? null : n4random.random.next;
        n4random = n4random.next.next;
      }

      Node ans = head.next;

      Node back2original = head;
      // correct next pointer of new list
      Node n4next = head.next;
      while (n4next != null) {
        back2original.next = back2original.next.next;
        n4next.next = n4next.next == null ? null : n4next.next.next;
        back2original = back2original.next;
        n4next = n4next.next;
      }

      return ans;

    }
  }

  private class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}