# Database Test

## Description

Provides a mechanism to setup databases for test requirements.

Today this is a minor project that is used only for local DynamoDB
testing.  TestContainers doesn't have a great way to run DynamoDB
which is why this exists. All other databases are represented better
with test containers

## Version details

As of version 1.0.6, requires JDK 17.