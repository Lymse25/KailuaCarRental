# Hotel Management System Design

```mermaid
classDiagram
    class Gaest {
        -navn: String
        -adresse: String
        -email: String
        -telefonNummer: String
        -legitimation: String
        +getters()
        +setters()
    }

    class Vaerelse {
        -vaerelsesNummer: int
        -antalSengepladser: int
        -pris: double
        +getters()
        +setters()
    }

    class PrisGruppe {
        -navn: String
        -priser: List~Double~
        +addPris(pris: double)
        +addVaerelse(vaerelse: Vaerelse)
    }

    class Ydelse {
        -betegnelse: String
        -pris: double
        +getters()
        +setters()
    }

    class Tilkoeb {
        -antal: int
        +beregnTotal(): double
    }

    class Reservation {
        -fraDato: LocalDate
        -tilDato: LocalDate
        +getAntalNaetter(): int
        +beregnTotalPris(): double
    }

    class Udlejning {
        -checkIn: LocalDateTime
        -checkOut: LocalDateTime
        +checkUd()
        +beregnTotalPris(): double
    }

    class Lejeaftale {
        -dato: LocalDate
        -ekspedient: String
        +addReservation(reservation: Reservation)
        +addUdlejning(udlejning: Udlejning)
    }

    Gaest "1" -- "0..*" Lejeaftale
    Lejeaftale "1" -- "0..1" Reservation
    Lejeaftale "1" -- "0..1" Udlejning
    Vaerelse "1" -- "1" PrisGruppe
    Vaerelse "1" -- "0..*" Udlejning
    Udlejning "1" -- "0..*" Tilkoeb
    Tilkoeb "1" -- "1" Ydelse
    Reservation "0..*" -- "1" Vaerelse