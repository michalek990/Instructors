
# Spring for instructors

Aplikacja "Instructors" to nowoczesne rozwiązanie zaprojektowane do zarządzania informacjami o instruktorach w ramach organizacji edukacyjnych. Umożliwia łatwe przechowywanie, aktualizację i wyszukiwanie danych na temat instruktorów, w tym ich specjalności, dostępności i osiągnięć. Wykorzystując moc Spring Boot oraz konteneryzację Docker, aplikacja ta zapewnia skalowalne i łatwe w obsłudze środowisko, które można łatwo dostosować do potrzeb każdej instytucji edukacyjnej. Dzięki intuicyjnym endpointom REST API, "Instructors" oferuje bezproblemową integrację z istniejącymi systemami oraz możliwość rozbudowy o dodatkowe moduły w przyszłości.


## Technologie

- **Java:** Język programowania używany do tworzenia aplikacji.
- **Spring Boot:** Framework ułatwiający tworzenie aplikacji Spring.
- **Maven:** Narzędzie do automatyzacji budowy oprogramowania.
- **Docker:** Platforma do konteneryzacji aplikacji, ułatwiająca wdrażanie i skalowanie.
- **Git:** System kontroli wersji służący do śledzenia zmian w kodzie źródłowym.

## Endpoints

Lista dostępnych endpointów API wraz z krótkimi opisami:

| Instructors             |Opis                                                                |
| ----------------- | ------------------------------------------------------------------ |
| GET /instructors | Zwraca listę wszystkich instruktorów. |
| GET /instructors/{id} | Zwraca szczegółowe informacje o instruktorze o podanym ID. |
| POST /instructors | Tworzy nowego instruktora z danymi przesłanymi w ciele żądania.|
| PUT /instructors/{id} | Aktualizuje dane instruktora o podanym ID. |
| DELETE /instructors/{id} |  Usuwa instruktora o podanym ID.|

| Security             |Opis                                                                |
| ----------------- | ------------------------------------------------------------------ |
| GET /instructors | Zwraca listę wszystkich instruktorów. |
| GET /instructors/{id} | Zwraca szczegółowe informacje o instruktorze o podanym ID. |
| POST /instructors | Tworzy nowego instruktora z danymi przesłanymi w ciele żądania.|



## Instalacja

Instrukcje dotyczące uruchomienia projektu lokalnie, np.:

**1. Sklonuj repozytorium**
```
git clone https://github.com/michalek990/Instructors.git
```
**2. Zbuduj i uruchom projekt przy użyciu Maven:**
```
./mvnw spring-boot:run
```
**3. Uruchomienie aplikacji w kontenerze Docker:**
```
docker build -t nazwa-twojego-obrazu .
docker-compose up
```


## Licencja

