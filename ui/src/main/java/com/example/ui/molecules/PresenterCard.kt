package com.example.ui.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockPresenter
import com.example.domain.model.Presenter
import com.example.ui.elements.images.CommunityAvatar
import com.example.ui.elements.text.TextHeading4
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

@Composable
internal fun PresenterCard(
    modifier: Modifier = Modifier,
    presenter: Presenter
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .weight(1f)
            .padding(end = EventTheme.dimensions.dimension10)) {
            TextHeading4(text = presenter.name)
            presenter.description?.let {
                TextSecondary(text = it)
            }
        }
        presenter.avatarModel?.let {
            CommunityAvatar(model = it)
        }
    }
}

@Preview
@Composable
private fun PresenterCardPreview() {
    PresenterCard(presenter = mockPresenter)
}