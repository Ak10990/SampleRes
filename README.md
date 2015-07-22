# SampleRes
Resources Sample

what needs to be done on app release
Resources res = getResources();
setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myarray));
en fr


Device compatibility
Restrict your app's availability to devices through Google Play Store :
- Device features
<uses-feature android:name="android.hardware.sensor.compass" android:required="true" />
PackageManager pm = getPackageManager();
if (!pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS)) {
 // This device does not have a compass, turn off the compass feature
 disableCompassFeature();
}

-Platform version
<uses-sdk android:minSdkVersion="14" android:targetSdkVersion="19" />
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {}

-Screen configuration
screen size (the physical size of the screen)(small, normal, large, and xlarge.) and screen density(ldpi(low)0.75, mdpi (medium)1.0, hdpi (hdpi)1.5, xhdpi (extra high)2.0, xxhdpi (extra-extra high))
orientation - layout-large-land/
"wrap_content" and"match_parent" fill_parent
relative layout
nine-patch bitmaps

Dimension
Screen density: The quantity of pixels within a physical area of the screen, usually referred to as dpi (dots per inch) "low" density screen has fewer pixels

dp/dip - Density-independent Pixels
160 dpi (dots per inch) screen, on which 1dp is roughly equal to 1px

sp - Scale-independent Pixels (font)

px - Pixels

pt(Points - 1/72in), mm, in








App Resources

When your application is compiled, aapt generates the R class, which contains resource IDs for all the resources in your res/directory.

animator/ - XML files that define property animations.
anim/ - Property Animation & View Animation
color/ -
<selector xmlns:android="http://schemas.android.com/apk/res/android" >
    <item
        android:color="hex_color"
        android:state_pressed=["true" | "false"]
        android:state_focused=["true" | "false"]
        android:state_selected=["true" | "false"]
        android:state_checkable=["true" | "false"]
        android:state_checked=["true" | "false"]
        android:state_enabled=["true" | "false"]
        android:state_window_focused=["true" | "false"] />
</selector>
menu/ - <menu>
xml/ - Resources.getXML()?
values/ -
arrays.xml for resource arrays (typed arrays).
colors.xml for color values
dimens.xml for dimension values.
strings.xml for string values.
styles.xml for styles.
Other:
	-Style
	<EditText style="@style/CustomText">
<resources>
    <style name="CustomText" parent="@style/Text">
        <item name="android:textSize">20sp</item>
        <item name="android:textColor">#008</item>
    </style>
</resources>


	-Bool

	-Color
	<resources>
	    <color name="color_name">hex_color</color>
	</resources>
	getResources().getColor()

	-Dimension
	<resources>
	    <dimen name="dimension_name" >dimension</dimen>
	</resources>
	float fontSize = res.getDimension(R.dimen.font_size);

	-ID
	<resources>
    	<item type="id" name="button_ok" />
    	</resources>
	<Button android:id="@id/button_ok">

	-Integer
	<resources>
    	<integer name="max_speed">75</integer>
	</resources>

	-Integer Array
<resources>
    <integer-array name="bits">
        <item>4</item>
        <item>8</item>
        <item>16</item>
        <item>32</item>
    </integer-array>
</resources>
int[] bits = res.getIntArray(R.array.bits);

	-String array
<resources>
    <string-array
        name="string_array_name">
        <item
            >text_string</item>
    </string-array>
</resources>
R.array.string_array_name

	-Typed Array
<resources>
    <array name="icons">
        <item>@drawable/home</item>
        <item>@drawable/settings</item>
        <item>@drawable/logout</item>
    </array>
    <array name="colors">
        <item>#FFFF0000</item>
        <item>#FF00FF00</item>
        <item>#FF0000FF</item>
    </array>
</resources>
TypedArray icons = res.obtainTypedArray(R.array.icons);
Drawable drawable = icons.getDrawable(0);
TypedArray colors = res.obtainTypedArray(R.array.colors);
int color = colors.getColor(0,0);


layout/ -
mipmap/ - different launcher icon densities
drawable/ -
	Bitmap files (.png, .9.png, .jpg, .gif) BitmapDrawable
	Nine-Patches (re-sizable bitmaps) filename.9.png LayerDrawable
	State lists StateListDrawable
(<selector xmlns:android="http://schemas.android.com/apk/res/android" >
    <item
        android:drawable="@drawable/"
        android:state_pressed=["true" | "false"]
        android:state_focused=["true" | "false"]
        android:state_selected=["true" | "false"]
        android:state_checkable=["true" | "false"]
        android:state_checked=["true" | "false"]
        android:state_enabled=["true" | "false"]
        android:state_window_focused=["true" | "false"] />
</selector>)
	Shapes
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape=["rectangle" | "oval" | "line" | "ring"] >
    <corners
        android:radius="integer"
        android:topLeftRadius="integer"
        android:topRightRadius="integer"
        android:bottomLeftRadius="integer"
        android:bottomRightRadius="integer" />
    <gradient
        android:angle="integer"
        android:centerX="integer"
        android:centerY="integer"
        android:centerColor="integer"
        android:endColor="color"
        android:gradientRadius="integer"
        android:startColor="color"
        android:type=["linear" | "radial" | "sweep"]
        android:useLevel=["true" | "false"] />
    <padding
        android:left="integer"
        android:top="integer"
        android:right="integer"
        android:bottom="integer" />
    <size
        android:width="integer"
        android:height="integer" />
    <solid
        android:color="color" />
    <stroke
        android:width="integer"
        android:color="color"
        android:dashWidth="integer"
        android:dashGap="integer" />
</shape>
	Animation drawables  <animation-list>
	Transition Drawable <transition>
	Scale Drawable <scale>
	Inset Drawable <inset>
	Clip Drawable <clip>
	LevelListDrawables <level-list> setLevel()
raw/ - lossless
AssetManager assetManager = getAssets();
  InputStream stream = null;
        try {
            stream = assetManager.open("generated-keys.bin");
        } catch (IOException e) {
            // handle
        }



Themes:
but instead of the at-symbol (@), use a question-mark (?), and the resource type portion is optional.
android:textColor="?android:textColorSecondary"(Style)

android:theme="@style/CustomTheme"
<activity android:theme="@android:style/Theme.Dialog">
<style name="CustomTheme" parent="android:Theme.Light">
    <item name="android:windowBackground">@color/custom_theme_color</item>
    <item name="android:colorBackground">@color/custom_theme_color</item>
</style>

Android Manifest
Information the system must have before it can run any of the app's code is provided to the Android system.
<?xml version="1.0" encoding="utf-8"?>

<manifest>(REQUIRED ONCE)

    <uses-permission />
    <permission />
    <permission-tree />
    <permission-group />
    <instrumentation />
    <uses-sdk />
    <uses-configuration />
    <uses-feature />
    <supports-screens />
    <compatible-screens />
    <supports-gl-texture />

    <application>(REQUIRED ONCE)

        <activity>
            <intent-filter>
                <action />
                <category />
                <data />
            </intent-filter>
            <meta-data />
        </activity>

        <activity-alias>
            <intent-filter> . . . </intent-filter>
            <meta-data />
        </activity-alias>

        <service>
            <intent-filter> . . . </intent-filter>
            <meta-data/>
        </service>

        <receiver>
            <intent-filter> . . . </intent-filter>
            <meta-data />
        </receiver>

        <provider>
            <grant-uri-permission />
            <meta-data />
            <path-permission />
        </provider>

        <uses-library />

    </application>

</manifest>


Permissions:
<permission>,<permission-group>,<permission-tree>
A permission is a restriction limiting access to a part of the code or to data on the device.
The limitation is imposed to protect critical data and code that could be misused to distort or damage the user experience.

<uses-permission android:name="android.permission.INTERNET" />
android.permission.WRITE_EXTERNAL_STORAGE
android.permission.ACCESS_NETWORK_STATE
android.permission.ACCESS_WIFI_STATE
android.permission.INTERNET
android.permission.CALL_EMERGENCY_NUMBERS
android.permission.READ_OWNER_DATA
android.permission.SET_WALLPAPER
android.permission.DEVICE_POWER


Activity:
<activity>
android:screenOrientation=["unspecified" | "behind" |
                                     "landscape" | "portrait" |
                                     "reverseLandscape" | "reversePortrait" |
                                     "sensorLandscape" | "sensorPortrait" |
                                     "userLandscape" | "userPortrait" |
                                     "sensor" | "fullSensor" | "nosensor" |
                                     "user" | "fullUser" | "locked"]
android:theme="resource or theme"
android:windowSoftInputMode=["stateUnspecified",
                                       "stateUnchanged", "stateHidden",
                                       "stateAlwaysHidden", "stateVisible",
                                       "stateAlwaysVisible", "adjustUnspecified",
                                       "adjustResize", "adjustPan"]

</activity>

Meta Data:
<meta-data> -A name-value pair for an item of additional, arbitrary data that can be supplied to the parent component


<application> -

allow backup - no backup or restore of the application will ever be performed, even by a full-system backup that would otherwise cause all application data to be saved via adb

android:isGame
Whether or not the application is a game. The system may group together applications classifed as games or display them separately from other applications.

android:persistent
Whether or not the application should remain running at all times — "true" if it should, and "false" if not. The default value is "false".
Applications should not normally set this flag; persistence mode is intended only for certain system applications.



<uses-configuration>-
Indicates what hardware and software features the application requires.
<uses-configuration
  android:reqFiveWayNav=["true" | "false"]
  android:reqHardKeyboard=["true" | "false"]
  android:reqKeyboardType=["undefined" | "nokeys" | "qwerty" | "twelvekey"]
  android:reqNavigation=["undefined" | "nonav" | "dpad" | "trackball" | "wheel"]
  android:reqTouchScreen=["undefined" | "notouch" | "stylus" | "finger"] />
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="string"
          android:sharedUserId="string"
          android:sharedUserLabel="string resource"
          android:versionCode="integer"
          android:versionName="string"
          android:installLocation=["auto" | "internalOnly" | "preferExternal"] >
</manifest>

<uses-library>-
Specifies a shared library that the application must be linked against. This element tells the system to include the library's code in the class loader for the package.

<uses-feature>-
Declares a single hardware or software feature that is used by the application.
