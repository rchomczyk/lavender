plugins {
    `lavender-java`
    `lavender-repositories`
}

dependencies {
    api(project(":lavender-brokers:lavender-broker-common"))
    api(libs.jnats)
}