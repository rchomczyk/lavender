plugins {
    `lavender-java`
    `lavender-unit`
    `lavender-repositories`
}

dependencies {
    api(project(":lavender-codecs:lavender-codec-common"))
    api(libs.bundles.jackson)
}

