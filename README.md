# Deep-Research-Agent
A command-line AI deep research agent built in Kotlin that generates structured, analytical Markdown reports on any topic using OpenAI API.

## Feautures 
* Interactive CLI -> user can ask any information directly from terminal.
* Deep structured reasoning -> the agent logically analyzes topics across causes, effects, risks, and insights.
* Formatted Markdown output -> ready for documentation, reports or summmaries.
* Automatic retries -> built-in handling dor transient network issues.

## Project structure
```
src/
├─ main/
│  ├─ kotlin/
│  │  ├─ com/cristian/research/
│  │  │  ├─ Main.kt
│  │  │  ├─ config/Config.kt
│  │  │  └─ service/
│  │  │     └─ OpenAIService.kt
└─ test/ 
```

## Requirements
* JDK 18+ (or 21 for Kotlin 2.0)
* Gradle 8+
* Kotlin 2.0.0
* OpenAI API key

## Configuration
API authorization is done using a key loaded from the ```.env``` file with the name ```API_KEY=your_key```.

## Running the agent
For running the agent run ```./gradlew run``` which will ask in the terminal the topic.</br>
Or a topic directly ```./gradlew run --args="Your_Topic"```

## Configuration
## Developed by
Cristian Olaru
