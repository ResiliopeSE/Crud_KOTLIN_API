package com.example.crud_prueba.view
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crud_prueba.model.UserRepository
import com.example.crud_prueba.ui.LoginScreen
import com.example.crud_prueba.viewmodel.UserViewModel
import com.example.crud_prueba.viewmodel.UserViewModelFactory


@Composable
fun UserScreen(userRepository: UserRepository) {
    // Crea una instancia de la fábrica del ViewModel
    val viewModelFactory = UserViewModelFactory(userRepository)

    // Usa la fábrica para obtener el ViewModel
    val userViewModel: UserViewModel = viewModel(factory = viewModelFactory)

    val user by userViewModel.userState.collectAsState()

    Column {
        user?.let {
            Text(text = "Nombre: ${it.name}")
            Text(text = "Email: ${it.email}")
        } ?: Text(text = "Cargando...")
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    // Proveer dependencias falsas o simuladas para el preview
    val mockRepository = UserRepository() // Crea una instancia ficticia o simulada
    UserScreen(userRepository = mockRepository)
}