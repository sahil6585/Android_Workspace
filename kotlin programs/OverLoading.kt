class sum
{
    fun s1(a: Int):Int
    {
        return a
    }
    fun s1(a: Int,b:Int):Int
    {
        return a+b
    }
    fun s1(a: Int,b:Int,c:Int):Int
    {
        return a+b+c
    }
}

fun main()
{
    var s =sum()
    println(s.s1(1,3))
    println( s.s1(1,))
    println( s.s1(1,3,1))
}