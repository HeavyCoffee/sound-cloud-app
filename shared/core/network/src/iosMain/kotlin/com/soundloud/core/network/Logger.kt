package com.soundloud.core.network

import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logger

internal actual fun Logger(): Logger = Logger.DEFAULT