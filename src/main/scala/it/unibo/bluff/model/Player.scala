package it.unibo.bluff.model

opaque type PlayerId = Int
object PlayerId:
  def apply(i:Int): PlayerId = i
  extension (p:PlayerId) def value: Int = p

final case class Hand(cards: List[Card]):
  def size: Int = cards.size
  def remove(cs: List[Card]): Either[String, Hand] =
    if cs.forall(cards.contains) then Right(Hand(cards.diff(cs))) else Left("Carte non presenti nella mano")
  def add(cs: List[Card]): Hand = Hand(cs ++ cards)
