# radsanWebsite
Revamp Radha Sangi Industries
# A Flow diagram on how Category entity works
<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/921659e1-aec7-49df-809f-510c977a9bfe" />
**Notes**
Browser / Frontend
        |
        v
CategoryController
(GET /api/categories)
        |
        v
CategoryService
(Business Logic)
        |
        v
CategoryRepository
(Spring Data JPA)
        |
        v
Category Entity
(JPA mapping)
        |
        v
PostgreSQL
(categories table)


