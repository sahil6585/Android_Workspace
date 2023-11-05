fun main()
{
    var c= ArrayList<String>()
    c.add("a")
    c.add("b")

    var c2= ArrayList<String>()
    c2.add("c")
    c2.add("d")
    c.addAll(c2)

    println(c)

    var i:Iterator<String> = c.iterator()

    while (i.hasNext())
    {
        println(i.next())
    }


}