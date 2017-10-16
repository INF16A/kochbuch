<!-- 
@author Patrick Hahn
-->
# Kochbuch Webservice
Der Kochbuch Webservice ist ein Projekt des Kurses INF16A, das im Kurs Web Engineering II durchgeführt wird.

## Build
Als Buildsystem wird Maven verwendet. Nach der Installation von Maven kann das Projekt mit `mvn install` gebaut werden.

## Run
Nach erfolgreichem Build wird eine `.jar`-Datei im Ordner `target` erzeugt. Diese kann einfach ausgeführt werden. Der Webservice ist unter dem Port `8080` erreichbar.

Unter `/swagger-ui.html` ist eine interaktive API-Dokumentation zu erreichen. Von dort können direkt über die Seite HTTP Anfragen gestellt werden.

## Contribute
Der `master`-Branch dieses Projektes ist geschützt. Die Entwicklung findet auf einem Feature-Branch statt, der von `master` abzweigt. Nachdem das Feature komplett ist, kann ein Pull Request erstellt werden, der nach einem Review in den `master` Branch gemergt werden kann.

Bei Fragen zu diesem Projekt, zu Git, zu GitHub oder zu Spring kannst du dich an [Patrick Hahn (@patrick246)](https://telegram.me/patrick246) wenden.