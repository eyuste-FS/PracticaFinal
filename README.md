# PracticaFinal
Práctica final del programa de formación de becarios

## javabackend

### Project compile
```
mvn install
```

### Run
Make sure a MySQL server is running at the designated port (3306).
```
java -jar  .\target\api-*-SNAPSHOT.jar
```
It can be found at
```
localhost:8080/
```

## vuefrontend

### Project setup
```
npm install
```

#### Compiles and hot-reloads for development
```
npm run serve -- --port 8081
```

#### Compiles and minifies for production
```
npm run build
```

#### Lints and fixes files
```
npm run lint
```

## How to start the proyect

DB server:

Start mysql server


Backend server:

```
cd .\javabackend\
mvn install
java -jar .\target\api-0.0.1-SNAPSHOT.jar
```

Frontend server:

```
cd .\vuefrontend\
npm i
npm run serve -- --port 8081
```

Acceder desde el navegador:
```http://localhost:8081/```

