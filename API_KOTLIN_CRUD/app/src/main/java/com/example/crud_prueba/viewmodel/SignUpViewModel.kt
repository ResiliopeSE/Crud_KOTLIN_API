package com.example.crud_prueba.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignUpViewModel : ViewModel() {
    // Para almacenar los datos del formulario
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword

    // Actualiza los valores cuando el usuario cambia los datos
    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        _confirmPassword.value = newConfirmPassword
    }

    // Función para manejar el registro (lógica de validación y conexión con la API más adelante)
    fun signUp() {
        if (_name.value.isNotEmpty() && _email.value.isNotEmpty() && _password.value.isNotEmpty() && _password.value == _confirmPassword.value) {
            // Aquí iría la lógica para conectarse a la API más adelante
            println("Registro exitoso con email: ${_email.value}")
        } else {
            println("Por favor complete todos los campos y asegúrese de que las contraseñas coincidan")
        }
    }
}
