fun printGameBorder(border: Array<Array<String>>){
   for(i in border.indices){
      for(j in border[i].indices){
         print("${border[i][j]},")
      }
      println()
   }
}
fun main() {

   val border: Array<Array<String>> = Array(5,{Array(5,{"0"})})
   printGameBorder(border)
}
