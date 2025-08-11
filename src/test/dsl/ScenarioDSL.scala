package it.unibo.bluff.dsl

import it.unibo.bluff.engine.*
import it.unibo.bluff.state.*
import it.unibo.bluff.rules.*
import it.unibo.bluff.model.*
import it.unibo.bluff.util.*

final case class Scenario private (name: String, initial: GameState, commands: List[GameCommand], assertions: List[GameState => Either[String,Unit]])(using TurnOrder):
  def run(): Either[String, Unit] =
    commands.foldLeft[Either[String, (GameState, List[GameEvent])]](Right(initial -> Nil)){ case (acc, cmd) => acc.flatMap{ case (st, _) => GameEngine.applyCommand(st, cmd) } }
      .flatMap{ case (finalState, _) =>
        assertions.foldLeft[Either[String,Unit]](Right(())){ (r, asrt) => r.flatMap(_ => asrt(finalState)) }
      }
//SCENARIO PER I TEST DA FARE
object Scenario:
  def builder(name: String)(using TurnOrder) = ScenarioBuilder(name, Nil, Nil)

final case class ScenarioBuilder(name: String, commands: List[GameCommand], assertions: List[GameState => Either[String,Unit]])(using TurnOrder):
  def given(state: GameState): Scenario = Scenario(name, state, commands.reverse, assertions.reverse)
  def when(cmd: GameCommand): ScenarioBuilder = copy(commands = cmd :: commands)
  def and(cmd: GameCommand): ScenarioBuilder = when(cmd)
  def expect(assertion: GameState => Either[String,Unit]): ScenarioBuilder = copy(assertions = assertion :: assertions)
