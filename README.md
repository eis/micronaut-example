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

Notes on Micronaut
 - if you experience tests strangely failing on IntelliJ,
    confirm you have annotation processing enabled
 - if you experience problems with Lombok annotation not being
    present on compile time with gradle, ensure your annotation
    processor is run before Micronaut annotation processor is run
