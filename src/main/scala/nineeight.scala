class ninetyeight {

  object Solution {
    def isValidBST(root: TreeNode): Boolean = {

      def rec(node: TreeNode, lb: BigInt, rb: BigInt): Boolean =
        if (node == null) true
        else if (lb < node.value && node.value > rb) rec(node.left, lb, node.value) && rec(node.right, node.value, rb)
        else false

      rec(root, BigInt(Int.MinValue) - 1, BigInt(Int.MaxValue) + 1)
    }

  }

}