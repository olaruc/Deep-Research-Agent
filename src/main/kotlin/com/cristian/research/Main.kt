package com.cristian.research

import com.aallam.openai.api.model.Model
import com.cristian.research.config.Config
import com.cristian.research.service.OpenAIService
import kotlinx.coroutines.runBlocking
import com.aallam.openai.client.OpenAI
import com.sun.tools.javac.tree.TreeInfo.args
import kotlinx.serialization.json.Json


fun main(args: Array<String>) = runBlocking {
    println("DEEP RESEARCH AGENT — Kotlin CLI ")
    println("=" .repeat(72))

    // Check API key
    if (Config.API_KEY.contains("your-")) {
        println(" Error: Please set your OpenAI API key in Config.kt")
        return@runBlocking
    }


    // User is asked for a research topic
    val topic = if (args.isNotEmpty()) {
        args.joinToString(" ").trim()
    } else {
        print("Enter research topic: ")
        readLine()?.trim().orEmpty().ifBlank { "artificial intelligence" }
    }

    println("\n📋 Research Topic: $topic")
    println("=".repeat(72))

    // Test OpenAI
    val openAI = OpenAIService(apiKey = Config.API_KEY)
    val json = Json { ignoreUnknownKeys = true; isLenient = true }


    val client = OpenAI(Config.API_KEY)
    try {
        val response = openAI.chat("Generate a structured deep research output on: \"$topic\".")

        println("-".repeat(60))
        println(response)
        println("-".repeat(60))

    } catch (e: Exception) {
        println("\nError: ${e.message}")
        e.printStackTrace()
    } finally {
        openAI.close()
    }
}