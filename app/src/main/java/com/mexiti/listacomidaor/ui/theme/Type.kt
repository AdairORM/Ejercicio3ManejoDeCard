package com.mexiti.listacomidaor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mexiti.listacomidaor.R

val JacquardaBastarda9 = FontFamily(
    Font(R.font.jacquarda_bastarda9_regular)
)
val Nunito = FontFamily(
    Font(R.font.nunito_bold)
)
val FiraSans = FontFamily(
    Font(R.font.fira_sans_bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
displayMedium = TextStyle(
    fontFamily = JacquardaBastarda9,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
) ,
    labelSmall = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )


    /*
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle( // Ajustar tamaño del título para los nombres de platillo
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold, // Resalta el título
        fontSize = 24.sp              // Tamaño del título
    )
*/

)
