
class excep {
    fun main()
    {
    try
    {
        var a = 10
        var b = 0

        var c = a / b
        println(c)
    }
    catch (e:Exception)
    {
     println(e)
    }
        finally
        {
            println("FINALLY BLOCK")
        }
    }
}

fun main()
{
    var ex=excep()
    ex.main()
}