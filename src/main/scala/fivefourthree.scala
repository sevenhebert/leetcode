class fivefourthree {

  object Solution {

    def maxDepthAtNode(node: TreeNode): Int =
      if (node == null) 0
      else {
        val whole = maxDepthAtNode(node.left) + maxDepthAtNode(node.right)
        val left = 1 + maxDepthAtNode(node.left)
        val right = 1 + maxDepthAtNode(node.left)
        List(whole, left, right).max
      }

    def width(root: TreeNode): Int = {

      List(whole, left, right).max
    }

  }

}


