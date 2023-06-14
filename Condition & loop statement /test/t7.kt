fun main()
{
    println("Enter marks of subject_1 : ")
    var s1= readLine()!!.toInt()
    println("Enter marks of subject_2 : ")
    var s2= readLine()!!.toInt()
    println("Enter marks of subject_3 : ")
    var s3= readLine()!!.toInt()
    println("Enter marks of subject_4 : ")
    var s4= readLine()!!.toInt()
    println("Enter marks of subject_5 : ")
    var s5= readLine()!!.toInt()

    var total=s1+s2+s3+s4+s5

    var per=total/5.toFloat()

    println("TOTAL = $total")
    println("PERCENTAGE = $per")



}