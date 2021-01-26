# RateYourStuff
[![Build Status](https://github.com/fh-erfurt/RateYourStuff//workflows/build/badge.svg)](https://github.com/fh-erfurt/RateYourStuff/actions)
[![Docs](https://img.shields.io/badge/javadoc-see%20here-9cf.svg?style=flat&logo=java)](https://fh-erfurt.github.io/RateYourStuff)

Projekt, um verschiedene Arten von Multimedia zu bewerten und Ihre aktuellen Fortschritte zu teilen.

Und wer sind die Köpfe hinter dieser großartigen und überwältigend Idee?
- Robin Beck
- Christoph Frischmuth
- Mickey Knop
- John Klippstein

## Einleitung
<details>
  <summary>Die Welt dreht sich immer mehr um ...</summary>
Die Welt dreht sich immer mehr um die verschiedensten Unterhaltungsmedien und es fällt dem Konsumenten immer schwerer sich vorab eine Meinung zu bilden. Vor allem im Jahre 2020, wo das Wort „Fakenews“ nicht nur die Wortneuschöpfung eines sehr verrückten und geistig labilen Politikers ist. 

Die meisten veröffentlichten Meinung sind von Kritikern, die evtl. nicht den eigenen Geschmack vertreten und wenn andere Konsumenten ihre Bewertung auf einer Plattform veröffentlichen können, ist diese Plattform meist nur für ein bestimmtes Medium.  

Auf unserer Plattform RateYourStuff werden alle Unterhaltungsmedien vertreten, von Büchern bis hin zu Videospielen, können sie zu allem und jedem ihre eigene freie Meinung äußern. (Vorausgesetzt sie gefällt uns und wir löschen sie nicht). 

Mit RateYourStuff soll ein persönliches Bewertungssystem für Unterhaltungsmedien verschiedener Art entwickelt werden. Diese werden von den Benutzern des Systems nach verschiedenen Kriterien bewertet und daraus wird ein Finaler Punktewert generiert, der die Qualität bzw. den Unterhaltungswert des Mediums wiedergibt. Darüber hinaus kann der Benutzer seinen Fortschritt zu dem Produkt angeben was beispielsweise die Seite eines Buches oder die Folge einer Serie beinhaltet, anhand dessen wird er in den dazugehörigen Diskussionsforen vor Spoilern automatisch gewarnt. Des Weiteren kann man sich dazugehörige Werke anzeigen und nach Erscheinungsdatum, oder diese auch in einer chronologischen Reihenfolge, filtern. 
</details>

## Ausgangssituation
<details>
  <summary>Im Rahmen der Pandemie, im Jahre 2020 n.Chr. ...</summary>
Im Rahmen der Pandemie, im Jahre 2020 n.Chr., wurden, gefühlt, unendlich viele Medien konsumiert. Der gewohnte Austausch auf der Arbeit, in der Schule, an der Universität oder in den Kreisen der Freunde viel jedoch aus. Nun hat der Mensch das dringende Bedürfnis sich mitzuteilen und viele Menschen tun ihre Meinung kund, ohne gefragt zu werden.  

Nun existiert schone eine größere Menge an Portalen, die sich mit der Bewertung von Medien beschäftigen, aber auch hier zeigen sich Probleme. Andere Portale sind oft nur für ein Medium ausgelegt und, oder sind einfach unübersichtlich, nicht gut organisiert oder bieten nicht die gewünschten Funktionen. An dieser Stelle soll das Konzept von „Rate Your Stuff“ greifen. „RYS“ bietet die Möglichkeit für die populärsten Medien Meinungen abzugeben und Wertungen. Die Meinungen und Wertungen können von anderen Usern/Freunden kommentiert werden und so kann ein Austausch über unterschiedliche Medien, auf einer Plattform stattfinden
</details>

## Was ist RateYourStuff?
<details>
  <summary>RateYourStuff soll eine Bewertungsplattform für verschiedene Arten von Medien sein. Es ist geplant, folgende Medientypen vorerst zu unterstützen:</summary>

- Bücher
- Filme
- Serien
- Videospiele

Benutzer können Medien mit unterschiedlichen Kriterien bewerten. 
Für jedes Medium gibt es eine allgemeine Bewertung, die durch die Bewertungskriterien bestimmt wird. Benutzer können ihren Fortschritt auf verschiedenen Medientypen teilen. Jedes Medium hat einen eigenen Kommentarbereich. Darüber hinaus ist eine Art Mediensammlung geplant, um Medien logisch zu gruppieren.
</details>


## Zielbestimmungen
Das System soll eine Plattform zum Bewerten von diversen Mediatypen darstellen. Zu den zu bewertenden Media-Typen zählen Bücher, Filme, Serien – inklusive Episoden – sowie Videospiele. 
Nutzer sollen Ihre Medien-Fortschritte für ihr Profil verwalten und anzeigen lassen können. 
Für jedes Medium sollen Kommentare geschrieben und diese auch entsprechend kommentiert werden können. 
Den Nutzern soll es möglich sein untereinander die eigenen Fortschritte zu teilen.  

Das System soll in mehreren Etappen entwickelt werden: <br>
    - Grundsystem <br>
    - Datenbankanbindung <br>
    - Webfrontend <br>

Für das Modul Java 01 wird vorerst jedoch nur das Grundsystem umgesetzt und implementiert. 


<details>
  <summary>Muss-Kriterien</summary>
  
  <details>
  <summary>Verwaltung von Medien</summary>
      Das System muss den Nutzern die Möglichkeit bieten: 
        - Medien anzulegen <br>
        - Medien zu suchen <br>
        - Medien zu bearbeiten <br>
        - Medien in Kollektionen einzuteilen <br>
      </details>
      
  <details>
  <summary>Verwaltung von Fortschritten</summary>
      Das System muss den Nutzern die Möglichkeit bieten: 
        - eigene Fortschritte für Medien anzulegen <br>
        - den aktuellen Fortschritt prozentual oder Medienspezifisch (Buchseite, Episode, Filmminute, Spielzeit) anzuzeigen <br>
        - bereits angelegte Fortschritte zu ändern <br>
        - bereits angelegte Fortschritte zu löschen <br>
      </details>
      
  <details>
  <summary>Verwaltung von Kommentaren</summary>
      Das System muss den Nutzern die Möglichkeit bieten: 
        - Kommentare zu einem Medium zu schreiben <br>
        - auf die Kommentare von anderen Nutzern zu antworten <br>
        - Kommentare mit potenziellen Spoilern auszublenden <br>
        - Kommentare zu löschen <br>
        - Kommentare zu deaktivieren  <br>
        - Kommentare wieder zu öffnen <br>
  </details>
  
  <details>
  <summary>Verwaltung von Kollektionen</summary>
      Das System muss den Nutzern die Möglichkeit bieten: 
      - Kollektionen anzulegen <br>
      - Medien zu Kollektionen zuzuweisen <br>
  </details>
      
      
  <details>
  <summary>Bewerten von Medien</summary>
      Das System muss den Nutzern und Moderatoren die Möglichkeit bieten: 
        - eine Bewertung für ein Medium abzugeben <br>
        - die eigene Bewertung zu editieren <br>
        - die eigene Bewertung zu löschen <br>
        - eine aus den bisher abgegebenen Bewertungen ermittelte Durchschnittsbewertung anzeigen lassen <br>
  </details>
  
  <details>
  <summary>Verwalten von Benutzern</summary>
      Das System muss den Nutzern und Moderatoren die Möglichkeit bieten: 
        - andere Nutzer anhand ihres Nutzernamens zu suchen <br>
        - die eigenen Nutzerdaten einzusehen <br>
        - die eigenen Nutzerdaten zu ändern <br>
        - sich am System zu registrieren     <br>
        - Nutzer-Accounts zu deaktivieren <br>
        - Nutzer-Accounts zu reaktivieren <br>
        - das Passwort von Benutzern zurückzusetzen <br>
        - Benutzern Moderator-Rechte zu geben <br>
  </details>
</details>

<details>
  <summary>Wunsch-Kriterien</summary>  
  
  Es ist wünschenswert, das System zu einem späteren Zeitpunkt um folgende Kriterien zu erweitern: 
    - Anzeigen von empfohlenen Medien auf Basis der bereits genutzten / bewerteten Medien <br>
    - gezieltes Ausblenden von Medien, die man nicht sehen möchte (z. B.: Anhand des Genres) <br>
    - Private Nachrichten an andere Nutzer senden <br>
    - Andere Benutzer zu Freundesliste hinzufügen <br>
    - Medien abonnieren, um bei Aktualisierungen / Neuerscheinungen benachrichtigt zu werden <br>
    - Filtern und Suchen nach Fortschritten, die Nutzer zu Medien angelegt haben <br>
    - Eigene Videos, die Ausschnitte des Mediums zeigen, im Rahmen des Zitatrechts, sollen als Kommentar beziehungsweise als Meinung möglich sein. So können, zum Beispiel,     Spielabschnitte zitiert und kommentiert werden, um seinen Freunden oder Interessierten eine Möglichkeit zu bieten die Bildung der Meinung nachvollziehen zu können. <br>
    - Ein weiteres Wunschkriterium ist eine Merkliste, in der Medien hinterlegt werden können, welche man sich später ansieht/liest/spielt.<br>
</details>

<details>
  <summary>Abgrenzungskriterien</summary>
  „Rate Your Stuff“ soll keine herkömmliche Produktbewertung sein. Die Plattform gibt verschiedene Kriterien vor, die sich mit den Inhalten beschäftigen und nicht mit dem Auslieferungszustand oder der Qualität des Papieres. <br>

 
Nicht realisiert werden, sollen: <br>
    - Möglichkeit zur Wiedergabe der Medien auf der Seite <br>
    - Ermitteln von Bewertungen für Medien auf anderen Seiten <br>
    - Trennung von Benutzerbewertungen und Journalistischen Rezensionen <br> 
</details>

## UML-Diagramme
Unter diesem Punkt befinden sich unsere UML-Diagramme die wir im Vorfeld erstellt haben um unsere Idee von der Applikation grafisch darzustellen und um eine bessere Vorstellung des Ganzen zu bekommen.

<details>
  <summary>Business-Use-Case</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817333-c55f2b80-5fb5-11eb-8f0a-b00e6bf0ec16.png">
 </details

<details>
  <summary>Medien verwalten</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817334-c55f2b80-5fb5-11eb-97a8-f803c8de4a5a.png">
</details

<details>
  <summary>Medium anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817344-c7c18580-5fb5-11eb-8202-40acbe244e5e.png">
  <img src="https://user-images.githubusercontent.com/71118367/105817348-c85a1c00-5fb5-11eb-9e25-320fa124ca68.png">
</details>

<details>
  <summary>neues Buch anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817352-c8f2b280-5fb5-11eb-95c2-85281a2a9bd1.png">
</details>

<details>
  <summary>neues Film anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817356-c98b4900-5fb5-11eb-8606-891ce5ab54f8.png">
</details>

<details>
  <summary>neues Serie anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817359-ca23df80-5fb5-11eb-8515-c8fe32300565.png">
</details>

<details>
  <summary>neues Episode anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817360-cabc7600-5fb5-11eb-8612-bd4592c584ff.png">
</details>

<details>
  <summary>neues Spiel anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/105817323-c1330e00-5fb5-11eb-92b6-94ea9f3a79c2.png">
</details>

<details>
  <summary>Medien-Kollektion verwalten</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/102487254-8bbc0c00-406a-11eb-9cb5-f5fe7547de85.png">
</details>

<details>
  <summary>Medien-Kollektion anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/102487308-a55d5380-406a-11eb-8b5c-ee638b19a421.png">
</details>

<details>
  <summary>vohandene Medien-Kollektion bearbeiten</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/102487426-d63d8880-406a-11eb-80e1-2558a2c1ba71.png">
  <img src="https://user-images.githubusercontent.com/71118367/102506629-9afb8380-4083-11eb-9e93-ae4adb850ecd.png">
</details>

<details>
  <summary>Fortschritte verwalten</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817337-c6905880-5fb5-11eb-820f-2ba352946ed8.png">
</details>
<details>
  <summary>Neuen Fortschritt anlegen</summary>  
  <img src="https://user-images.githubusercontent.com/71118367/102483413-ff5b1a80-4064-11eb-9eaa-b8abf8dcde3a.png">
  <img src="https://user-images.githubusercontent.com/71118367/102485076-6aa5ec00-4067-11eb-8d7d-a04649e59a4d.png">
</details>

<details>
  <summary>Benutzer verwalten</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817335-c5f7c200-5fb5-11eb-8921-caf694b492f7.png">
</details>

<details>
  <summary>Kommentare verwalten</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817341-c728ef00-5fb5-11eb-989c-9e1b4ec59b43.png">
</details>

<details>
  <summary>Bewertungen verwalten</summary>
  <img src="https://user-images.githubusercontent.com/71118367/105817343-c7c18580-5fb5-11eb-81f4-0b9f9b49c15d.png">
</details>


## Zusammenarbeit
Im Rahmen des Projektes haben wir auf gewissen Elemente von Scrum und Kanban zurückgegriffen.

Das Team um "RateYourStuff" haben sich alle 7 Tage zusammengefunden. 
Zu diesen Treffen hat jeder seinen PPP (Progress, Planned, Problems) der Runde mitgeteilt und es wurden die Ziele für die nächsten 7 Tage gesetzt. 
Diese gesetzten Ziele wurden in einem Kanban-Board festgehalten.

<details>
  <summary>Kanban-Board des Teams</summary>
  Bild einfügen
</details>

Das Board wurde unterteilt in <br>
"ToDo" --> Hier wurden alle Issues eingestellt, die erledigt werden mussten <br>
<br>
"In progress 'Vorname des Teammitgliedes'" --> Jedes Teammitglied konnte sich dann selbst Issues aus dem Bereich ToDo nehmen und in seinen Bereich verschieben. So konnte jeder aus dem Team sehen wer sich gerade um welchen Part kümmert. Issues wurden meistens mit Checklisten versehen, so konnte auch gleichzeitig mit eingesehen werden, wie weit der Issue abgearbeitet ist <br>
<br>
"currently Done" --> in diesem BEreich des Boards wandern alle Issues, die fertigestellt wurden. dort verweilen sie bis zum nächsten Meeting. Bei diesem Meeting wird über die fertiggestellten Issues gesprochen und wenn diese in Ordnung sind, werden sie geschlossen und wandern in den BEreich "Done". <br>
<br>
"Done" --> in diesem BEreich befinden sich alle geschlossenen Issues, also alles was bisher abgearbeitet und für "fertig" erklärt wurde.<br>
<br>
Die Aufgaben wurden somit fair untereinander aufgeteilt, jeder hat meistens das genommen was ihm am besten gelegen hat und am Ende wurde alles durch das Team geprüft.<br>
<br>
Alles in allem lief das Projekt nahezu problemlos ab. Was auf unsere gute Planung und unser sehr gut harmonisierendes Team zurückzuführen ist

## Lessons Learned
Wie schon im vorhergehenden Part erwähnt hatten wir keine wirklichen Probleme in unserem Projekt. Die meisten Probleme existierten durch Unwissheit und mit einem geringen Aufwand an Selbststudium konnten diese auch behoben werden. Spätestens durch gegenseitige Hilfe waren Probleme schnell vom Tisch. <br> <br>
Dennoch soll dieses Kapitel nicht gänzlich leer bleiben. <br> 

   - Listen die in einer Klasse immer wieder benutzt werden, sollten als Attribut dieser Klasse verwendet werden! <br>
   - Keep simple stupid --> Kleine Funktionen schreiben, die in Komplexeren Methoden zusammen verwendet werden können! <br>


## Schlusswort
Nobody can touch this *Mic drop*

