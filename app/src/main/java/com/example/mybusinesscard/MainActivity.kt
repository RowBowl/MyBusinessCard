package com.example.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun BusinessCardPreview() {
        BusinessCard()
    }

    @Composable
    fun BusinessCard(modifier: Modifier = Modifier) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight()
        ) {
            ProfilePicture("Robel", "Beyene", "Android Developer",
                modifier = Modifier)

            Spacer(modifier = Modifier.size(50.dp))

            //Phone number and email
            ContactInfoBlock( string1 = stringResource(R.string.contact_phone_number),
                string2 = stringResource(R.string.contact_email),
                icon1 = Icons.Outlined.Phone,
                icon2 = Icons.Outlined.MailOutline,
                modifier = Modifier)

            Spacer(modifier = Modifier.size(25.dp))

            //important sites
            ContactInfoBlock( string1 = stringResource(R.string.link_linkedin),
                string2 = stringResource(R.string.link_github),
                icon1 = Icons.Outlined.KeyboardArrowRight,
                icon2 = Icons.Outlined.KeyboardArrowRight,
                modifier = Modifier)
        }
    }

    @Composable
    fun ProfilePicture(firstName: String, lastName: String, title: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.robel_profile_pic)
        val borderWidth = 12.dp
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(200.dp)
        ) {
            Image(
                painter = image,
                contentScale = ContentScale.Crop,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        BorderStroke(borderWidth, Color.Magenta),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )
            Text (
                text = "$firstName $lastName",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
            )
            Text (
                text = title,
                fontSize = 16.sp
            )
        }
    }
    @Composable
    fun ContactInfoBlock(borderColor: ULong = Color.Red.value,
                         backgroundColor: ULong = Color.Blue.value,
                         icon1: ImageVector,
                         icon2: ImageVector,
                         string1: String,
                         string2: String,
                         modifier: Modifier = Modifier) {


        Column (
            modifier = Modifier
                .border(3.dp, Color(borderColor))
                .fillMaxWidth()
                .padding(8.dp)
                .height(100.dp)
            , verticalArrangement = Arrangement.Center
        ) {

            Row (
                Modifier.padding(bottom = 10.dp)
            ) {
                Icon(
                    icon1, contentDescription = "Phone Number Icon",
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
                Text(
                    text = string1,
                    modifier = Modifier
                )
            }
            Row {
                Icon(
                    icon2, contentDescription = "Email Icon",
                    modifier = Modifier
                        .padding(end = 8.dp)
                )
                Text(
                    text = string2,
                    modifier = Modifier
                )
            }
        }
    }
}
