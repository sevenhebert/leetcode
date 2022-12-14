import scala.collection.mutable

class onefoursix {

  class LRUCache(_capacity: Int) {

    import collection.mutable

    val cache = new mutable.LinkedHashMap[Int, Int]()

    def get(key: Int): Int = cache.get(key) match {
      case Some(value) =>
        cache.remove(key)
        cache.addOne(key, value)
        value
      case None => -1
    }

    def put(key: Int, value: Int): Unit = {
      cache.get(key) match {
        case Some(_) =>
          cache.remove(key)
        case None =>
          if (cache.size >= _capacity) cache.eld(cache.head._1)
      }
      cache.addOne(key, value)
    }

  }

  /**
   * Your LRUCache object will be instantiated and called as such:
   * var obj = new LRUCache(capacity)
   * var param_1 = obj.get(key)
   * obj.put(key,value)
   */

}
