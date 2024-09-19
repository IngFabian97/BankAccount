package org.example

import jdk.jfr.DataAmount

fun main() {

    var accountType: String = ""
    var userChoice: Int = 0

    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    while (accountType == ""){
        println("Choose an option (1,2 or 3)")
        userChoice = readln().toInt()
        println("The selected option is...$userChoice")

        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue
        }

        println("You have created a $accountType account")
     }

    println("Enter account balance")
    var accountBalance: Int = readln().toInt()
    println("The current balance is $accountBalance dollars.")

    println("Enter the amount of money")
    val money: Int = readln().toInt()
    println("The amount you transferred is $money dollars.")

    var output = 0

    fun withdraw(ammount: Int): Int {
        accountBalance -= ammount
        println("You withdraw $ammount and have a balance of $accountBalance")
        return ammount
    }

    //Prueba operacion retiro cuentas generica y credito
    output = withdraw(money)
    println("The amount you withdrew is ${output} dollars.")

    fun debitWithdraw(amount: Int): Int{
        if (accountBalance == 0){
            println("Can't withdraw, no money on this account!")
            return  accountBalance
        }
        else if (amount > accountBalance){
            println("Not enough money on this account! The checking balance is ${accountBalance} dollars.")
            return 0
        }
        else{
            return withdraw(amount)
        }

    }

    //Prueba operacion retiro cuentas debito
    output = debitWithdraw(money)
    println("The amount you withdrew is ${output} dollars.")

    fun deposit(amount: Int): Int{
        accountBalance += amount
        println("You successfully deposited ${amount} dollars. The current balance is ${accountBalance} dollars.")
        return amount
    }

    output = deposit(money)
    println("The amount you deposited is ${output} dollars.")

    fun creditDeposit(amount: Int): Int{
        if(accountBalance == 0){
            println("This account is completely paid off! Do not deposit money!")
            return  accountBalance
        }

        else if(accountBalance + amount >0){
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is $accountBalance dollars")
            return 0
        }

        else if(amount == -accountBalance){
            accountBalance = 0
            println{"You have paid off this account!"}
            return amount
        }
        else{
            return deposit(amount)
        }
    }

    output = creditDeposit(money)
    println("The amount you deposited is ${output} dollars.")

    fun transfer(mode: String){
        val transferAmount: Int

        when(mode){
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = withdraw(money)
                }

                println("The amount you withdrew is ${transferAmount} dollars. ")
            }

            "deposit" -> {
                if (accountType == "credit") {
                    transferAmount = creditDeposit(money)
                } else {
                    transferAmount = deposit(money)
                }

                println("The amount you deposited is ${transferAmount} dollars.")
            }

            else-> return

        }
    }

    var isSystemOpen = true
    var option = 0

    while(isSystemOpen == true){
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the app")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = readln().toInt()
        println("The selected option is ${option}.")

        when(option){
            1 -> println("The current balance is ${accountBalance} dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen=false
                println("The system is closed")
                }
            else -> continue
        }
    }

}
