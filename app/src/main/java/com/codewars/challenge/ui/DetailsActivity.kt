package com.codewars.challenge.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codewars.challenge.database.entity.Challenges
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val challenge = Gson().fromJson(intent.extras?.getString("CHALLENGE"), Challenges::class.java)

        setContent {
            MaterialTheme {
                mainView(challenge)
            }
        }

    }

    @Composable
    fun mainView(challenge: Challenges)
    {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Challenge ID",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Blue
                )

                Text(
                    text = challenge.id,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Challenge Name",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Blue
                )

                Text(
                    text = challenge.name,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Challenge Slug",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Blue
                )

                Text(
                    text = challenge.slug,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Challenge Completed At",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Blue
                )

                Text(
                    text = challenge.completedAt,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }
        }
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

        mainView(list[0])
    }
}