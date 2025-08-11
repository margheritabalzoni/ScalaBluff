# ScalaBluff 🎴

## Membri del gruppo
- Balzoni Margherita (margherita.balzoni@studio.unibo.it)
- Buzi Sajmir (Sajmir.buzi@studio.unibo.it)
- Gioele Santi (gioele.santi2@studio.unibo.it)

**Deadline:** 15/09/2025

---
## Processo di sviluppo
Il progetto adotterà un approccio SCRUM-inspired. Nel primo incontro sono stati definiti:
- Idea generale
- Fattibilità tecnica
- Funzionalità minime per una versione giocabile

---
## Requisiti principali
Sviluppo in Scala di una versione digitale del gioco di carte Bluff ("Dubito"): i giocatori giocano carte coperte dichiarandone (non sempre veridicamente) il valore; gli altri possono "chiamare il bluff" verificando le carte e assegnando penalità.

---
## Funzionalità base
- Gestione del mazzo e distribuzione iniziale delle carte
- Gestione dei turni e delle dichiarazioni
- Meccanismo di verifica del bluff e assegnazione penalità
- Aggiornamento dello stato di gioco e rilevamento della fine partita
- Interfaccia testuale semplice e funzionale
- Test tramite DSL per la modellazione degli stati del gioco

---
## Requisiti opzionali
- Modalità "torneo" con più partite e classifica finale
- Introduzione di un bot (logiche di bluff semplificate o casuali)
- Statistiche di gioco (bluff riusciti, errori di accusa, vittorie)
- Interfaccia avanzata con ScalaFX o curses