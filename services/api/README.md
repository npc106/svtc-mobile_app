# SVTC API Service

Backend API for the SVTC MVP system.

## Current Status

This folder currently contains an API contract draft only. No database, migration, or backend runtime has been created yet.

Files:

- `openapi.yaml`: mobile-facing API contract draft for authentication, profile, dashboard, classes, sessions, devices, and notifications.

## MVP Scope

- Google authentication verification for students.
- Admin authentication.
- Student, course, class, lesson, and notification APIs.
- CSV import processing.
- Schedule generation.
- Push notification scheduling and cancellation.

## Data Rules

- Store timestamps in UTC.
- Display times in `Asia/Ho_Chi_Minh`.
- Keep reference codes on core data for future integration with SVTC systems.
- Do not commit secrets or personal service credentials.

## Setup

Add backend service files here after choosing the API stack.

Do not add database migrations or schema files until the database design is confirmed.
