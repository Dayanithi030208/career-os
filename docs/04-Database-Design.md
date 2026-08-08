# Database Design

**Project:** Career OS  
**Version:** 1.0  
**Database:** PostgreSQL

---

# 1. Overview

Career OS uses PostgreSQL as its primary relational database.

The database is designed using normalization principles to minimize data redundancy while maintaining simplicity and scalability.

The schema supports Version 1 of the application and is structured to allow future integrations without requiring major schema changes.

---

# 2. Database Design Principles

The database follows the following principles:

- Normalize data where appropriate.
- Keep entities independent and reusable.
- Avoid duplicated information.
- Maintain referential integrity using foreign keys.
- Store timestamps for auditing.
- Design for future expansion without breaking existing schema.

---

# 3. Entity Relationship Diagram (ERD)

```text
                     +----------------+
                     |      User      |
                     +----------------+
                     | id             |
                     | name           |
                     | email          |
                     | password       |
                     +--------+-------+
                              |
      -------------------------------------------------
      |                 |                |            |
      |                 |                |            |
      ▼                 ▼                ▼            ▼

+---------------+ +----------------+ +------------+ +----------------+
| CareerProfile | |LearningProgress| | Project    | | JobApplication |
+---------------+ +----------------+ +------------+ +----------------+
        |                 |                 |                |
        |                 |                 |                |
        +-----------------+-----------------+----------------+
                              |
                              ▼
                     Career Readiness Engine
                              |
                              ▼
                   Recommendation Engine
```

---

# 4. Database Schema

## User

| Column | Type | Constraints |
|---------|------|-------------|
| id | UUID | Primary Key |
| name | VARCHAR(100) | Not Null |
| email | VARCHAR(255) | Unique |
| password | VARCHAR(255) | Not Null |
| created_at | TIMESTAMP | Not Null |
| updated_at | TIMESTAMP | Not Null |

---

## Career Profile

| Column | Type | Constraints |
|---------|------|-------------|
| id | UUID | Primary Key |
| user_id | UUID | Foreign Key |
| target_role | VARCHAR(100) | Not Null |
| current_level | VARCHAR(50) | Not Null |
| career_goal | TEXT | Nullable |
| created_at | TIMESTAMP | Not Null |
| updated_at | TIMESTAMP | Not Null |

---

## Learning Progress

| Column | Type | Constraints |
|---------|------|-------------|
| id | UUID | Primary Key |
| user_id | UUID | Foreign Key |
| subject | VARCHAR(100) | Not Null |
| progress | INTEGER | 0–100 |
| updated_at | TIMESTAMP | Not Null |

---

## Project

| Column | Type | Constraints |
|---------|------|-------------|
| id | UUID | Primary Key |
| user_id | UUID | Foreign Key |
| title | VARCHAR(150) | Not Null |
| description | TEXT | Nullable |
| tech_stack | TEXT | Nullable |
| github_url | VARCHAR(255) | Nullable |
| live_url | VARCHAR(255) | Nullable |
| status | ENUM | Not Null |
| completion_percentage | INTEGER | 0–100 |
| created_at | TIMESTAMP | Not Null |
| updated_at | TIMESTAMP | Not Null |

---

## Job Application

| Column | Type | Constraints |
|---------|------|-------------|
| id | UUID | Primary Key |
| user_id | UUID | Foreign Key |
| company | VARCHAR(150) | Not Null |
| role | VARCHAR(150) | Not Null |
| application_date | DATE | Not Null |
| status | ENUM | Not Null |
| notes | TEXT | Nullable |
| created_at | TIMESTAMP | Not Null |
| updated_at | TIMESTAMP | Not Null |

---

# 5. Entity Relationships

| Parent | Child | Relationship |
|---------|-------|--------------|
| User | Career Profile | One-to-One |
| User | Learning Progress | One-to-Many |
| User | Project | One-to-Many |
| User | Job Application | One-to-Many |

---

# 6. Design Decisions

## UUID as Primary Key

UUIDs are used instead of auto-incrementing IDs to improve uniqueness and simplify future distributed deployments.

---

## Learning Progress

Learning progress is stored as one record per subject rather than one column per subject.

Example:

| Subject | Progress |
|----------|----------|
| DSA | 80 |
| OS | 65 |
| DBMS | 50 |

This approach allows new subjects to be added without modifying the schema.

---

## Enumerations

The following fields use enums:

### Project Status

- Planned
- In Progress
- Completed

### Job Application Status

- Applied
- Online Assessment
- Technical Interview
- HR Interview
- Offer
- Rejected

Enums ensure consistency while keeping values readable.

---

## Audit Fields

Every entity stores:

- created_at
- updated_at

These support auditing and future analytics.

---

# 7. Future Database Evolution

The current schema is intentionally minimal.

Future versions may introduce additional entities such as:

- Interview
- Resume
- Company
- Achievement
- GitHub Repository
- LeetCode Submission
- Calendar Event
- AI Recommendation History

These can be added without modifying the existing core entities.
