package com.codewars.challenge.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.codewars.challenge.database.entity.Challenges
import com.codewars.challenge.ui.viewmodel.MainActivityViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: MainActivityViewModel by viewModels()
                mainView(
                    viewModel
                )
            }
        }

    }

    @Composable
    fun mainView(viewModel: MainActivityViewModel)
    {
        val challengesList = viewModel.challengesForUserStateFlow.collectAsState(initial = emptyList())
        val isLoading = viewModel.isLoading.collectAsState(initial = false)
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
        ) {

            loadingBar(isLoading.value)

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {

                searchBar(viewModel)

                Text(
                    text = "Completed Challenges",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Blue
                )

                if(challengesList.value.isNotEmpty())
                {
                    LazyColumn(
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(
                            items = challengesList.value,
                            itemContent = {
                                itemView(challenges = it)
                            })
                    }
                }
                else
                {
                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = "No Results",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Blue
                    )
                }
            }
        }
    }

    @Composable
    fun loadingBar(isLoading: Boolean)
    {
        if (isLoading) {
            Dialog(
                onDismissRequest = {},
                DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                Box(
                    contentAlignment= Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }

    @Composable
    fun searchBar(viewModel: MainActivityViewModel)
    {
        var text by rememberSaveable { mutableStateOf("g964") }
        Text(
            text = "Insert Username",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.Blue
        )

        Row {
            Column(
                modifier = Modifier.weight(weight = 1f)
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor =  Color.Transparent
                    )
                )
            }

            TextButton (
                onClick = {
                    viewModel.currentUser.value = text
                    viewModel.getListCompleteChallenges(text)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
        }

    }

    @Composable
    fun itemView(challenges: Challenges)
    {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(applicationContext, DetailsActivity::class.java)
                intent.putExtra("CHALLENGE", Gson().toJson(challenges))
                startActivity(intent)
            }
        ) {
            Row {
                Icon(
                    Icons.Filled.Assignment,
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .align(Alignment.CenterVertically)
                )

                Column(
                    modifier = Modifier.padding(8.dp)
                ){
                    Text(text = challenges.name)
                    Text(text = challenges.completedAt)
                }
            }

        }
        
        Spacer(modifier = Modifier.padding(4.dp))
    }

    @Preview
    @Composable
    fun mainPreview()
    {
        var list : List<Challenges> = listOf(
            Challenges(
                username = "rrebelo",
                completedAt = "ontem",
                completedLanguages = listOf("C", "Java"),
                id = "1",
                name = "Ricardo",
                slug = "Tyson"
            )
        )

        itemView(list[0])
    }
}