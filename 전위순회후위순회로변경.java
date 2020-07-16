

import java.util.Deque;
import java.util.LinkedList;

public class 전위순회후위순회로변경 {
   public static String solution(String input) {

      Node root = new Node(input.charAt(0));

      Deque<Node> que = new LinkedList<>();
      que.add(root);
      for (int i = 1; i < input.length(); i++) {
         Node node = que.poll();
         if (node.left == null) {
            node.left = new Node(node, input.charAt(i));
            que.addFirst(node);
            que.add(node.left);
         } else {
            node.right = new Node(node, input.charAt(i));
            que.add(node.right);
         }
      }
      return postFixedString(root);
   }

   public static String postFixedString(Node node) {
      String answer = "";

      if (node.left != null) {
         answer += postFixedString(node.left);
      }
      if (node.right != null) {
         answer += postFixedString(node.right);
      }
      answer += node.value;

      return answer;
   }

   public static class Node {
      Node parent;
      Node left;
      Node right;

      char value;

      public Node(Node parent, Node left, Node right, char value) {
         super();
         this.parent = parent;
         this.left = left;
         this.right = right;
         this.value = value;
      }

      public Node(char value) {
         super();
         this.value = value;
      }

      public Node(Node parent, char value) {
         super();
         this.parent = parent;
         this.value = value;
      }

   }

   public static void main(String[] args) {
      String input = "ABCDEF";
      String output = "DEBFCA";

      String answer = solution(input);

      if (answer.equals(output)) {
         System.out.println("정답");
      } else {
         System.out.println("오답");
         System.out.println(answer);
      }

   }
}