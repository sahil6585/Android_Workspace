//write a program you have to print the table of given number.

fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()

    var i=1

    for (i in i..10)
    {
        var a= n * i
        
        println("$n * $i = $a ")
    }

}
