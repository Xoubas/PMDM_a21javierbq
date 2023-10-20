fun isNumberDivisible(num:Int, div:Int)=num%div == 0

fun multiplicarNum(mult: Int=1, value:Int){
    println("$mult * $value = ${mult *value}")
}

//Sobrecarga de funciones
fun suma(operando1: Int, operando2: Int)= operando1 + operando2
fun resta(operando1: Int, operando2: Int)= operando1 - operando2
fun mult(operando1: Int, operando2: Int)= operando1 * operando2
//fun suma(operando1: String, operando2: String)= operando1 + operando2

fun main(){
    //println(suma(7,9))
    //println(suma("Hola","Adios"))
    //var miFuncion = ::suma

    var add = ::suma
    var sub = ::resta
    var operaciones = arrayOf(add, sub)

    for(op in operaciones) println(op(2,3))
}