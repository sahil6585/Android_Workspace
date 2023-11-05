fun main()
{
    println("enter number : ")
    var num= readLine()!!.toInt()

    var a=2
    var b=0
    while (a<=num/2)
    {
        if (num%a == 0)
        {
            println("NOT A PRIME NUMBER")
            b = 1

        }
        a++
    }
    if (b==0)
        {
            println("PRIME NUMBER")
        }
}