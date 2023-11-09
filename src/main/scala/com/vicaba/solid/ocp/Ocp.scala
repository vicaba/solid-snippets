package com.vicaba.solid.ocp

import java.awt.Rectangle

// VIOLATING OCP
trait ShapeViolation
case class RectangleViolation(width: Int, height: Int) extends ShapeViolation
case class SquareViolation(width: Int) extends ShapeViolation
case class TriangleViolation(width: Int, height: Int) extends ShapeViolation

class OcpViolation {
  def calculateArea(shape: ShapeViolation): Int = {
    shape match {
      case RectangleViolation(width, height) => width * height
      case SquareViolation(width)            => width * width
      case TriangleViolation(width, height)  => width * height / 2
      // for a new shape, we will need to add a new case, we are "opening" the class again
    }
  }
}

// RESPECTING OCP
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
