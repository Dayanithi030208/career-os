# Product Requirements Document (PRD)

**Project:** Career OS  
**Version:** 1.0  
**Status:** Approved for Development  
**Document Owner:** Dayanithi Ganapathi

---

# 1. Overview

Career OS is an intelligent career companion designed to help Computer Science students prepare for software engineering roles. Instead of managing tasks, it evaluates a user's interview readiness, identifies their weakest areas, and recommends the highest-impact action to improve every day.

The product aims to replace scattered preparation across multiple tools with a single system that guides users toward their career goals.

---

# 2. Problem Statement

Students preparing for software engineering interviews often rely on multiple disconnected tools such as coding platforms, notes, spreadsheets, resumes, calendars, and job trackers.

While these tools help manage information, none of them answer the most important question:

> **"What is the most valuable thing I should do today to increase my chances of getting a software engineering job?"**

Career OS addresses this gap by combining career tracking with intelligent recommendations.

---

# 3. Vision

To become the operating system for software engineering career preparation by helping students understand where they stand, what they should improve, and how they can consistently progress toward their career goals.

---

# 4. Product Goals

The product aims to help users:

- Measure their overall interview readiness.
- Track learning progress across core Computer Science subjects.
- Organize personal projects.
- Monitor job applications and interview progress.
- Recommend the highest-impact task every day.
- Visualize long-term improvement through meaningful analytics.

---

# 5. Target Users

### Primary Users

- Computer Science Students
- Information Technology Students
- Fresh Graduates
- Software Engineering Aspirants

### Future Expansion

- Career Switchers
- Experienced Software Engineers
- Students from other engineering disciplines

---

# 6. MVP Scope

Version 1 includes the following modules:

## Authentication

- User Registration
- Login
- Secure Authentication

## Career Profile

- Target Role
- Current Skill Level
- Career Goal

## Learning Tracker

Track progress in:

- Data Structures & Algorithms
- Operating Systems
- Database Management Systems
- Computer Networks
- Object-Oriented Programming
- System Design

## Project Tracker

Manage:

- Personal Projects
- Progress Status
- Completion Status

## Job Tracker

Track:

- Job Applications
- Online Assessments
- Interviews
- Offers

## Career Readiness Engine

Generate:

- Career Readiness Score
- Weak Area Analysis
- Daily Highest-Impact Task
- Weekly Progress Summary

---

# 7. Functional Requirements

| ID | Requirement | Priority |
|----|-------------|----------|
| FR-01 | Users shall be able to register and log in securely. | Must |
| FR-02 | Users shall maintain a career profile. | Must |
| FR-03 | Users shall track learning progress across core CS subjects. | Must |
| FR-04 | Users shall manage personal software projects. | Must |
| FR-05 | Users shall track job applications and interview stages. | Must |
| FR-06 | The system shall calculate a Career Readiness Score. | Must |
| FR-07 | The system shall recommend the highest-impact task for the day. | Must |
| FR-08 | The system shall explain why a recommendation was generated. | Must |
| FR-09 | Users shall view their overall progress over time. | Must |

---

# 8. Non-Functional Requirements

| ID | Requirement |
|----|-------------|
| NFR-01 | The application should provide a clean and intuitive user experience. |
| NFR-02 | Authentication must be secure using JWT. |
| NFR-03 | The system should be modular and easily extensible. |
| NFR-04 | The application should be deployable using free-tier cloud services. |
| NFR-05 | The architecture should support future AI integration without major redesign. |

---

# 9. Out of Scope (Version 1)

The following features are intentionally excluded from the MVP:

- AI Chat Assistant
- Resume Analyzer
- ATS Resume Checker
- GitHub Integration
- LeetCode Integration
- Calendar Synchronization
- Browser Extension
- Mobile Application
- Push Notifications

These features will be considered in future releases.

---

# 10. Success Metrics

Career OS will be considered successful if users can:

- Clearly understand their current interview readiness.
- Know what to work on every day without manual planning.
- Track measurable improvement over time.
- Manage interview preparation from a single platform.

---

# 11. Future Roadmap

### Version 1

Career Tracking Platform

### Version 2

AI Career Coach

### Version 3

Automatic Integrations

- GitHub
- LeetCode
- Calendar

### Version 4

Company-Specific Interview Preparation

### Version 5

Complete Engineering Career Platform

---

# 12. Product Principles

Career OS follows these guiding principles:

- Every metric should lead to an actionable recommendation.
- AI should assist learning rather than replace it.
- Minimize manual effort wherever possible.
- Every recommendation should explain its reasoning.
- Users should spend more time improving than managing the application.

---

# 13. Definition of Success

Career OS is successful when it:

- Solves a real career preparation problem.
- Demonstrates strong software engineering practices.
- Provides meaningful daily guidance.
- Remains maintainable and extensible.
- Becomes a product that users genuinely rely on during interview preparation.
