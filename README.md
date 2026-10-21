# java

## Build

The examples target Java 21. Install a JDK 21 or newer, then use the Maven Wrapper from the repository root:

```powershell
.\mvnw.cmd clean package
```

On macOS or Linux, run `./mvnw clean package`. The wrapper downloads the pinned Maven distribution on its first run, so a system Maven installation is not required. Maven reads the project-local `.mvn/settings.xml` instead of machine-level Maven settings.
