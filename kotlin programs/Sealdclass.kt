open class Phone()
{
    fun p()
    {
        println("phone class")
    }
    class Samsung():Phone()
    {
        fun s()
        {
            println("Samsung class")
        }
    }
    class Mi():Phone()
    {
        fun m()
        {
            println("Mi class")
        }
    }
}

fun main()
{
    var p1=Phone.Mi()

    p1.p()
    p1.m()

    Phone.Samsung().s()
}