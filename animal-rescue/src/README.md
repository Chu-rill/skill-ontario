# Animal Rescue CLI 🐾

A Java-based CLI application to manage animals in a shelter.

## Features
- Add / Remove animals
- Search by name or species
- Sort animals
- Archive adopted animals
- Adoption fee calculation

## How to Run

### Using Maven
```bash
mvn clean package
java -jar target/animal-rescue.jar
```

### Using Docker
```bash
docker build -t animal-rescue .
docker run -it animal-rescue
```

## Project Structure
```
├── animal-rescue.iml
└── src
    ├── Dockerfile
    ├── Main.java
    ├── README.md
    ├── data
    ├── model
    ├── pom.xml
    ├── screenshots
    ├── service
    └── util
```
### Menu
![Menu](screenshots/initial.png)