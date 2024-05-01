package com.example.weatherapplication.presentation.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

//@Preview
//@Composable
//fun CardPreview() {
//    WeatherCard(
//        WeatherState(),
//        Color.White,
//        Modifier
//    )
//}

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->

        Card(
            backgroundColor = backgroundColor,
            modifier = modifier.padding(16.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today + ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    modifier = modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = modifier.padding(16.dp))

                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )

                Spacer(modifier = modifier.height(16.dp))

                Text(
                    text = "${data.temperatureCelsius}°C",
                    color = Color.White,
                    fontSize = 50.sp
                )

                Spacer(modifier = modifier.height(16.dp))

                Text(
                    text = data.weatherType.weatherDesc,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(32.dp))

                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt()  ,
                        unit = "hpa",
                        icon = ImageVector.vectorResource(R.drawable.ic_pressure),
                        textStyle = TextStyle(color = Color.White),
                        iconTint = Color.White
                    )
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt()  ,
                        unit = "%",
                        icon = ImageVector.vectorResource(R.drawable.ic_drop),
                        textStyle = TextStyle(Color.White),
                        iconTint = Color.White
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt()  ,
                        unit = "km/h",
                        icon = ImageVector.vectorResource(R.drawable.ic_wind),
                        textStyle = TextStyle(Color.White),
                        iconTint = Color.White
                    )
                }



            }

        }
    }


}