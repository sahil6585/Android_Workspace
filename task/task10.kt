//write a program you have to make a summation of first and last Digit. (E.g. 1234 ans:-5)

fun main()
{
    println("Enter a number")
    var n= readLine()!!.toInt()

   var l_digit=0
   var sum=0

   l_digit=n%10
    sum=(sum*10)+l_digit

    while(n>0)
    {
        if (n>9)
        {
            n=n/10
        }
        else
        {
            l_digit=n
            sum=sum+l_digit
            n=n/10
        }


    }
    println("$sum")

}