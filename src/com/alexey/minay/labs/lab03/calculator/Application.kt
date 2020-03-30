package com.alexey.minay.labs.lab03.calculator

fun main(args: Array<String>) {

    val variableStorage = VariableStorage()
    var isResume = true
    println("Калькулятор запущен")
    println("Введите комнаду")
    while (isResume) {
        val input = readLine()
        val splittedInput = input?.split(" ")

        if (splittedInput == null || splittedInput.isEmpty()) {
            println("Некорректный ввод")
            continue
        }
        val command = splittedInput[0]
        val identifier = if (splittedInput.size == 2) splittedInput[1] else ""
        val splittedIdentifier = identifier.split("=")
        val variable = splittedIdentifier[0]
        val value = if (splittedIdentifier.size == 2) {
            splittedIdentifier[1]
        } else {
            ""
        }
        when (command.toLowerCase()) {
            "..." -> isResume = false
            "var" -> variableStorage.`var`(variable)
            "let" -> variableStorage.let(variable, value)
            "print" -> variableStorage.print(variable)
            "printvars" -> variableStorage.printVars()
            "printfns" -> variableStorage.printFns()
            "fn" -> variableStorage.fn(variable, value)
            else -> println("Некорректный ввод")
        }
    }
}