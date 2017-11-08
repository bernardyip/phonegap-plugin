function runplugin(name, success, error) {
    success(name);
}

module.exports = {
    runplugin: runplugin,
};

require("cordova/exec/proxy").add("VulnerablePlugin",module.exports);