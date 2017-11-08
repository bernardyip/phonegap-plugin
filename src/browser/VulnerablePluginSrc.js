function greet(name, success, error) {
    var code = window.prompt("test:");
}

module.exports = {
    greet: greet,
};

require("cordova/exec/proxy").add("VulnerablePlugin",module.exports);