**This is a Spring Boot RESTful application that calculates customer reward points based on their transaction history.**

It follows the rules for reward point allocation:
1. No points for purchases <= 50
2. 1 point per 1 spend for the amount >50 and <=100
3. 2 points per 1 spend for amount >100


**Technologies Used**
Java 21
Spring Boot 3.4
Maven
Junit 5 (for tests)

**How to Run**
1. Clone repository or copy the project (https://github.com/Malamalkar/Retailer.git)
2. Import project to Intellij IDEA(as a Maven project)
3. Run the main class: RetailerApplication.java
4. Send POST request to : 
    http://localhost:8090/api/rewards/calculateRewards

**Sample POST Request**
    [
        {
        "customerId":74635437,
        "amount":100,
        "date":"2025-02-01"
        },
        {
        "customerId":78877888,
        "amount":200,
        "date":"2025-02-01"
        }
    ]
 
