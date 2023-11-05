open class Clg
{
    fun A()
    {
        println("Clg class")
    }
}
class Facluty : Clg()
{
    fun B()
    {
        println("Faculty class")
    }
}
class Student : Clg()
{
    fun C()
    {
        println("Student class")
    }
}
fun main()
{
    var f = Facluty()
    var s = Student()
    f.B()
    f.A()
    s.C()
    s.A()


}
