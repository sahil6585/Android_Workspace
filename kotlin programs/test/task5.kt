//Write a program you have to print the Fibonacci series up to user given number

fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()

    var a=0
    var b=1
    var fib=0

    while (n>0)
    {
        println("$fib")
        fib=a+b
        a=b
        b=fib
        n--

    }
}
