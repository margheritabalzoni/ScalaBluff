error id: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Rules.scala:`<none>`.
file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Rules.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -it/unibo/bluff/model/Card.
	 -Card.
	 -scala/Predef.Card.
offset: 525
uri: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/Rules.scala
text:
```scala
package it.unibo.bluff.model

import it.unibo.bluff.model.*

/** Strategia ordine turni (permette estensioni future: reverse, skip, ecc.) */
trait TurnOrder:
  def next(players: Vector[PlayerId], current: PlayerId): PlayerId
object TurnOrder:
  given TurnOrder with
    def next(players: Vector[PlayerId], current: PlayerId): PlayerId =
      val idx = players.indexOf(current)
      players((idx + 1) % players.size)

object DeckBuilder:
  def standardShuffled(rng: util.RNG): List[Card] =
    rng.shuffle(Car@@d.fullDeck)

object BluffResolution:
  enum BluffResult:
    case BluffSuccessful(bluffer: PlayerId)
    case BluffFailed(accuser: PlayerId)

  import BluffResult.*

  /** Verifica se le carte corrispondono al rango dichiarato */
  def check(decl: state.Declaration): Boolean = decl.hiddenCards.forall(_.rank == decl.declared)

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.