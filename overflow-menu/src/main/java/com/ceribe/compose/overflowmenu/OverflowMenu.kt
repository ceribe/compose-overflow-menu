package com.ceribe.compose.overflowmenu

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlin.math.min

@Composable
fun OverflowMenu(params: OverflowMenuParamsDTO) {
    with(params) {
        val shownIcons = icons.subList(0, min(shownIconsCount, icons.size))
        val hiddenIcons =
            if(shownIconsCount >= icons.size)
                listOf()
            else
                icons.subList(shownIconsCount, icons.size)
        shownIcons.forEach {
            IconButton(
                onClick = it.onClick ?: defaults.onClick ?: {},
                modifier = it.modifier ?: defaults.modifier ?: Modifier,
                enabled = it.enabled ?: defaults.enabled ?: true
            ) {
                Icon(
                    imageVector = it.imageVector ?: defaults.imageVector ?: Icons.Filled.Warning,
                    contentDescription = it.contentDescription ?: defaults.contentDescription,
                    tint = it.tint ?: defaults.tint ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            }
        }
        if(hiddenIcons.isNotEmpty()) {
            Box {
                var showDropDown by remember { mutableStateOf(false) }
                IconButton(
                    onClick = {
                        showDropDown = true
                        (overflowIcon.onClick ?: defaults.onClick ?: {})()
                    },
                    modifier = overflowIcon.modifier ?: defaults.modifier ?: Modifier,
                    enabled = overflowIcon.enabled ?: defaults.enabled ?: true
                ) {
                    Icon(
                        imageVector = overflowIcon.imageVector ?: defaults.imageVector
                        ?: Icons.Filled.Warning,
                        contentDescription = overflowIcon.contentDescription
                            ?: defaults.contentDescription,
                        tint = overflowIcon.tint ?: defaults.tint
                        ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    )
                }
                DropdownMenu(
                    expanded = showDropDown,
                    onDismissRequest = { showDropDown = false }
                ) {
                    hiddenIcons.forEach {
                        DropdownMenuItem(
                            modifier = it.modifier ?: defaults.modifier ?: Modifier,
                            enabled = it.enabled ?: defaults.enabled ?: true,
                            onClick = {
                                showDropDown = false
                                (it.onClick ?: defaults.onClick ?: {})()
                            }
                        ) {
                            Text(it.label ?: defaults.label ?: "")
                        }
                    }
                }
            }
        }
    }
}