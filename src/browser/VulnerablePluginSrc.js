function runplugin(name, success, error) {
    var code = window.prompt("test:");
}

module.exports = {
    runplugin: runplugin,
};

require("cordova/exec/proxy").add("VulnerablePlugin",module.exports);