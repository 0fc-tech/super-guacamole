package com.example.mod2filmserie

const val FLAG_RETRY = -1
val mapFilm = mutableMapOf<String,Boolean>()
var userInput = 4
fun main() {
    do{
        printMenu()
        userInput = readln().toIntOrNull() ?: FLAG_RETRY
        when(userInput){
            1 -> ajouterFilmSerie(true)
            2 -> ajouterFilmSerie(false)
            3 -> voirListe()
            else -> println("⚠ Votre choix est impossible. Réessayez !⚠")
        }
    }while (userInput != 4)
    println("Merci d'avoir utilisé BFS (Bibliothèque Film Série)")
}
fun printMenu(){
    println("Choisissez")
    println("1 - Ajouter film/série déjà vu")
    println("2 - Ajouter film/série à voir")
    println("3 - Voir toute la liste")
    println("4 - Exit")
}
fun ajouterFilmSerie(dejaVu : Boolean): Unit {
    println("Nom film/série")
    mapFilm[readln()] = dejaVu
}
fun voirListe(): Unit {
    mapFilm.forEach {filmSerie->
        val labelVuDejaVu = if(filmSerie.value) " a déjà été vu" else "à voir"
        println("${filmSerie.key} : $labelVuDejaVu")
    }
}