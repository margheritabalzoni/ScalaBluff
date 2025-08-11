package it.unibo.bluff.model

trait Shuffler:
  def shuffle[A](xs: List[A]): List[A]
