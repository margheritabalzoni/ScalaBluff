error id: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/view/cli/CLI.scala:standardShuffled.
file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/view/cli/CLI.scala
empty definition using pc, found symbol in pc: standardShuffled.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 297
uri: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/view/cli/CLI.scala
text:
```scala
package it.unibo.bluff.view.cli

import it.unibo.bluff.view.*

//COME SE FOSSE LA PARTE GRFICA DEL GIOCO, MA INVECE E' TESTUALE
object CLI:
  private given TurnOrder = TurnOrder.given

  def start(players: Int = 2): Unit =
    val rng = RNG.default()
    val deck = DeckBuilder.standardS@@huffled(rng)
    var state = GameState.initial(players, deck)
    println(s"Nuova partita con $players giocatori. Comandi: deal | play <p> <Rank> <idx,idx,..> | bluff <p> | show <p> | hands | quit")
    loop(state)

  private def loop(st: GameState)(using TurnOrder): Unit =
    if st.finished then
      println("Partita terminata.")
    else
      print(s"[Turno ${st.turn.value}] > ")
      val line = scala.io.StdIn.readLine()
      if line == null || line.trim.equalsIgnoreCase("quit") then ()
      else
        parse(line.trim, st) match
          case None =>
            println("Comando non riconosciuto")
            loop(st)
          case Some(cmd) =>
            GameEngine.applyCommand(st, cmd) match
              case Left(err) =>
                println(s"Errore: $err")
                loop(st)
              case Right((next, events)) =>
                events.foreach(renderEvent)
                loop(next)

  private def parse(s: String, st: GameState): Option[GameCommand] =
    s.split(" ").toList match
      case "deal" :: Nil => Some(GameCommand.Deal)
      case "play" :: p :: rankStr :: idxStr :: Nil =>
        for
          pid <- parseInt(p)
          rank <- parseRank(rankStr)
          hand <- st.hands.get(PlayerId(pid))
          idxs = idxStr.split(",").flatMap(parseInt).toList
          cards <- idxs.traverse(i => hand.cards.lift(i))
        yield GameCommand.Play(PlayerId(pid), cards, rank)
      case "bluff" :: p :: Nil => parseInt(p).map(i => GameCommand.CallBluff(PlayerId(i)))
      case _ => None

  private def renderEvent(ev: GameEvent): Unit = ev match
    case GameEvent.CardsDealt => println("Carte distribuite")
    case GameEvent.DeclarationMade(decl) => println(s"Giocatore ${decl.player.value} dichiara ${decl.declared} e gioca ${decl.hiddenCards.size} carte")
    case GameEvent.BluffCalled(accuser, decl, truthful) => println(s"Giocatore ${accuser.value} chiama il bluff: dichiarazione ${if truthful then "vera" else "falsa"}")
    case GameEvent.GameEnded(winner) => println(s"Vittoria del giocatore ${winner.value}")
  private def parseInt(s: String): Option[Int] = s.toIntOption
  private def parseRank(s: String): Option[Rank] = Rank.values.find(_.toString.equalsIgnoreCase(s))

  extension [A](l: List[A])
    def traverse[B](f: A => Option[B]): Option[List[B]] =
      l.foldRight(Option(List.empty[B])){ (a, acc) => for bs <- acc; b <- f(a) yield b :: bs }

```


#### Short summary: 

empty definition using pc, found symbol in pc: standardShuffled.