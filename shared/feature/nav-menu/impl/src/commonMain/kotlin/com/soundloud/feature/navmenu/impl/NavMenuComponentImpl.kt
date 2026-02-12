package com.soundloud.feature.navmenu.impl

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.soundloud.core.decompose.decompose.ext.AppComponentContext
import com.soundloud.core.decompose.decompose.ext.state
import com.soundloud.feature.navmenu.MenuComponent
import com.soundloud.feature.navmenu.NavMenuComponent
import com.soundloud.feature.navmenu.NavMenuComponent.*
import kotlinx.serialization.Serializable

internal class NavMenuComponentImpl(
    componentContext: AppComponentContext
) : NavMenuComponent, AppComponentContext by componentContext {
    private val reducer = componentContext.state<State, Nothing>(State())

    private val homeNavigation = StackNavigation<MenuConfig.HomeConfig>()
    private val homeBackStack: Value<ChildStack<*, MenuComponent.HomeComponent>> = childStack(
        source = homeNavigation,
        childFactory = ::homeComponentFactory,
        serializer = MenuConfig.HomeConfig.serializer(),
        initialConfiguration = MenuConfig.Home
    )

    private val searchNavigation = StackNavigation<MenuConfig.SearchConfig>()
    private val searchBackStack: Value<ChildStack<*, MenuComponent>> = childStack(
        source = searchNavigation,
        childFactory = ::searchComponentFactory,
        serializer = MenuConfig.SearchConfig.serializer(),
        initialConfiguration = MenuConfig.Search
    )

    private val libraryNavigation = StackNavigation<MenuConfig.LibraryConfig>()
    private val libraryBackStack: Value<ChildStack<*, MenuComponent>> = childStack(
        source = libraryNavigation,
        childFactory = ::libraryComponentFactory,
        serializer = MenuConfig.LibraryConfig.serializer(),
        initialConfiguration = MenuConfig.Library
    )

    override val stack: Value<ChildStack<*, MenuComponent>>
        get() = TODO("Not yet implemented")

    private fun homeComponentFactory(
        config: MenuConfig.HomeConfig,
        componentContext: AppComponentContext
    ): MenuComponent.HomeComponent = when (config) {
        MenuConfig.Home -> MenuComponent.Home
        MenuConfig.Profile -> MenuComponent.Profile
        MenuConfig.Playlist -> MenuComponent.Playlist
        MenuConfig.TrackInfo -> MenuComponent.TrackInfo
        MenuConfig.Artist -> MenuComponent.Artist
    }

    private fun searchComponentFactory(
        config: MenuConfig.SearchConfig,
        componentContext: AppComponentContext
    ): MenuComponent.SearchComponent = when (config) {
        MenuConfig.Search -> MenuComponent.Search
        MenuConfig.Playlist -> MenuComponent.Playlist
        MenuConfig.TrackInfo -> MenuComponent.TrackInfo
        MenuConfig.Artist -> MenuComponent.Artist
    }

    private fun libraryComponentFactory(
        config: MenuConfig.LibraryConfig,
        componentContext: AppComponentContext
    ): MenuComponent.LibraryComponent = when (config) {
        MenuConfig.Library -> MenuComponent.Library
        MenuConfig.Playlist -> MenuComponent.Playlist
        MenuConfig.TrackInfo -> MenuComponent.TrackInfo
        MenuConfig.Artist -> MenuComponent.Artist
    }
}

@Serializable
internal sealed interface MenuConfig {
    @Serializable
    sealed interface HomeConfig : MenuConfig
    @Serializable
    sealed interface SearchConfig : MenuConfig
    @Serializable
    sealed interface LibraryConfig : MenuConfig

    @Serializable
    data object Profile : HomeConfig
    @Serializable
    data object Search : SearchConfig
    @Serializable
    data object Library : LibraryConfig
    @Serializable
    data object Home : HomeConfig
    @Serializable
    data object Artist : HomeConfig, SearchConfig, LibraryConfig
    @Serializable
    data object Playlist : HomeConfig, SearchConfig, LibraryConfig
    @Serializable
    data object TrackInfo : HomeConfig, SearchConfig, LibraryConfig
}