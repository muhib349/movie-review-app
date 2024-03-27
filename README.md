# Movie Review Application
This is an Android application designed to get movies from the http://www.omdbapi.com API. The app allows users to sign up, and sign in including biometric authentication. 

# Features

* Users can sign up and sign in. Biometric sign in also implemented. 
* Users can search for movies using keywords(for now titles containing love).
* Movies will appear that are released after the year 2000.
* Movies are ordered by their release year lowest to highest.
* Added on scroll pagination to fetch movies by calling API


# Technologies Used

* **Kotlin** as the primary programming language used for development.
* The application is developed using the **Android Studio** IDE.
* **Room** as the local database to store user data
* **MVVM** design pattern is used to develop this application
* **Retrofit** has been used to call REST APIs
* For dependency injection **Hilt** has been used.
* **Glide** is used to fetch movie posters based on a URL.

# Installation

1. git clone https://github.com/muhib349/movie-review-app.git
2. Open the project in Android Studio. 
3. Build and run the project on an Android device or emulator.
