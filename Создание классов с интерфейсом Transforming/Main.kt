
fun circle(){
    val centerX=3
    val centerY=-3
    println("Круг:")
    val configFigure=Circle(3f,2,5)
    val f:Figure=configFigure
    val f1:Movable=configFigure
    val f2:Transforming=configFigure
    println("Площадь круга равна: ${f.area()}")
    configFigure.printSize()
    f2.resize(3)
    configFigure.printPos()
    f1.move(-3,4)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.CounterClockwise,centerX,centerY)
}
fun rect(){
    val centerX=3
    val centerY=-3
    println("Прямоугольник:")
    val configFigure=Rect(4,3,2,5)
    val f:Figure=configFigure
    val f1:Movable=configFigure
    val f2:Transforming=configFigure
    println("Площадь прямоугольника равна: ${f.area()}")
    configFigure.printSize()
    f2.resize(3)
    configFigure.printPos()
    f1.move(-3,4)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.CounterClockwise,centerX,centerY)
}
fun square(){
    val centerX=3
    val centerY=-3
    println("Квадрат:")
    val configFigure=Rect(4,3,2,5)
    val f:Figure=configFigure
    val f1:Movable=configFigure
    val f2:Transforming=configFigure
    println("Площадь квадрата равна: ${f.area()}")
    configFigure.printSize()
    f2.resize(3)
    configFigure.printPos()
    f1.move(-3,4)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.Clockwise,centerX,centerY)
    configFigure.printPosUntilRotate(centerX,centerY)
    f2.rotate(RotateDirection.CounterClockwise,centerX,centerY)
}
fun main() {
    square()
    circle()
    rect()
}