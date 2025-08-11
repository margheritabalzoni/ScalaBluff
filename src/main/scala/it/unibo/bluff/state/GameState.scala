package it.unibo.bluff.state

import it.unibo.bluff.model.*
import it.unibo.bluff.rules.TurnOrder

/** Dichiarazione effettuata: rango dichiarato e carte coperte giocate */
final case class Declaration(player: PlayerId, declared: Rank, hiddenCards: List[Card])

/** Pila centrale delle carte giocate */
final case class CenterPile(stacks: List[List[Card]]):
  def allCards: List[Card] = stacks.flatten
  def push(cs: List[Card]): CenterPile = CenterPile(cs :: stacks)
  def clear: (List[Card], CenterPile) = (allCards, CenterPile(Nil))
object CenterPile:
  val empty = CenterPile(Nil)

/** Stato principale del gioco */
final case class GameState(
  players: Vector[PlayerId],
  hands: Map[PlayerId, Hand],
  deck: List[Card],
  pile: CenterPile,
  turn: PlayerId,
  lastDeclaration: Option[Declaration],
  pendingPenalty: Option[PlayerId],
  finished: Boolean
):
  def nextPlayer(using order: TurnOrder): PlayerId = order.next(players, turn)

object GameState:
  def initial(players: Int, shuffled: List[Card]): GameState =
    val ids = Vector.tabulate(players)(PlayerId.apply)
    GameState(ids, Map.empty, shuffled, CenterPile.empty, ids.head, None, None, false)
