package name.lorenzani.andrea.experiments

object MonadUsage extends App {
  def stupidFunc[T](monad: MonadTrait[T]): MonadTrait[MonadTrait[T]] = MonadTrait(monad)
  val listMonads = (1 to 10) map ( x => MonadTrait(x) )
  val filteredValues = for {x <- listMonads
                            if x.get > 5}
                        yield x
  val test = for {a <- filteredValues
  // b <- stupidFunc(a)} yield b // compile time  found   : name.lorenzani.andrea.experiments.MonadTrait[name.lorenzani.andrea.experiments.MonadTrait[Int]]
  //                                              required: scala.collection.GenTraversableOnce[?]
  } yield a

                  println(test)
}
