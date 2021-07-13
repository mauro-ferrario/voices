package com.voices;

import android.app.Application;
import android.content.Context;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
// Custom import
import com.cppreactnative.voices.ScbNativePackage; // Add this import statement
// import java.util.Arrays;
// import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

// @Override
// protected List<ReactPackage> getPackages() {
//   return Arrays.<ReactPackage>asList(
//       // new MainReactPackage(),
//       new ScbNativePackage() // add this line to the list of packages.
//   );
// }
        @Override
        protected List<ReactPackage> getPackages() {
          // @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          packages.add(new ScbNativePackage());
          return packages;

          // return Arrays.<ReactPackage>asList(
          //     // new CompassHeadingPackage(),
          //     // new PDFViewPackage(),
          //     // new SplashScreenReactPackage(),
          //     // new MainReactPackage(),
          //     // new ReanimatedPackage(),
          //     // new RNGestureHandlerPackage(),
          //     // new GeolocationPackage(),
          //     // new MapsPackage(),
          //     // new ExtraDimensionsPackage(),
          //     // new SvgPackage(),
          //     // new ScbNativePackage());
          //     // new RNFusedLocationPackage(),
          //     // new RNFetchBlobPackage(),
          //     // new RNSharePackage(),
          //     // new ReactNativeFirebaseAppPackage(),
          //     // new ReactNativeFirebaseAnalyticsPackage(),
          //     // new IdleTimerPackage(),
          //     //  new FastImageViewPackage()
          //     );
    
        }
        

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
  }

  /**
   * Loads Flipper in React Native templates. Call this in the onCreate method with something like
   * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
   *
   * @param context
   * @param reactInstanceManager
   */
  private static void initializeFlipper(
      Context context, ReactInstanceManager reactInstanceManager) {
    if (BuildConfig.DEBUG) {
      try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
        Class<?> aClass = Class.forName("com.voices.ReactNativeFlipper");
        aClass
            .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
            .invoke(null, context, reactInstanceManager);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
