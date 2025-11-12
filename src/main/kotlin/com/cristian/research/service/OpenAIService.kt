package com.cristian.research.service

import com.aallam.openai.api.chat.ChatCompletion
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.chat.Effort
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.cristian.research.config.Config
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class OpenAIService(apiKey: String = Config.API_KEY) {

    private val client = OpenAI(
        token = apiKey
        )

    suspend fun chat(
        prompt: String,
        systemPrompt: String = Config.SYSTEM_PROMPT
    ): String {
        return withRetry {
            val request = ChatCompletionRequest(
                model = ModelId(Config.LLM_MODEL),
                messages = listOf(
                    ChatMessage(role = ChatRole.System, content = systemPrompt),
                    ChatMessage(role = ChatRole.User, content = prompt)
                ),

            )

            val completion: ChatCompletion = client.chatCompletion(request)
            completion.choices.first().message.content ?: ""
        }
    }

    private suspend fun <T> withRetry(
        maxRetries: Int = 3,
        initialDelay: Long = 1000,
        block: suspend () -> T
    ): T {
        var currentDelay = initialDelay
        repeat(maxRetries - 1) { attempt ->
            try {
                return block()
            } catch (e: Exception) {
                println("⚠️  Attempt ${attempt + 1} failed: ${e.message}")
                delay(currentDelay)
                currentDelay *= 2
            }
        }
        return block()
    }

    fun close() {
        client.close()
    }
}