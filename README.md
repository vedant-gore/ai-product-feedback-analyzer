# 🧠 AI Product Feedback Analyzer

> ✨ Summarize user/product feedback using local AI  
> 🤖 Powered by **TinyLlama** via Ollama + Spring AI  
> 🐳 Fully **Dockerized** and **100% offline** — No API keys, No cloud, No limits

---

[![Java](https://img.shields.io/badge/Java-21-red?logo=java)](https://adoptium.net/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.7-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)  
[![Spring AI](https://img.shields.io/badge/Spring--AI-1.0.0-purple?logo=spring)](https://docs.spring.io/spring-ai/)  
[![Ollama](https://img.shields.io/badge/Ollama-TinyLlama-yellow)](https://ollama.com)  
[![Dockerized](https://img.shields.io/badge/Docker-Ready-blue?logo=docker)](https://www.docker.com/)  
[![Local Only](https://img.shields.io/badge/LLM-100%25%20Offline-critical)](#)  
[![MIT License](https://img.shields.io/badge/License-MIT-lightgrey)](LICENSE)

---

## 🧾 What It Does

Give it user feedback like:

> “I love the design, but it crashes every time I try to share a photo.”

It returns:

Summary: Crash issue during photo sharing.
Sentiment: Mixed (Positive UI, negative stability).
Suggested Action: Investigate crash on sharing functionality.


✔️ **No JSON**  
✔️ **Plain text insights**  
✔️ **LLM-level summarization** without the cloud

---

## ⚙️ Tech Stack

| Layer         | Tech                        |
|---------------|-----------------------------|
| AI Model      | 🧠 TinyLlama (via Ollama)    |
| Prompt Engine | Spring AI 1.0.0             |
| Language      | ☕ Java 21                   |
| Framework     | Spring Boot 3.4.x           |
| Runtime       | 🐳 Docker & Docker Compose  |
| Output        | 📝 Plain Text Only           |

---

## 🧠 How It Works

User Feedback → Spring AI PromptTemplate → ChatClient → Ollama (TinyLlama) → Insightful Summary


---

## 🐳 Run with Docker + Ollama

### 🧱 Prerequisites

- [Ollama](https://ollama.com/) installed and running
- [Docker](https://www.docker.com/) installed

### 🏃 Steps to Run

1. **Pull the model**  
```bash
ollama pull tinyllama

2. **Start the model server**
ollama run tinyllama

3. **Clone & run the app**
git clone https://github.com/vedant-gore/ai-feedback-analyzer.git
cd ai-feedback-analyzer
docker-compose up --build
