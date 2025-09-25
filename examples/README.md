# Tests


### Run all tests

```
./gradlew test --no-daemon
```

### Run a single test class

to run the `TestDedicatedPublicVpc` tests:

```
./gradlew test --no-daemon --tests com.bucketav.acceptance.core.TestDedicatedPublicVpc
```

### Run a single test

to run the `TestDedicatedPublicVpc.testEicarDetectionWithoutFileDeletion` test:

```
./gradlew test --no-daemon --tests com.bucketav.acceptance.core.TestDedicatedPublicVpc.testEicarDetectionWithoutFileDeletion
```

