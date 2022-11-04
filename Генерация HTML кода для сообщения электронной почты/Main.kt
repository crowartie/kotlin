import java.io.PrintWriter

data class Message(val sender:String?, val recipient:String?, val topic:String?, val message:String?){
    fun toHTML():String {
        val HTMLCode =  "<html>\n"+
                        "\t<head>\n"+
                        "\t\t<link rel=\"stylesheet\" href=\"style.css\">\n"+
                        "\t</head>\n"+
                        "\t<body>\n"+
                        "\t\t<table>\n"+
                        when(sender){
                            null->sender.let{"\t\t\t<tr><td class=\"nameRow\">Отправитель:</td><td></td></tr>\n"}
                            else->sender.let{"\t\t\t<tr><td class=\"nameRow\">Отправитель:</td><td>$it</td></tr>\n"}
                        }+
                        when(recipient){
                            null->recipient.let{"\t\t\t<tr><td class=\"nameRow\">Получатель:</td><td></td></tr>\n"}
                            else->recipient.let{"\t\t\t<tr><td class=\"nameRow\">Получатель:</td><td>$it</td></tr>\n"}
                        }+
                        when(topic){
                            null->topic.let{"\t\t\t<tr><td class=\"nameRow\">Тема:</td><td></td></tr>\n"}
                            else->topic.let{"\t\t\t<tr><td class=\"nameRow\">Тема:</td><td>$it</td></tr>\n"}
                        }+
                        when(message){
                            null->message.let{"\t\t\t<tr><td class=\"nameRow\">Сообщение:</td><td></td></tr>\n"}
                            else->message.let{"\t\t\t<tr><td class=\"nameRow\">Сообщение:</td><td>$it</td></tr>\n"}
                        }+
                        "\t\t</table>\n"+
                        "\t</body>\n"+
                        "</html>"

        val writerHTML=PrintWriter("index.html")
        writerHTML.append(HTMLCode)
        writerHTML.close()
        return HTMLCode
    }
    fun toStyle():String{
        val style=  "table{\n"+
                    "\tborder:2px solid black;\n"+
                    "\tborder-collapse:collapse;\n"+
                    "\tfont-size:24px;\n"+
                    "}\n"+
                    "td{\n"+
                    "\tborder:1px solid black;\n"+
                    "\ttext-align:center;\n"+
                    "}\n"+
                    ".nameRow{\n"+
                    "\ttext-align:left;\n"+
                    "\tbackground-color: #E6E6E0;\n"+
                    "}"
        val writerStyleHTML=PrintWriter("style.css")
        writerStyleHTML.append(style)
        writerStyleHTML.close()
        return style
    }
}





fun main(){

    val mes=Message("sender@mail.ru","recipiend@mail.ru",null,"Как дела?")
    println(mes.toHTML())
    println(mes.toStyle())
}