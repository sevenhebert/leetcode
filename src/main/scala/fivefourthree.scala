class fivefourthree {

  object Solution {

    def traverse(tn: TreeNode): List[TreeNode] =
      if (tn == null) List.empty
      else traverse(tn.left) ++ traverse(tn.right) ++ List(tn)

    def depth(node: TreeNode): Int =
      if (node == null) 0
      else 1 + Math.max(depth(node.left), depth(node.right))

    def diameterOfBinaryTree(root: TreeNode): Int =
      if (root == null) 0
      else traverse(root).foldLeft(0) { case (max, cur) => math.max(max, depth(cur.left) + depth(cur.right)) }

  }

}


