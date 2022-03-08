package com.interviewprep.seniorandroiddev.mvp

import android.annotation.SuppressLint
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.interviewprep.seniorandroiddev.mvp.model.Breed
import com.interviewprep.seniorandroiddev.mvp.model.BreedAttributes
import com.interviewprep.seniorandroiddev.mvp.presenter.BreedListContract
import com.interviewprep.seniorandroiddev.mvp.presenter.BreedPresenter
import com.interviewprep.seniorandroiddev.ui.theme.SeniorAndroidDevInterviewPrepTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@OptIn(ExperimentalMaterialApi::class)
class MainActivity : ComponentActivity(), BreedListContract.ListView{

    companion object{
        val map: HashMap<String, List<String>?> = hashMapOf("Maximum Temperature" to listOf("10", "25", "50"),
            "Monthly Budget In USD" to listOf("35", "70", "100"),
            "Purpose" to listOf("GUARD", "FAMILY"),
            "Minimum Daily Time(In Minutes)" to listOf("45", "90", "120"))
    }

    private val presenter = BreedPresenter()

    var saveMap = hashMapOf<String, String>("Maximum Temperature" to "50",
        "Monthly Budget In USD" to "35",
        "Purpose" to "GUARD",
        "Minimum Daily Time(In Minutes)" to "45")

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
        setContent {
            SeniorAndroidDevInterviewPrepTheme {
                Surface{
                    var text by rememberSaveable { mutableStateOf("Selected Breed : The Selection will appear here")}
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        attributesColumn(attributes = map,
                            submitBtn = {
                                lifecycleScope.launch {
                                    presenter.attributesSelected(
                                        BreedAttributes(
                                            saveMap["Maximum Temperature"],
                                            saveMap["Monthly Budget In USD"],
                                            saveMap["Purpose"],
                                            saveMap["Minimum Daily Time(In Minutes)"]
                                        )
                                    ).collect {
                                        text = "Your preferred Breed is ${it[0].name}"
                                    }
                                }
                            },
                            btnText = "Find Breed", saveMap)
                        Text(
                            text = text,
                            color = Color.Magenta,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun attributesColumn(attributes: HashMap<String, List<String>?>,
                    submitBtn: () -> Unit,
                    btnText: String, saveMap: HashMap<String, String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
    ) {
        attributes.forEach{
            attribute ->
                dropDownListItem(attribute = attribute.key, options = attribute.value, saveMap)
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
fun dropDownListItem(attribute: String, options: List<String>?, saveMap: HashMap<String, String>) {
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
            onValueChange = {},
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
                        saveMap[attribute] = selectedOptionText!!
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }

    }
}


