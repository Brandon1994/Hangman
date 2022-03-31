package com.hangman.main

var template = ""
var mistakes = 0
var wordToBeGuessed = ""
var remainingGuesses = 6

val words = listOf("BANANA", "COELHO", "GATO", "RATO", "CACHORRO", "LARANJA")

fun main(){
    var shot: Char

    gameSetup()
    template = getInitialTemplate()
    do {
        if(wordToBeGuessed == template){
            printGameStatus()
            printCongratsMessage()
            break
        }
        shot = askForShot()
        checkTheShot(shot)
    } while (remainingGuesses != 0)
}

fun getInitialTemplate():String{
    var template = ""
    for(i:Int in 1 .. wordToBeGuessed.length){
        template+="_"
    }
    return template
}

fun askForShot():Char{
    println("Digite uma letra")
    val input = readLine()?:""
    return input.first().uppercaseChar()
}

fun getUpdatedTemplate(shot:Char) : String{
    var index = wordToBeGuessed.indexOf(shot)
    while (index != -1) {
        template = template.substring(0, index) + shot + template.substring(index + 1)
        index = wordToBeGuessed.indexOf(shot, index + 1)
    }

    return template
}

fun checkTheShot(shot: Char){
    if(!wordToBeGuessed.contains(shot)){
        mistakes ++
        remainingGuesses --
    }
    printGameStatus(shot)
}

fun printCongratsMessage(){
    println("Acertou a palavra, você é fera")
}

fun printGameStatus(shot: Char = '0'){
    when(mistakes){
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }
    if(mistakes!=6){
        print("Word: ${getUpdatedTemplate(shot)}")
        println("\n Você ainda tem $remainingGuesses tentativas")
    } else {
        println("Caiu na forca, que pena, a palavra era $wordToBeGuessed")
    }
}

fun gameSetup(){
    wordToBeGuessed = words.random()
}

fun print0Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\      ")
}
fun print1Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\      ")
}
fun print2Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print3Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print4Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print5Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}
fun print6Mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     / \\ ")
    println(" /|\\      ")
    println("/ | \\     ")
}