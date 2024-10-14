package;


import lime.system.CFFI;
import lime.system.JNI;


class Google_sdk {
	
	
	public static function sampleMethod (inputValue:Int):Int {
		
		#if android
		
		var resultJNI = google_sdk_sample_method_jni(inputValue);
		var resultNative = google_sdk_sample_method(inputValue);
		
		if (resultJNI != resultNative) {
			
			throw "Fuzzy math!";
			
		}
		
		return resultNative;
		
		#else
		
		return google_sdk_sample_method(inputValue);
		
		#end
		
	}
	
	
	private static var google_sdk_sample_method = CFFI.load ("google_sdk", "google_sdk_sample_method", 1);
	
	#if android
	private static var google_sdk_sample_method_jni = JNI.createStaticMethod ("org.haxe.extension.Google_sdk", "sampleMethod", "(I)I");
	#end
	
	
}