class oneonezero {

  object Solution {
    def isBalanced(root: TreeNode): Boolean =
      if (root == null) true
      else if (math.abs(depth(root.left) - depth(root.right)) <= 1) isBalanced(root.left) & isBalanced(root.right)
      else false

    private def depth(node: TreeNode): Int =
      if (node == null) 0
      else 1 + math.max(depth(node.left), depth(node.right))

  }

}