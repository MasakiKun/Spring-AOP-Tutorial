plugins {
	id("java")
}

group = "kr.ayukawa"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	compile("org.springframework:spring-core:5.1.5.RELEASE")
	compile("org.springframework:spring-aop:5.1.5.RELEASE")

	compile("org.slf4j:slf4j-api:1.7.26")
	compile("ch.qos.logback:logback-core:1.2.3")
}
