# UP42 - Features Rest API

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This is simple rest api service to perform read operations of features and images from stored json data via API

## Tech
- language used: Kotlin
- frameworks: spring boot, rest assured.

## Features
- Rest API endpoint to - Get feature data present in the resource file.
- Rest API endpoint to - Get feature image for the given feature ID.

## Considerations
> Rest api has been built using Kotlin, spring framework.

> The project has below main folders -
Controller -> Rest controller to handle the http requests.
Exception -> Centralized exception handling files.
Repositry -> JPA related files, Currently we have an interface that will allow to read data from resource folder
Security -> Can be used to enable web security in the app.
Service -> This layer can be used to define the business logic for a given functionality.

we have also enabled test framework to do testing and also dockerized the application so that it can be deployed to any cloud.

## Installation

This application can be started in 2 ways
1.we can start the application using the docker-compose in the app.
```sh
cd backend-coding-challenge
docker -v
docker-compose up
```

2.we need gradle environment to run this application.
```sh
cd backend-coding-challenge
./gradlew build
./gradlew bootrun
```

## Routes

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Routes | Description |
| ------ | ------ |
| /features | Returns all the features available |
| /features/{feature_id}/quicklook | returns a PNG image for the feature id |

