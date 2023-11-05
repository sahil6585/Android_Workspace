import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var In=ObjectInputStream(FileInputStream("D://example.txt"))
    var c:class1= In.readObject() as class1

    println("${c.name},${c.num}")
}