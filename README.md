# Auto Service Information System Specification

This project outlines the specifications for an information system designed to manage an auto service company. The company consists of multiple workstations that offer a range of services and sell various products.

## System Requirements

### Services
- A centralized list of all services offered by the company is maintained.
- Each service is defined by:
  - A unique code
  - Name
  - Price

### Products
- A centralized list of all products for sale is maintained.
- Each product is defined by:
  - A unique code
  - Name
  - Price
  - Quantity in stock

### Workstations
- Each workstation in the auto service company has:
  - A unique identification number
  - Address
- Workstations can offer either the complete set or a subset of services and products available at the company level.
- Users can view all services and products offered by each workstation.

### Clients
Clients of the auto service can be either individuals or companies:
- **Individual Clients**:
  - Name
  - Surname
  - Place of residence
- **Corporate Clients**:
  - Company name
  - Headquarters location
- Each client may own multiple vehicles, with records kept for each vehicle, including:
  - Chassis number
  - Registration plate
  - Brand
  - Model
  - Type of vehicle

### Employees
- Each workstation can have multiple employees, and records are kept for each employee including:
  - Unique employee identification number
  - Name
  - Surname
  - Address
  - Username (for system access)
  - Password (for system access)
  - Job title
- An employee is associated with a single workstation, but a workstation may have multiple employees.
- Each employee can be assigned to multiple work orders, with details of tasks assigned to them recorded.

### Vehicle Intake and Assignment
- Upon vehicle intake, an assignment record is created that includes:
  - The employee who created the assignment (employee ID)
  - The vehicle assigned (chassis number)
  - The workstation handling the assignment (workstation ID)
  - Date of intake
  - Expected completion date
  - Additional description
- After creating an assignment, an initial invoice with an amount of 0.00 and a date is generated.

### Work Orders
- For each assignment, multiple work orders can be created. Each work order includes:
  - Unique work order ID
  - Expected completion date
  - Status
  - Employee who created the work order (employee ID)
- An assignment can have multiple related work orders, but each work order is linked to exactly one assignment.
- Each work order can include various services and products.

### Invoice and Stock Management
- Adding a new service or product to a work order automatically increases the invoice total for the corresponding assignment.
- Removing a service or product from a work order adjusts the invoice amount accordingly and updates the stock quantity of the product.
  - When adding `x` quantity of a product to a work order, the stock level of that product decreases accordingly.
- The system displays the list of services and products in each work order, along with the revenue from sold products and services.

## Implementation Notes
- This project should adhere to:
  - Object-oriented programming principles
  - Clean code practices
  - Variable and function naming conventions consistent with the chosen programming language
