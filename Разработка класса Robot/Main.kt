import java.lang.Character.isDigit
fun input(): Int {
    while (true) {
        var ch=0
        val digit = readLine().toString()
        digit.forEach {
            if(!isDigit(it)){
                ch++
            }
        }
        if(ch!=0){
            print("Введённое вами значение не является числом или содержит иные символы\nПовторите попытку:")
        }
        else{
            return (digit.toInt())
        }
    }
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}
fun moveRobot(r: Robot, toX: Int, toY: Int) {
    r.checkTurn(toX,toY)
}

fun main() {
    println("Для работы программы необходимо указать начальную позицию робота и конечную")
    print("Укажите текущее положение робота по оси Х:")
    val X0=input()
    print("Укажите текущее положение робота по оси У:")
    val Y0=input()
    print("Укажите место прибытия робота по оси Х:")
    val X=input()
    print("Укажите место прибытия робота по оси У:")
    val Y=input()
    val r=Robot(X0,Y0,Direction.UP)
    moveRobot(r,X,Y)


}