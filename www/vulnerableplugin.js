var exec = require('cordova/exec');

module.exports = {
	greet: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "VulnerablePlugin", "greet", [name]);
    }
};