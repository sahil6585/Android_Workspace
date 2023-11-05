//with perameter with return type
/*
fun add(a:Int,b:Int):Int
{
    return a+b
}

fun main()
{
   println(add(5,6))
}*/

//--------------------------------------------------

//with perameter without return type
/*
fun add(a:Int, b:Int)
{
    var c=a+b
    println(c)
}

fun main()
{
    add(6,7)
}
*/

//------------------------------------------------
//with return type without perameter

/*fun add():Int
{
    var a=7
    var b=8
    var c=a+b
    return c

}
fun main()
{
    println(add())
}*/

//--------------------------------------------------
//without perameter without returntype
/*
fun add()
{
    var a=8
    var b=9
    var c=a+b
    println(c)

}

fun main()
{
    add()
}*/

//--------------------------------------------------
// INBUILT NAMED FUNCTION
/*
fun info(name: String, lastname: String, contact: Long)
{
    println("$name,$lastname,$contact")
}

fun main()
{
    info("sahil","jagani",7046434446)
    info(lastname ="jagani", contact =7069793454, name ="jaimin")
}*/

//------------------------------------------------------------

//INBUILT EXTENTION FUNCTION

class C1
{
    fun hasPass(marks1 : Int,marks2: Int) : Boolean
    {
        return marks1>40 && marks2>40
    }
}

fun C1.Grade(marks1: Int,marks2:Int):Boolean
{
    return marks1>75 && marks2>75
}

fun main()
{
    var a=C1()
    println(a.hasPass(65,41))
    println(a.Grade(65,78))

}


//---------------------------------------------
//INBUILT INFIX FUNCTION
/*
class C1
{
    fun hasPass(marks : Int) : Boolean
    {
        return marks>40
    }
}

infix fun C1.Grade(marks: Int):Boolean
{
    return marks>75
}

fun main()
{
    var a=C1()
    println(a.hasPass(65))
    println(a.Grade(65))

}
*/