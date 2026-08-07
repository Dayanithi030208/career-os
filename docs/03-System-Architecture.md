# System Architecture

**Project:** Career OS  
**Version:** 1.0  
**Architecture Style:** Modular Monolith

---

# 1. Overview

Career OS follows a **Modular Monolith Architecture** where all business capabilities are developed within a single Spring Boot application while maintaining clear module boundaries.

This architecture was chosen because it provides a clean separation of concerns, simplifies deployment, reduces operational complexity, and is well-suited for a single developer building an MVP. It also allows the application to evolve into microservices in the future if required.

---

# 2. Why Modular Monolith?

| Modular Monolith | Microservices |
|------------------|--------------|
| Single deployment | Multiple deployments |
| Easier debugging | Distributed debugging |
| Simple local development | Requires service orchestration |
| Lower infrastructure cost | Higher infrastructure cost |
| Perfect for MVP | Better for large-scale teams |

### Decision

For Version 1, a Modular Monolith offers the best balance between maintainability, scalability, and development speed.

---

# 3. High-Level Architecture

```text
                    +----------------------+
                    |        User          |
                    +----------+-----------+
                               |
                               | HTTPS
                               |
                    +----------v-----------+
                    |   React Frontend     |
                    +----------+-----------+
                               |
                               | REST API
                               |
                    +----------v-----------+
                    | Spring Boot Backend  |
                    +----------------------+
                               |
     ----------------------------------------------------------
     |            |              |             |               |
     |            |              |             |               |
+----v----+ +-----v-----+ +------v------+ +----v-----+ +-------v-------+
| Auth    | | Career    | | Learning    | | Projects | | Job Tracker   |
| Module  | | Profile   | | Tracker     | | Tracker  | |               |
+----+----+ +-----+-----+ +------+------+-+----+-----+ +-------+-------+
     |            |              |             |               |
     +------------+--------------+-------------+---------------+
                               |
                    +----------v-----------+
                    | Career Readiness     |
                    | Engine               |
                    +----------+-----------+
                               |
                    +----------v-----------+
                    | Recommendation       |
                    | Engine               |
                    +----------+-----------+
                               |
                    +----------v-----------+
                    | PostgreSQL Database  |
                    +----------------------+
```

---

# 4. Backend Architecture

The backend follows a layered architecture.

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
PostgreSQL
```

Each layer has a single responsibility.

| Layer | Responsibility |
|--------|----------------|
| Controller | Handle HTTP requests and responses |
| Service | Business logic |
| Repository | Database interaction |
| Entity | Persistent domain objects |
| DTO | Request and response models |
| Security | Authentication and authorization |
| Config | Application configuration |
| Exception | Centralized error handling |

---

# 5. Module Responsibilities

| Module | Responsibility |
|---------|----------------|
| Authentication | User registration, login, JWT authentication |
| Career Profile | Career goals and user information |
| Learning Tracker | Track progress across core CS subjects |
| Project Tracker | Manage software engineering projects |
| Job Tracker | Track applications and interview stages |
| Career Readiness Engine | Evaluate overall readiness |
| Recommendation Engine | Generate daily recommendations with explanations |

---

# 6. Request Lifecycle

Every client request follows the same flow.

```text
User
 │
 ▼
React Frontend
 │
 ▼
REST Controller
 │
 ▼
Service Layer
 │
 ▼
Repository Layer
 │
 ▼
PostgreSQL
 │
 ▼
Repository
 │
 ▼
Service
 │
 ▼
Controller
 │
 ▼
React Frontend
 │
 ▼
User
```

---

# 7. Design Principles

The architecture follows these principles:

- Modular Monolith
- Layered Architecture
- Separation of Concerns
- Single Responsibility Principle (SRP)
- Dependency Injection
- Stateless REST APIs
- JWT-Based Authentication
- Future Extensibility

---

# 8. Deployment Architecture

```text
+----------------+
| React Frontend |
|    (Vercel)    |
+-------+--------+
        |
        | HTTPS
        |
+-------v--------+
| Spring Boot    |
| Railway/Render |
+-------+--------+
        |
        |
+-------v--------+
| PostgreSQL     |
+----------------+
```

---

# 9. Architecture Decisions

| Decision | Reason |
|----------|--------|
| Modular Monolith | Simplifies development and deployment |
| React + TypeScript | Strong type safety and modern frontend ecosystem |
| Spring Boot | Robust backend framework with mature ecosystem |
| PostgreSQL | Reliable relational database for structured data |
| JWT Authentication | Stateless and scalable authentication |
| REST APIs | Simple and widely adopted communication protocol |

---

# 10. Future Evolution

The current architecture is designed for Version 1.

Future versions can introduce:

- AI Career Coach
- GitHub Integration
- LeetCode Integration
- Calendar Integration
- Microservice extraction (if required)

No architectural redesign should be required to support these future enhancements.
