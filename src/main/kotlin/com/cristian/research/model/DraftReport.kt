package com.cristian.research.model

import kotlinx.serialization.Serializable

@Serializable
data class DraftReport(
    val topic: String,
    val sections: List<ReportSection>,
)

@Serializable
data class ReportSection(
    val title: String,
    val content: String
)