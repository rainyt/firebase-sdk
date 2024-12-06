package org.haxe.extension;

import android.util.Log;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import zygame.ZSDK;
import zygame.events.SDKListener;
import zygame.plugins.ILogin;

/**
 * 基础登陆流程实现
 */
public class AuthUILogin implements ILogin {

    /**
     * 登陆回调处理
     */
    public static SDKListener loginListener;

    @Override
    public void init(SDKListener listener) {
        listener.onSuccess(null);
    }

    @Override
    public void login(final SDKListener listener) {
        loginListener = listener;
        if (FirebaseSdk.loginMode.equals("google"))
            FirebaseSdk.loginGoogleId();
        else
            FirebaseSdk.loginEmailId();
    }

    @Override
    public void logout(final SDKListener listener) {
        AuthUI.getInstance()
                .signOut(ZSDK.getInstance().activity)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Log.i("ZSDK", "AutuUI logout");
                        listener.onSuccess(null);
                    }
                });
    }

    @Override
    public boolean hasUserInfo() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null;
    }
}
