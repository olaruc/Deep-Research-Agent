package com.cristian.research.model

import kotlinx.serialization.Serializable

@Serializable
data class FinalReport(
    val topic: String,
    val markdownContent: String,
) {
    fun toMarkdown(): String {
        val sb = StringBuilder()

        sb.appendLine("# Research Report: $topic")
        sb.appendLine()
        sb.appendLine(markdownContent)
        sb.appendLine()
        sb.appendLine("---")

        return sb.toString()
    }
}
