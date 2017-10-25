<!-- 
@author Yoco Harrmann
-->
# Quickstart Guide für nicht so schlaue Leute: 
1. Projekt mit der git-bash von Github [herunterladen](https://github.com/INF16A/kochbuch/archive/master.zip) und entpacken (Befehl: `git clone https://github.com/INF16A/kochbuch.git`) 
2. In IntelliJ öffnen. Über View -> Tool Windows -> Maven Projects den Button "Execute Maven Goal" klicken und dort `mvn install` eingeben und ausführen (Falls nichts passiert den VirenScanner deaktivieren). 
3. XAMPP runterladen und installieren. Dann die Module MySQL und Apache starten. Darauf achten, dass der Port 3306 bei MySQL angezeigt wird, ansonsten PC neustarten und hoffen, dass es beim nächsten mal klappt. 
4. http://localhost/phpmyadmin/ aufrufen und eine Datenbank mit dem Namen `kochbuch` anlegen. 
5. Bei dem `mvn install` wird in dem `kochbuch/target/` Ordner eine .jar-Datei erzeugt, diese mit der Powershell ausführen. Befehl dazu lautet: `java -jar .\kochbuch-1.0.0.jar`
6. http://localhost:8080/swagger-ui.html aufrufen und hoffen, dass es funktioniert.
7. Testdaten liegen in `kochbuch/src/main/resources/sql_recipes.sql` -> Den Inhalt in http://localhost/phpmyadmin/ unter dem Reiter SQL ausführen. 
8. Bei Fragen an [Patrick Hahn (@patrick246)](https://telegram.me/patrick246) wenden, er hat die Ahnung. 
<!-- Ende Yoco-Teil -->


<!-- 
@author Patrick Hahn
@author Armin Beck
-->
# Kochbuch Webservice
Der Kochbuch Webservice ist ein Projekt des Kurses INF16A, das im Kurs Web Engineering II durchgeführt wird.

## MySQL mit Docker
Um sich die MySQL lokal bereitzustellen, kann man entweder MySQL manuell installieren und konfigurieren oder die Datenbank sich mit Docker automatisch bereitstellen lassen(erfordert Dockerinstallation). Mit dem Befehl `docker-compose up -d` startet man die Datenbank (der Parameter -d lässt die DB ähnlich eines Daemons laufen). Um die Datenbank zu stoppen verwendet man `docker-compose down`.

## Build
Als Buildsystem wird Maven verwendet. Nach der Installation von Maven kann das Projekt mit `mvn install` gebaut werden.

## Run
Nach erfolgreichem Build wird eine `.jar`-Datei im Ordner `target` erzeugt. Diese kann einfach im Wurzelverzeichnis des Repositorys mit `java -jar target\kochbuch-1.0.0.jar` ausgeführt werden. Der Webservice ist unter dem Port `8080` erreichbar.
Unter `/swagger-ui.html` ist eine interaktive API-Dokumentation zu erreichen. Von dort können direkt über die Seite HTTP Anfragen gestellt werden.

### MySQL Parameter 
Über die Kommandozeile, lässt sich der MySQL Pfad ändern, falls sie nicht auf localhost gehostet ist.
- MySQL-Host Parameter: ```--mysql-host=<HOST>```
- MySQL-Port Parameter: ```--mysql-port=<PORT>```

## Contribute
Der `master`-Branch dieses Projektes ist geschützt. Die Entwicklung findet auf einem Feature-Branch statt, der von `master` abzweigt. Nachdem das Feature komplett ist, kann ein Pull Request erstellt werden, der nach einem Review in den `master` Branch gemergt werden kann.

Bei Fragen zu diesem Projekt, zu Git, zu GitHub oder zu Spring kannst du dich an [Patrick Hahn (@patrick246)](https://telegram.me/patrick246) wenden.
