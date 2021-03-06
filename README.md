# CINEMA
[![CircleCI](https://circleci.com/gh/wigryz/cinema/tree/master.svg?style=svg)](https://circleci.com/gh/wigryz/cinema/tree/master)

This project is developed by [jlitewka99][jlitewka99] and [wigryz][wigryz].

## Features
TODO
## Technologies
TODO
## Plugins
TODO
## Try out our application!

To start using cinema-backend you need to have java 16 and npm installed.  
After that all you have to do is to clone our repo and run following commands:
```sh
cd cinema/backend
./mvnw spring-boot:run
cd cinema/frontend
npm start
```

## Docker

Provide description of how to set up this application in docker container.

### Continuous integration

There is a control integration named CircleCI set up for this project. It tests all branches, so after your push
there will be a run going in the background. After some time you will notice a :heavy_check_mark: - if your
build was successful or :x: - if it failed. You can click on it to get more information about tests that failed or
some information about test coverage.

What does our CI do:
* build application,
* run unit & integration tests,
* printing out code coverage,
* validate formatting and imports.

### Database

![database_schema](./resources/cinema-db_schema.jpg)

[//]: # (HERE YOU CAN ADD MORE MAGIC LINKS])
[repo]: <https://github.com/wigryz/cinema-backend>
[wigryz]: <https://github.com/wigryz>
[jlitewka99]: <https://github.com/jlitewka99>
