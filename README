# Dashboard for Job Tracking Agent

## Table of Contents
### Project Overview

## Overview
This project will simply be the UI that gets information from the database and will display all the information. Its meant to replace looking at a google sheet and customize the viewing expierence. Theoretically a sheets is more accessible from anywhere but is also accessible to anyone so not ideal nor secure. The information should be more rigid and predictable espessically since the agent is the one handling the management of the data. How will this work? 
<br><br>
We will serve the entire dashboard from an nginx server so that only one port is open and makes it easy to audit traffic in the future. Secondly, it makes sense so that the frontend can route calls to the backend through one proxy. The frontend will consist of a Vue.js UX to make the dashboard dynamic and handle state easy. The backend will be a Springboot backend to be robust and **again** predictable. Springboot is also very secure and easy to lockdown which makes this migration from sheets to a homemade dashboard for the reasons of security make more sense. 
<br><br>
The dashboard will try to mimic sheets ironically by displaying the data in a tabular format just with some more colors representing data in a quick manner that won't require reading everything to understand.
<br><br>
| Color  | Meaning |
| ------ | ------------------------------------- |
| Green  | Active/In progress |
| Yellow | Applied but haven't heard a response |
| Amber  | Haven't heard in a while/ Ghosted |
| Red    | Known Rejection |
