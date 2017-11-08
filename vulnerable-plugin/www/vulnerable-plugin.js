var exec = require('cordova/exec');

exports.vulnerableMethod = function (arg0, success, error) {
    exec(success, error, 'vulnerable-plugin', 'vulnerableMethod', [arg0]);
};
