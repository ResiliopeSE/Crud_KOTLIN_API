package com.example.crud_prueba.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud_prueba.model.User
import com.example.crud_prueba.model.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _userState = MutableStateFlow<User?>(null)
    val userState: StateFlow<User?> = _userState

    init {
        fetchUser()  // Llamamos a fetchUser al inicializar el ViewModel
    }

    fun fetchUser() {
        // Usamos el repositorio para obtener los datos del usuario
        _userState.value = userRepository.getUser()
    }
}