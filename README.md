# Mobile App SVTC

Repository for the SVTC MVP system.

The MVP includes:

- Android mobile app for students.
- Admin web app for SVTC staff.
- Backend API.
- PostgreSQL database.
- Push notification integration.
- Project documentation.

## Project Structure

```text
mobile-app-svtc/
├─ apps/
│  ├─ mobile/        # Android student app
│  └─ admin/         # Admin web app
├─ services/
│  └─ api/           # Backend API
├─ docs/             # Product and technical documents
├─ infra/            # Local infrastructure and deployment notes
├─ docker-compose.yml
├─ .env.example
└─ README.md
```

## Suggested Stack

- Mobile: Android Kotlin + Jetpack Compose.
- Admin: React or Next.js.
- API: Node.js/NestJS or another backend framework selected by the team.
- Database: PostgreSQL.
- Push notifications: Firebase Cloud Messaging.

## First Development Milestones

1. Define database schema for students, classes, courses, lessons, and notifications.
2. Build backend authentication and admin APIs.
3. Build admin web screens for importing students and managing schedules.
4. Build Android login, home, schedule, lesson detail, notifications, and profile screens.
5. Add push notification workflows.

## Local Setup

Copy the environment file:

```bash
cp .env.example .env
```

Start local database services:

```bash
docker compose up -d
```

Application-specific setup instructions should be added in:

- `apps/mobile/README.md`
- `apps/admin/README.md`
- `services/api/README.md`

## Documentation

Project requirement documents are stored in `docs/`.

