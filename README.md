# TODOLU

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframe](#Wireframe)
2. [Schema](#Schema)

## Overview
### Description
An Android mobile application that allows users to interact with friends and followers in the form of productive social media. Users will be able to post daily tasks lists, add events and meetings to their calendars, listen to music, play with study pets, and share their progress on this app. 

### App Evaluation

- **Category: Productive Social Media**
- **Mobile: Android**
- **Story: Oftentimes, we deem our worth based on how productive we are. We wanted to create this application to allow users to be transparent in their daily tasks and use social media in a productive way, thereby reverting from the distorted facade normal social media apps present.**
- **Market: This app was created to aid in human productivity but also show transparency throughout our days. Sometimes the days get by us, and that is ok. Once we become vulnerable showing that not every single day has to be just work and that we can balance with some play and relaxation, people will be more open to creating a work life balance and sharing that with their peers.**
- **Scope: We hope that anyone and everyone can utilize this app in their own unique way, but we definitely had college students and working adults in mind, especially those who spend most of their time behind a screen or work long hours.**

## Product Spec

### 1. User Stories 

* Login page so that existing users can access their daily tasks, view their friends' timelines, and use other features on the application.
* Registration page so that new users can utilize the app and have their information saved.
* Home page so that users can navigate to other screens and view their followers' timelines, as well as leave likes and comments to motivate users.
* Calendar page to help keep track of upcoming events and meetings and plan out days in advance.
* To do list page, so that users can add their daily tasks or add tasks in advance to make sure they are completing a certain itinerary everyday.
* Profile page so that users can change their profile picture, view their followers, view recent activity, and reply to other users.
* Timer page so that users can use different methods to study or complete work.
* Music page so that users can listen to whatever genre of tunes to help them focus or stay on task while completing work. 
* Pets page so that users can take a break from working by dueling with other users' pets and amass wins and losses. 


### 2. Screen Archetypes

* LOGIN
   * Allows users to access their profile, view others' daily tasks, and use the numerous other features of the application such as the calendar, to do list, timers, music, and pets pages. Users can also update their information if they forget or feel the need to change it. 
   
* REGISTRATION
   * Allows users to create an account to access all the features of the application.

* HOME
   * Allows users to navigate to other pages based on their icons, view followers' daily tasks, and leave likes and comments. 

* CALENDAR
   * Allows users to schedule events and meetings in advance, add notes and details of any items to bring, set locations and proper times, and plan out weeks in advance so that important commemorations are not forgotten.

* TO DO LIST
   * Allows users to add tasks for that day and for days in advance, check off tasks which have been complete, and discard tasks which have been cancelled or are not necessary to complete that day.

* PROFILE
   * Allows users to view information on their own profile such as their picture, followers and following, and recent activity from others. Users can also view posts on which others have liked and commented on and reply to them. 

* TIMERS
   * Allows users to use stopwatches and timers to study or work. 
   
* MUSIC 
   * Allows users to listen to music on different streaming platforms to focus. 
   
* PETS 
   * Allows users to play games with study pets once they have completed a certain amount of work. Three different games will be available and pets' wins and losses will be displayed after every match. 

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* Profile 
* Calendar 
* To Do List 
* Timers
* Music 
* Pets 

**Flow Navigation** (Screen to Screen)

* Home &#8594; Profile &#8594; Home 
* Home &#8594; Calendar &#8594; Home 
* Home &#8594; To Do List &#8594; Home 
* Home &#8594; Timers &#8594; Home 
* Home &#8594; Music &#8594; Home
* Home &#8594; Pets &#8594; Home 

## Wireframe
https://www.figma.com/file/oGuW2mDhDYDlPbobB5ItvS/todolu?node-id=0%3A1

## Schema 
### Models
#### Login

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | noaccount         | string     | redirection to login page if no account is associated with user                      |
   | editpassword     | string  | ability to edit password if forgotten or outdated                             |
   | editusername        | string   | ability to edit username is forgotten or oudated   |
   
   #### Registration

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | firstname        | string     | user's first name                       |
   | lastname     | string   | user's last name                      |
   | email        | string   | user's email   |
   | password      | string   | user's password |
   | reenterpassword | string | user's reentered password checked for verification |
   
   #### To Do List

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | buttonadd       | string     | button to add item onto to do list                        |
   | etitem     | string   | added item text                              |
   | rvitems       | string   | removed item text   |
   
   #### Profile

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | pfp       | string     | current saved user profile picture                         |
   | storageref     | string   | current and past profile picture image url                            |
   | editprofile       | string   | gallery images url   |
   | firstname     | string   | user's first name when searched up |
   | fullname     | string   | user's full name when searched up |
   
   #### Music

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | getrainbtn      | button     | when pressed plays rain sounds                        |
   | getcafebtn     | button   | when pressed plays cafe sounds                            |
   | getforestbtn      | button   | when pressed plays forest sounds   |
   | getspotifybtn     | button     | when pressed takes the user to spotify to login and listen to music                       |
   | getyoutbtn     | button   | when pressed takes the user to youtube to login and listen to music                             |
   
   #### Calendar

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | cal      | integer     | number of month                        |
   | dateview    | integer   | number of date                              |
   
   #### Home

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | post       | string     | name of user who posted                       |
   | search     | string   | text to search up user by email                             |
   | imageurl       | string   | post url   |
   
   #### Timers

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | seconds      | integer    | number of seconds left on stopwatch                        |
   | running    | boolean   | denotes whether timer or stopwatch is running in current time                            |
   | wasrunning       | boolean   | denoes whethee timer or stopwatch was the last one running   |
   
### Resources 
- https://stackoverflow.com/questions/35882752/how-to-create-a-login-database-in-android)
- https://developer.android.com/reference/android/widget/CalendarView
- https://developer.ibm.com/articles/os-android-devel/
- https://firebase.google.com/
- https://developer.android.com/reference/java/util/Timer
- https://developer.android.com/guide/fragments
- https://developer.android.com/develop/ui/views/layout/recyclerview?gclid=Cj0KCQiAkMGcBhCSARIsAIW6d0BLGE6GST_bcQkaUaHN5xw1eL-mvX4G9p-gh2J4vIP92ztCPpn8xh4aAn5nEALw_wcB&gclsrc=aw.ds
