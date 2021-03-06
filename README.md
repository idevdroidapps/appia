# appia demo
Android app to demonstrate basic Appia API usage.

## Specifications / Requirements
Create an Android app that consists of two screens. The first screen contains a scrolling list of products, which uses the Appia Ads API as the datasource. In this first screen, each item should display at least name, thumbnail, rating of the product. When the user clicks on one of the items, it brings the user to the second screen. The second screen should contain all pertinent information provided by the aforementioned API. Clicking the back button should bring the user back to the first screen.
* **_This demo app requires that you add your own appia API id and password:_**
Never share API passwords, ids, or keys publicly.

## Built With
* [Kotlin](https://kotlinlang.org/)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
* [Retrofit](https://square.github.io/retrofit/)

## Instructions
This demo uses the Gradle build system.

- Download the demo by cloning this repository.
- In Android Studio, create a new project and choose the "Import Project" option.
- Select the root directory that you downloaded with this repository.
- If prompted for a gradle configuration, accept the default settings. 
- Alternatively use the gradlew build command to build the project directly.

**_This demo app requires that you add your own appia API id and password:_**
Never share API passwords, ids, or keys publicly.

### Get an appia API password and id
- Create a file in the root directory called secure.properties (this file should NOT be under version control to protect your API credentials). 
- Add two lines to secure.properties that look like APPIA_API_PASSWORD="YOUR_API_PASSWORD" and APPIA_API_ID="YOUR_API_ID", where YOUR_API_PASSWORD and YOUR_API_ID are the API credentials obtained from your appia provider.
- Build and run

## Issues Encountered
- Providing a method for 'injecting' the API PASSWORD and ID so the project could be shared publicly
- Use of the DataBinding Library can often require to rebuild the project in order to generate Implementation classes.

## Author
* James Campbell - *Senior Android Engineer* -

