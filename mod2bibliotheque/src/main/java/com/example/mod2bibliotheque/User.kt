package com.example.mod2bibliotheque

class User(val name : String, id : Int) {
    val borrowItems = mutableListOf<Item>()


    fun borrow(item: Item){
        if(item is Borrowable && item.borrow(this) ){
            borrowItems.add(item)
        }
    }
    fun returnItem(item : Item){
        if(item is Borrowable){
            item.returnItem(this)
            borrowItems.remove(item)
        }
    }
}
