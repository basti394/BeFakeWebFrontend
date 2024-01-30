package DownloadButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AndroidDownloadButton(
    modifier: Modifier = Modifier,
    font: FontFamily
) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .border(
                width = 0.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(40f)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable() {  }
            .height(45.dp)
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.wrapContentWidth().padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource("androidLogo.png"),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get the App",
                fontFamily = font,
                fontSize = 20.sp,
            )
        }
    }
}