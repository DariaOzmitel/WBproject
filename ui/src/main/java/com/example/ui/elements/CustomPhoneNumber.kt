package com.example.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.DropdownMenuItems
import com.example.ui.elements.text.TextMedium19
import com.example.ui.elements.text.TextRegular19
import com.example.ui.theme.EventTheme

private const val BLANK_NUMBER = "000 000-00-00"
private const val PHONE_LENGTH = 10

@Composable
fun CustomPhoneNumber(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    selectedCountryCode: DropdownMenuItems,
    onRowClickListener: () -> Unit,
    onDismissRequestClickListener: () -> Unit,
    onItemClickListener: (DropdownMenuItems) -> Unit,
    displayText: String,
    onValueChangeClickListener: (String) -> Unit
) {
    Row(modifier = modifier) {
        CustomCountryCode(
            expanded = expanded,
            selectedCountryCode = selectedCountryCode,
            onRowClickListener = onRowClickListener,
            onDismissRequestClickListener = onDismissRequestClickListener
        ) {
            onItemClickListener(it)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(EventTheme.dimensions.dimension16))
                .background(EventTheme.colors.neutralOffWhite)
                .padding(
                    vertical = EventTheme.dimensions.dimension16,
                    horizontal = EventTheme.dimensions.dimension12
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = displayText,
                onValueChange = {
                    onValueChangeClickListener(it.take(PHONE_LENGTH))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { decorationBox ->
                    if (displayText.isBlank()) {
                        TextRegular19(
                            text = BLANK_NUMBER,
                            color = EventTheme.colors.neutralDisabled,
                        )
                    }
                    decorationBox()
                },
                textStyle = EventTheme.typography.regular19.copy(color = EventTheme.colors.neutralDisabled),
                visualTransformation = PhoneNumberTransformation()
            )
        }
    }
}

@Composable
private fun CustomCountryCode(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    selectedCountryCode: DropdownMenuItems,
    onRowClickListener: () -> Unit,
    onDismissRequestClickListener: () -> Unit,
    onItemClickListener: (DropdownMenuItems) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(end = EventTheme.dimensions.dimension8)
                .clickable { onRowClickListener() }
                .clip(RoundedCornerShape(EventTheme.dimensions.dimension16))
                .background(EventTheme.colors.neutralOffWhite)
                .padding(
                    vertical = EventTheme.dimensions.dimension16,
                    horizontal = EventTheme.dimensions.dimension20
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(end = EventTheme.dimensions.dimension8)
                    .size(EventTheme.dimensions.dimension16)
                    .clip(RoundedCornerShape(EventTheme.dimensions.dimension4)),
                painter = painterResource(id = selectedCountryCode.imageResId),
                contentDescription = null
            )
            TextMedium19(
                text = selectedCountryCode.countryCode,
            )
        }
        DropDownMenuContent(
            expanded = expanded,
            onDismissRequestClickListener = onDismissRequestClickListener
        ) {
            onItemClickListener(it)
        }

    }
}

@Composable
private fun DropDownMenuContent(
    expanded: Boolean,
    onDismissRequestClickListener: () -> Unit,
    onItemClickListener: (DropdownMenuItems) -> Unit
) {
    DropdownMenu(
        modifier = Modifier
            .width(EventTheme.dimensions.dimension76)
            .background(EventTheme.colors.neutralOffWhite),
        expanded = expanded,
        onDismissRequest = onDismissRequestClickListener
    ) {
        DropdownMenuItems.entries.forEachIndexed { index, item ->
            DropdownMenuItem(text = {
                TextMedium19(
                    text = item.countryCode,
                    color = EventTheme.colors.neutralDisabled
                )
            }, onClick = {
                onItemClickListener(item)
            },
                leadingIcon = {
                    Image(
                        modifier = Modifier
                            .size(EventTheme.dimensions.dimension16)
                            .clip(RoundedCornerShape(EventTheme.dimensions.dimension4)),
                        painter = painterResource(id = item.imageResId),
                        contentDescription = null
                    )
                }
            )
            val isDividerVisible = index != DropdownMenuItems.entries.lastIndex
            if (isDividerVisible) {
                HorizontalDivider()
            }
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

@Preview
@Composable
private fun CustomPhoneNumberPreview() {
    var phone: String by rememberSaveable {
        mutableStateOf("")
    }
    CustomPhoneNumber(
        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension68),
        displayText = phone,
        expanded = false,
        selectedCountryCode = DropdownMenuItems.RUSSIA,
        onDismissRequestClickListener = {},
        onItemClickListener = {},
        onRowClickListener = {},
        onValueChangeClickListener = { phone = it })
}