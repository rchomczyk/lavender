plugins {
    `lavender-java`
    `lavender-repositories`
}

dependencies {
    implementation(project(":lavender-brokers:lavender-broker-common"))
    implementation(project(":lavender-codecs:lavender-codec-common"))
}