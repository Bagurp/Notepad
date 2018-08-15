# Notepad
Simple web application developed using Grails framework.

## Install Grails

This can be done by downloading and extracting the zip file from -
```
https://github.com/grails/grails-core/releases.
```

## Configuring Grails

* Set the `GRAILS_HOME` environment variable to the location where you extracted the zip.
* On Windows this is typically a matter of setting an environment variable under -
```
My Computer/Advanced/Environment Variables
```
* Add the `bin` directory to your `PATH` variable
* On Windows this is done by modifying the `Path` environment variable under 
```
My Computer/Advanced/Environment Variables
```

## Test Configuration
This can be done easily by typing `grails -version` in the terminal window and see output similar to this:
```
Grails version: 3.3.8
```
To install Grails on Unix/Linux or for more information on installation, please see the docs at -
```
http://docs.grails.org/latest/guide/gettingStarted.html
```

## Run Application
* Get the latest code using `git pull`
* Open `Command Prompt` and navigate to the project.
* Once you are inside the project, type `grails`. (This prompts the Grails to start)
* type `run-app` to run the application. 
* Open browser and go to `http://localhost:8080/` to access the application.
* Type `exit` in Command Prompt to close Grails.
