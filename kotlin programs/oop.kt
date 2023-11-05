

//create object
/*
class sahil
{
    var contact=""
    var name=""

}


fun main()
{
    var s=sahil()
    s.contact="7046434446"
    s.name="sahil"

    println( "${s.contact}___${s.name}")
}

 */
//-----------------------------------------------------------

//constructor 1 primary con
/*
class sahil(var name:String , var id:Int)
{
    fun display()
    {
        println("$name ____$id")
    }

}
fun main()
{
    var s=sahil("sahil",39)

    s.display()

}
*/

//----------------------------------------------------------

//constructor 2 secondary con

/*
class sahil
{
    constructor( m1:Int)
    {
        var a=m1
        println(a)
    }
    constructor(m1:Int,m2:Int)
    {
        var b=m1+m2
        println(b)
    }
    constructor(m1:Int,m2:Int,m3:Int)
    {
        var c=m1+m2-m3
        println(c)
    }
}


fun main()
{
    var s=sahil(25,25)
    var s1=sahil(1,)
    var s2=sahil(25,25,20)
    var s3=sahil(25,25)
}
*/

//----------------------------------------------------

//companion object (static)
/*
class Sahil(var id:Int,var name:String)
{
    companion object
    {
        var clg:String="marwadi"

    }

    fun display()
    {
        println("$id--------$name--------$clg")
    }

}

fun main()
{
    var s=Sahil(39,"sahil")
    var s2=Sahil(40,"jayraj")

    s.display()
    s2.display()
}
*/
//------------------------------------------------------

//constructor and companion object

class Sahil
{
    companion object
    {
        var count=0
    }

    constructor(id:Int,name:String)
    {
        count++
        println("$count :  $id   $name ")
    }
}



fun main()
{
    var s1=Sahil(11,"sahil")
    var s2=Sahil(12,"jayraj")
    var s3=Sahil(13,"ashish")
    var s4=Sahil(14,"jaimin")
    var s5=Sahil(15,"yaksh")
    var s6=Sahil(16,"nilesh")

}























