package com.mexiti.listacomidaor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.mexiti.listacomidaor.data.DataSource
import com.mexiti.listacomidaor.model.Platillo
import com.mexiti.listacomidaor.ui.theme.ListaComidaOrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaOrTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuApp()
                }
            }
        }
    }
}

@Composable
fun MenuApp() {
    MenuCardList(platilloList = DataSource().LoadPlatillos())
}

@Composable
fun MenuCardList(platilloList: List<Platillo>, modifier: Modifier = Modifier) {

    Scaffold (
        topBar = {
            MenuTopAppBar()
        }
    ){
        it->
        LazyColumn(contentPadding = it) {
            items(platilloList) { platillo ->
                MenuCard(
                    platillo = platillo,
                    modifier = modifier.padding(10.dp)
                )
            }
        }
    }

}

@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopAppBar(modifier: Modifier =Modifier){
CenterAlignedTopAppBar(title = {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.logo_cubiertos),
             contentDescription =null,
            modifier = modifier.run {
                padding(8.dp)
                    .size(64.dp)

            }
        )
        Text(text = stringResource(id = R.string.Comudel),
            style =MaterialTheme.typography.displayLarge)
    }

}, modifier = modifier
)
}

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Imagen circular del platillo
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .size(160.dp)  // Tamaño de la imagen
                    .clip(CircleShape),  // Hace la imagen circular
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre la imagen y el texto

            // Column que contiene el nombre, precio y oferta (si existe)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically) // Centra el contenido verticalmente respecto a la imagen
            ) {
                // Nombre del platillo
                Text(
                    text = stringResource(id = platillo.stringResourceId),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                // Precio del platillo
                Text(
                    text = "MX ${platillo.precio}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                // Si está en oferta
                if (platillo.oferta) {
                    Text(
                        text = "Ahorra hasta el 30%",
                        color = Color.Blue,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ShowMenuCard() {
    MenuCardList(platilloList = DataSource().LoadPlatillos())
}

