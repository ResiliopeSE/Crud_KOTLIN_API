package com.example.crud_prueba.model

class UserRepository {
    // Aquí podrías hacer llamadas a una API o manejar una base de datos local
    fun getUser(): User {
        return User(1, "Juan Pérez", "juan.perez@example.com")
    }
}
