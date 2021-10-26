// Named imports
import week3.Rational
//import week3.{Rational, Hello}

// Wildcard import (I think because _ pattern matches everything)
//import week3._



object scratch extends App{
  // Without import, I would need
  //println(new week3.Rational(1,2))

  // With import we can do it like this
  println(new Rational(1,2))

  // Returns type Nothing
  def error(msg: String) = throw new Error(msg)

  //Null is just like in Java, extends all reference types
  // Nothing extends val types and null (and therefore, indirectly ref types)
  val s: String = null
  // Won't work    val t: String = Nothing


}
