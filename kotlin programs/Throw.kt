fun main()
{
    println("Enter age")
    var age= readLine()!!.toInt()

    if (age>=18)
    {
        println("You are Eligible for vote")
    }
    else
    {
        throw Exception("not Eligible")
    }
}