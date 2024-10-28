plugins {
    `lavender-java`
    `lavender-publish`
    `lavender-repositories`
}

dependencies {
    api(project(":lavender-brokers:lavender-broker-common"))
    api(libs.jnats)
}

lavenderPublish {
    artifactId = "lavender-broker-nats"
}