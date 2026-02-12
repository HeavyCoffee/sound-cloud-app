package com.soundloud.feature.navmenu

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.soundloud.feature.navmenu.model.Menu

interface NavMenuComponent {
    val stack: Value<ChildStack<*, MenuComponent>>

    data class State(
        val menu: Menu = Menu.HOME
    )
}

sealed interface MenuComponent {
    sealed interface HomeComponent : MenuComponent
    sealed interface SearchComponent : MenuComponent
    sealed interface LibraryComponent : MenuComponent

    @Composable
    open fun Content() = Unit
    data object Home : HomeComponent
    data object Search : SearchComponent
    data object Library : LibraryComponent
    data object Profile : HomeComponent
    data object Playlist : HomeComponent, SearchComponent, LibraryComponent
    data object Artist : HomeComponent, SearchComponent, LibraryComponent
    data object TrackInfo : HomeComponent, SearchComponent, LibraryComponent
}