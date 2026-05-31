# 📍 Kosova Address System (JavaFX & MySQL)

Sistemi i Menaxhimit të Adresave të Kosovës është një projekt akademik dhe profesional i zhvilluar si një aplikacion desktop, duke përdorur gjuhën programuese **Java (JDK 26+)**, kornizën grafike **JavaFX**, dhe sistemin e menaxhimit të bazave të të dhënave **MySQL**. Qëllimi kryesor i këtij aplikacioni është digjitalizimi, struktursimi dhe automatizimi i procesit të regjistrimit dhe menaxhimit të lokacioneve gjeografike brenda territorit të Kosovës, duke ofruar një ndërfaqe të qëndrueshme dhe me performancë të lartë.

Softueri është projektuar mbi arkitekturën **MVC (Model-View-Controller)**, duke siguruar ndarjen e plotë të logjikës së biznesit nga ndërfaqja grafike. Në thelb të sistemit qëndron moduli **CRUD** i cili ndërlidhet me bazën e të dhënave përmes teknologjisë **JDBC**. Çdo komunikim me serverin SQL mbrohet përmes mekanizmave për trajtimin e përjashtimeve (`try-catch`), duke garantuar stabilitetin e aplikacionit dhe parandalimin e ndaljeve të papritura (*crash*) nëse lidhja me rrjetin apo serverin dështon.

## 📐 Karakteristikat Kryesore të Sistemit

* **Paneli Analitik (Dashboard):** Sistemi integron një modul statistikor që shndërron të dhënat e papërpunuara të SQL-it në grafikë dinamikë (`BarChart` dhe `PieChart`). Ky modul analizon në kohë reale dendësinë e adresave për çdo qytet dhe numrin total të regjistrimeve.
* **Motori i Kërkimit në Kohë Reale (Live Search):** Përmes përdorimit të klasave `FilteredList` dhe query-ve të optimizuara me operatorin `LIKE`, përdoruesi mund të filtrojë adresat në mënyrë asinkrone gjatë shkrimit, pa pasur nevojë për rifreskim manual të faqes.
* **Ndërfaqja UI/UX dhe Navigimi:** Ndërfaqja grafike është ndërtuar me FXML dhe është stiluar në mënyrë moderne me CSS. Aplikacioni përdor një strukturë hierarkike me `MenuBar` për menaxhimin e përgjithshëm, `Toolbar` për qasje të shpejtë në module dhe një `Status Bar` për njoftimin e gjendjes së sistemit (*Ready, Saved, Searching...*).
* **Internacionalizimi (Multi-language):** Projekti mbështet plotësisht gjuhën **Shqip** dhe **Anglisht** përmes skedarëve të lokalizimit (`.properties`). Ndërrimi i gjuhës realizohet në mënyrë dinamike pa pasur nevojë për rindezje të aplikacionit.
* **Qasja dhe Optimizimi (Accessibility):** Ndërtuar sipas standardeve inxhinierike, ku përdoruesi mund të navigojë plotësisht përmes tastierës duke përdorur tastin `TAB` me fokusim automatik të kursorit, si dhe përmes shkurtesave të integruara:
  * `Ctrl + S` — Ruajtja e formularit (Save)
  * `Ctrl + F` — Fokusimi i kërkimit (Search)
  * `Ctrl + Q` — Mbyllja e sigurt e aplikacionit (Exit)
