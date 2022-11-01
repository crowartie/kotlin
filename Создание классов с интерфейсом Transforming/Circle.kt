import kotlin.math.pow

class Circle(var r:Float, var x:Int, var y:Int):Figure(0),Movable,Transforming {
    override fun area(): Float {
        return  (3.14.toFloat()*(r.pow(2)))
    }

    override fun move(dx: Int, dy: Int) {
        x += dx;
        y += dy
    }

    override fun resize(zoom: Int) {
        printSize()
        r*=zoom

        println("Радиус круга после маштабирования:[${r}]")
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if ((centerX==x) and (centerY==y)){
            println("поворот совпадает с позицией круга")
            return
        }
        if(direction==RotateDirection.Clockwise){
            val task=x
            x=-1*(centerY-y)+centerX
            y = 1*(centerX-task)+centerY

            println("позиция круга после поворота по часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]")
        }
        else{
            val task=x
            x=1*(centerY-y)+centerX
            y = -1*(centerX-task)+centerY

            println("позиция круга после поворота против часовой:[${x}:${y}] относительно точки:[${centerX}:${centerY}]")
        }
    }
    fun printSize(){
        println("Текущий радиус круга:[${r}]")
    }
    fun printPos(){
        println("Текущие координаты круга:[${x}:${y}]")
    }
    fun printPosUntilRotate(centerX: Int,centerY: Int){
        println("позиция круга до поворота:[${x}:${y}] относительно точки:[${centerX}:${centerY}]\nРадиус круга:[${r}]")
    }
}