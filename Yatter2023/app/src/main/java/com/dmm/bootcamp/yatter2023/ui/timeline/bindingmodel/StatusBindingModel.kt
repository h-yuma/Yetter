package com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel

import java.time.LocalDate
import java.util.Date

data class StatusBindingModel(
    val id: String,
    val displayName: String,
    val username: String,
    val avatar: String?,
    val content: String,
    val createAt: String,
    val attachmentMediaList: List<MediaBindingModel>
)