package com.ceribe.compose.sample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.ceribe.compose.overflowmenu.OverflowMenu
import com.ceribe.compose.sample.ui.theme.SampleTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sample1()
//                    Sample2()
//                    Sample3()
                }
            }
        }
    }
}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

@Composable
fun Sample1() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 1") },
                actions = {
                    OverflowMenu {
                        shownIconsCount = 2
                        icons {
                            icon {
                                imageVector = Icons.Filled.Edit
                                onClick = { context.toast("First Icon Clicked") }
                            }
                            icon {
                                imageVector = Icons.Filled.Delete
                                onClick = { context.toast("Second Icon Clicked") }
                            }
                            icon {
                                label = "Third Example"
                                onClick = { context.toast("Third Icon Clicked") }
                            }
                        }
                        defaults {
                            tint = Color.Red
                        }
                        overflowIcon {
                            tint = Color.Yellow
                        }
                    }
                }
            )
        }
    ) {}
}

@Composable
fun Sample2() {
    var numberOfShownIcons by remember { mutableStateOf(3) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 2") },
                actions = {
                    OverflowMenu {
                        shownIconsCount = numberOfShownIcons
                        icons {
                            icon {
                                onClick = { numberOfShownIcons = 3 }
                                tint = Color.Green
                                imageVector = Icons.Filled.Add
                            }
                            icon {
                                imageVector = Icons.Filled.Settings
                            }
                            icon {
                                onClick = { numberOfShownIcons = 1 }
                                tint = Color.Red
                                imageVector = Icons.Filled.Delete
                            }
                            icon {
                                label = "Fourth Example"
                            }
                            icon {
                                label = "Fifth Example"
                            }
                        }
                        defaults {
                            label = "Default Label"
                        }
                    }
                }
            )
        }
    ) {}
}

@Composable
fun Sample3() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sample 3") },
                actions = {
                    OverflowMenu {
                        shownIconsCount = 1
                        icons {
                            icon {
                                onClick = { context.toast("Clicked") }
                                modifier = Modifier.rotate(30f)
                                enabled = true
                                imageVector = Icons.Filled.Favorite
                                label = "Example label"
                                contentDescription = "Sample Icon"
                                tint = Color.Cyan
                            }
                        }
                    }
                }
            )
        }
    ) {}
}