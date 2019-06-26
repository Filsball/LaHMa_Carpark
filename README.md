# LaHMa_Carpark
#### Carpark simulation

1. [User Stories](https://github.com/Filsball/LaHMa_Carpark/blob/master/modelling/User%20Stories.docx) LaHMa_Carpark\modelling\User Stories
2. [Digitalisierungskonzept](https://github.com/Filsball/LaHMa_Carpark/blob/master/modelling/Digitalisierungskonzept.docx)	LaHMa_Carpark\modelling\Digitalisierungskonzept
3. [Use Case Diagramme](https://github.com/Filsball/LaHMa_Carpark/tree/master/modelling/Use_Case)		LaHMa_Carpark\modelling\Use_Case
4. [Robustheitsanalyse](https://github.com/Filsball/LaHMa_Carpark/tree/master/modelling/Robustness_Analysis)		LaHMa_Carpark\modelling\Robustness_Analysis
5. [Sequenzdiagramme](https://github.com/Filsball/LaHMa_Carpark/tree/master/modelling/Sequence_Diagrams)		LaHMa_Carpark\modelling\Sequence_Diagrams
6. [Klassendiagramm](https://github.com/Filsball/LaHMa_Carpark/tree/master/modelling/Class_Diagramm)		LaHMa_Carpark\modelling\Class_Diagramm
7. [Unit Tests](https://github.com/Filsball/LaHMa_Carpark/tree/master/LaHMa_Servlet/src/unittests)			LaHMa_Carpark\LaHMa_Servlet\src\unittests
8. [Model Klassen](https://github.com/Filsball/LaHMa_Carpark/tree/master/LaHMa_Servlet/src/model) 		LaHMa_Carpark\LaHMa_Servlet\src\model
9. [Controller Klassen](https://github.com/Filsball/LaHMa_Carpark/tree/master/LaHMa_Servlet/src/controller)		LaHMa_Carpark\LaHMa_Servlet\src\controller
10. [Standartschritte](https://github.com/Filsball/LaHMa_Carpark/blob/master/modelling/Standardschritte.docx) LaHMa_Carpark\modelling

#### Patterns
- Template Pattern:
	- ServletState definiert Algorithmus für die 
	processGetRequestAndChangeState-Methode	und überlässt 
	konkrete Implementierung von Sub-Algorithmus von
	processGetRequest-Methode
	den Unterklassen

- Singleton Pattern:
	- Klasse Parkhaus als Singleton umgesetzt
	
- [MVC](https://www.youtube.com/watch?v=YYvOGPMLVDo)
	- Servlet dient als Controller, jsp-Dateien als Views, [Model Klassen](https://github.com/Filsball/LaHMa_Carpark/tree/master/LaHMa_Servlet/src/model) kapseln Daten um Views von Programmlogik unabhängig zu machen
	
- State Pattern:
	- LaHMa_Controller als Kontext hat einen Zustand vom Typ ServletState (oder sämtlichen Unterklassen)
