import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var in1 = ObjectInputStream(FileInputStream("D://android//LoginPogram.txt"))
    var b:A1 = in1.readObject() as A1

    println("${b.name} & ${b.surname}")
}