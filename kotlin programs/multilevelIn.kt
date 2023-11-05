open class A
{
    fun a1()
    {
        println("First class")
    }
}
open class B : A()
{
    fun b1()
    {
        println("Second class")
    }
}
class C : B()
{
    fun c1()
    {
        println("Third class")
    }
}
fun main()
{
    var c1 = C()
    c1.a1()
    c1.b1()
    c1.c1()
}

