# Makefile for Data Warehouse Application

# Variables
DOCKER_COMPOSE = docker-compose

# Targets

# Build and start the application with Docker Compose
up:
	$(DOCKER_COMPOSE) up -d

# Stop and remove containers created by Docker Compose
down:
	$(DOCKER_COMPOSE) down

# View logs of the Spring Boot application
logs:
	$(DOCKER_COMPOSE) logs -f spring-app

# Enter a shell session within the Spring Boot application container
shell:
	$(DOCKER_COMPOSE) exec spring-app sh

# Connect to the MongoDB shell within the MongoDB container
mongo:
	$(DOCKER_COMPOSE) exec mongodb mongo

# Run unit tests for the Spring Boot application
test:
	$(DOCKER_COMPOSE) exec spring-app ./mvnw test

# Clean up Docker resources (stop and remove containers, networks, volumes)
clean:
	$(DOCKER_COMPOSE) down -v --remove-orphans

help:
	@echo "Data Warehouse Application Makefile"
	@echo "Available targets:"
	@echo "  up        : Build and start the application with Docker Compose"
	@echo "  down      : Stop and remove containers created by Docker Compose"
	@echo "  logs      : View logs of the Spring Boot application"
	@echo "  shell     : Enter a shell session within the Spring Boot application container"
	@echo "  mongo     : Connect to the MongoDB shell within the MongoDB container"
	@echo "  test      : Run unit tests for the Spring Boot application"
	@echo "  clean     : Clean up Docker resources (stop and remove containers, networks, volumes)"
	@echo "  help      : Display this help message"

.DEFAULT_GOAL := help
