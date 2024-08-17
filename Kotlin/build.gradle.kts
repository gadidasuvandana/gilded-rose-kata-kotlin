import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.10"
	application
	id("com.diffplug.gradle.spotless") version "4.5.1"
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
	testImplementation("org.amshove.kluent:kluent:1.73")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions.jvmTarget = "1.8"
}

// config java extension to same target version, to avoid build failure on Gradle 8.x
java {
	targetCompatibility = JavaVersion.VERSION_1_8
}

application {
	mainClass.set("com.gildedrose.TexttestFixtureKt")
}
