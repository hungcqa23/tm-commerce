# TM Commerce
**TM Commerce** is a microservices-based e-commerce platform, designed to provide a scalable and modular structure for online retail applications.

## Architecture

**TM Commerce** follows a **microservices architecture**, where each core function of the platform is broken down into separate, independently deployable services. This structure enhances scalability, allows for flexible deployment, and simplifies maintenance. Key services include:

- **Api Gateway**: Routes requests between services.
- **Authentication Service**: Handles user authentication, authorization, and session management.
- **Product Service**: Handles product catalog, categories, and inventory.
- **Order Service**: Manages orders, order statuses, and payments.
- **Notification Service**: Sends notifications to users (email, SMS).
- **Profile Service**: Manages user profiles, addresses, and preferences.
- **Analytics Service**: Tracks and reports platform analytics.

Each service can be developed, scaled, and deployed independently, allowing the platform to adapt quickly to changing demands and enhancements.

## Description

**TM Commerce** is a monorepo containing all code and resources for managing and deploying its microservices.

## Prerequisites

To set up and run **TM Commerce**, ensure the following are installed:

- **Java SDK 21**
- **Docker**

## Installation

To install and set up **TM Commerce**, run the following Docker commands:

```bash
# Start Neo4j container with authentication
docker run --publish=7474:7474 --publish=7687:7687 -e 'NEO4J_AUTH=neo4j/secret' neo4j:5

# Start PostgreSQL container with specified password
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=postgres -d postgres
