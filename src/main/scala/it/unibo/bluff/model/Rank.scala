package it.unibo.bluff.model

enum Rank {
  case Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
}

object Rank:
  val order: Vector[Rank] = Vector(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
  given Ordering[Rank] = Ordering.by(order.indexOf)