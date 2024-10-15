package org.haxe.extension;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class GoogleSdk extends Extension {

	/**
	 * 登陆谷歌请求
	 */
	public static void loginGoogleId() {
		Intent signInIntent = AuthUI.getInstance()
				.createSignInIntentBuilder()
				// ... options ...
				.setAvailableProviders(Arrays.asList(
						new AuthUI.IdpConfig.EmailBuilder().build(),
						new AuthUI.IdpConfig.GoogleBuilder().build()))
				.build();
		mainActivity.startActivityForResult(signInIntent, 2);
	}

	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		Log.i("ZSDK","onActivityResult:"+String.valueOf(requestCode));
		FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
		if (user != null ){
			Log.i("ZSDK","User login success."+user.getUid());
			if(AuthUILogin.loginListener != null){
				JSONObject jsonData = new JSONObject();
				try {
					jsonData.put("access_token",user.getIdToken(false));
					jsonData.put("uid",user.getUid());
					jsonData.put("avatar",user.getPhotoUrl());
					jsonData.put("name",user.getDisplayName());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				AuthUILogin.loginListener.onSuccess(jsonData);
				AuthUILogin.loginListener = null;
			}
		}else {
			Log.i("ZSDK", "User login fail.");
			if (AuthUILogin.loginListener != null) {
				AuthUILogin.loginListener.onError(-1, "User login fail.");
				AuthUILogin.loginListener = null;
			}
		}
		return true;
	}

	/**
	 * Called when the activity receives th results for permission requests.
	 */
	public boolean onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

		return true;

	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		FirebaseApp.initializeApp(mainActivity);
	}

	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}