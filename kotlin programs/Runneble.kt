class cl1:Runnable
{
    override fun run()
    {
        for (i in 1..10)
            println(i)
    }

}
class cl2 : Runnable
{
    override fun run()
    {
        for (i in 11..20)
            println(i)
    }
}

fun main()
{
   var c1=Thread(cl1())
    var c2=Thread(cl2())

    c1.start()
    c2.start()

}