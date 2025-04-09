package com.martins.milton.middle.earth.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.martins.milton.middle.earth.common.ComposableCallBack
import com.martins.milton.middle.earth.common.UnitCallback
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RefreshBox(
    modifier: Modifier = Modifier,
    onRefresh: UnitCallback,
    loading: Boolean,
    content: ComposableCallBack
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = loading,
        onRefresh = onRefresh
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        content()
        PullRefreshIndicator(
            modifier = Modifier.align(Alignment.TopCenter),
            refreshing = loading,
            state = pullRefreshState
        )
    }
}

@Preview
@Composable
private fun Preview() {
    RefreshBox(
        onRefresh = {},
        loading = true
    ) {
        Text("Preview")
    }
}