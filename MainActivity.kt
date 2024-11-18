package com.example.begin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.begin.ui.theme.BeginTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start_screen") {
        composable("start_screen") { StartScreen(navController) }
        composable("first_bratek") { First_bratek(navController) }
        composable("second_zonkil") { Second_zonkil(navController) }
        composable("third_storczyk") { Third_storczyk(navController) }
    }
}

@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Wykonał: Mateusz Nowak",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tytuł: Jetpack Compose",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("first_bratek") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F684D)) // Jasnozielony
        ) {
            Text(text = "Bratek")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("second_zonkil") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F684D)) // Jasnozielony
        ) {
            Text(text = "Żonkil")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("third_storczyk") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F684D)) // Jasnozielony
        ) {
            Text(text = "Storczyk")
        }
    }
}
@Composable
fun First_bratek(navController: NavHostController) {
    Kwiat(
        navController = navController,
        imageRes = R.drawable.bratek,
        description = "Pokrój\n" +
                "Roślina o wysokości do 25 cm, o łodygach pokładających się lub wzniesionych, mięsistych, czterograniastych.\n" +
                "Liście\n" +
                "Dolne – jajowatosercowate, górne – podłużnie lancetowate.\n" +
                "Kwiaty\n" +
                "We wszystkich niemal kolorach, również dwubarwne."
    )
}

@Composable
fun Second_zonkil(navController: NavHostController) {
    Kwiat(
        navController = navController,
        imageRes = R.drawable.zonkil,
        description = "Liście\n" +
                "Długie, szpiczaste w takim samym kolorze co łodyga.\n" +
                "Korzeń\n" +
                "Zielony, okrągły o gładkiej strukturze. Trudny do złamania\n" +
                "Kwiaty\n" +
                "U typowej formy gatunku na jednym pędzie osadzonych jest 2–6 pachnących kwiatów, barwy żółtej"
    )
}

@Composable
fun Third_storczyk(navController: NavHostController) {
    Kwiat(
        navController = navController,
        imageRes = R.drawable.storczyk,
        description = "Liście\n" +
                "Na łodydze tylko jeden osadzony pochwiasto liść, pozostałe skupione u nasady w różyczkę.\n" +
                "Korzeń\n" +
                "Dwie jajowate do kulistych, niepodzielne, podziemne bulwy.\n" +
                "Kwiaty\n" +
                "Zebrane w kształtny, gęsty kłos osadzony na szczycie łodygi"
    )
}

@Composable
fun Kwiat(navController: NavHostController, imageRes: Int, description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("start_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F684D)) // Jasnozielony
        ) {
            Text(text = "Powrót")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    BeginTheme {
        StartScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun FlowerScreenPreview() {
    BeginTheme {
        Kwiat(
            navController = rememberNavController(),
            imageRes = R.drawable.bratek,
            description = "To jest przykład kwiatka."
        )
    }
}