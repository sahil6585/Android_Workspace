import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{
    println("Enter a name ")
    var n= readLine()!!.toString()

    println("Enter a surname ")
    var s= readLine()!!.toString()


    var a1=A1(n,s)
    var file = FileOutputStream("D://android//LoginPogram.txt")
    var obj= ObjectOutputStream(file)
    obj.writeObject(a1)

    /*   println("Enter a email ")
       var e= readLine()!!.toString()

       println("Enter a password ")
       var p= readLine()!!.toString()

       println("Enter a conf_password ")
       var cp= readLine()!!.toString()

      if (p == cp)
      {
          var file = FileOutputStream("D://android//LoginPogram.txt")

          var n1 = "\n Enter a name : "
          var s1 = "\n Enter a surname : "
          var e1 = "\n Enter a email : "
          var p1 = "\n Enter a password : "
          var cp1 = "\n Enter a conf_password : "

          file.write(n1.toByteArray())
          file.write(n.toByteArray())

          file.write(s1.toByteArray())
          file.write(s.toByteArray())

          file.write(e1.toByteArray())
          file.write(e.toByteArray())

          file.write(p1.toByteArray())
          file.write(p.toByteArray())

          file.write(cp1.toByteArray())
          file.write(cp.toByteArray())

          println("success")
      }
       else
       {
           println("Both Password are not same")

       }*/
}