 class T1:Thread()
{
     override fun run()
    {
        for (i in 1..10)
            println(i)
    }

}
class T2 : Thread()
{
    override fun run()
    {
       for (i in 11..20)
           println(i)
    }
}

fun main()
{
    var t1=T1()
    var t2=T2()

    t1.start()
    t2.start()
}