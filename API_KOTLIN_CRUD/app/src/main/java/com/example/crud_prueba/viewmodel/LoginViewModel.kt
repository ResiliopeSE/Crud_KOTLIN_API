package com.example.crud_prueba.viewmodel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    // Para almacenar el email y la contraseña
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    // Para validar si los datos son correctos (más adelante se puede conectar con la API)
    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login() {
        // Lógica para manejar el login más adelante
        // Por ahora podemos solo validar si los campos no están vacíos
        if (_email.value.isNotEmpty() && _password.value.isNotEmpty()) {
            // Aquí iría la lógica para autenticar con la API
            println("Login exitoso con email: ${_email.value}")
        } else {
            println("Por favor ingrese ambos campos")
        }
    }
}