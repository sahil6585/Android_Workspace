//Write a program you have to print the Fibonacci series up to user given number

fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()
    var a=0
    var b=0

    while(n>0)
    {
        b=n%10
        if (b>a)
        {
            a=b
        }
        n=n/10
    }
    println(a)
}