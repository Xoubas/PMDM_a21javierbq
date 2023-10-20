import kotlin.math.max

fun main(args: Array<String>){
    var array1 = arrayOf(1,2,3,4,5)
    var array2 = IntArray(5,{3})
    for(ar in array2) println(ar)

    array1.first()
    array1.last()

    for(i in 0..array2.size-1) println(array2[i])

    var listaPlanetas = mutableListOf("Mercurio", "Marte", "Venus")
    println(listaPlanetas)

    listaPlanetas.add("Júpiter")

    //Listas vacías
    var listaCosas: MutableList<String> = mutableListOf()
    listaCosas.add("Marte")
    println(listaCosas.maxOrNull() ?: "vacía")
    println(listaCosas.maxOrNull() ?: "vacía")
}

fun maxLength(lista: MutableList<String>): Int{
    var len = 0
    lista.forEach{len= max(len,it.length)}
    return len
}