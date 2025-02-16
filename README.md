# Assignment 1 - Android Quiz App

## Overview
This is a simple Android quiz application that presents a series of 10 questions, with each question being displayed in a separate activity. At the end of the quiz, the results are shown, and the score is reset when the user navigates back to the main activity.

## Features
- **10 Question Activities**: Each question has its own activity.
- **Score Tracking**: Keeps count of correct answers.
- **Result Display**: Shows the final score at the end.
- **Automatic Score Reset**: Resets the score when returning to the main activity.
- **Simple UI**: User-friendly and easy to navigate.

## Technologies Used
- **Java** (for logic and app functionality)
- **Android Studio** (development environment)
- **XML** (for UI layout)

## Project Structure
```
Assignment1/
│-- app/
│   │-- manifests/ (AndroidManifest.xml)
│   │-- java/com/example/assignment1/
│   │   │-- MainActivity.java
│   │   │-- Question1Activity.java
│   │   │-- Question2Activity.java
│   │   │-- ...
│   │   │-- Question10Activity.java
│   │   │-- QuizActivity.java
│   │   │-- Result.java
│   │   │-- SplashScreen.java
│   │-- res/
│   │   │-- layout/ (XML files for UI)
│   │   │-- drawable/ (Images and assets)
│   │   │-- anim/ (Animations)
│-- README.md
```

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/YOUR-USERNAME/Assignment1.git
   ```
2. Open the project in **Android Studio**.
3. Build and run the app on an emulator or a physical device.

## How to Use
1. Start the app and enter your name (if applicable).
2. Answer each question by selecting an option.
3. At the end, view your result.
4. Use the **Back** button to return to the main screen (score resets automatically).

## Contribution
Feel free to contribute by submitting pull requests or reporting issues.

## License
This project is licensed under the MIT License.

