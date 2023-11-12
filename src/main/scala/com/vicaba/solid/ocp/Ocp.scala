package com.vicaba.solid.ocp

object OcpViolation {

  trait Shape
  case class Rectangle(width: Int, height: Int) extends Shape
  case class Square(width: Int) extends Shape
  case class Triangle(width: Int, height: Int) extends Shape

  class Ocp {
    def calculateArea(shape: Shape): Int = {
      shape match {
        case Rectangle(width, height) => width * height
        case Square(width)            => width * width
        case Triangle(width, height)  => width * height / 2
        // for a new shape, we will need to add a new case, we are "opening" the class again
        case _ => throw new IllegalArgumentException("Shape not supported")
      }
    }
  }

}

// RESPECTING OCP
object OcpRespecting {

  trait Shape {
    def area: Int
  }
  case class Rectangle(width: Int, height: Int) extends Shape {
    override def area: Int = width * height
  }
  case class Square(width: Int) extends Shape {
    override def area: Int = width * width
  }
  case class Triangle(width: Int, height: Int) extends Shape {
    override def area: Int = width * height / 2
  }

  // Even you do not need this Ocp class, you can use Shape directly
  class Ocp {
    def calculateArea(shape: Shape): Int = shape.area
  }
}
