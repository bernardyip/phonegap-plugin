var exec = require('cordova/exec');

module.exports = {
	run: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VulnerablePlugin", "run", [name]);
    }
};