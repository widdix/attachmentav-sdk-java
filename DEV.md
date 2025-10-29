# Development

To generate the SDK execute the following command. Ensure to modify the `artifactVersion`.

```
openapi-generator generate -i api.yml -g java -o ./sdk --additional-properties=artifactId=virus-scan-sdk,artifactVersion=0.4.0,developerOrganizationUrl=https://attachmentav.com,developerOrganization=attachmentAV,developerName="Andreas Wittig",developerEmail=andreas@attachmentav.com,licenseName=MIT,licenseUrl=https://mit-license.org,groupId=com.attachmentav,invokerPackage=com.attachmentav.client,apiPackage=com.attachmentav.api,modelPackage=com.attachmentav.model,artifactDescription="A virus scan SDK for Java. Scan files for viruse; trojans; and other kinds of malware with attachmentAV.",artifactUrl=https://github.com/widdix/attachmentav-sdk-java,scmUrl=https://github.com/widdix/attachmentav-sdk-java,scmDeveloperConnection=scm:git:git@github.com:widdix/attachmentav-sdk-java.git,scmConnection=scm:git:git@github.com:widdix/attachmentav-sdk-java.git
```

It might be necessary to delete the `sdk` folder in case of breaking changes.

```
rm -fR sdk 
```

After doing so, add the following plugins to `sdk/pom.xml`.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-gpg-plugin</artifactId>
    <version>1.6</version>
    <executions>
        <execution>
            <id>sign-artifacts</id>
            <goals>
                <goal>sign</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <gpgArguments>
            <argument>--pinentry-mode</argument>
            <argument>loopback</argument>
        </gpgArguments>
    </configuration>
</plugin>

<plugin>
    <groupId>org.sonatype.central</groupId>
    <artifactId>central-publishing-maven-plugin</artifactId>
    <version>0.8.0</version>
    <extensions>true</extensions>
    <configuration>
        <publishingServerId>central</publishingServerId>
    </configuration>
</plugin>
```

Deploying a new version requires a valid PGP key for `andreas@attachmentav.com` and credentials for Maven Central in `~/.m2/settings.xml`.

```xml
<settings>
  <servers>
    <server>
      <id>central</id>
      <username>...</username>
      <password>...</password>
    </server>
  </servers>
</settings>
```

Execute the deployment.

```
mvn clean deploy
```