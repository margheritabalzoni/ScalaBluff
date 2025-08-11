package it.unibo.scalabluff.model

enum Rank {
  case Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
}

object Rank:
  /** Ordine naturale del gioco; Ace può essere alto o basso nelle varianti. */
  val order: Vector[Rank] = Vector(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
  given Ordering[Rank] = Ordering.by(order.indexOf)