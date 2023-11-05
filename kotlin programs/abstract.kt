abstract class ex
{
    abstract fun abs()
}
class ex1 : ex()
{
    override fun abs ()
    {
        println("ABSTRACT CLASS")
    }
}
fun main()
{
    var e=ex1()
    e.abs()
}