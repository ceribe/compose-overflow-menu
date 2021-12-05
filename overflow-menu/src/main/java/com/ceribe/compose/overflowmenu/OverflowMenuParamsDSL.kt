package com.ceribe.compose.overflowmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@DslMarker
annotation class OverflowMenuDSL

@Composable
fun OverflowMenu(block: OverflowMenuParamsBuilder.() -> Unit) {
    OverflowMenu(OverflowMenuParamsBuilder().apply(block).build())
}

@OverflowMenuDSL
class OverflowMenuParamsBuilder {

    var shownIconsCount = 1
    private val icons = mutableListOf<IconParamsDTO>()
    private var overflowIcon: IconParamsDTO = IconParamsDTO(imageVector = Icons.Filled.MoreVert)
    private var defaults: IconParamsDTO = IconParamsDTO()


    fun overflowIcon(block: IconParamsBuilder.() -> Unit) {
        overflowIcon = IconParamsBuilder(Icons.Filled.MoreVert).apply(block).build()
    }

    fun defaults(block: IconParamsBuilder.() -> Unit) {
        defaults = IconParamsBuilder().apply(block).build()
    }

    fun icons(block: IconsParamsBuilder.() -> Unit) {
        icons.addAll(IconsParamsBuilder().apply(block))
    }

    fun build() = OverflowMenuParamsDTO(shownIconsCount, icons, overflowIcon, defaults)
}

@OverflowMenuDSL
class IconParamsBuilder(icon: ImageVector? = null) {
    var onClick: (() -> Unit)? = null
    var modifier: Modifier? = null
    var enabled: Boolean? = null
    var imageVector: ImageVector? = icon
    var label: String? = null
    var contentDescription: String? = null
    var tint: Color? = null
    fun build() = IconParamsDTO(onClick, modifier, enabled, imageVector, label, contentDescription, tint)
}

@OverflowMenuDSL
class IconsParamsBuilder: ArrayList<IconParamsDTO>() {
    fun icon(block: IconParamsBuilder.() -> Unit) {
        add(IconParamsBuilder().apply(block).build())
    }
}