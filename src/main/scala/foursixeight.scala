class foursixeight {

  object Solution {

    private def validIpV6Char(c: Char): Boolean = c.isLetter && ('a' to 'f').contains(c.toLower) || c.isDigit

    private def validIpV6Sec(s: String): Boolean = s.nonEmpty && s.length <= 4 && s.forall(validIpV6Char)

    private def validIpV6(sections: Array[String]) =
      if (sections.length == 8 && sections.forall(validIpV6Sec)) "IPv6"
      else "Neither"

    private def validIpV4Char(c: Char): Boolean = c.isDigit

    private def validIpV4Sec(s: String): Boolean = s match {
      case "" => false
      case "0" => true
      case s => s.head != '0' && s.forall(validIpV4Char) && (0 to 255).contains(s.toInt)
    }

    private def validIpV4(sections: Array[String]) =
      if (sections.length == 4 && sections.forall(validIpV4Sec)) "IPv4"
      else "Neither"

    def validIPAddress(queryIP: String): String = {
      if (queryIP.slice(0, 6).contains(':') && queryIP.last != ':') validIpV6(queryIP.split(':'))
      else if (queryIP.slice(0, 256).contains('.') && queryIP.last != '.') validIpV4(queryIP.split('.'))
      else "Neither"
    }

  }
}
