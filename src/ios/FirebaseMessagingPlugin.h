#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>
@import FirebaseDatabase;

@interface FirebaseDatabasePlugin : CDVPlugin

- (void)initialize:(CDVInvokedUrlCommand *)command;
- (void)subscribe:(CDVInvokedUrlCommand *)command;
- (void)unsubscribe:(CDVInvokedUrlCommand *)command;
@property(strong, nonatomic) NSString *eventCallbackId;
@end
