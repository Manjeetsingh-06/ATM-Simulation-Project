# ATM-Simulation-Project
“A console-based ATM simulation in Java using OOP principles. It supports PIN authentication, balance inquiry, deposits, withdrawals, transaction history, and PIN change with input validation.”

🏧 ATM Simulation – Java Console Project

A console-based ATM Simulation project developed in Java using Object-Oriented Programming (OOP) principles.
This project simulates real ATM operations such as authentication, balance inquiry, deposits, withdrawals, and transaction tracking.

📌 Project Description 

A console-based ATM simulation in Java using OOP concepts. It supports PIN authentication, balance checking, deposits, withdrawals, transaction history, and PIN change with input validation.

✨ Features

PIN verification with limited attempts

Check account balance

Deposit money

Withdraw money with limits

Transaction history tracking

Change ATM PIN

Secure logout

Input validation

🧠 OOP Concepts Used

Encapsulation

Abstraction

Modularity

Object interaction

Use of constants

🗂️ Project Structure

ATM-Simulation/


├── ATMSimulation.java   // Main entry point

├── ATM.java             // ATM logic and menu handling

├── Account.java         // Account data and transactions

└── README.md            // Project documentation


▶️ How to Run
Prerequisites

Java JDK 8 or above

Compile
javac *.java

Run
java ATMSimulation

🔑 Default Settings

Default PIN: 1234

Initial Balance: 1000.00

Maximum PIN Attempts: 3

Withdrawal Limit: 1.00 – 500.00

🔄 Console Flowchart

START

  ↓
	
Enter PIN

  ↓
	
PIN Verified?

  ├─ No → Retry (Max 3) → Exit
	
  └─ Yes
	
       ↓
			 
     ATM Menu
		 
       ↓
			 
 Perform Operation
 
       ↓
			 
     Logout
		 
       ↓
			 
      END
			

🚀 Future Enhancements

Multiple user accounts

File handling (persistent storage)

GUI using Swing/JavaFX

Daily withdrawal limits

Admin panel

👨‍💻 Author

Manjeet Singh

📜 License

This project is created for learning and educational purposes and is free to use and modify.
