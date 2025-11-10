package com.example.jc_ui_components

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jc_ui_components.ui.theme.Green
import com.example.jc_ui_components.ui.theme.JCUIComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCUIComponentsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        SayHelloText("Satish")
        JCButton("Click Me")
        JCTextField()
        JCSwitch()
        JCRadioButton()
        JCCheckBox()
    }
}

//@PreviewScreenSizes
@Preview(showSystemUi = true)
//@Preview(showSystemUi = true, showBackground = false, name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    JCUIComponentsTheme {
        HomeScreen()
    }
}

@Composable
fun SayHelloText(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 30.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Hello $name",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Gray)
                .padding(6.dp),
            lineHeight = 10.sp
        )
    }
}

@Composable
fun JCButton(btnText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        val context = LocalContext.current

        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            },
            border = BorderStroke(1.dp, Color.Black),
            contentPadding = PaddingValues(10.dp, 4.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = btnText,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Composable
fun JCTextField() {
    var inputValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = inputValue,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { inputValue = it },
            label = { Text("Enter Text") },
            placeholder = { Text("Type here") },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
            ),
            trailingIcon = { Icon(Icons.Outlined.Info, contentDescription = "Clear") },
            //shape = MaterialTheme.shapes.medium,
            visualTransformation = VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                disabledTextColor = Color.Gray,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
                errorCursorColor = Color.Red,
                //focusedIndicatorColor = Color.Transparent,
                //unfocusedIndicatorColor = Color.Transparent,
                //disabledIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Handle the "Done" action here
                },
                onNext = {
                    // Move focus to the next TextField
                },
                onPrevious = {
                    // Move focus to the previous TextField
                },
                onSearch = {
                    // Handle the "Search" action here
                },
                onSend = {
                    // Handle the "Send" action here
                }
            )
        )
        Spacer(Modifier.height(6.dp))
        Text("You Entered Text: $inputValue")
    }
}

@Composable
fun JCSwitch() {
    val context = LocalContext.current
    val switchState = rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                0.dp, 8.dp, 0.dp, 0.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value = it
                Toast.makeText(context, "Switch: $it", Toast.LENGTH_SHORT).show()
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Green, // Color of the thumb when checked
                checkedTrackColor = Color.DarkGray, // Color of the track when checked
                uncheckedThumbColor = Color.Gray, // Color of the thumb when unchecked
                uncheckedTrackColor = Color.LightGray // Color of the track when unchecked
            )
        )
    }
}

@Composable
fun JCRadioButton() {
    val options = listOf("One", "Two", "Three")
    var (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(options[0]) }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .selectableGroup()
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        options.forEach { rbText ->
            Row(
                modifier = Modifier.selectable(
                    selected = (rbText == selectedOption),
                    onClick = {
                        selectedOption = rbText
                        onOptionSelected(rbText)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = (rbText == selectedOption),
                    onClick = {
                        selectedOption = rbText
                        onOptionSelected(rbText)
                        Toast.makeText(context, "Selected: $rbText", Toast.LENGTH_SHORT).show()
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Gray
                    )
                )
                Text(text = rbText)
            }
        }
    }
}

@Composable
fun JCCheckBox() {
    var checkBoxState by rememberSaveable { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = checkBoxState,
            onCheckedChange = {
                checkBoxState = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.Red
            )
        )
        Text(text = "CheckBox Text")
    }
}