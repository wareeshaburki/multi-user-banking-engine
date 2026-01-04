# Multi-User Banking Engine (Java) 

A console-based backend engine designed to handle multi-user banking operations with a focus on logic and data integrity.

### Core Features:
* **Object-to-Object Communication:** Managing dynamic references between `User` and `Account` objects.
* **Transactional Integrity:** A secure transfer module ensuring dual-sided balance updates.
* **Error Resilience:** Robust `try-catch` implementation to handle Scanner buffer issues and invalid inputs.

### Logic Highlights:
* **Buffer Management:** Solved the common `Scanner` newline issue using flush logic.
* **State Control:** Implemented status flags (`found`) to manage user search sessions efficiently.
