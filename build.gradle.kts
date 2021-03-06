import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

val kotlinVersion = "1.1.51"
val commonMarkVersion = "0.9.0"

plugins {
    application
    kotlin("jvm", "1.1.51")
}

configure<ApplicationPluginConvention> {
    mainClassName = "link.kotlin.scripts.Application"
}

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/heapy/heap") }
}

configure<KotlinProjectExtension> {
    experimental.coroutines = Coroutines.ENABLE
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:0.19.1")

    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.8")
    compile("org.slf4j:slf4j-api:1.7.25")
    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("io.sentry:sentry-logback:1.4.0")

    compile("com.rometools:rome:1.7.0")
    compile("com.github.dfabulich:sitemapgen4j:1.0.6")
    compile("org.jsoup:jsoup:1.10.2")
    compile("by.heap.remark:remark-kotlin:1.2.0")

    compile("org.jetbrains.kotlin:kotlin-script-util:$kotlinVersion")
    compile("com.atlassian.commonmark:commonmark:$commonMarkVersion")
    compile("com.atlassian.commonmark:commonmark-ext-gfm-tables:$commonMarkVersion")

    compile("com.squareup.okhttp3:okhttp:3.8.1")

    testCompile("junit:junit:4.12")
}
