package cordova.plugin.vulnerable;

import android.content.*;
import android.provider.*;
import android.database.*;
import android.Manifest;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class VulnerablePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		PermissionHelper.requestPermission(this, 0, Manifest.permission.READ_CONTACTS); //search
		PermissionHelper.requestPermission(this, 3, Manifest.permission.READ_CONTACTS); //pick
			
        if (action.equals("runplugin")) {
			
            String receiverName = data.getString(0);
            String message = "Hello, " + receiverName + "\n";
            
			ContentResolver resolver = this.cordova.getActivity().getContentResolver();
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
