#include "firebaseSdk.hpp"
#import <Foundation/Foundation.h>

#include "FirebaseCore.h"
#include "FirebaseAuthUI.h"


/**
 初始化firebase sdk
 */
void initSdk() {
    // Use Firebase library to configure APIs
    [FIRApp configure];
}

/**
 通过firebaseUI登录
 */
void loginByFirebase() {
    FUIAuth *authUI = [FUIAuth defaultAuthUI];
    NSArray<id<FUIAuthProvider>> *providers = @[

    ];
    authUI.providers = providers;
    [authUI authViewController];
}
