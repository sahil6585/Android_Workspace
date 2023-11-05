class Lamda()
{
    fun lam(a:Int,b:Int,sum:(Int) -> Unit)
    {
        var c=a+b
        sum(c)
    }
}
fun main()
{
    var l=Lamda()

    var lamda : (Int) -> Unit={a : Int -> println(a) }

    l.lam(7,8,lamda)

}
