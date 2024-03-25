# mobile-automation-e2e-bdd

This project helps you to automate the mobile applications on both Android and iOS platforms across virtual and real devices.

# Tools:
Maven: 3
Java: 17
Appium server: 2.5.1
Appium java client: 8.5.1
Selenium support: 4.9.1
extentreports: 5.0.9
Cucumber: 7.15.0

# Pre-requisites:
The system should have the android sdk setup and the following environment variables setup:<br>
a. ANDROID_HOME </br>
b. ANDROID_SDK_ROOT

The system should have the Node sever and the appium server installed.

For ios simulators: The system should have the XCode and simulators setup done.

# Configurations:
The automation run configurations can be updated in [Config.properties](src/test/resources/Config.properties) file:
1. platformName = The name of the platform: Possible values(**IOS**, **ANDROID**)
2. deviceType = The type of the device: Possible values(**VIRTUAL**, **REAL**)
3. appiumServerMode = The mode of the appium server: Possible values(**local**, **saucelabs**)
4. implicitWaitTime=The implicit waiting time for a WebElement.
5. androidHome={Path of the android sdk}

# Capabilities
Capabilities for Android, ios and sauce labs can be maintained [here](src/test/resources/capabilities)

# Appium server details
Local and remote appium server details can be maintained [here](src/test/resources/appiumServerDetails.json)

    
