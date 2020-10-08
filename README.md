# FRIENDS

Dit project heeft betrekking op mijn individueel project voor semester 3 bij de Fontys. in dir project zal al mijn documentatie, code en eventueel andere benodigheden staan voor mijn prject.

Kanban bord: https://trello.com/invite/b/dpDj7pfy/ef1896bdf02df67cb05642dc4bc50549/friends

# Inhoud

- [Inleiding](#Inleiding)
- [Situaties](#situaties)
    - [Huidige situatie](#huidige-situatie)
    - [Het probleem](#het-probleem)
    - [Gewenste situatie](#gewenste-situatie)
- [MoSCoW methode](#MoSCoW-methode)
    - [Must](#must)
    - [Should](#should)
    - [Could](#could)
- [Requirements](#Requirements)
    - [Functional requirements](#Functional-requirements)
    - [Non-functional requirements](#Non-functional-requirements)
 
<br>

# Inleiding

Ik heb een lange tijd zitten brainstormen over wat ik met mijn project wou gaan doen, hierbij heb ik allerlij ideeen gehad maar wou ik eigenlijk wel iets nuttigs en relevants maken waar ik na dit project ook nog iets mee kan. Toen kwam mijn idee "Friends". Friends is een applicatie voor vriendengroepen die vaak moeite hebben met beslissingen maken voor bijvoorbeeld wat ze gaan doen of wanneer, in mijn app kan iedereen individuel stemmen over vooraf bepaalde onderwerpen of hij/zij het wel of niet leuk vind, als iedereen dit gedaan heeft komt er een mooie en overzichtelijke uitslag van wat er het beste bij de groep past. Hierdoor elimineer je het probleem dat mensen het niet met elkaar eens worden over wat ze willen gan doen.

# Situaties

In dit hoofdstuk worden de huidige en gewenste situatie beschreven. De gewenste situatie is een situatie waarin alles perfect is, deze kan dus afwijken van de uiteindelijke situatie.

## Huidige situatie

op het moment is er nog geen goed platorm om met een groep mensen of je wel of niet iets leuks vind en naderhand een mooie uitslag krijgt.

## Het Probleem

Er is nog geen applicatie dus dat is het probleem.

## Gewenste situatie

De gewenste situatie is dat er een gebruiksvriendelijke en overzichtige applicatie is die niet te ingewikkeld is om met een groep uitjes en/of spelletjes te kiezen.

<br>

# MoSCoW methode
In dit hoofdstuk staan de huidige requirements opgesteld in een MoSCoW model. Deze requirements kunnen gedurende het project aangepast worden.

## Must

- Een website maken.
- Login voor personeel en gebruikers
- Vrienden uitnodigen om zich bij een game aan te sluiten
- Een game kunnen aanmaken als gebruiker
- Een eigen catagory maken om te spelen,  en op te kunnen slaan en publishen
- Een overzicht krijgen na de game
- In een game aan kunnen geven of je een onderwerp wel of niet leuk vind

## Should

- Een soort datum prikker maken voor eindresultaat
- Agendas van vrienden samen nemen en zo data aanbevelen
- Vrienden opslaan voor snel toevoegen
- Een functie voor anoniem stemmen
- Het evenement aan je persoonlijke agenda toevoegen

## Could

- Gepersonaliseerde reclame
- Met verschillende groepen een game spelen

# Requirements

Functional requirements gaan over wat het systeem wel en niet moet doen, de Non-functional requirements gaan over hoe het systeem het moet doen.

## Functional requirements

### FR.001: De gebruiker moet in kunnen loggen
- K01.1 Wanneer de gebruiker geen geldige wachtwoord/email combinatie invoert verschijnt er een foutmelding.
- B01.2 Als de gebruiker geen account heeft kan deze niet inloggen.
- B01.3 Wachtwoorden moeten minimaal 7 tekens lang zijn en een hoofdletter bevatten.

### FR.002: De gebruiker moet een account kunnen aanmaken.
- B02.1 Als de gebruiker al een account heeft dan kan hij er niet nog een aanmaken met hetzelfde e mailadres.
- B02.2 Er mogen geen dubbele e mailadressen in de database staan.

### FR.003: De gebruiker moet zijn account kunnen verwijderen.
- K03.1 Er moet visuele feedback naar de gebruiker zijn dat het account is verwijderd.

### FR.004: De gebruiker moet een eigen gemaakte catagorie kunnen uploaden.
- B04.1 De benodigde gegevens voor de catagorie moeten worden ingevoerd. Titel, beschrijving en inhoud.
- B04.2 de catagorie moet meteen beschikbaar zijn op de website voor alle gebruikers.

### FR.005: Een gebruiker moet de catagorie kunnen spelen.
- K05.1 de gebruiker moet de catagorie in de browser of app kunnen spelen.

### FR.006: Gebruikers moeten een makkelijk en overzichtelijk beeld hebben van alle categorieën.
- K06.1 De gebruiker moet op een catagorie kunnen klikken om meer informatie te zien en ze te kunnen spelen.
     
<br> 

## Non-functional requirements

- NF001: De backend wordt in spring boot gemaakt.
- NF002: De data wordt in een MYSQL database opgeslagen.
- NF003: De frontend moet gebruiksvriendelijk zijn.
- NF004: Het systeem moet een gebruikersnaam en wachtwoord gebruiken om bij de data te kunnen komen.
- NF005: De data moet toegankelijk zijn via een REST-API.
