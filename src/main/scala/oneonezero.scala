class oneonezero {

  object Solution {
    def depth(node: TreeNode): Int =
      if (node == null) 0
      else 1 + Math.max(depth(node.left), depth(node.right))

    def isBalanced(root: TreeNode): Boolean = {
      if (root == null) true
      else {
        val leftDepth = depth(root.left)
        val rightDepth = depth(root.right)

        if (leftDepth == rightDepth || leftDepth + 1 == rightDepth || leftDepth - 1 == rightDepth) isBalanced(root.left) && isBalanced(root.right)
        else false
      }

    }

  }

}