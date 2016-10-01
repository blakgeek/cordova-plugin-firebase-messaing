package com.blakgeek.cordova.plugin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseMessagingPlugin extends CordovaPlugin {

    private CallbackContext eventContext;

    @Override
    protected void pluginInitialize() {
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "initialize":
                return initialize(args, callbackContext);
            case "subscribe":
                return subscribe(args, callbackContext);
            case "unsubscribe":
                return unsubscribe(args, callbackContext);
            default:
                return false;
        }
    }
    private boolean initialize(JSONArray args, CallbackContext callbackContext) {
        if (eventContext == null) {
            eventContext = callbackContext;
        }
        return true;
    }

    private boolean subscribe(JSONArray args, CallbackContext callbackContext) {
        // subscribe
        return true;
    }

    private boolean unsubscribe(JSONArray args, CallbackContext callbackContext) {
        // unsubscribe
        return true;
    }


    private void raiseEvent(String type) {
        raiseEvent(type, null);
    }

    private void raiseEvent(String type, Object data) {

        if (eventContext != null) {

            JSONObject event = new JSONObject();
            try {
                event.put("type", type);
                event.put("data", data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PluginResult result = new PluginResult(PluginResult.Status.OK, event);
            result.setKeepCallback(true);
            eventContext.sendPluginResult(result);
        }
    }

}