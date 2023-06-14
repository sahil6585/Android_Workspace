fun main()
{
    println("Enter number 1 : ")
    var num1= readLine()!!.toInt()
    println("Enter number 2 : ")
    var num2= readLine()!!.toInt()

    var add= num1+num2
    var sub= num1-num2
    var mul= num1*num2
    var div= num1/num2

    println("addition = $add")
    println("substraction = $sub")
    println("Multiplication = $mul")
    println("Division = $div")

}