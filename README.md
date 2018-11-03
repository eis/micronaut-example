Hello World micronaut app

Created by using

```
sdk install micronaut
mn create-app hello-world
mkdir -p src/main/java/example/helloworld
vi src/main/java/example/helloworld/HelloController.java
./gradlew run
```

Call
```
curl localhost:8080/hello
```

Build a package
```
./gradlew assemble
```

Notes on IntelliJ
 - if you experience tests strangely failing, confirm you have
    annotation processing enabled