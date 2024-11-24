# Database Test

## Description

Provides a mechanism to setup databases for test requirements.

Today this is a minor project that is used only for local DynamoDB
testing.  TestContainers doesn't have a great way to run DynamoDB
which is why this exists. All other databases are represented better
with test containers

## Version details

Requires JDK 17.


| Library       | Purpose                           | Version                                                                                   |
|---------------|-----------------------------------|-------------------------------------------------------------------------------------------|
| database-test | Core Library                      | ![database-test](https://img.shields.io/maven-central/v/com.codeheadsystems/database-test) |

- test
