![Alt Text](https://media1.tenor.com/m/s12dLPNA3-QAAAAd/cod-waw-call-of-duty-world-at-war.gif)


## NeoForge-Port: Minecraft 26.3

- Minecraft **26.3**, NeoForge **26.3.0.39-beta**
- JDK **25**, Gradle **9.2.1**, ModDevGradle **2.0.147**

Build unter Windows: `./gradlew.bat build`

Client starten: `./gradlew.bat runClient`

Dedizierten Server starten: `./gradlew.bat runServer`

Das Entwicklungsverzeichnis ist `run-neoforge`. Die JAR liegt unter
`build/libs/tabakmod-4-26.3-neoforge.jar`.

Der 26.3-Port verwendet die neue optionale Loot-Bedingung im
`AddItemModifier` und die neuen JSON-Formate für Loot-Bedingungen und
Loot-Modifikatoren. Die alte globale Modifier-Liste entfällt; NeoForge lädt
die Modifier direkt. Entity-Prädikate und Advancement-Hintergründe wurden
an die neuen Datenformate angepasst. Die entfallenen Block-Codecs wurden entfernt.
Kompostierung erfolgt über Item-Komponenten und Context-Int-Provider:
Tabakblätter haben 30 %, Samen 20 % Erfolgschance; die erste Schicht gelingt immer.

Die 52 Handelsangebote liegen unter `data/tabakmod/villager_trade`.
Tags erweitern die Vanilla-Berufe; der Tabakhändler verwendet eigene
Trade-Sets für alle fünf Stufen. Mod-ID und Registry-Namen bleiben erhalten.

## Samen und Integrationstest

Die aktuell eingestellte Dropchance für Tabaksamen aus kurzem und hohem Gras
beträgt 0,1 %. Die Pflanze nutzt `minecraft:supports_vegetation`, damit sie
auch auf Grasblöcken gepflanzt werden kann. Sie ist außerdem in
`minecraft:maintains_farmland` eingetragen und erhält Ackerboden unter sich.

Gezielter Integrationstest: `./gradlew.bat runServer -PseedTest`

Der Test verwendet ausschließlich `build/seed-test-run-26.3` (mit separat
akzeptierter Server-EULA in dessen `eula.txt`) und beendet den Testserver
selbstständig. Er prüft das Samen-Item auf fünf geeigneten Böden sowie auf
Stein, den Samenverbrauch, den Erhalt von trockenem Ackerboden, je 20.000
Loot-Auswertungen für kurzes Gras, hohes Gras und Stein, die Ernte unreifer
und reifer Pflanzen sowie die Kompostierung von Samen und Blättern.
Die erwartete Dropchance wird aus den geladenen Mod-Ressourcen gelesen.
Ein erfolgreicher Durchlauf schreibt `SEED_CHECKS_COMPLETE` ins Log.
Testklassen werden weder in die Mod-JAR noch in normale Client-/Serverstarts
aufgenommen.

Ein manueller Client-/Mehrspielertest und die Migration alter Spielwelten
sind durch diesen Servertest nicht abgedeckt.

## Spitting Image

[Spitting Image 5v für NeoForge 26.3](https://www.curseforge.com/minecraft/mc-mods/spitting-image/files/8912504)
ist auf Client und Server erforderlich und muss neben der Tabakmod installiert
werden. Gradle lädt diese Abhängigkeit für Entwicklungsstarts automatisch;
sie wird nicht in die Tabakmod-JAR eingebettet.

Der Spuckeffekt ruft alle 80 Spieler-Ticks (4 Sekunden bei 20 TPS) den
serverseitigen Spuckhandler von Spitting Image auf. Dessen Projektil, Ton,
Schaden und konfigurierter Cooldown gelten auch für das automatische Spucken.
Ein längerer Cooldown kann einzelne Spuckversuche verhindern. Kaugeräusche
bleiben alle 25 Spieler-Ticks erhalten. Auf Nicht-Spieler hat der Effekt keine
Aktion. Die Zeitsteuerung verwendet den individuellen Spieler-Tickzähler;
der erste Versuch kann daher innerhalb der ersten 80 Ticks erfolgen.

Der Integrationstest prüft zusätzlich zwei unabhängige Testspieler,
Projektiltyp und Besitzer, den Cooldown sowie sichere Anwendung auf Nicht-Spieler.

Kompatibilitätshinweis: Die veröffentlichte Spitting-Image-Datei 8912504
(5v-26.3-neoforge) kompiliert als Abhängigkeit, startet aber unter
NeoForge 26.3.0.39-beta nicht: Sie referenziert das entfernte
`ModConfig.Type.COMMON`. Vor einem gemeinsamen Spielstart muss Spitting Image
entsprechend aktualisiert werden. Der Integrationstest ist bis dahin blockiert.
