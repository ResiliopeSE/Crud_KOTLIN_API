package com.example.crud_prueba.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crud_prueba.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, signUpViewModel: SignUpViewModel = viewModel()) {
    // Observamos los cambios en los campos del ViewModel
    val name by signUpViewModel.name.collectAsState()
    val email by signUpViewModel.email.collectAsState()
    val password by signUpViewModel.password.collectAsState()
    val confirmPassword by signUpViewModel.confirmPassword.collectAsState()

    // Diseño de la pantalla de SignUp
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Registrarse", modifier = Modifier.padding(bottom = 16.dp))

        // Campo de nombre
        OutlinedTextField(
            value = name,
            onValueChange = { signUpViewModel.onNameChange(it) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de email
        OutlinedTextField(
            value = email,
            onValueChange = { signUpViewModel.onEmailChange(it) },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { signUpViewModel.onPasswordChange(it) },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de confirmación de contraseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { signUpViewModel.onConfirmPasswordChange(it) },
            label = { Text("Confirmar Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de registro
        Button(
            onClick = { signUpViewModel.signUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Registrarse")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
