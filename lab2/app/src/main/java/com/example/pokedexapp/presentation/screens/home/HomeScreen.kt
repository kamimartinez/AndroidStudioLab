package com.example.pokedexapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.pokedexapp.presentation.screens.home.components.PokemonListTab
import com.example.pokedexapp.presentation.screens.home.components.SearchTab

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(onPokemonClick: (String) -> Unit) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Pokémon List", "Search")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pokédex") },
            )
        },
    ) { padding ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(padding),
        ) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> PokemonListTab(onPokemonClick = onPokemonClick)
                1 -> SearchTab(onPokemonClick = onPokemonClick)
            }
        }
    }
}
