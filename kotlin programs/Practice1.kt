import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun  main()
{
    var c1=class1("SAHIL JAGANI",39)
    var f1=FileOutputStream("D://example.txt")
    var o1=ObjectOutputStream(f1)
    o1.writeObject(c1)

    println("SUCCESSFULLY RUN")
}