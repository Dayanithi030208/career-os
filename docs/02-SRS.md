
# Software Requirements Specification (SRS)

**Project:** Career OS  
**Version:** 1.0  
**Status:** Approved for Development  
**Document Owner:** Dayanithi Ganapathi

---

# 1. Introduction

## 1.1 Purpose

This Software Requirements Specification (SRS) defines the technical requirements for Version 1 (V1) of Career OS.

It translates the product requirements into software requirements that guide the design, development, testing, and deployment of the system.

This document intentionally avoids implementation details such as database schema, API contracts, and business algorithms, which are covered in separate technical documents.

---

## 1.2 Scope

Career OS is a web application that enables Computer Science students to manage their interview preparation through a single platform.

The system allows users to:

- Manage their career profile
- Track learning progress
- Manage software projects
- Track job applications
- Measure career readiness
- Receive actionable daily recommendations

---

## 1.3 Intended Audience

This document is intended for:

- Software Developers
- Software Architects
- Test Engineers
- Future Contributors
- Project Owner

---

# 2. System Overview

Career OS follows a Modular Monolith architecture consisting of a React frontend, Spring Boot backend, and PostgreSQL database.

The system exposes REST APIs consumed by the frontend while maintaining business logic within backend service modules.

The Career Readiness Engine acts as the central business component responsible for evaluating user progress and generating recommendations.

---

## Technology Stack

### Frontend

- React
- TypeScript
- Tailwind CSS
- React Router
- TanStack Query

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication

### Database

- PostgreSQL

### Deployment

- Frontend: Vercel
- Backend: Railway / Render
- Database: PostgreSQL

---

# 3. Functional Requirements

---

## Authentication Module

### FR-001

The system shall allow users to register using email and password.

Acceptance Criteria

- Email must be unique.
- Password must be securely encrypted.
- Successful registration creates a new account.

---

### FR-002

The system shall authenticate registered users.

Acceptance Criteria

- Valid credentials generate a JWT token.
- Invalid credentials return an authentication error.

---

### FR-003

The system shall restrict protected resources to authenticated users only.

---

## Career Profile Module

### FR-004

The system shall allow users to create and maintain a single Career Profile.

The profile includes:

- Target Role
- Current Skill Level
- Career Goal

---

### FR-005

Users shall be able to update their Career Profile at any time.

---

## Learning Tracker Module

### FR-006

The system shall track learning progress for the following subjects:

- Data Structures & Algorithms
- Operating Systems
- Database Management Systems
- Computer Networks
- Object-Oriented Programming
- System Design

---

### FR-007

Each subject shall store a progress percentage ranging from 0 to 100.

---

### FR-008

Users shall be able to update progress manually.

---

## Project Tracker Module

### FR-009

Users shall be able to create personal software projects.

Each project contains:

- Title
- Description
- Technology Stack
- GitHub URL
- Live URL (Optional)
- Status
- Completion Percentage

---

### FR-010

Users shall be able to edit and delete existing projects.

---

## Job Tracker Module

### FR-011

Users shall be able to record job applications.

Each application contains:

- Company
- Role
- Application Date
- Current Stage
- Notes

---

### FR-012

Users shall be able to update application stages.

Supported stages include:

- Applied
- Online Assessment
- Technical Interview
- HR Interview
- Offer
- Rejected

---

## Career Readiness Engine

### FR-013

The system shall calculate an overall Career Readiness Score.

---

### FR-014

The system shall identify weak areas contributing to the readiness score.

---

### FR-015

The system shall generate the highest-impact task for the current day.

---

### FR-016

Every recommendation shall include an explanation describing why it was generated.

---

## Dashboard

### FR-017

The dashboard shall display:

- Career Readiness Score
- Today's Highest-Impact Task
- Weak Areas
- Weekly Progress Summary

---

# 4. Non-Functional Requirements

## Performance

### NFR-001

Dashboard data should load within 2 seconds under normal operating conditions.

---

## Security

### NFR-002

Passwords shall never be stored in plain text.

---

### NFR-003

Authentication shall use JWT-based authorization.

---

### NFR-004

Protected endpoints shall require valid authentication.

---

## Scalability

### NFR-005

The system shall follow a Modular Monolith architecture to support future modular expansion.

---

## Maintainability

### NFR-006

The application shall follow a layered architecture separating:

- Controllers
- Services
- Repositories
- Domain Models

---

### NFR-007

Business logic shall remain independent from presentation logic.

---

## Reliability

### NFR-008

Unexpected errors shall be handled gracefully.

---

### NFR-009

Input validation shall be performed before business processing.

---

# 5. System Modules

## Authentication

Responsibilities

- Registration
- Login
- JWT Generation
- Authorization

---

## Career Profile

Responsibilities

- Store career goals
- Maintain target role
- Maintain current skill level

---

## Learning Tracker

Responsibilities

- Store learning progress
- Update subject completion
- Provide learning data to the Readiness Engine

---

## Project Tracker

Responsibilities

- Store project portfolio
- Track completion
- Provide project data to the Readiness Engine

---

## Job Tracker

Responsibilities

- Manage job applications
- Track interview stages
- Store interview history

---

## Career Readiness Engine

Responsibilities

- Evaluate career readiness
- Analyze weak areas
- Generate daily recommendations

---

# 6. Business Rules

### BR-001

Each account owns exactly one Career Profile.

---

### BR-002

Only authenticated users may access personal career data.

---

### BR-003

Progress percentage shall remain between 0 and 100.

---

### BR-004

Every project belongs to exactly one user.

---

### BR-005

Every job application belongs to exactly one user.

---

### BR-006

Every recommendation must include an explanation.

---

### BR-007

The readiness score shall be recalculated whenever relevant career data changes.

---

# 7. External Interfaces

## REST APIs

The backend shall expose REST APIs for:

- Authentication
- Career Profile
- Learning Tracker
- Project Tracker
- Job Tracker
- Dashboard

---

## Database

PostgreSQL

---

## Authentication

JWT

---

# 8. Assumptions & Constraints

## Assumptions

- Every account represents one student.
- Learning progress is updated manually.
- Users provide accurate project information.
- Internet connectivity is available.

---

## Constraints

- Modular Monolith architecture
- Free-tier deployment
- No AI functionality in Version 1
- No external integrations in Version 1

---

# 9. Out of Scope

The following capabilities are excluded from Version 1:

- AI Career Coach
- Resume Analyzer
- ATS Checker
- GitHub Integration
- LeetCode Integration
- Calendar Integration
- Browser Extension
- Mobile Application
- Notifications

---

# 10. Traceability

| PRD Requirement | SRS Section |
|-----------------|------------|
| Authentication | FR-001 – FR-003 |
| Career Profile | FR-004 – FR-005 |
| Learning Tracker | FR-006 – FR-008 |
| Project Tracker | FR-009 – FR-010 |
| Job Tracker | FR-011 – FR-012 |
| Readiness Engine | FR-013 – FR-016 |
| Dashboard | FR-017 |
