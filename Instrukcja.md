# Instrukcja uruchomienia aplikacji:

Aplikację można uruchomić na dwa sposoby:
1. Github -  klonując kod z repozytorium: https://github.com/Jancik82/carexpenses.git
2. Heroku -  przechodząc po adres https://mycarexpenses.herokuapp.com/

------------

##Uruchomienie z Github:

Do uruchomienia aplikacji potrzeby jest dotęp do dowolnej bazy danych
Aplikacja jest skonfigurowana pod bazę POSTGRESQL oraz MS SQL

1. Sklonować aplikację, a następnie rozpakować w dowolnym miejscu na swoim komputerze
2. Zaimportować projekt do IDE
3. W pliku application.properties zakomentować lub odkomentować odpowiednią konfigurację bazy danych lub skofigurować własną bazę danych
4. Stworzyć  plik ‘’db.properties’ i wypełnić wg ‘db-template.properties
5. Uruchomić aplikację.
6. Uruchomić przeglądarkę internetową i przejść pod adres: https://localhost:8080
(Tomcat initialized with port(s): 8080 (http))
7. Nacisnąć przycisk "wchodzę"
8. Zalogować się do aplikacji (Username: user, Password: user1)
(Zmianę danych logowania można dokonać w clasie: SecurityConfig zmieniając .username oraz .password) 
9. Korzystać z aplikacji

------------

##Uruchomienie z Heroku:
1. Uruchomić przeglądarkę internetową i przejść pod adres https://carexpenses.herokuapp.com/
2. Nacisnąć przycisk "wchodzę"
3. Zalogować się do aplikacji (Username: user, Password: user1)

Ograniczenia alikacji na serwisie Heroku
- brak możliwości zmiany użytkownika oraz hasła

