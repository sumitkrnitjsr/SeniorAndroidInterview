package com.interviewprep.seniorandroiddev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.interviewprep.seniorandroiddev.ui.theme.SeniorAndroidDevInterviewPrepTheme

@ExperimentalMaterialApi
@OptIn(ExperimentalMaterialApi::class)
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeniorAndroidDevInterviewPrepTheme {
                Surface{
                    val map: HashMap<String, List<String>?> = hashMapOf("maxTemperature" to listOf("10", "25", "50"),
                        "monthlyBudgetUSD" to listOf("35", "70", ">70"),
                        "purpose" to listOf("GUARD", "FAMILY"),
                        "dailyTimeMin" to listOf("45", "90", ">90"))
                    attributesColumn(attributes = map, submitBtn = { }, btnText = "Find Breed")
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun attributesColumn(attributes: HashMap<String, List<String>?>,
                    submitBtn: () -> Unit,
                    btnText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
    ) {
        attributes.forEach{
            attribute ->
                dropDownListItem(attribute = attribute.key, options = attribute.value)
        }

        Button(
            onClick = submitBtn,
        ){
            Text(text = btnText)
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun dropDownListItem(attribute: String, options: List<String>?) {
    var expanded by rememberSaveable { mutableStateOf(false)}
    var selectedOptionText by rememberSaveable { mutableStateOf(options?.get(0)) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = Modifier.padding(16.dp),
        onExpandedChange = {expanded = !expanded}
    ){

        TextField(
            readOnly = true,
            value = selectedOptionText!!.toString(),
            onValueChange = { },
            label = { Text(attribute) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options?.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }

    }
}


