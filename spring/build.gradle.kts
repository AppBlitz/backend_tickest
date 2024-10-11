plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation ("org.hibernate.validator:hibernate-validator:6.1.7.Final")
	implementation ("javax.validation:validation-api:2.0.1.Final")
	implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.0")
	implementation ("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation ("com.google.zxing:core:3.4.1")
	implementation ("com.google.zxing:javase:3.4.1")
	implementation ("org.springframework.boot:spring-boot-starter-mail")
	implementation("com.mercadopago:sdk-java:2.1.29")
	implementation ("org.springframework.security:spring-security-crypto:6.3.3")
	implementation ("io.jsonwebtoken:jjwt-api:0.12.6")
	runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.12.6")
}


tasks.withType<Test> {
	useJUnitPlatform()
}
