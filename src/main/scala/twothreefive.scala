class twothreefive {

  object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {

      if (p.value < root.value && q.value < root.value) lowestCommonAncestor(root.left, p, q)
      else if (p.value > root.value && q.value > root.value) lowestCommonAncestor(root.right, p, q)
      else root
    }
  }

}
