class bike:Thread()
{
    fun z1( a : Int)
   {
       for (i in a..5)
       { println(i)}

       for (i in 6 downTo  a)
       { println(i)}
   }
}
class car(var bi : bike,var a: Int):Thread()
{
     override fun run()
    {
        synchronized(bi)
        {
            bi.z1(a)
        }
    }
}
fun main()
{
  var bi=bike()

    var a1=car(bi,1)

    a1.start()
}