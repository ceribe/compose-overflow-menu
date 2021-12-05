package com.ceribe.compose.overflowmenu

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class OverflowMenuParamsDTO(
    val shownIconsCount: Int,
    val icons: List<IconParamsDTO>,
    val overflowIcon: IconParamsDTO,
    val defaults: IconParamsDTO
)

class IconParamsDTO(
    val onClick: (() -> Unit)? = null,
    val modifier: Modifier? = null,
    val enabled: Boolean? = null,
    val imageVector: ImageVector? = null,
    val label: String? = null,
    val contentDescription: String? = null,
    val tint: Color? = null
)