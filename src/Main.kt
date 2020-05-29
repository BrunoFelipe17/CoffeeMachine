package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)

    do {
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = scanner.nextLine()
        coffeeMachine.nextStep(action)
    } while (action != "exit")
}

class CoffeeMachine(var water: Int, var milk: Int, var coffeeBeans: Int, var disposableCups: Int, var money: Int) {

    private fun printState() {
        println("""
            The coffee machine has:
            $water of water
            $milk of milk
            $coffeeBeans of coffee beans
            $disposableCups of disposable cups
            $$money of money
        """.trimIndent())
    }

    fun nextStep(action: String) {
        when (action) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printState()
        }
    }

    private fun take() {
        print("I gave you $${this.money}")
        this.money = 0
    }

    private fun fill() {
        val scanner = Scanner(System.`in`)

        print("Write how many ml of water do you want to add: ")
        val water = scanner.nextInt()

        print("Write how many ml of milk do you want to add: ")
        val milk = scanner.nextInt()

        print("Write how many grams of coffee beans do you want to add: ")
        val coffeeBeans = scanner.nextInt()

        print("Write how many disposable cups of coffee do you want to add: ")
        val disposableCups = scanner.nextInt()

        this.water += water
        this.milk += milk
        this.coffeeBeans += coffeeBeans
        this.disposableCups += disposableCups
    }

    private fun buy() {
        val scanner = Scanner(System.`in`)
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val flavor = scanner.nextLine()

        when (flavor) {
            "1" -> {
                if (this.water >= 250 && this.coffeeBeans >= 16) {
                    println("I have enough resources, making you a coffee!")
                    this.money += 4
                    this.water -= 250
                    this.coffeeBeans -= 16
                    this.disposableCups -= 1
                } else {
                    if (this.water < 250) {
                        println("Sorry, not enough water!")
                    } else if (this.coffeeBeans < 16) {
                        println("Sorry, not enough coffee beans!")
                    }
                }
            }
            "2" -> {
                if (this.water >= 350 && this.milk >= 75 && this.coffeeBeans >= 20) {
                    println("I have enough resources, making you a coffee!")
                    this.money += 7
                    this.water -= 350
                    this.milk -= 75
                    this.coffeeBeans -= 20
                    this.disposableCups -= 1
                } else {
                    if (this.water < 350) {
                        println("Sorry, not enough water!")
                    } else if (this.milk < 75) {
                        println("Sorry, not enough milk!")
                    }  else if (this.coffeeBeans < 16) {
                        println("Sorry, not enough coffee beans!")
                    }
                }
            }
            "3" -> {
                if (this.water >= 200 && this.milk >= 100 && this.coffeeBeans >= 12) {
                    println("I have enough resources, making you a coffee!")
                    this.money += 6
                    this.water -= 200
                    this.milk -= 100
                    this.coffeeBeans -= 12
                    this.disposableCups -= 1
                } else {
                    if (this.water < 250) {
                        println("Sorry, not enough water!")
                    } else if (this.milk < 100) {
                        println("Sorry, not enough milk!")
                    }  else if (this.coffeeBeans < 12) {
                        println("Sorry, not enough coffee beans!")
                    }
                }
            }
        }
    }
}