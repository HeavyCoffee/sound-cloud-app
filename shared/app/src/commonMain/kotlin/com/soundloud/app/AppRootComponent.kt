package com.soundloud.app

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.soundloud.core.decompose.decompose.ext.AppComponentContext
import kotlinx.serialization.Serializable

interface AppRootComponent {
    val stack: Value<ChildStack<*, FlowComponent>>
}

internal class AppRootComponentImpl(
    componentContext: AppComponentContext
) : AppRootComponent, AppComponentContext by componentContext {
    private val navigation = StackNavigation<FlowConfig>()

    override val stack: Value<ChildStack<*, FlowComponent>> = childStack(
        source = navigation,
        serializer = FlowConfig.serializer(),
        initialConfiguration = FlowConfig.Launch,
        childFactory = ::componentFactory
    )

    private fun componentFactory(
        config: FlowConfig,
        componentContext: AppComponentContext
    ): FlowComponent = when (config) {
        FlowConfig.Launch -> FlowComponent.Launch
        FlowConfig.Auth -> FlowComponent.Auth
        FlowConfig.NavMenu -> FlowComponent.NavMenu
    }
}

sealed interface FlowComponent {
    @Composable
    open fun Content() = Unit

    data object Launch : FlowComponent
    data object Auth : FlowComponent {
        @Composable
        override fun Content() {}
    }
    data object NavMenu : FlowComponent {
        @Composable
        override fun Content() {}
    }
}

@Serializable
internal sealed interface FlowConfig {
    @Serializable
    data object Launch : FlowConfig
    @Serializable
    data object Auth : FlowConfig
    @Serializable
    data object NavMenu : FlowConfig
}