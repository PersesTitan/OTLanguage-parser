plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.13.3"
    id("org.jetbrains.grammarkit") version "2022.3.1"
}

group = "com.otl.sdk"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

sourceSets["main"].java.srcDirs("src/main/gen")
dependencies.testImplementation("junit:junit:4.13.2")

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.2.5")
    plugins.set(listOf("com.intellij.java"))
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("221")
        untilBuild.set("231.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

grammarKit {
    jflexRelease.set("1.7.0-1")
    grammarKitRelease.set("2021.1.2")
}