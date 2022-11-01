class Square(var x:Int, var y:Int, var width:Int, var height:Int):Movable,Figure(0),Transforming {
    override fun resize(zoom: Int) {
        printSize()
        width*=zoom
        height*=zoom
        println("размеры квадрата после маштабирования:[${width}:${height}]")
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if ((centerX==x) and (centerY==y)){
            println("поворот совпадает с позицией квадрата")
            return
        }
        if(direction==RotateDirection.Clockwise){
            val task=x
            x=-1*(centerY-y)+centerX
            y = 1*(centerX-task)+centerY
            println("позиция квадрата после поворота по часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]")
        }
        else{
            val task=x
            x=1*(centerY-y)+centerX
            y = -1*(centerX-task)+centerY
            println("позиция квадрата после поворота против часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]")
        }
    }

    override fun area():Float{
        return (width*height).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx;
        y += dy
        println("координаты квадрата после перемещения:[${x}:${y}]")
    }
    fun printSize(){
        println("Текущие размеры квадрата:[${width}:${height}]")
    }
    fun printPos(){
        println("Текущие координаты квадрата:[${x}:${y}]")
    }
    fun printPosUntilRotate(centerX: Int,centerY: Int){
        println("позиция квадрата до поворота:[${x}:${y}] относительно точки:[${centerX}:${centerY}]")
    }
}