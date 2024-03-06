
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

| Address             |Opis                                                                |
| ----------------- | ------------------------------------------------------------------ |
| PUT /addresses/{addressId} | Aktualizauje dane konkretnego adresu. |
| DELETE /addresses/{addressId} | Usuwa konkretny adres. |
| POST /addresses | Tworzy nowy adres.|
| GET /addresses/all | Pobiera wszystkie adresy. |

| Security             |Opis                                                                |
| ------------------- | ------------------------------------------------------------------ |
| POST /auth/register | Rejestracja nowego użytkownika. |
| POST /auth/login    | Autentykacja użytkownika do uzyskania dostępów do zasobów i metod. |
| GET /auth/verify    | Weryfikacja konta nowo stworzonego użytkownika.|



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

