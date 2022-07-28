# TODOLU

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
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

## Digital Wireframe
https://www.figma.com/file/oGuW2mDhDYDlPbobB5ItvS/todolu?node-id=0%3A1

## Schema 
### Models
#### DoubleStat

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | statTitle1         | String     | Title of the first statistic                        |
   | statTitle2     | String   | Title of the second statistic                             |
   | stat1        | Number   | The first statistic   |
   | stat2      | Number   | The second statistic |
   
   #### State

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | stateName         | String     | Title of the first statistic                        |
   | deathCount     | Number   | Number of deaths                             |
   | recoveredCount        | Number   | Number of patients recovered   |
   | infectedCount      | Number   | Number of patients infected |
   | stateImage | Image | An image of the state |
   
### Networking

* screen name
  * website used
  * (request method) explanation 

* screen name
  * website used
  * (request method) explanation 

* screen name
  * website used
  * (request method) explanation  
   
### Resources 
- paste website links
