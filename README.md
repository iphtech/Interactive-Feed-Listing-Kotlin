# Interactive-Feed-Listing-Kotlin
Feed listing with Interactive UI


# Application feature-

1. When application open list of feed will be load and display
2. When user pull down swiprefresh layout will call, it will refresh the list and load more feed list
3. After all item loaded if user furthur pull down it will show no more item to load
4. On click of three dot in feed, group name will toast
5. To exit the app need to press back button twice

# The files contained here:

AndroidManifest.xml

This XML file describes to the Android platform what your application can do.
It is a required file, and is the mechanism you use to show your application
to the user (in the app launcher's list), handle data types, etc.


src/*

This directory includes the Java source for your application.


src\main\java\com\example\mvvm

This is the implementation of the "activity" feature described in
AndroidManifest.xml.  The path of each class implementation is
{src/PACKAGE/CLASS.java}, where PACKAGE comes from the name in the <package>
tag and CLASS comes from the class in the <activity> tag.


res/*

Under this directory are the resources for your application.


res/font/gilroybold.ttf

The res/font directory contains fonts that can be user to change the default font of textview by creacting custom style


res/layout/activity_main.xml

The res/layout/ directory contains XML files describing user interface
view hierarchies.  The activity_splash_screen.xml file here is used by
SplashScreen.java to construct its UI.  The base name of each file
(all text before a '.' character) is taken as the resource name;
it must be lower-case.


res/drawable/chat.png

The res/drawable/ directory contains images and other things that can be
drawn to the screen.  These can be bitmaps (in .png or .jpeg format) or
special XML files describing more complex drawings.  The violet.png file
here is used as the image to display in one of the views in
activity_main.xml.  Like layout files, the base name is used for the
resulting resource name.


res/mipmap

This res/mipmap containg app launcher images


res/values/colors.xml
res/values/strings.xml
res/values/styles.xml

These XML files describe additional resources included in the application.
They all use the same syntax; all of these resources could be defined in one
file, but we generally split them apart as shown here to keep things organized.



build.gradle/*

dependencies that are used in this app

ViewModel and livedata
implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"

Glide
implementation 'com.github.bumptech.glide:glide:4.12.0'
kapt 'com.github.bumptech.glide:compiler:4.12.0'

Pixel dependencies
implementation 'com.intuit.sdp:sdp-android:1.0.6'
implementation 'com.intuit.ssp:ssp-android:1.0.5'

Circular image dependencies
implementation 'de.hdodenhof:circleimageview:3.1.0'

Swipe refresh layout dependencies
implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"


# GIF
<img src="https://user-images.githubusercontent.com/82376705/165748642-63ac0c61-35a5-4af8-b89f-b9716763a1ef.gif" width="250" height="500"/>




