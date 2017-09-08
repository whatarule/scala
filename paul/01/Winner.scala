
object Winner {
  case class Player(name: String, score: Int)

  val sue = Player("Sue", 7)
  val bob = Player("Bob", 8)

  val players = List(
      Player("Sue", 7)
    , Player("Bob", 8)
    , Player("Joe", 4)
    )

  def winner(p1: Player, p2: Player): Player =
    if (p1.score > p2.score) p1
    else p2

  def printWinner(p: Player): Unit =
    println(p.name + " is the winner!")

  def declareWinner(p1: Player, p2: Player): Unit =
    printWinner(winner(p1, p2))

  //  declareWinner(sue, bob)
    printWinner(
        players.reduceLeft(winner)
      )

}

