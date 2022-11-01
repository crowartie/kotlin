class Rect(var x:Int, var y:Int, var width:Int, var height:Int):Movable,Figure(0),Transforming {
    override fun resize(zoom: Int) {
        printSize()
        width*=zoom
        height*=zoom
        println("размеры прямоугольника после маштабирования:[${width}:${height}]")
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if ((centerX==x) and (centerY==y)){
            println("поворот совпадает с позицией прямоугольника")
            return
        }
        if(direction==RotateDirection.Clockwise){
            val task=x
            x=-1*(centerY-y)+centerX
            y = 1*(centerX-task)+centerY
            val trialWidth=width
            width=height
            height=trialWidth
            println("позиция прямоугольника после поворота по часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]\nНовые размеры прямоугольника:[${width}:${height}]")
        }
        else{
            val task=x
            x=1*(centerY-y)+centerX
            y = -1*(centerX-task)+centerY
            val trialWidth=width
            width=height
            height=trialWidth
            println("позиция прямоугольника после поворота против часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]\nНовые размеры прямоугольника:[${width}:${height}]")
        }
    }

    override fun area():Float{
        return (width*height).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx;
        y += dy
        println("координаты прямоугольника после перемещения:[${x}:${y}]")
    }
    fun printSize(){
        println("Текущие размеры прямоугольника:[${width}:${height}]")
    }
    fun printPos(){
        println("Текущие координаты прямоугольника:[${x}:${y}]")
    }
    fun printPosUntilRotate(centerX: Int,centerY: Int){
        println("позиция прямоугольника до поворота:[${x}:${y}] относительно точки:[${centerX}:${centerY}]\nРазмеры прямоугольника:[${width}:${height}]")
    }
}