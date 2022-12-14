class onenine {

  object Solution {
    def offset(cur: ListNode, rem: Int): ListNode =
      if (rem == 1) cur.next
      else offset(cur.next, rem - 1)

    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {

      def rec(hd: ListNode, off: ListNode): ListNode = {
        if (off == null) n match {
          case 1 if hd.next == null => null
          case 1 => hd.next = null; head
          case 2 => hd.next
        }
        else if (off.next == null) {
          hd.next = hd.next.next
          head
        }
        else rec(hd.next, off.next)
      }

      rec(head, offset(head, n))
    }

  }

}
