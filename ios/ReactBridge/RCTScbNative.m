#import "RCTScbNative.h"
#import <React/RCTLog.h>

@implementation RCTScbNative

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(sayHello2)
{
 RCTLogInfo(@"Hello!");
}

RCT_REMAP_METHOD(sayHello,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
  resolve(@"Hello from Objective-C");
}

@end
