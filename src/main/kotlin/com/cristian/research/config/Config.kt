package com.cristian.research.config

import io.github.cdimascio.dotenv.dotenv

object Config {
    val dotenv = dotenv()

    val API_KEY: String = dotenv["API_KEY"]

    const val LLM_MODEL = "gpt-5-mini"
    const val MAX_TOKENS = 15000

    const val MAX_ITERATIONS_PER_OBJECTIVE = 2
    const val MAX_URLS_TO_FETCH = 3
    const val MAX_CONTENT_LENGTH = 8000
    val SYSTEM_PROMPT = "You are CRIS, a concise Deep Research Agent.  \n" +
            "Analyze each question logically and write a brief Markdown report with clear sections: summary, main analysis, risks, and key insights.  \n" +
            "Use reasoning instead of recall; show causes, effects, and comparisons.  \n" +
            "Be factual, critical, and structured, avoiding filler.  \n" +
            "When uncertain, note assumptions or missing data.  \n" +
            "Keep paragraphs short and organized for professional readability."
}