package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.DropdownMenuItems
import com.example.wbproject.ui.theme.elements.text.TextBody1

private const val BLANK_NUMBER = "000 000-00-00"
private const val PHONE_LENGTH = 10

@Composable
fun CustomPhoneNumber(
    modifier: Modifier = Modifier,
    displayText: String,
    onValueChangeClickListener: (String) -> Unit
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    var selectedCountryCode by rememberSaveable { mutableStateOf(DropdownMenuItems.RUSSIA) }

    Row(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension36)
                    .width(MeetingTheme.dimensions.dimension56)
                    .clickable { expanded = true }
                    .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension4))
                    .background(MeetingTheme.colors.neutralOffWhite)
                    .padding(MeetingTheme.dimensions.dimension8),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(MeetingTheme.dimensions.dimension16)
                        .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension4)),
                    painter = painterResource(id = selectedCountryCode.imageResId),
                    contentDescription = null
                )
                TextBody1(
                    text = selectedCountryCode.countryCode,
                    color = MeetingTheme.colors.neutralDisabled
                )
            }
            DropdownMenu(
                modifier = Modifier.width(MeetingTheme.dimensions.dimension72),
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItems.entries.forEachIndexed { index, item ->
                    DropdownMenuItem(text = {
                        TextBody1(
                            text = item.countryCode,
                            color = MeetingTheme.colors.neutralDisabled
                        )
                    }, onClick = {
                        selectedCountryCode = item
                        expanded = false
                    },
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .size(MeetingTheme.dimensions.dimension16)
                                    .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension4)),
                                painter = painterResource(id = item.imageResId),
                                contentDescription = null
                            )
                        }
                    )
                    val isDividerVisible = index != DropdownMenuItems.entries.size - 1
                    if (isDividerVisible)
                        Divider()
                }
            }
        }

        Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension6))
        Box(
            modifier = Modifier
                .height(MeetingTheme.dimensions.dimension36)
                .fillMaxWidth()
                .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension4))
                .background(MeetingTheme.colors.neutralOffWhite)
                .padding(MeetingTheme.dimensions.dimension8),
            contentAlignment = Alignment.CenterStart
        )
        {
            BasicTextField(
                value = displayText,
                onValueChange = {
                    onValueChangeClickListener(it.take(PHONE_LENGTH))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { decorationBox ->
                    if (displayText == "") {
                        TextBody1(
                            text = BLANK_NUMBER,
                            color = MeetingTheme.colors.neutralDisabled,
                        )
                    }
                    decorationBox()
                },
                textStyle = MeetingTheme.typography.bodyText1.copy(color = MeetingTheme.colors.neutralDisabled),
                visualTransformation = PhoneNumberTransformation()
            )
        }
    }


}

class PhoneNumberTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val originalText = text.text
        val formattedText = StringBuilder()

        originalText.forEachIndexed { index, char ->
            formattedText.append(char)
            when (index) {
                2 -> formattedText.append(' ')
                5, 7 -> formattedText.append('-')
            }
        }

        val out = formattedText.toString()

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when (offset) {
                    in 0..2 -> offset
                    in 3..5 -> offset + 1
                    in 6..7 -> offset + 2
                    in 8..10 -> offset + 3
                    else -> out.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when (offset) {
                    in 0..2 -> offset
                    in 3..6 -> offset - 1
                    in 7..9 -> offset - 2
                    in 10..12 -> offset - 3
                    else -> text.length
                }
            }
        }
        return TransformedText(AnnotatedString(out), offsetMapping)
    }
}