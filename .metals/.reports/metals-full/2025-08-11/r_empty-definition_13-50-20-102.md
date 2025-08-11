error id: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Card.scala:`<none>`.
file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Card.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Rank#
	 -scala/Predef.Rank#
offset: 67
uri: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Card.scala
text:
```scala
package it.unibo.scalabluff.model

final case class Card(rank: Ra@@nk)

/** Collezione immutabile di carte. */
final case class Hand(cards: List[Card])
object Hand:
  val empty: Hand = Hand(Nil)

/** Mazzo astratto: permette di pescare e conoscere la dimensione. */
trait Deck:
  def draw(n: Int): (List[Card], Deck)
  def size: Int
  def isEmpty: Boolean = size == 0

/** Strategia di mescolamento, separata per testabilità. */
trait Shuffler:
  def shuffle[A](xs: List[A]): List[A]

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.