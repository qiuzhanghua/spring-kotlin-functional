import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		jcenter()
		maven { setUrl("https://repo.spring.io/milestone") }
		maven { setUrl("https://repo.spring.io/snapshot") }
		maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap-1.1") }
	}

	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.4-eap-54")
		classpath("com.github.jengelman.gradle.plugins:shadow:2.0.1")
		classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-RC2")
	}
}

apply {
	plugin("kotlin")
	plugin("com.github.johnrengelman.shadow")
	plugin("org.junit.platform.gradle.plugin")
}

repositories {
	mavenCentral()
	maven { setUrl("https://repo.spring.io/milestone") }
	maven { setUrl("https://repo.spring.io/snapshot") }
	maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap-1.1") }
}


tasks {

	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305-annotations=enable")
		}
	}

	dependencies {
		compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:1.1.4-eap-54")
		compile("org.jetbrains.kotlin:kotlin-reflect:1.1.4-eap-54")

		compile("org.springframework:spring-webflux:5.0.0.BUILD-SNAPSHOT")
		compile("org.springframework:spring-context:5.0.0.BUILD-SNAPSHOT")
		compile("io.projectreactor.ipc:reactor-netty:0.7.0.M1")
		compile("com.samskivert:jmustache:1.13")

		compile("org.slf4j:slf4j-api:1.7.25")
		compile("ch.qos.logback:logback-classic:1.2.3")
		
		compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")
		compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.0")
		
		testCompile("io.projectreactor:reactor-test:3.1.0.M3")

		testCompile("org.junit.jupiter:junit-jupiter-api:5.0.0-RC2")
		testRuntime("org.junit.jupiter:junit-jupiter-engine:5.0.0-RC2")
		testRuntime("org.junit.platform:junit-platform-launcher:1.0.0-RC2")
	}
}
