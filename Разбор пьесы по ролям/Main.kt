import java.io.File
fun checkingTheFile(file: File){
    if(file.exists()){
        println("Файл существует")
    }
    else{
        println("Файл не существует")
    }
}

fun saveRoles(arrayFile:List<String>): List<String> {
    val roles = arrayListOf<String>()
    for (i in arrayFile.indices) {
        if ((arrayFile[i] != "roles:") and (arrayFile[i] != "textLines:")) {
            roles.add(arrayFile[i])
        } else if (arrayFile[i] == "textLines:") {
            break
        }
    }
    return roles
}

fun saveTextRoles(arrayFile:List<String>): List<String>{
    val textRoles = arrayListOf<String>()
    for (i in arrayFile.indices){
        if((arrayFile[i] != "roles:") and (arrayFile[i] != "textLines:")){
            for(j in arrayFile[i].indices) {
                if (arrayFile[i][j] == ':') {
                    textRoles.add(arrayFile[i])
                    break

                }
            }
        }
    }
    return(textRoles)
}

fun printTextsRole(roles:List<String>,textRoles:List<String>){
    for(i in roles.indices){
        println(roles[i]+":")
        for(j in textRoles.indices){
            if(textRoles[j].startsWith(roles[i] + ":")){
                println("   "+(j+1)+")"+textRoles[j].replaceFirst(roles[i] + ": ", ""))
            }
        }
    }
}

fun main(args: Array<String>) {
    val file  = File("piesa.txt")
    checkingTheFile(file)
    val arrayFile: List<String> = file.readLines()
    val roles = saveRoles(arrayFile)
    val textRoles=saveTextRoles(arrayFile)
    printTextsRole(roles,textRoles)
}