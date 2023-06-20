//Write a program to print the number in reverse order.
fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()

    println("--reverse order--")


    for (a in n downTo 1)
    {
        println(a)
    }
}