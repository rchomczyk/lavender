plugins {
    `lavender-java`
    `lavender-unit`
    `lavender-publish`
    `lavender-repositories`
}

dependencies {
    api(project(":lavender-codecs:lavender-codec-common"))
    api(libs.bundles.jackson)
}

lavenderPublish {
    artifactId = "lavender-codec-jackson"
}