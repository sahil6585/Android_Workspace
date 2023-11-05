import java.io.DataInputStream
import java.io.FileWriter

fun main()
{
    var dis = DataInputStream(System.`in`)

    var fw=FileWriter("E://FileWriter.txt")
    var ch :Char
    println("Enter string : ")
    do
    {
        ch=dis.read().toChar()

        if (ch== '$')
        {
            break
        }
        fw.write(ch.toInt())



    }while (true)
fw.close()

}