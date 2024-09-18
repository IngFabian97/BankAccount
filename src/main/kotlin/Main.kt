package org.example

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
        userChoice = (1..5).random()
        println("The selected option is...$userChoice")

        when {
            userChoice <= 1 ->
                {
                    accountType = "debit"
                }
            userChoice <= 2 ->
                {
                    accountType = "credit"
                }
            userChoice <= 3 ->
                {
                    accountType = "checking"
                }
            else ->
                {
                    continue
                }
        }

        println("You have created a $accountType account")
     }


}
