package cordova.plugin.vulnerable;

import android.content.*;
import android.provider.*;
import android.database.*;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class VulnerablePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("runplugin")) {

            String name = data.getString(0);
            String message = "Hello, " + name + "\n";
            
			ContentResolver resolver = getApplicationContext().getContentResolver();
			Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
			while (cursor.moveToNext()) {
				String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
				String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				message += "\n" + id + " : " + name;
			}
			
			callbackContext.success(message);
			
            return true;

        }
            
        return false;
    }
}
