# AppsMaddle Android SDK

AppsMaddle is feature flag and analytics service for mobile apps.

## Installation

Add the dependency in your (app-level) build.gradle

```gradle
dependencies {
    implementation 'com.appsmaddle.sdk:maddle:1.0.0'
}
```

## Usage
### Initialize it
```java
AppsMaddle.init(this, YOUR_API_KEY, YOUR_APP_KEY);
```
Initializing is enough to get analytics from your app.

### Get your configs
#### You can download your customized Config class from AppsMaddle dashboard.
```java
AppsMaddle.loadConfig(Config.class, new OnLoadListener<Config>() {
    @Override
    public void onLoaded(Config config) {
        mConfig = config;

        //Check flag is toggled
        if(mConfig.multilingual.show_message) {
            //Get other configs
            String title = mConfig.multilingual.message_title;
            String description = mConfig.multilingual.message_desc;
            showAlertDialog(title, description);
        }

    }
});
```

## More
By default, AppsMaddle gets language specific configs according to system language.
You can override default language.

```java
AppsMaddle.loadConfig("en", Config.class, new OnLoadListener<Config>() {
    @Override
    public void onLoaded(Config config) {
        ...
    }
});
```
