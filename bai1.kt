import kotlin.math.PI

fun main() {

    // ===== Dice game =====
    val luckyNumber = 4
    val rollResult = (1..6).random()
    println("Số may mắn: $luckyNumber")
    println("Số quay được: $rollResult")

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! You rolled a 6. Try again!")
    }

    printBorder("=", 20)
    val dice = Dice(6)
    println("Random: ${dice.roll()}")

    // ===== OOP =====
    val tron = NhaTron(20.4)
    val vuong = NhaVuong(19.2)
    val nhaTang = NhaTang(8.7, 4)

    println("Diện tích nhà tròn: ${tron.dienTich()}")
    println("Diện tích nhà vuông: ${vuong.dienTich()}")
    println("Diện tích nhà tầng: ${nhaTang.dienTich()}")

    // ===== List =====
    println("=========== MẢNG ===========")
    val mang = listOf(1, 2, 3, 4, 6)
    println("Kích thước mảng: ${mang.size}")

    print("For: ")
    for (e in mang) print(e)

    println()
    print("While: ")
    var i = 0
    while (i < mang.size) {
        print(mang[i])
        i++
    }
    println()

    // ===== String =====
    val name = "Android"
    println("$name có ${name.length} ký tự")

    // ===== Set & Map =====
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("Set: ${numbers.toSet()}")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Giao: ${set1.intersect(set2)}")
    println("Hợp: ${set1.union(set2)}")

    val peopleAges = mutableMapOf("Fred" to 30, "Ann" to 23)
    peopleAges["Barbara"] = 42
    peopleAges["Joe"] = 51

    peopleAges.forEach { println("${it.key} is ${it.value}") }

    // ===== Lambda =====
    val triple: (Int) -> Int = { it * 3 }
    println("Triple(5) = ${triple(5)}")

    // ===== Null safety =====
    var quantity: Int? = null
    println("Elvis: ${quantity ?: 0}")
    quantity = 4
    println("Elvis: ${quantity ?: 0}")

    // ===== Backing property =====
    val example = ExampleProperty()
    println("Backing property: ${example.currentWord}")

    // ===== Function delay =====
    val output = getValue()
    println("getValue(): $output")
}

// ===== Functions & Classes =====

fun printBorder(border: String, times: Int) {
    repeat(times) { print(border) }
    println()
}

class Dice(private val number: Int) {
    fun roll(): Int = (1..number).random()
}

abstract class NoiO {
    abstract val vatLieu: String
    abstract fun dienTich(): Double
}

open class NhaTron(private val radius: Double) : NoiO() {
    override val vatLieu = "Xi măng"
    override fun dienTich(): Double = PI * radius * radius
}

class NhaTang(radius: Double, private val soTang: Int) : NhaTron(radius) {
    override fun dienTich(): Double = super.dienTich() * soTang
}

class NhaVuong(private val width: Double) : NoiO() {
    override val vatLieu = "Sắt"
    override fun dienTich(): Double = width * width
}

class ExampleProperty {
    private var _currentWord = "test"
    val currentWord: String
        get() = _currentWord
}

fun getValue(): Double {
    Thread.sleep(1000)
    return 42.0
}
