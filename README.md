JRPG Combat Timer for Tabletop Gaming
=====================================

I'm creating a simple web interface that mimics some of the functionality of old Japanese RPG combat systems. Specifically, I am replicating
the timer progress bars. Final Fantasy 3 (6 in Japan) is an example of a game with this type of combat system.

![Final Fantasy 3 Combat](https://upload.wikimedia.org/wikipedia/en/d/df/WikibattleFF6.PNG)

My plan is to use this system at the table while playing Dungeons & Dragons 5th edition. Player Characters (PCs) will have an initiative they enter
and a combat speed. Initiative is an existing stat which helps determine starting order of combat turns. Combat Speed is a new statistic for
PCs.

Combat Speed
------------
- affected by initiative
- affected by class (i.e Monks would have the highest, Fighters would also have a high combat speed, etc)
- represents a characters ability to re-ready itself after taking an action in combat
- work in progress

Tech Stack
----------
The serverside architecture is a [Spring-Boot](https://projects.spring.io/spring-boot/) application. It uses [Spring Data](http://projects.spring.io/spring-data/) to automatically wire up REST endpoints for our domain models. I use Maven to handle dependecies and building the jar.

The front end architecture is an [Angular.js](https://angularjs.org/) app. It uses the [ui-bootstrap module](https://angular-ui.github.io/bootstrap) to integrate Twitter Bootstrap UI components into the Angular app.

Styles are used from [Twitter Bootstrap](http://getbootstrap.com/2.3.2/). 

No front end build system is used at this time, due to simplicity of the application.

Running the application
-----------------------
* Run `mvn spring-boot:run` inside the root folder
* Example urls include [localhost:8080](http://localhost:8080) and [localhost:8080/api/characters](http://localhost:8080/api/characters)
