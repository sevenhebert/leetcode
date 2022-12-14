class twothreezero {

  object Solution {

    def trav(node: TreeNode): List[Int] =
      if (node == null) Nil
      else (trav(node.left) :+ node.value) :++ trav(node.right)

    def kthSmallest(root: TreeNode, k: Int): Int = trav(root)(k - 1)

  }

}
