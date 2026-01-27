package com.example.lib.bai1

fun main(){
    // Define the function.
    fun printHello(){
        println("Hello, Hua Cong An")
    }
    // Call the function.
    printHello()

    fun printBorder(border: String, timesToRepeat: Int) {
        repeat(timesToRepeat) {
            print(border)
        }
        println()
    }
    printBorder("*", 10)
    printBorder("-", 20)

    fun roll() : Int {
        val randomNumber = (1..1609).random()
        return randomNumber
    }
    println("Random Numbers ${roll()}")
}