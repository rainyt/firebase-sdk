package;

import lime.system.CFFI;
import lime.system.JNI;

/**
 * FirebaseSdk
 */
class FirebaseSdk {
	#if android
	private static var jni_loginGoogleId = JNI.createStaticMethod("org.haxe.extension.FirebaseSdk", "loginGoogleId", "()V");
	private static var jni_openReview = JNI.createStaticMethod("org.haxe.extension.FirebaseSdk", "openReview", "(I)V");
	#end

	/**
	 * 通过Google登录
	 */
	public static function loginGoogleId() {
		#if android
		jni_loginGoogleId();
		#end
	}

	/**
	 * 打开应用内评论功能
	 */
	public static function openReview(debug:Int = 0) {
		#if android
		jni_openReview(debug);
		#end
	}
}
