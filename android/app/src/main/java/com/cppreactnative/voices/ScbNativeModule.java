package com.cppreactnative.voices;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ScbNativeModule extends ReactContextBaseJavaModule {

    public ScbNativeModule(ReactApplicationContext reactContext) {
        super(reactContext); //required by React Native
    }

    @Override
    public String getName() {
        return "ScbNative"; //ScbNative is how this module will be referred to from React Native
    }

    @ReactMethod
    public void sayHello(Promise promise) { //this method will be called from JS by React Native
        promise.resolve("Hello from Android");
    }
}