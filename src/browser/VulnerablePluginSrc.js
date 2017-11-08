function runplugin(success, error, name, name2, name3) {
    success(name + " : " + name2 + " : " + name3);
}

module.exports = {
    runplugin: runplugin,
};

require("cordova/exec/proxy").add("VulnerablePlugin",module.exports);