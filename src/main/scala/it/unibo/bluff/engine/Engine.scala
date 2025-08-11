package it.unibo.bluff.engine

import it.unibo.bluff.model.*
import it.unibo.bluff.model.state.*
import it.unibo.bluff.model.TurnOrder
//ho fartto lo scheletro del motore di gioco ci sono dei commenti cosi si capisce ma dovrebbe essere chiaro

// === Game Commands (input dal giocatore / UI) ===
sealed trait GameCommand
object GameCommand:
  /** Distribuzione carte iniziale */
  case object Deal extends GameCommand
  /** Giocare una o più carte dichiarando un rango */
  final case class Play(player: PlayerId, cards: List[Card], declared: Rank) extends GameCommand
  /** Accusare l'ultima dichiarazione */
  final case class CallBluff(player: PlayerId) extends GameCommand

// === Game Events (output del motore) ===
sealed trait GameEvent
object GameEvent:
  case object CardsDealt extends GameEvent
  final case class DeclarationMade(decl: Declaration) extends GameEvent
  final case class BluffCalled(accuser: PlayerId, decl: Declaration, truthful: Boolean) extends GameEvent
  final case class GameEnded(winner: PlayerId) extends GameEvent

object GameEngine:
  /** Punto di ingresso: applica un comando allo stato e produce nuovo stato + eventi */
  def applyCommand(state: GameState, cmd: GameCommand)(using TurnOrder): Either[String,(GameState,List[GameEvent])] =
    cmd match
      case GameCommand.Deal => deal(state)
      case p: GameCommand.Play => play(state, p)
      case b: GameCommand.CallBluff => callBluff(state, b)
      
  private def deal(state: GameState): Either[String,(GameState,List[GameEvent])] =
    Left("TODO: implement deal")

  private def play(state: GameState, cmd: GameCommand.Play)(using TurnOrder): Either[String,(GameState,List[GameEvent])] =
    Left("TODO: implement play")

  private def callBluff(state: GameState, cmd: GameCommand.CallBluff): Either[String,(GameState,List[GameEvent])] =
    Left("TODO: implement callBluff")
