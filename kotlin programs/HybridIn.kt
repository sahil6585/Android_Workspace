open class First
{
    fun f()
    {
        println("First class")

    }
}
interface Second
{
    fun s()
    {
        println("Second interface")

    }
}
class Third : First() , Second
{
    fun t()
    {
        println("Thrid class")

    }
}

fun main()
{
    var t1 = Third()
    t1.t()
    t1.f()
    t1.s()
}