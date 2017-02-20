package mikecandco.de;

/**
 * Created by mikehuff on 2/19/17.
 */
public class Treeeeeeeeees {

  class Node {
    int data;
    Node left;
    Node right;
  }




////////////////////// -- these are both part of my solution to printing preorder
  void preOrder(Node root) {
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);
    System.out.println(sb.toString());
  }

  void preorder(Node root, StringBuilder sb) {
    if(root !=  null) {
      //Visit the node by Printing the node data
      sb.append(root.data).append(" ");
      preorder(root.left, sb);
      preorder(root.right, sb);
    }
  }
//////////////////////
}
