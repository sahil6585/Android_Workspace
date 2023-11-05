interface a1
{
    fun a()
    {
        println("First Interface")
    }
}
interface b1
{
    fun b()
    {
        println("second Interface")
    }
}
class Main : a1,b1
{
    fun c()
    {
        println("main class")
    }
}

fun main()
{
    var c = Main()
    c.a()
    c.c()
    c.b()
}