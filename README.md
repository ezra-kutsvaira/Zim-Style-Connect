# 🛍️ ZimStyle Connect

### *AI-Driven Fashion E-Commerce Platform for Zimbabwe*

---

## 📘 Overview

**ZimStyle Connect** is an innovative, AI-powered e-commerce platform designed to transform the Zimbabwean fashion retail industry.
The system leverages **Java (Spring Boot)** for backend management, **Python (Flask + TensorFlow)** for artificial intelligence, and **MySQL** as the central database.

A unique part of the project is the **Excel-based data preparation pipeline**, which cleans and processes real-world fashion and customer data for **AI model training**.
Through **recommendation systems** and **sentiment analysis**, ZimStyle Connect provides personalized product suggestions and customer emotion insights for local fashion brands.

---

## 🎯 Objectives

* Deliver personalized fashion recommendations using machine learning.
* Analyze customer sentiments from reviews and chatbot conversations.
* Transform spreadsheet data into usable machine learning datasets.
* Provide data-driven insights for fashion businesses in Zimbabwe.
* Build a scalable, modular, and intelligent e-commerce system.

---

## 🧩 System Architecture

```
[Frontend: React]
         ↓
[Backend: Java Spring Boot]
         ↓
[AI Engine: Python Flask + TensorFlow]
         ↓
[Database: MySQL]
         ↑
[Data Source: Excel Spreadsheet → Cleaning Pipeline]
```

### **Key Components**

| Layer           | Technology                          | Function                                                   |
| --------------- | ----------------------------------- | ---------------------------------------------------------- |
| **Frontend**    | React                               | User interface for browsing, purchases, and feedback       |
| **Backend**     | Java (Spring Boot 3.x)              | REST APIs, authentication, order and user management       |
| **AI Engine**   | Python (Flask + TensorFlow + NLP)** | Product recommendation and sentiment analysis              |
| **Database**    | MySQL 8.x                           | Stores users, products, transactions, and cleaned feedback |
| **Data Source** | Excel Spreadsheet                   | Raw customer, product, and feedback data                   |
| **Security**    | Spring Security + JWT               | User authentication and authorization                      |

---

## 🧠 Artificial Intelligence Modules

### 1. **Recommendation Engine**

* Built with **TensorFlow** neural networks.
* Trains on user–product interactions extracted from the cleaned dataset.
* Uses collaborative filtering and embeddings to predict user preferences.
* Continuously improves with new data from MySQL.

### 2. **Sentiment Analysis Module**

* Powered by **NLP models** (TextBlob / VADER / Hugging Face Transformers).
* Analyzes customer reviews and chatbot feedback.
* Detects sentiment polarity (*Positive / Negative / Neutral*) and confidence score.
* Helps vendors track customer satisfaction and product perception trends.

---

## 🧮 Data Flow

1. User and product data originate from Excel spreadsheets.
2. Python scripts clean, normalize, and encode the data.
3. The processed dataset is uploaded to MySQL.
4. The Python AI engine trains models using TensorFlow/NLP.
5. Java Spring Boot interacts with Python microservices to fetch predictions.
6. Personalized recommendations and sentiment results are displayed in the frontend.

---

## ⚙️ Backend Setup (Spring Boot)

### **Key Endpoints**

| Endpoint                        | Method | Description                                |
| ------------------------------- | ------ | ------------------------------------------ |
| `/api/auth/register`            | POST   | Register a new user                        |
| `/api/auth/login`               | POST   | Authenticate and issue JWT                 |
| `/api/products`                 | GET    | Retrieve product catalog                   |
| `/api/recommendations/{userId}` | GET    | Fetch personalized product recommendations |
| `/api/feedback`                 | POST   | Submit and analyze feedback                |
| `/api/sentiment`                | POST   | Send review text to AI sentiment analyzer  |

---

## 🧑‍💻 Author

**Ezra Kutsvaira**
💻 *Java Developer | DevOps Enthusiast | Final-Year Electronic Commerce Student*
