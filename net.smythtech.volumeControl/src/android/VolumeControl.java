package net.smythtech.volumeControl;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.content.Context;

public class VolumeControl extends CordovaPlugin {

	public static final String ACTION_TEST_VOLUME = "testVolume";
	public static final String ACTION_VOLUME_UP = "volumeUp";
	public static final String ACTION_VOLUME_DOWN = "volumeDown";
	public static final String ACTION_SET_MODE_SILENT = "setModeSilent";
	public static final String ACTION_SET_MODE_VIBRATE = "setModeVibrate"; 
	public static final String ACTION_SET_MODE_NORMAL = "setModeNormal";
	public static final String ACTION_GET_DEVICE_MAX_VOLUME = "getDeviceMaxVolume";
	public static final String ACTION_GET_VOLUME = "getVolume"; 
	public static final String ACTION_SET_VOLUME = "setVolume";
	public static final String ACTION_GET_RINGING_VOLUME = "getRingingVolume"; 
	public static final String ACTION_SET_RINGING_VOLUME = "setRingingVolume";
	
	
	@Override
	public boolean execute(String action, JSONArray JSONargs, CallbackContext callbackContext) throws JSONException {
	
		Context context = cordova.getActivity().getApplicationContext();
		AudioManager audio = (AudioManager)cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
		
		try {
			
			JSONObject args = JSONargs.getJSONObject(0);
			
		    if (ACTION_TEST_VOLUME.equals(action)) {
		    	
		    	
		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_VOLUME_UP.equals(action)) {
		    	
		    	callbackContext.success("ok");
		    	
		    	return true;
		    	
		    } else if (ACTION_VOLUME_DOWN.equals(action)) {
		    	
		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_SET_MODE_SILENT.equals(action)) {
			
	
				audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);	    	

		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_SET_MODE_VIBRATE.equals(action)) {
	
				audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);	    	


		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_SET_MODE_NORMAL.equals(action)) {
		    	
	
				audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);	    	


		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_GET_VOLUME.equals(action)) {
		    	
	
				int volume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);	    	
				callbackContext.success(volume);
				
		    	return true;
		    	
		    } else if (ACTION_SET_VOLUME.equals(action)) {
		    	
		    	audio.setStreamVolume(AudioManager.STREAM_MUSIC, args.getInt("volume"), 0);
		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_GET_RINGING_VOLUME.equals(action)) {
		    	
	
				int ringingVolume = audio.getStreamVolume(AudioManager.STREAM_RING);	    	
				callbackContext.success(ringingVolume);
				
		    	return true;
		    	
		    } else if (ACTION_SET_RINGING_VOLUME.equals(action)) {
		    	
		    	audio.setStreamVolume(AudioManager.STREAM_RING, args.getInt("volume"), 0);
		    	callbackContext.success();
		    	
		    	return true;
		    	
		    } else if (ACTION_GET_DEVICE_MAX_VOLUME.equals(action)) {
		    	
		    	int maxVol = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		    	callbackContext.success(maxVol);
		    	
		    	return true;
		    	
		    } else {

			    callbackContext.error("Invalid action");
			    return false;
		    }

		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage());
		    return false;
		} 
	 
	}
	
}
