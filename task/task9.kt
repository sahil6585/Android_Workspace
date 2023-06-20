//Write a program make a summation of given number(E.g. 1523 ans :-11)

fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()

    var a=0

    while (n>0)
    {
        a=a+n%10
        n=n/10
    }
    println(a)
}