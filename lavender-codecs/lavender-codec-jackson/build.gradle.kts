plugins {
    `lavender-java`
    `lavender-unit`
    `lavender-repositories`
}

dependencies {
    implementation(project(":lavender-codecs:lavender-codec-common"))
    api(libs.bundles.jackson)
}

