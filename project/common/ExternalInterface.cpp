#ifndef STATIC_LINK
#define IMPLEMENT_API
#endif

#if defined(HX_WINDOWS) || defined(HX_MACOS) || defined(HX_LINUX)
#define NEKO_COMPATIBLE
#endif


#include <hx/CFFI.h>
#include "Utils.h"


using namespace google_sdk;



static value google_sdk_sample_method (value inputValue) {
	
	int returnValue = SampleMethod(val_int(inputValue));
	return alloc_int(returnValue);
	
}
DEFINE_PRIM (google_sdk_sample_method, 1);



extern "C" void google_sdk_main () {
	
	val_int(0); // Fix Neko init
	
}
DEFINE_ENTRY_POINT (google_sdk_main);



extern "C" int google_sdk_register_prims () { return 0; }