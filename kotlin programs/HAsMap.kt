import java.util.HashMap

fun main()
{
    var a= HashMap<Int,String>()
    a.put(1,"ab")
    a.put(2,"cd")
    a.put(3,"ef")
    a.put(4,"gh")
    println(a)
    a.remove(3)
    println(a)
}

