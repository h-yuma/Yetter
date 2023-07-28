package com.dmm.bootcamp.yatter2023.ui.timeline

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.MediaBindingModel
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.StatusBindingModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun StatusRow(
    statusBindingModel: StatusBindingModel,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            ){
        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = statusBindingModel.avatar,
            contentDescription = "アバター画像",
            contentScale = ContentScale.Crop,

        )

        Column (
                modifier = modifier
                    .padding(start = 15.dp)
                ){
            Row {
                Text(
                    text = statusBindingModel.displayName,
                    style = TextStyle(fontSize = 12.sp)
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "@${statusBindingModel.username}",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                    ){
                Text(text = statusBindingModel.content)
                Text(
                    text = substringDate(statusBindingModel.createAt) + " " + substringTime(statusBindingModel.createAt),
                    style = TextStyle(fontSize = 12.sp),
                    modifier = Modifier.align(Alignment.Bottom),

                )



            }

            Row(modifier = Modifier.fillMaxWidth()) {
                statusBindingModel.attachmentMediaList.map {
                    AsyncImage(
                        modifier = Modifier.size(96.dp),
                        model = it.url,
                        contentDescription = it.description
                    )
                }
            }

        }

    }
}

fun substringDate(StringDate: String): String{
    return StringDate.substringBefore("T")
}
fun substringTime(StringDate: String): String{
    val subDate = StringDate.substringAfter("T")
    return subDate.substringBefore("+")
}





@Preview
@Composable
private fun StatusRowPreview() {
    Yatter2023Theme {
        Surface {
            StatusRow(
                statusBindingModel = StatusBindingModel(
                    id = "id",
                    displayName = "mito",
                    username = "mitohato14",
                    avatar = "https://avatars.githubusercontent.com/u/19385268?v=4",
                    content = "preview content",
                    createAt = "2023-07-26T03:49:04+09:00",
                    attachmentMediaList = listOf(
                        MediaBindingModel(
                            id = "id",
                            type = "image",
                            url = "https://avatars.githubusercontent.com/u/39693306?v=4",
                            description = "icon"
                        )
                    )
                )
            )
        }
    }
}


