# attachmentav-sdk-java
A virus scan SDK for Java. Scan files for viruses, trojans, and other kinds of malware with attachmentAV API.

## What is attachmentAV API?
The attachmentAV provides a REST API enabling you to scan files for viruses, trojans, and other kinds of malware. Two options are available:

* [attachmentAV Virus Scan API (SaaS)](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/): get started quickly with a fully-managed service
* [attachmentAV Virus Scan API (Self-hosted on AWS)](https://attachmentav.com/help/virus-malware-scan-api-aws/setup-guide/): deploy the production-ready API on AWS

## Install SDK

Find the latest version of the [virus-scan-sdk](https://central.sonatype.com/artifact/com.attachmentav/virus-scan-sdk) on Maven Central and add it to the dependencies of your project.

```xml
<dependency>
  <groupId>com.attachmentav</groupId>
  <artifactId>virus-scan-sdk</artifactId>
  <version>0.2.0</version>
</dependency>
```

## Configure SDK

> attachmentAV Virus Scan API (SaaS) requires a subscriotion