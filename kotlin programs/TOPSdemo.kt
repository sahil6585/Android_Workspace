import java.io.FileOutputStream

fun main()
{
    println("Enetr a name")
    var name= readLine()!!.toString()

    println("Enetr a surname")
    var surname= readLine()!!.toString()

    println("Enetr a email")
    var email= readLine()!!.toString()

    var fout=FileOutputStream("E://Sahil.txt")


    fout.write(name.toByteArray())

    fout.write(surname.toByteArray())

    fout.write(email.toByteArray())

    println("success")

}