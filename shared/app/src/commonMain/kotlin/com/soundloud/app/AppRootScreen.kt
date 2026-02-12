package com.soundloud.app

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@Composable
fun AppRootScreen(component: AppRootComponent) {
    Children(
        stack = component.stack,
        animation = stackAnimation(fade() + scale())
    ) {
        it.instance.Content()
    }
}