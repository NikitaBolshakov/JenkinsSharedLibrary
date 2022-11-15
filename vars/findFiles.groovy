def call(pattern) {
    return usc(windows:"dir * /s/b | findstr ${pattern}", returnStdout: true).trim()
}
