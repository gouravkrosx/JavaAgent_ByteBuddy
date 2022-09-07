# JavaAgent - ByteBuddy

A sample app explaining how to use [ByteBuddy](https://bytebuddy.net/#/) and JavaAgent.

## Usage

### Setup App

1. ```git clone https://github.com/gouravkrosx/JavaAgent_ByteBuddy```


2. ``` cd JavaAgent_ByteBuddy ```


3. ```mvn clean install```


### Run the Application

1. To use Agent for intercepting, run below on terminal
```shell
   java -javaagent:<path to agent>.jar -jar <path to application>.jar
```
for eg: 
```shell
   java -javaagent:/Users/sarthak_1/Documents/Keploy/trash/JavaAgent_ByteBuddy/Interceptor_Agent/target/Interceptor_Agent-1.0.0-SNAPSHOT.jar -jar /Users/sarthak_1/Documents/Keploy/trash/JavaAgent_ByteBuddy/Application/target/Application-1.0.0-SNAPSHOT.jar
```

2. To use ByteBuddy for advices, run below command on terminal
```shell
   java -javaagent:<path to agent>.jar -jar <path to application>.jar
```
for eg:
```shell
   java -javaagent:/Users/sarthak_1/Documents/Keploy/trash/JavaAgent_ByteBuddy/Advice_Agent/target/Advice_Agent-1.0.0-SNAPSHOT.jar -jar /Users/sarthak_1/Documents/Keploy/trash/JavaAgent_ByteBuddy/Application/target/Application-1.0.0-SNAPSHOT.jar
```
