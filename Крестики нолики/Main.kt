import java.util.regex.Pattern

fun createGameBorder(N:Int) : Array<Array<String>>{
    var ch=0
    val gameBorder : Array<Array<String>> = Array(N,{Array(N,{"0"})})
    for (i in gameBorder.indices) {
        for (j in gameBorder[i].indices) {
            ch=ch+1
            gameBorder[i][j]=ch.toString()
        }
    }
    return gameBorder
}
fun printGameBorder(gameBorder : Array<Array<String>>,N : Int)  {
    for (i in gameBorder.indices) {
        for (j in gameBorder[i].indices) {

            if((gameBorder[i][j]=="x") or (gameBorder[i][j]=="o")) {
                print("|${gameBorder[i][j]} |")
            }
            else if ((0 <= gameBorder[i][j].toInt()) and (gameBorder[i][j].toInt() <= 9)) {
                print("|${gameBorder[i][j]} |")

            }
            else if ((10 <= gameBorder[i][j].toInt()) or (gameBorder[i][j].toInt() <= 90)) {
                print("|${gameBorder[i][j]}|")
            }
        }
        println()
    }
}
fun statusGame(gameBorder: Array<Array<String>>,a : String,N: Int) : Int{
    var statusGame=0
    for(i in gameBorder.indices){
        for (j in gameBorder[i].indices){

            if((i!=N-1) and (N-1!=j) and (i!=0) and (0!=j)){
                if(((gameBorder[i-1][j-1]==a) and (gameBorder[i][j]==a) and (gameBorder[i+1][j+1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i-1][j-1]==a) and (gameBorder[i-1][j]==a) and (gameBorder[i-1][j+1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i][j-1]==a) and (gameBorder[i][j]==a) and (gameBorder[i][j+1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i+1][j-1]==a) and (gameBorder[i+1][j]==a) and (gameBorder[i+1][j+1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i-1][j-1]==a) and (gameBorder[i][j-1]==a) and (gameBorder[i+1][j-1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i+1][j]==a) and (gameBorder[i][j]==a) and (gameBorder[i+1][j]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i-1][j+1]==a) and (gameBorder[i][j+1]==a) and (gameBorder[i+1][j+1]==a))){
                    println("Победа")
                    statusGame=1
                }
                else if(((gameBorder[i+1][j+1]==a) and (gameBorder[i][j]==a) and (gameBorder[i+1][j-1]==a))){
                    println("Победа")
                    statusGame=1
                }
            }
        }
    }
    return statusGame

}
fun editGameBoard(a : String, b : String,gameBorder: Array<Array<String>>, N: Int) : Int{
    val delim=" "
    val arr = Pattern.compile(delim).split(a)
    gameBorder[arr[1].toInt()-1][arr[0].toInt()-1]=b
    printGameBorder(gameBorder,N)
    val winnerGame=statusGame(gameBorder, b,N)
    return winnerGame
}
fun main(args: Array<String>) {
    var actionPlayer=0
    var winnerGame=0
    print("Введите размерность поля:")
    val N = readLine().toString().toInt()
    val gameBorder=createGameBorder(N)
    printGameBorder(gameBorder,N)


    while(winnerGame==0){
        print("Введите позицию:")
        val a = readLine().toString()
        if(actionPlayer==0) {
            winnerGame=editGameBoard(a,"x",gameBorder,N)
            actionPlayer=1
            if(winnerGame==1){
                print("Победил игрок X")
            }
        }
        else{
            winnerGame=editGameBoard(a,"o",gameBorder,N)
            actionPlayer=0
            if(winnerGame==1){
                print("Победил игрок O")
            }
        }
    }
}