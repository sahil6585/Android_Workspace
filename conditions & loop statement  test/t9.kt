fun main()
{
    println("Enter a Year : ")
    var y= readLine()!!.toInt()

    if (y%4==0)
    {
        println("$y is Leap year")
    }
    else
    {
        println("$y is not Leap year")

    }

}