<div align="center">
    <h1>FFmpeg DSL Android</h1>
</div>

Pure Kotlin DSL library to build FFmpeg CLI commands in a more descriptive and comprehensive way

[![Latest Version](https://img.shields.io/badge/Latest_Version-0.1-green.svg)](https://github.com/orgs/moises-ai/packages?repo_name=ffmpeg-dsl-android)

---

## Summary

## Getting Start

Steps explain how the add the `FFmpeg DSL` library to your Android project.

Take [this post](https://ppulikal.medium.com/publishing-android-libraries-to-the-github-package-registry-part-2-3c5aab31f477)
as a reference to the following steps.

### 1 - Create the `github.properties` file on your root project directory

```
// github.properties

gpr.usr=00000 // Your Github User ID
gpr.key=xxxx // Your Github Personal Access Token with the permission to read packages
```

- **Alternative**: Set some environment variables with the credentials, something like `GPR_USER` and `GPR_API_KEY`.

\*_see the [github.properties.example](./github.properties.example) file_

\*_[how to get the Github User Id](https://stackoverflow.com/questions/17308954/where-can-i-find-the-github-id-in-my-account#:~:text=Up%20vote%202-,It%20can%20be%20easily%20retrieved%20using%20Github%20API%20.,.noreply.github.com%20.)_

### 2 - Add the repository to the `bundle.gradle` file

At the top of your `bundle.gradle` file, add the code to read the `github.properties`
content

```gradle
def githubProperties = new Properties()

try {
    githubProperties.load(new FileInputStream(rootProject.file("github.properties")))
} catch(FileNotFoundException e) {
    // ignore
}

def user = githubProperties.getProperty('gpr.usr', System.getenv("GPR_USER"))
def key = githubProperties.getProperty('gpr.key', System.getenv("GPR_API_KEY"))
```

At the `allprojects` block, add a custom Maven repository

```gradle
allprojects {
    repositories {
        ...
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/moises-ai/ffmpeg-dsl-android")
            credentials {
                username = user
                password = key
            }
        }
    }
}
```

### 3 - Add the library dependency to your `app/bundle.gradle`

```gradle
implementation 'ai.moises:ffmpeg-dsl:[LATEST_VERSION]'
```

## Publishing a new version

Steps explain how to manually publish a new version of the `FFmpeg DSL` library
to the Github Package Registry.

Take [this post](https://proandroiddev.com/publishing-android-libraries-to-the-github-package-registry-part-1-7997be54ea5a)
as a reference to the following steps.

### 1 - Create the `github.properties` file on your root project directory

```
// github.properties

gpr.usr=00000 // Your Github User ID
gpr.key=xxxx // Your Github Personal Access Token with the permission to read packages
```

- **Alternative**: Set some environment variables with the credentials, something like `GPR_USER` and `GPR_API_KEY`.

\*_see the [github.properties.example](./github.properties.example) file_

\*_[how to get the Github User Id](https://stackoverflow.com/questions/17308954/where-can-i-find-the-github-id-in-my-account#:~:text=Up%20vote%202-,It%20can%20be%20easily%20retrieved%20using%20Github%20API%20.,.noreply.github.com%20.)_

### 2 - Update the version name

On the `build.gradle` file, update the `versionName` variable with the new version.

### 3 - Publishing

For Windows and Linux, run the flowing scripts under the root directory of the project.

```sh
$ gradle clean
$ gradle assemble
$ gradle publish
```

For MacOS, run the flowing scripts under the root directory of the project.

```sh
$ ./gradlew clean
$ ./gradlew assemble
$ ./gradlew publish
```

## Basic Usage

```kotlin
    ffmpegCommand {
        isOverrideAllowed = true

        input {
            seekStart = minutes(2)
            inputTimeOffset = seconds(0.3102834467120186)
            path = "test.mp3"
        }

        outputPath = "out.mp3"
    }

    // result: -y -ss "02:00" -itoffset "0.3102834467120186" -i "test.mp3" "out.mp3"
```

See the Example app for more usage examples.

## 👀 Check the Wiki for available commands and DSL syntax
