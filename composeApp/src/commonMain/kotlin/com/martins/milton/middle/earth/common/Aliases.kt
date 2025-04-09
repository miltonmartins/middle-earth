package com.martins.milton.middle.earth.common

import androidx.compose.runtime.Composable

typealias UnitCallback = () -> Unit

typealias ComposableCallBack = @Composable () -> Unit

typealias GenericCallback<T> = (T) -> Unit