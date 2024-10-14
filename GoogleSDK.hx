package;

import lime.system.CFFI;
import lime.system.JNI;

/**
 * 谷歌SDK
 */
class GoogleSDK {
	#if android
	private static var jni_loginGoogleId = JNI.createStaticMethod("org.haxe.extension.GoogleSdk", "loginGoogleId", "()V");
	#end

	/**
	 * 通过Google登录
	 */
	public static function loginGoogleId() {
		#if android
		jni_loginGoogleId();
		#end
	}
}
