# DealsSearch App

## Background
This app is intended to allow users to search for current deals on products they may enjoy. For the initial version of the app this functionality is limited to just showing the current deals at the time.

## App Highlights

1. **Deals List**
    * When you open the app the latest deals will be loaded into a list
    * Each deal will show the regular price, sale price (if applicable) and an option to ship the item or find it in a store
    * If an item has an image it will display on the left
2. **Deal Details**
    * Clicking a deal will show more details about a deal, which includes a thorough description of the deal
3. **Credit Card Validation**
    * Clicking the credit card icon in the toolbar will open a dialog that prompts for credit card entry
    * The submit button of the dialog will be disabled until you type in a valid credit card
4. **Dark Mode Support!**
    * Added simple themes to leverage Android support of dark mode and created specific colors for use in dark mode
5. **Motion (Still in Progress)**
    * This feature is not finished yet, but initial MotionLayout implementation on the Deal Item screen can be found in the `motion` branch

## Libraries/APIs Used

* **Android Architecture Components**
    * Coroutines were used to simplify the threading model of the app (primarily to fetch data from the Deals API
    * LiveData was used to pas data from the ViewModel to the View
    * The Navigation component was used to simplify the transitions between screens and facilitate passing data across fragments using SafeArgs
* **Hilt/Dagger**
    * Used the newly stable Hilt library build on Dagger for dependency injection to inject relevant classes into the ViewModels, Repositories, etc
* **Glide**
    * Used to download deal images from the network
* **Retrofit**
    * Used as a networking layer to interact with the Deals API
* **Gson**
    * Used Retrofit's Gson parser to parse JSON responses into Kotlin model objects
* **Kotlin**
    * Used to reduce boilerplate code and reduce nullability issues

## Issues Encountered
* I experienced issues with the linked documentation for the credit card validation algorithm -- upon further searching I found the step I was missing
* I experienced a data binding compile issue that forced me to clean the repo before building in certain cases
* I had trouble getting a UI test framework set up using the new HiltTestRule

## Roadmap/Future Improvements
* Add additional unit tests for ViewModel and Repository classes
* Add Espresso/UI tests to validate UI flows
* Use a database to store deals and potentially add a mechanism to favorite/save them
* Implement a retry mechanism for failed API calls (i.e exponential backoff)
* Further UI and style improvements -- converting deals list to use Jetpack Compose
* Add more information to the details screen