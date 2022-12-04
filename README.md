
# Cook Master

Cook Master is an Android App, in which we can search recipes. Each Recipe item contains:
* Recipe name
* Recipe Image
* Date Created

## DEMO

![demo_app](https://user-images.githubusercontent.com/78906777/205507500-3c0e27c8-ce6e-4993-8566-c6c0fb2a1154.gif)

## Tech Stack

**Client:** Kotlin, XML, Android Studio

**Server-side API:** Tasty API

## API Reference

Tasty API: query data about recipe, plan, ingredients, etc… as on official site: https://tasty.co/

### URL

```http
    https://tasty.p.rapidapi.com
```

#### Get List of Recipes

```http
  GET  /recipes/list
```

#### Headers

|  Headers  | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |
| `api_host`| `string` | **Required**. Host URL     |

#### Parameters

| Parameter | Type     | Description                                                        |
| :-------- | :------- | :----------------------------------------------------------------- |
| `from`    | `integer`| **Required**.  offset of items to be ignored in response for paging|
| `size`    | `integer`| **Required**. Number of items returned per response                |
| `tag`     | `string` | **Optional**. Tags associated to recipe or ingredients to search   |
| `q`       | `integer`| **Optional**. Name of food or ingredients to search by             |


### Steps to access API

* Create an account with Rapid API
* Select FOOD from categories list
* Select Tasty API (https://rapidapi.com/apidojo/api/tasty/)
* Go to the recipes/list endpoint info
* Copy the API key and use it in your project

## Requirements

*   [Android Studio](https://developer.android.com/studio) (installed on a Linux, Mac or Windows machine)

*   Android device in
    [developer mode](https://developer.android.com/studio/debug/dev-options)
    with USB debugging enabled

*   USB cable (to connect Android device to your computer)

## Build and run

### Step 1. Clone App source code

Clone the GitHub repository to your computer to get the
application.

```
https://https://github.com/adiupd123/CookMaster
```

Open the App's source code in Android Studio. To do this, open Android
Studio and select `Open an existing project`, going to the folder containing the Project folder

### Step 2. Build the Android Studio project

Select `Build -> Make Project` and check that the project builds successfully.
You will need Android SDK configured in the settings. You'll need at least SDK
version 23. The `build.gradle` file will prompt you to download any missing
libraries.

### Step 3. Install and run the app

Connect the Android device to the computer and be sure to approve any ADB
permission prompts that appear on your phone. Select `Run -> Run app.` Select
the deployment target in the connected devices to the device on which the app
will be installed. This will install the app on the device.
