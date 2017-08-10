# TECHEXE-AppTools



android app custom library

AppTools is an Android library that simplifies the process of requesting permissions at runtime and much more.

Android Marshmallow includes a new functionality to let users grant or deny permissions when running an app instead of granting them all when installing it. This approach gives the user more control over applications but requires developers to add lots of code to support it.

Its frees your permission code from your activities and lets you write that logic anywhere you want.

Usage
-----

### Dependency

Include the library in your ``build.gradle``

```groovy
dependencies{
    compile 'com.techexe:apptools:app:+'
}
```


To start using the library you just need to call `PermissionManager` with a valid `Activity`:

```java
public MyActivity extends Activity {
	@Override public void onCreate() {
		super.onCreate();
        new PermissionManager.Builder(MainActivity.this)
                .addPermissions(PermissionRequest.callPermission())
                .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                    @Override
                    public void onGrant() {
                        
                    }

                    @Override
                    public void onDenied(String permission) {

                    }
                }).build().request();

	}
}
```

### Single permission
For each permission, register a ``PermissionCallback`` implementation to receive the state of the request:

```java
        new PermissionManager.Builder(MainActivity.this)
                .addPermissions(PermissionRequest.callPermission())
                .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                    @Override
                    public void onGrant() {
                        
                    }

                    @Override
                    public void onDenied(String permission) {

                    }
                }).build().request();
```

To make your life easier we offer some ``PermissionListener`` implementations to perform recurrent actions:


### Multiple permissions
If you want to request multiple permissions you just add to request:

```java
        new PermissionManager.Builder(MainActivity.this)
                .addPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                    @Override
                    public void onGrant() {

                    }

                    @Override
                    public void onDenied(String permission) {

                    }
                }).build().request();
```


The library will notify you when something bad happens. In general, it is a good practice to, at least, log every error AppTools may throw but is up to you, the developer, to do that.

**IMPORTANT**: Remember to follow the [Google design guidelines][2] to make your application as user-friendly as possible.



License
-------

    Copyright 2015

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: ./art/sample.gif
[2]: http://www.google.es/design/spec/patterns/permissions.html
[3]: https://github.com/JakeWharton/butterknife
[4]: https://github.com/junit-team/junit
[5]: https://github.com/mockito/mockito
