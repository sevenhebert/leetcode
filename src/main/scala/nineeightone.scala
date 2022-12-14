class nineeightone {

  class TimeMap() {

    import collection.mutable

    private val hm = mutable.Map[String, mutable.ArrayBuffer[(Int, String)]]()

    def set(key: String, value: String, timestamp: Int): Unit =
      hm.updateWith(key) {
        case Some(entry) => Some(entry.addOne(timestamp, value))
        case None => Some(mutable.ArrayBuffer((timestamp, value)))
      }

    def get(key: String, timestamp: Int): String = {
      val entries = hm.getOrElse(key, mutable.ArrayBuffer.empty)

      def search(i: Int, j: Int): String =
        if (j - i <= 1) entries.slice(i, j + 1).findLast(_._1 <= timestamp).getOrElse((timestamp, ""))._2
        else {
          val mid = ((j - i) / 2) + i
          if (entries(mid)._1 < timestamp) search(mid + 1, j)
          else search(0, mid)
        }

      search(0, entries.length - 1)
    }
  }

  /**
   * Your TimeMap object will be instantiated and called as such:
   * var obj = new TimeMap()
   * obj.set(key,value,timestamp)
   * var param_2 = obj.get(key,timestamp)
   */
}
