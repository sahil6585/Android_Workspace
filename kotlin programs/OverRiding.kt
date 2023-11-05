
open class OverRinding1
{
   open fun mark():Int
    {
        return 0
    }
}

class Marwadi : OverRinding1()
{
   override fun mark():Int
    {
        return 73
    }
}

class Atmiya: OverRinding1()
{
    override fun mark():Int
    {
        return 56
    }
}

class Darshan : OverRinding1()
{
    override fun mark():Int
    {
        return 98
    }
}

fun main()
{
 var O1 = OverRinding1 ()
    println(O1.mark())

    O1=Marwadi()
    println(O1.mark())

    O1=Atmiya()
    println(O1.mark())

    O1=Darshan()
    println(O1.mark())


}
