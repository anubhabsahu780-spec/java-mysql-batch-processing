# Java MySQL Batch Example

This project demonstrates how to use **JDBC Batch Processing** to execute multiple SQL statements efficiently in one go.

## 🛠️ Setup Requirements
* **Java JDK:** 8 or higher.
* **Database:** MySQL Server.
* **Driver:** `mysql-connector-j-xxxx.jar` (Already included in the project folder).

## 🚀 How to Run in VS Code
1. Open the project in **VS Code**.
2. Go to the **Java Projects** view in the sidebar.
3. Locate **Referenced Libraries** and click the `+` icon.
4. Select the `mysql-connector-j-xxxx.jar` file.
5. Open `Batch_Example.java` and click **Run**.

## 💻 Manual Terminal Command
If you prefer the terminal, use the following command (replace with your JAR name):
```bash
javac Batch_Example.java
java -cp ".;mysql-connector-j-9.0.0.jar" Batch_Example
