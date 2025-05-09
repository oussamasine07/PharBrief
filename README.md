# Pharmacy Product Management API

This project is a RESTful API developed using Spring Boot to manage pharmacy products effectively. It is designed to support a new pharmacy owner in organizing and maintaining the product inventory, ensuring better stock visibility and reducing time spent on manual product tracking.

---

## ✨ Features

As the pharmacy owner, you can:

- **Add** new products to the inventory by providing:
    - Product name
    - Quantity in stock
    - Price
    - Short description  
      *(The ID is generated automatically)*

- **Update** existing product details to correct or refresh data such as:
    - Quantity
    - Price
    - Description

- **Delete** products that are no longer needed or are obsolete.

- **Retrieve** the full list of available products in the inventory.

---

## 🛠️ Tech Stack

- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** or **PostgreSQL**
- **Postman** (for API testing)

---

## 📦 API Endpoints

| Method | Endpoint         | Description                      |
|--------|------------------|----------------------------------|
| POST   | `/api/products`  | Add a new product                |
| GET    | `/api/products`  | Get the list of all products     |
| GET    | `/api/products/{id}` | Get details of a specific product |
| PUT    | `/api/products/{id}` | Update an existing product     |
| DELETE | `/api/products/{id}` | Delete a product               |

---

## 🧪 Testing the API

You can use [Postman](https://.postman.co/workspace/My-Workspace~613763ab-1af0-4e3d-87b9-4fde1d40207c/collection/4121566-b728d164-e554-4ae8-9438-20c23b86f659?action=share&creator=4121566) to test the endpoints:

1. Start your Spring Boot application.
2. Use the above endpoints with JSON request bodies.
3. Example `POST` request body:
```json
{
  "name": "Paracetamol 500mg",
  "quantity": 100,
  "price": 2.99,
  "description": "Pain reliever and fever reducer"
}
