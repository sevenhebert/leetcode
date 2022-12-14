class twotwosix {

  object Solution {

    def invertTree(root: TreeNode): TreeNode =
      if (root == null) root
      else {
        val leftCopy = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(leftCopy)
        root
      }
  }

}
