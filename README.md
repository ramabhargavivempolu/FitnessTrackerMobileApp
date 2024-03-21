Overview

An Android software programme designed specifically for people who want to precisely track and improve their fitness routines is called the Fitness Tracker Mobile App. An variety of functions are included in this user-friendly and simple programme to provide a thorough and customised fitness monitoring experience. The app features include:
•	Tracking workout duration
•	Conversion between different units of measurements
•	Playing workout audio tracks
•	Scheduling workouts
•	Viewing a summary of workouts
Features


1. Workout Tracking
The Detail Activity part of the Fitness Tracker Mobile App includes a function that enables users to keep an in-depth log of their workouts. The 'Start Tracking' and 'Stop Tracking' buttons here allow users to start and stop tracking their workouts, respectively. When the 'Start Tracking' button is clicked, the application immediately logs the current time as the start of the workout. Similar to this, when the 'Stop Tracking' button is activated, the application records the current time as the workout's ending time and determines the overall time spent working out. SharedPreferences is used to securely store this data together with details about the weight used and the workout's intensity level.



2. Unit Conversion
The app's UnitConversionActivity feature makes it simple to convert between various measurement units. Users can enter the needed value, choose an appropriate unit conversion from the spinner's drop-down menu, and then click the "Convert" button. For the user's convenience, the result of this conversion is then displayed on the screen.
3. Workout Audio
By playing upbeat audio tracks while exercising, users of the WorkoutAudioActivity component can improve their workout experience. Three independent audio tracks, each with its own 'Play' button, are accessible through the application. When a track's 'Play' button is clicked, only that track starts to play; the 'Play' buttons for the other two tracks are hidden at the same time to prevent any confusion.
4. Workout Scheduling
Users have the opportunity to schedule their workouts using this function under the Detail Activity area. Users are prompted to enter the date for the scheduled workout in a DatePickerDialog popup that appears when they click the "Schedule Workout" button. The workout is then scheduled by an AlarmManager using the chosen date.
5. Workout Summary
The app's WorkoutSummaryActivity feature generates an in-depth account of the user's most recent workout. The data displayed includes information on the weight used, the length of the session, the intensity level, and the start and end times of the workout.
How to Use

 

1.	Workout Tracking: Enter your weight and the intensity of your workout in the Detail Activity section, then click the 'Start Tracking' button to start keeping track of your workout. When you're done, use the 'Stop Tracking' button. 
 


2.	Unit Conversion: Enter the value to be converted into the Unit Conversion Activity, choose the desired unit conversion from the drop-down menu, and then click the "Convert" button to obtain the result.

 

3.	Workout Audio: Go to the WorkoutAudioActivity and select the tune you wish to listen to while working out by clicking the 'Play' button.

 

4.	Workout Scheduling: Select the date for your workout in the dialogue that opens by clicking the "Schedule Workout" option in the Detail Activity.

 


5.	Workout Summary: Go to the Workout Summary Activity to view a summary of your most recent workout.

