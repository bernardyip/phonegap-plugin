package cordova-plugin-vulnerable;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class vulnerable-plugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("vulnerableMethod")) {
            this.vulnerableMethod(args.getString(0), callbackContext);
            return true;
        }
        return false;
    }

    private void vulnerableMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
			message = "fuck you";
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
