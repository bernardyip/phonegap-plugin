var exec = require('cordova/exec');

module.exports = {
	runplugin: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VulnerablePlugin", "runplugin", [name]);
    }
};