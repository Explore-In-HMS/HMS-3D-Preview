 <h1 align="center">HMS 3D Viewer App Github Documentation</h3>
 
![Latest Version](https://img.shields.io/badge/latestVersion-1.0.0-yellow)
<br>
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-000000?style=for-the-badge&logo=kotlin&logoColor=green)
<br>
![Supported Platforms](https://img.shields.io/badge/Supported_Platforms:-Native_Android-orange)


# Introduction

In this documentation, we explained the development steps of 3D Viewer App.

This project helps to preview existing 3D models, generate new 3D models from real world and show them in the application. 

# Specifications
Input Image Resolution (Unit: px)
 - 1280 x 720 to 4096 x 3072 (All images input at a time must have the same resolution.)

Number of Input Images
 - 20 to 200 (recommended: 50 to 200)

Total Size of Input Images
 - No more than 800 MB

Input Image Format
 - JPG
 - JPEG

Output Format
 - OBJ
 - glTF

# Functions

- Show exist objects with HMS Scene Kit SceneView ability
- Shoot photos and collect them
- Upload photos to HMS cloud for reconstruct

# How to start?
  
# Register a developer account on HUAWEI Developers and configure.

1. Register in to [Huawei Developer Console] (https://developer.huawei.com/consumer/en/console) and Create and configure an app and enable 3D Modeling Kit in AppGallery Connect.
2. To use 3D Modeling Kit, you need to enable it in AppGallery Connect. For details, please refer to Enabling Services(https://developer.huawei.com/consumer/en/doc/distribution/app/agc-help-enabling-service-0000001146598793).


##   Adding the AppGallery Connect Configuration File of Your App
1. Sign in to AppGallery Connect and click My projects.
2. Find your project and click the app for which you want to integrate the HMS Core SDK.
3. Go to Project settings > General information. In the App information area, download the agconnect-services.json file.

 ##  Configuring the Maven Repository Address for the HMS Core SDK
1. Configuring the Maven Repository Address for the HMS Core SDK
2. Open the build.gradle file in the root directory of your Android Studio project.
3. Add the AppGallery Connect plugin and the Maven repository.

**Note** : A device with Huawei Mobile Services (HMS) installed is required
In the **project-level** build.gradle, include Huawei's Maven repository.

```groovy
buildscript { 
    repositories { 
        google() 
        jcenter() 
        // Configure the Maven repository address for the HMS Core SDK. 
        maven {url 'https://developer.huawei.com/repo/'} 
    } 
    dependencies { 
        ... 
        // Add the AppGallery Connect plugin configuration. You are advised to use the latest plugin version. 
        classpath 'com.huawei.agconnect:agcp:1.6.0.300' 
    } 
} 
 
allprojects { 
    repositories { 
        google() 
        jcenter() 
        // Configure the Maven repository address for the HMS Core SDK. 
        maven {url 'https://developer.huawei.com/repo/'} 
    } 
} 
```
4. Adding Build Dependencies
```groovy
dependencies { 
    implementation 'com.huawei.hms:modeling3d-object-reconstruct:{version}' 
    implementation 'com.huawei.scenekit:full-sdk:5.1.0.300'
    implementation 'com.huawei.scenekit:scenekit-render-foundation:6.0.0.301'
    implementation 'com.huawei.scenekit:scenekit-render-extension:6.0.0.301'
     
     // CameraX
    def camerax_version = "1.0.0-rc01"
    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation "androidx.camera:camera-core:${camerax_version}"
    implementation "androidx.camera:camera-camera2:${camerax_version}"
    // If you want to additionally use the CameraX Lifecycle library
    implementation "androidx.camera:camera-lifecycle:${camerax_version}"
    // If you want to additionally use the CameraX View class
    implementation "androidx.camera:camera-view:1.0.0-alpha20"
}
```
## **Permissions**
```xml
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.CAMERA" />
```
## **3D Reconstruct**
```java

    private final Modeling3dReconstructUploadListener uploadListener = new Modeling3dReconstructUploadListener() {
        @Override
        public void onUploadProgress(String taskId, double progress, Object ext) {
            progressCustomDialog.setCurrentProgress(progress);
        }

        @Override
        public void onResult(String taskId, Modeling3dReconstructUploadResult result, Object ext) {
            if (result.isComplete()) {
                TaskInfoAppDbUtils.updateTaskIdAndStatusByPath(saveInnerPath, taskId, 1);
                NewScanActivity.this.runOnUiThread(() -> {
                    clearImage();
                    if (camMode == 2) {
                        stepNum = 1;
                        tvShowSteps.setText(String.valueOf(stepNum));
                        ivCaptureButton.setVisibility(View.GONE);
                    }
                    progressCustomDialog.dismiss();
                    Toast.makeText(NewScanActivity.this, getString(R.string.upload_text_success), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NewScanActivity.this, PresentModelActivity.class);
                    startActivity(intent);
                });
            }
        }

        @Override
        public void onError(String taskId, int errorCode, String message) {
            runOnUiThread(() -> {
                clearImage();
                progressCustomDialog.dismiss();
                Toast.makeText(NewScanActivity.this, message + errorCode, Toast.LENGTH_SHORT).show();
            });
        }

    };
        
        Observable.create((Observable.OnSubscribe<Modeling3dReconstructInitResult>) subscriber -> {
            Modeling3dReconstructSetting setting = new Modeling3dReconstructSetting.Factory()
                    .setReconstructMode(rgbMode)
                    .setTextureMode(textureMode)
                    .create();
            magic3dReconstructInitResult = magic3dReconstructEngine.initTask(setting);
            String taskId = magic3dReconstructInitResult.getTaskId();
            if (taskId == null || taskId.equals("")) {
                subscriber.onNext(magic3dReconstructInitResult);
            } else {
                allTaskId = taskId;
                magic3dReconstructEngine.setReconstructUploadListener(uploadListener);
                magic3dReconstructEngine.uploadFile(taskId, saveInnerPath);
            }
            subscriber.onCompleted();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Modeling3dReconstructInitResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Modeling3dReconstructInitResult result) {
                progressCustomDialog.dismiss();
                Toast.makeText(NewScanActivity.this, result.getRetMsg(), Toast.LENGTH_SHORT).show();
            }
        });
            
## **3D Object Preview**
We used SceneView ability of HMS Scene Kit. For more details, please check the link below. 
https://developer.huawei.com/consumer/en/hms/huawei-scenekit/

To draw our objects in the SceneView, we prepared a CustomSceneView layout, which retrieves the name of object to be drawn.

```kotlin

class CustomSceneView : SceneView {
    private var modelName = ""

    constructor(context: Context?) : super(context)
    constructor(
        context: Context?,
        attributeSet: AttributeSet?
    ) : super(context, attributeSet)

    fun setModel(model: String) {
        this.modelName = model
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        super.surfaceCreated(holder)
        loadScene("${modelName}/scene.gltf")
//        loadSkyBox("skyboxTexture.dds") // if you want to draw a skybox, uncomment this line.
        loadSpecularEnvTexture("specularEnvTexture.dds")
        loadDiffuseEnvTexture("diffuseEnvTexture.dds")
    }
}
```
## **Main Page**

![image](https://user-images.githubusercontent.com/77769277/153003941-cba7a40d-8834-412d-a93b-f319c20b106c.jpg)

## **3D Modelling Page**

![image](https://user-images.githubusercontent.com/77769277/153003947-84cb2739-3146-49ad-a7a5-d52d31748c3e.jpg)

## **Capture Photos**

![image](https://user-images.githubusercontent.com/77769277/153003953-67bb3f1b-6b84-4f52-94a9-953ef73ade16.jpg)

![image](https://user-images.githubusercontent.com/77769277/153003955-b06de1e5-cc24-40c5-9053-3a238c8fe58d.jpg)

![image](https://user-images.githubusercontent.com/77769277/153003963-7ed56321-4944-44bc-8e64-19c0a720e1ab.jpg)

## **Select Object**

![image](https://user-images.githubusercontent.com/77769277/153003967-010282d3-356b-4625-a92d-6a6b2dd42abe.jpg)

## **Object Preview**

![image](https://user-images.githubusercontent.com/77769277/153003969-69af4eba-d0d5-4092-9022-c062dd24f991.jpg)
