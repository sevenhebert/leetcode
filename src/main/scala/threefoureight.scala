class threefoureight {

  class TicTacToe(_n: Int) {

    private val rows1 = Array.fill(_n)(0)
    private val cols1 = Array.fill(_n)(0)
    private var diaDown1 = 0
    private var diaUp1 = 0

    private val rows2 = Array.fill(_n)(0)
    private val cols2 = Array.fill(_n)(0)
    private var diaDown2 = 0
    private var diaUp2 = 0

    private val diaUp = (0 until _n).reverse.zipWithIndex.map({ case (a, b) => (b, a) }).toSet

    private def isWin(player: Int) =
      if (player == 1) rows1.contains(_n) || cols1.contains(_n) || diaDown1 == _n || diaUp1 == _n
      else rows2.contains(_n) || cols2.contains(_n) || diaDown2 == _n || diaUp2 == _n

    def move(row: Int, col: Int, player: Int): Int = {
      if (player == 1) {
        rows1.update(row, rows1(row) + 1)
        cols1.update(col, cols1(col) + 1)
        if (row == col) diaDown1 += 1
        if (diaUp.contains((row, col))) diaUp1 += 1
      }
      if (player == 2) {
        rows2.update(row, rows2(row) + 1)
        cols2.update(col, cols2(col) + 1)
        if (row == col) diaDown2 += 1
        if (diaUp.contains((row, col))) diaUp2 += 1
      }

      if (isWin(player)) player
      else 0
    }

  }

}
