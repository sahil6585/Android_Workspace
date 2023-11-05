
data class Data(var name:String,var id:Int)
{

}

fun main()
{
    var D1=Data("Sahil",39)
    var D2=Data("Jaimin",45)


    println(D1)
    println(D2)

    var D3=D2.copy()
    println(D3)
   println()


}