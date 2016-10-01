#import "FirebaseDatabasePlugin.h"
@import Firebase;

@implementation FirebaseDatabasePlugin

- (void)initialize:(CDVInvokedUrlCommand *)command {

    if(![FIRApp defaultApp) {
        [FIRApp configure];
    }
    self.eventCallbackId = command.callbackId;
}

- (void)subscribe:(CDVInvokedUrlCommand *)command {

- (void)unsubscribe:(CDVInvokedUrlCommand *)command {

}

-(void) raiseEvent:(NString*) type withMessage:(NSObject*) message {

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:@{
        @"type": type,
        @"message": message
    }];
    [pluginResult setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:self.eventCallbackId];
}
@end