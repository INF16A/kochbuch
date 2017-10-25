<!-- 
@author Patrick Hahn
@author Armin Beck
-->
# Kochbuch Webservice
Der Kochbuch Webservice ist ein Projekt des Kurses INF16A, das im Kurs Web Engineering II durchgeführt wird.

## MySQL mit Docker
Um sich die MySQL lokal bereitzustellen, kann man entweder MySQL manuell installieren und konfigurieren oder die Datenbank sich mit Docker automatisch bereitstellen lassen(erfordert Dockerinstallation). Mit dem Befehl `docker-compose up -d` startet man die Datenbank (der Parameter -d lässt die DB ähnlich eines Daemons laufen). Um die Datenbank zu stoppen verwendet man `docker-compose down`.

## MySQL Parameter 
Über die Kommandozeile, lässt sich der MySQL Pfad ändern, falls sie nicht auf localhost gehostet ist.
- MySQL-Host Parameter: ```--mysql-host=<HOST>```
- MySQL-Port Parameter: ```--mysql-port=<PORT>```

## Build
Als Buildsystem wird Maven verwendet. Nach der Installation von Maven kann das Projekt mit `mvn install` gebaut werden.

## Run
Nach erfolgreichem Build wird eine `.jar`-Datei im Ordner `target` erzeugt. Diese kann einfach ausgeführt werden. Der Webservice ist unter dem Port `8080` erreichbar.

Unter `/swagger-ui.html` ist eine interaktive API-Dokumentation zu erreichen. Von dort können direkt über die Seite HTTP Anfragen gestellt werden.

## Contribute
Der `master`-Branch dieses Projektes ist geschützt. Die Entwicklung findet auf einem Feature-Branch statt, der von `master` abzweigt. Nachdem das Feature komplett ist, kann ein Pull Request erstellt werden, der nach einem Review in den `master` Branch gemergt werden kann.

Bei Fragen zu diesem Projekt, zu Git, zu GitHub oder zu Spring kannst du dich an [Patrick Hahn (@patrick246)](https://telegram.me/patrick246) wenden.
