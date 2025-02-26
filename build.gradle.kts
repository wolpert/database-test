// gradle clean build test publishToSonatype closeAndReleaseSonatypeStagingRepository

plugins {
    `java-library`
    `maven-publish`
    signing
    checkstyle
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()  // was jcenter() which is dying
    google()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/releases/")
}

dependencies {
    implementation(platform(libs.aws.sdk2.bom))
    implementation("software.amazon.awssdk:dynamodb")
    implementation(libs.codehead.test)
    implementation(libs.aws.dynamodblocal)
    implementation(libs.aws.sdk2.ddb)
    implementation(libs.slf4j.api)
    api(libs.bundles.testing)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(libs.bundles.logback)
}
tasks.named<Test>("test") {
    useJUnitPlatform()
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
    withJavadocJar()
    withSourcesJar()
}

group = "com.codeheadsystems"
version = "1.0.12"
//version = "1.0.9-SNAPSHOT"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "database-test"
            from(components["java"])
            pom {
                name = "Database-Test"
                description = "Testing utilities"
                url = "https://github.com/wolpert/database-test"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "wolpert"
                        name = "Ned Wolpert"
                        email = "ned.wolpert@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/wolpert/database-test.git"
                    developerConnection = "scm:git:ssh://github.com/wolpert/database-test.git"
                    url = "https://github.com/wolpert/database-test/"
                }
            }

        }
    }
    repositories {
        maven {
            val releasesRepoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepoUrl = "https://oss.sonatype.org/content/repositories/snapshots"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            name = "ossrh"
            credentials(PasswordCredentials::class)
        }
    }
}// gradle publishToSonatype closeAndReleaseSonatypeStagingRepository
nexusPublishing {
    repositories {
        sonatype()
    }
}
signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}