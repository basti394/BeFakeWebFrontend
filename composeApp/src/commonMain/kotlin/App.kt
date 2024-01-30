import DownloadButtons.AndroidDownloadButton
import DownloadButtons.AppleDownloadButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.resource


@OptIn(ExperimentalResourceApi::class, ExperimentalLayoutApi::class)
@Composable
fun App(
    platform: String
) {

    var font: FontFamily? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        font = FontFamily(
            Font("Inter-Bold.ttf", resource("Inter-Bold.ttf").readBytes())
        )
    }


    MaterialTheme {
        Scaffold(
            topBar = {

            },
            contentColor = Color.Black
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                item {
                    Spacer(modifier = Modifier.fillMaxWidth().height(200.dp))
                    Image(
                        modifier = Modifier
                            .height(59.5.dp)
                            .width(222.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource("befake_icon.png"),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    val imageHeight = 500
                    font?.let {
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            text = "Don't wanna post just to stalk?",
                            fontSize = 40.sp,
                            fontFamily = it,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        FlowRow {
                            Column(
                                modifier = Modifier.padding(10.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = "BeReal.",
                                    fontSize = 25.sp,
                                    fontFamily = it,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Image(
                                    modifier = Modifier
                                        .height(imageHeight.dp)
                                        .width((imageHeight*0.75).dp),
                                    contentScale = ContentScale.FillWidth,
                                    painter = painterResource("BeRealDemo.png"),
                                    contentDescription = null
                                )
                            }

                            Column(
                                modifier = Modifier.padding(10.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    text = "BeFake.",
                                    fontSize = 25.sp,
                                    fontFamily = it,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Image(
                                    modifier = Modifier
                                        .height(imageHeight.dp)
                                        .width((imageHeight*0.75).dp),
                                    contentScale = ContentScale.FillWidth,
                                    painter = painterResource("BeFakeDemo.png"),
                                    contentDescription = null
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        when(platform) {
                            "android" -> AndroidDownloadButton(font = it)
                            "ios" -> AppleDownloadButton(font = it)
                            else -> FlowRow {
                                AndroidDownloadButton(
                                    modifier = Modifier.padding(10.dp),
                                    font = it
                                )
                                AppleDownloadButton(
                                    modifier = Modifier.padding(10.dp),
                                    font = it
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}