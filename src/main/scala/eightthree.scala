class eightthree {

  object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {

      def rec(n: ListNode): ListNode =
        if (n == null) head
        else if (n.next != null && n.x == n.next.x) {
          val grandChild = n.next.next
          n.next = grandChild
          rec(n)
        }
        else rec(n.next)

      rec(head)
    }
  }

}
