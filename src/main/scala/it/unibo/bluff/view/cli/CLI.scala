package it.unibo.bluff.view.cli

import it.unibo.bluff.model.*
import it.unibo.bluff.model.util.RNG
import it.unibo.bluff.model.state.GameState

object CLI:

  def start(players: Int = 2): Unit =
    val rng  = RNG.default()
    val deck = DeckBuilder.standardShuffled(rng) // DeckBuilder è in it.unibo.bluff.model.Rules.scala
    val st   = GameState.initial(players, deck)

    println(s"Nuova partita con $players giocatori.")
    println(s"Mazzo iniziale: ${deck.size} carte.")
    println(s"Primo turno al giocatore: ${st.turn}")
