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

## What is RateYourStuff?
<details>
  <summary>RateYourStuff soll eine Bewertungsplattform für verschiedene Arten von Medien sein. Es ist geplant, folgende Medientypen vorerst zu unterstützen:</summary>

- Bücher
- Filme
- Serien
- Videospiele

Benutzer können Medien mit unterschiedlichen Kriterien bewerten. 
Für jedes Medium gibt es eine allgemeine Bewertung, die durch die Bewertungskriterien bestimmt wird. Benutzer können ihren Fortschritt auf verschiedenen Medientypen teilen. Jedes Medium hat einen eigenen Kommentarbereich. Je nach Fortschritt jedes Benutzers gibt es Spoiler-Warnungen. Darüber hinaus ist eine Art Mediensammlung geplant, um Medien logisch zu gruppieren.
</details>


## Zielbestimmungen
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
      - nach Kollektionen zu suchen <br>
  </details>
      
      
  <details>
  <summary>Bewerten von Medien</summary>
      Das System muss den Nutzern und Moderatoren die Möglichkeit bieten: 
        - eine Bewertung für ein Medium abzugeben <br>
        - die eigene Bewertung zu editieren <br>
        - die eigene Bewertung zu löschen <br>
        - eine aus den bisher abgegebenen Bewertungen ermittelte Durchschnittsbewertung anzeigen lassen <br>
        - einen Bewertungstext zu verfassen <br>
  </details>
  
  <details>
  <summary>Verwalten von Benutzern</summary>
      Das System muss den Nutzern und Moderatoren die Möglichkeit bieten: 
        - andere Nutzer anhand ihres Nutzernamens zu suchen <br>
        - andere Nutzer der Freundesliste hinzuzufügen <br>
        - andere Nutzer von der Freundesliste zu entfernen <br>
        - die eigenen Nutzerdaten einzusehen <br>
        - die eigenen Nutzerdaten zu ändern <br>
        - sich am System zu registrieren     <br>
        - Nutzer-Accounts zu deaktivieren <br>
        - Nutzer-Accounts zu reaktivieren <br>
        - das Passwort von Benutzern zurückzusetzen <br>
        - Benutzern Moderator-Rechte zu geben <br>
        - von Benutzern angelegte Kollektionen und Medien vor Veröffentlichung zu prüfen und freizugeben <br>
  </details>
</details>

<details>
  <summary>Wunsch-Kriterien</summary>  
  
  Es ist wünschenswert, das System zu einem späteren Zeitpunkt um folgende Kriterien zu erweitern: 
    - Anzeigen von empfohlenen Medien auf Basis der bereits genutzten / bewerteten Medien 
    - gezieltes Ausblenden von Medien, die man nicht sehen möchte (z. B.: Anhand des Genres) 
    - Private Nachrichten an andere Nutzer senden 
    - Andere Benutzer zu Freundesliste hinzufügen 
    - Medien abonnieren, um bei Aktualisierungen / Neuerscheinungen benachrichtigt zu werden 
    - Filtern und Suchen nach Fortschritten, die Nutzer zu Medien angelegt haben 
    - Eigene Videos, die Ausschnitte des Mediums zeigen, im Rahmen des Zitatrechts, sollen als Kommentar beziehungsweise als Meinung möglich sein. So können, zum Beispiel,     Spielabschnitte zitiert und kommentiert werden, um seinen Freunden oder Interessierten eine Möglichkeit zu bieten die Bildung der Meinung nachvollziehen zu können. 
Ein weiteres Wunschkriterium ist eine Merkliste, in der Medien hinterlegt werden können, welche man sich später ansieht/liest/spielt.
  
</details>


Nobody can touch this *Mic drop*

