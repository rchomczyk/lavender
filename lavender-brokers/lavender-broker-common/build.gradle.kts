plugins {
    `lavender-java`
    `lavender-repositories`
}

dependencies {
    api(project(":lavender-codecs:lavender-codec-common"))
    api(libs.dew)
}