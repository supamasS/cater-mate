# cater-mate
## Food catering app

## Daily Progress
- April 15th (80% done)
  - add ADMIN, SUPERADMIN roles and have permission set for "/users" as accessible by SUPERADMIN and "/menu" and 
    "/viewOrders" are for ADMIN & SUPERADMIN
  - any user with first name starting with "admin" will be assigned "ROLE_USER" and "ROLE_ADMIN" role
  - any user with first name starting with "superadmin" will be assigned "ROLE_USER", "ROLE_ADMIN", and "SUPERADMIN" role
  - added 3 error html pages - 403, 404, and 500 errors under "templates/error" folder.
  - add 3 custom queries for Order class and add search boxes in "View Orders" page (currently all 3 searches are "OR" 
    together)
  - TODO: style 3 search boxes so they align
  
- April 14th (75% done)
  - created a MenuItemServiceImpl bean using @Bean annotation (to satisfy a Capstone requirement)
  - finished styling registration page
  - merged the old User class to Spring security login User class

- April 12th (70% done)
  - add Spring security login from class example - still need to style registration.html page 
    and merge the old User class and related code to the example User class

### Login
- As an admin, I want to log in with an admin privilege so that I can edit the list of items in the menu, update 
the price, etc. 
  - Tasks: 
    1. Create a database and a User table containing username, password and privilege. 
    2. Login screen asking for username and password. 
    3. Check if the username exists in the User table 
    4. Check if the password matches the entry in the table 
    5. Assign the privilege to the current user login session 
    6. If login is successful, show the main screen with options according to login privilege.
  - Question: How to encrypt the password?
  

- As a user, I want to log in with a user privilege so that I can do basic operations like entering a customer's order.
  - Tasks:
    1. Same as for admin login a-e 
    2. If login is successful, show the screen for ordering.

## User Stories

### User
- As a user, I want to add each item in the order, in terms of name, options, and quantity.

- As a user, I want to see the total amount as I add each item so that I can tell the customer if needed.

#### Not implemented in this version:
- As a user, I want to have the kitchen pick sheet automatically created after I place an order.

- As a user, I want to create an invoice as a pdf file so that I can send it to the customer.

- As a user, I want to query the order that need to be filled for a specific day so that I can print the pick sheets 
for the kitchen.

### Admin
- As an admin, I want to view all the items on the menu listed with the price.

- As an admin, I want to search the menu based on customer name, date, and location.

- As an admin, I want to create a new menu item so that it's available on the menu.

- As an admin, I want to edit a menu item in terms of name, description, and price, so that it's up to date.

- As an admin, I want to delete a menu item so that it is no longer on the menu.

#### Not implemented in this version:

- As an admin, I want to view the quantity ordered for each menu item so I know which item is popular.

- As an admin, I want to add a new ingredient so that it can be used as part of an item in the menu.

- As an admin, I want to view the list of ingredients so that I see what's available.

- As an admin, I want to edit an ingredient so that I can keep it up to date.

- As an admin, I want to delete an ingredient so that it is removed from the list.

