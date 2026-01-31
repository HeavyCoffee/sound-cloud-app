package com.soundloud.core.decompose.decompose.ext

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ComponentContextFactory
import com.arkivanov.decompose.GenericComponentContext
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.statekeeper.StateKeeperOwner
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

interface AppComponentContext : GenericComponentContext<AppComponentContext>, ChildComponentFactory

interface ChildComponentFactory : KoinComponent {
    fun <Params, NavEvent, Component>getChildComponent(
        inputParams: Params,
        componentContext: ComponentContext,
        onEvent: (NavEvent) -> Unit
    ): Component = get {
        parametersOf(inputParams, componentContext, onEvent)
    }
}

internal class AppComponentContextImpl(
    componentContext: ComponentContext
) : AppComponentContext,
    LifecycleOwner by componentContext,
    StateKeeperOwner by componentContext,
    InstanceKeeperOwner by componentContext,
    BackHandlerOwner by componentContext {

    override val componentContextFactory: ComponentContextFactory<AppComponentContext> =
        ComponentContextFactory { lifecycle, stateKeeper, instanceKeeper, backHandler ->
            AppComponentContextImpl(
                componentContext.componentContextFactory(
                    lifecycle = lifecycle,
                    stateKeeper = stateKeeper,
                    instanceKeeper = instanceKeeper,
                    backHandler = backHandler
                )
            )
        }
}