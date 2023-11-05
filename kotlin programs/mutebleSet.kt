fun main()
{
    var a = mutableSetOf(1,2,3,4,5,7,8,5,3)
    println(a)

    a.add(120)
    println(a)

    var i:Iterator<Int> = a.iterator()
    while (i.hasNext())
    {
        println(i.next())
    }
}