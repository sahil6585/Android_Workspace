import java.io.FileReader

fun main()
{
    var fr=FileReader("E://FileWriter.txt")

    var ch:String=""
    var data:Int=ch.length
    for (i in 1..data)
    {
        ch=fr.readText()
        println(ch)
    }
    fr.close()
}