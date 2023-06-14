fun main()
{
    println("Enter value of Principle :")
    var p= readLine()!!.toInt()
    println("Enter value of rate of interest : ")
    var r= readLine()!!.toFloat()
    println("Enter value of number of interest : ")
    var n= readLine()!!.toInt()

    var SI = ((p*r*n)/100).toFloat()

    println("Simple Interest : $SI")

}