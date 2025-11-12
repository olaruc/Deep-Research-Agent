package com.cristian.research

import com.aallam.openai.api.chat.ChatCompletion
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val dotenv = dotenv()

    val apiKey = dotenv["API_KEY"]

    println("🔑 Testing OpenAI API key...")

    // Create OpenAI client
    val openAI = OpenAI(apiKey)

    try {
        // Create chat completion request
        val chatCompletionRequest = ChatCompletionRequest(
            model = ModelId("gpt-4o-mini"),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.User,
                    content = "How are you?"
                )
            ),
            maxTokens = 100,
            temperature = 0.7
        )

        // Send request
        val completion: ChatCompletion = openAI.chatCompletion(chatCompletionRequest)

        // Extract response
        val reply = completion.choices.firstOrNull()?.message?.content

        println("\n✅ Success!")
        println(" Assistant reply: $reply")
        println("Tokens used: ${completion.usage?.totalTokens}")

    } catch (e: Exception) {
        println("\nError: ${e.message}")
        e.printStackTrace()
    }
}