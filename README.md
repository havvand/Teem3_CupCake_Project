### Funktionelt kan applikationen:

- Vise en forside med links til undersider, som endnu ikke er lavet
- Logge en user på. Der findes to brugere i databasen.
    1. `user` med password: `1234` (rolle: `user`)
    2. `admin` med password: `1234` (rolle: `admin`)
- Man kan se på `index.jsp` og `WEB-INF/welcome.jsp` hvordan man kan udnytte om en user er logget på eller ej.
- Hvis man indtaster ugyldige data under indlogning, bliver man sendt til en en fejlside.
- Logge en bruger af
- Metoden `isRoleAllowed(String role, HttpServletRequest request)` som ligger i pakken `services`. Den tjekker om en given bruger matcher en given rolle.

## MVC arkitektur
 
 
