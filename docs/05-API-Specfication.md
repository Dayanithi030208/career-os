# API Specification

**Project:** Career OS  
**Version:** 1.0  
**API Style:** REST Level 2  
**Base URL:** `/api/v1`

---

# 1. API Standards

- RESTful API design
- JSON request and response format
- JWT-based authentication
- Resource-oriented endpoints
- Standard HTTP status codes

---

# 2. Authentication

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/auth/register` | Register a new user | ❌ |
| POST | `/auth/login` | Authenticate user | ❌ |
| GET | `/auth/me` | Get current user | ✅ |

---

# 3. Career Profile

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/career-profile` | Retrieve career profile | ✅ |
| POST | `/career-profile` | Create career profile | ✅ |
| PUT | `/career-profile` | Update career profile | ✅ |

---

# 4. Learning Tracker

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/learning-progress` | Get all learning progress | ✅ |
| PUT | `/learning-progress/{subject}` | Update subject progress | ✅ |

---

# 5. Portfolio Projects

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/portfolio-projects` | List all projects | ✅ |
| POST | `/portfolio-projects` | Create project | ✅ |
| GET | `/portfolio-projects/{id}` | Get project details | ✅ |
| PUT | `/portfolio-projects/{id}` | Update project | ✅ |
| DELETE | `/portfolio-projects/{id}` | Delete project | ✅ |

---

# 6. Job Applications

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/job-applications` | List job applications | ✅ |
| POST | `/job-applications` | Create application | ✅ |
| GET | `/job-applications/{id}` | Get application details | ✅ |
| PUT | `/job-applications/{id}` | Update application | ✅ |
| DELETE | `/job-applications/{id}` | Delete application | ✅ |

---

# 7. Dashboard

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/dashboard` | Retrieve dashboard summary | ✅ |

---

# 8. Response Format

## Success Response

```json
{
  "success": true,
  "message": "Operation completed successfully.",
  "data": {}
}
```

## Error Response

```json
{
  "success": false,
  "message": "Validation failed.",
  "errors": []
}
```

---

# 9. HTTP Status Codes

| Code | Meaning |
|------|---------|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 409 | Conflict |
| 500 | Internal Server Error |

---

# 10. API Versioning

Current API version:

```
/api/v1
```

Future breaking changes will be introduced using a new version prefix (e.g., `/api/v2`) without affecting existing clients.
