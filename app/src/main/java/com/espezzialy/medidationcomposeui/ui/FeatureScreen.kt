package com.espezzialy.medidationcomposeui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.espezzialy.medidationcomposeui.ui.model.Feature
import com.espezzialy.medidationcomposeui.ui.theme.*

@Composable
fun FeatureScreen(
    feature: Feature
) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column(modifier =
        Modifier.verticalScroll(rememberScrollState())
        )
        {
            HeaderSection()
            ItemSection(feature)
            RelatedSection(listOf(
                Feature(
                    title = "Sleep meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Feature(
                    title = "Tips for sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                )))
        }

    }
}


@Composable
fun HeaderSection(
//    isFavorite: Boolean = false
) {
    var isFavorite by remember {
        mutableStateOf(false)
    }

    val icon: Painter = if (isFavorite) {
        painterResource(id = R.drawable.ic_star)
    } else {
        painterResource(id = R.drawable.ic_star_without)
    }

    Row(
       horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )

        Icon(
            painter = icon,
            contentDescription = "Favorite",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    isFavorite = !isFavorite
                }
        )
    }

}

@Composable
fun ItemSection(
    feature: Feature
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
        text = feature.title,
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 10.dp)
        )

        Text(
            text = "Best practice medidations",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 15.dp, bottom = 15.dp, end = 15.dp)
        )

        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(300.dp)
        ) {
            FeatureSpecificItem(feature)
        }

        Text(
            text = "Sleep Music" + " • " + "45" + " min",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(15.dp)
        )

        Text(
            text = "Ease the mind into a restful night's sleep with these deep, amblent tones.",
            style = MaterialTheme.typography.body1,
            lineHeight = 24.sp,
            modifier = Modifier.padding(start = 15.dp, bottom = 15.dp, end = 15.dp)

        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            IconRegistrator(icon = painterResource(id = R.drawable.ic_star), title = "Saved", count = 15542)
            IconRegistrator(icon = painterResource(id = R.drawable.ic_headphone), title = "Lestening", count = 43543)
        }
    }
    Divider(color = AquaBlue, thickness = 0.5.dp, modifier = Modifier.padding(15.dp))

}

@Composable
fun IconRegistrator(
    icon: Painter,
    title: String,
    count: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = icon,
            contentDescription = title,
            tint = Color.White,
            modifier = Modifier
                .padding(end = 15.dp)
                .size(24.dp)
        )

        Text(
            text = "$count  $title",
            style = MaterialTheme.typography.body1,
            color = TextWhite
        )
    }


}


@Composable
fun FeatureSpecificItem(
    feature: Feature
) {
    BoxWithConstraints(
        //AspectRatio guarantees aways be a square
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f )
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f )
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f )
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f )
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat() )


        //Path
        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standartQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standartQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standartQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standartQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        // Light colored path
        val lightColoredPoint1 = Offset(0f, height * 0.35f )
        val lightColoredPoint2 = Offset(width * 0.1f, height * 0.4f )
        val lightColoredPoint3 = Offset(width * 0.3f, height * 0.35f )
        val lightColoredPoint4 = Offset(width * 0.65f, height.toFloat() )
        val lightColoredPoint5 = Offset(width * 1.4f, -height.toFloat()  / 3f)


        //Path
        val lightColoredPath = Path().apply {
            moveTo(lightColoredPoint1.x, lightColoredPoint1.y)
            standartQuadFromTo(lightColoredPoint1, lightColoredPoint2)
            standartQuadFromTo(lightColoredPoint2, lightColoredPoint3)
            standartQuadFromTo(lightColoredPoint3, lightColoredPoint4)
            standartQuadFromTo(lightColoredPoint4, lightColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        })


        Box(modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)) {
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .align(Alignment.BottomStart)
                    .size(24.dp)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(15.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 12.dp, horizontal = 15.dp)
            )
        }

    }
}

@Composable
fun RelatedSection(
    features: List<Feature>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Related",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(15.dp)
    ) {
        FeatureItem(feature = features[0])
        FeatureItem(feature = features[1])
    }

}
