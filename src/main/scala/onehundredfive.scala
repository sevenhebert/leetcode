class onehundredfive {

  object Solution {

    // pre-order head will always be root
    // values to the left of the roots index in the in-order list will be the results left subtree
    // partition pre-order tail based on the number of elements to the left of the root index ^

    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode =
      if (preorder.isEmpty) null
      else {
        val rootIdx = inorder.indexOf(preorder.head)
        val (leftPreorder, rightPreorder) = preorder.tail.splitAt(rootIdx)
        val (leftInorder, rightInorder) = inorder.splitAt(rootIdx)

        println("leftPreorder: " + leftPreorder.toList)
        println("leftInorder: " + leftInorder.toList)
        println("rightPreorder: " + rightPreorder.toList)
        println("rightInorder: " + rightInorder.toList)

        val tree = new TreeNode(preorder.head)
        tree.left = buildTree(leftPreorder, leftInorder)
        tree.right = buildTree(rightPreorder.drop(1), rightInorder.drop(1))

        tree
      }
  }

}
