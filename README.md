JRPG Combat Timer for Tabletop Gaming
=====================================

I'm creating a simple web interface that mimics some of the functionality of old Japanese RPG combat systems. Specifically, I am replicating
the timer progress bars. Final Fantasy 3 (6 in Japan) is an example of a game with this type of combat system.

![Final Fantasy 3 Combat](https://upload.wikimedia.org/wikipedia/en/d/df/WikibattleFF6.PNG)

My plan is to use this system at the table while playing Dungeons & Dragons 5th edition. Player Characters (PCs) will have an initiative they enter
and a combat speed. Initiative is an existing stat which helps determine starting order of combat turns. Combat Speed is a new statistic for
PCs.

Formula for determining combat order
------------------------------------
- y = mx + b
- y = combat position
- m = combat speed
- x = the given round
- b = initiative

Combat Speed
------------
- rate of change of combat order
- some function of a character's dexterity ability score and constitution ability score

Tech Stack
----------
- [Spring Data JPA](http://projects.spring.io/spring-data/) to make it easy to query models
- [Spring Data REST](https://spring.io/guides/gs/accessing-data-rest/) to automatically wire up REST endpoints for our domain models
- [Spring-Boot](https://projects.spring.io/spring-boot/) application
- [Maven](https://github.com/apache/maven) for dependency management
- [Angular.js](https://angularjs.org/) for SPA HTML front end
- [ui-bootstrap module](https://angular-ui.github.io/bootstrap) to integrate Twitter Bootstrap UI components into the Angular app
- [Twitter Bootstrap](http://getbootstrap.com/2.3.2/) for base styling

No front end build system is used at this time, due to simplicity of the application.

Running the application
-----------------------
- Run `mvn spring-boot:run` inside the root folder
- Example urls include:
	- [http://localhost:8080](http://localhost:8080)
	- [http://localhost:8080/api/combats](http://localhost:8080/api/combats)
