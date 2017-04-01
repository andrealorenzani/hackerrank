package name.lorenzani.andrea.experiments

import scala.collection.GenTraversableOnce

trait MonadTrait[T] {
  def bind[M](func: T => MonadTrait[M]): MonadTrait[M]
  def flatMap[M](func: T => MonadTrait[M]): MonadTrait[M] = {
    println("flatmapping")
    bind(func)
  }
  def map[B](f: T => B): MonadTrait[B] = {
    println("mapping")
    flatMap (x => MonadTrait(f(x)))
  }
  def foreach[U](f: T => U): Unit
  def filter(func: T => Boolean): MonadTrait[T]
  def withFilter(func: MonadTrait[T] => Boolean): MonadTrait[T] = {
    println("invoking withFilter")
    filter(x => func(MonadTrait(x)) )
  }
  def get: T
  def toOption: Option[T]
}

class Monad[T] private (unit: T) extends MonadTrait[T] {
  override def bind[M](func: T => MonadTrait[M]): MonadTrait[M] = {
    println(s"$unit: binding")
    func(unit)
  }
  override def foreach[U](f: T => U): Unit = {
    println(s"$unit: invoking foreach")
    f(unit)
  }
  override def filter(func: T => Boolean): MonadTrait[T] = {
    println(s"$unit: filtering")
    if(func(unit)) this else EmptyMonad()
  }
  override def withFilter(func: MonadTrait[T] => Boolean): MonadTrait[T] = {
    println(s"$unit: invoking withFilter")
    filter(x => func(MonadTrait(x)) )
  }
  override def get: T = {
    println(s"$unit: getting value")
    unit
  }
  override def toOption: Option[T] = Option(unit)

  override def toString: String = s"Monad(${unit.toString})"
}

class EmptyMonad[T] private () extends MonadTrait[T] {
  override def bind[M](func: (T) => MonadTrait[M]): MonadTrait[M] = {
    println("EmptyMonad: binding")
    EmptyMonad()
  }
  override def map[B](f: (T) => B): MonadTrait[B] = {
    println("EmptyMonad: mapping")
    EmptyMonad()
  }
  override def foreach[U](f: T => U): Unit = {
    println("EmptyMonad: foreach")
  }
  override def filter(f: T => Boolean): MonadTrait[T] = {
    println("EmptyMonad: filtering")
    EmptyMonad()
  }
  override def withFilter(func: MonadTrait[T] => Boolean): MonadTrait[T] = {
    println("EmptyMonad: invoking withFilter")
    EmptyMonad()
  }
  override def get: T = {
    println("EmptyMonad: getting value")
    throw new NoSuchFieldError("empty monad")
  }
  override def toOption: Option[T] = None

  override def toString: String = "EmptyMonad"
}

object MonadTrait {
  def apply[T](unit: T): MonadTrait[T] = {
    Option(unit) match {
      case Some(x) => Monad[T](x)
      case None => EmptyMonad()
    }
  }
}
object EmptyMonad {
  def apply[T](): EmptyMonad[T] = new EmptyMonad[T]()
}
object Monad {
  def apply[T](unit: T): Monad[T] = new Monad[T](unit)
}
