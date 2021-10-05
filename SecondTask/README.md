Justina Šalukaitė 5gr.

2 dalis:
testuotojas: Žygimantas Augustas Keršys (https://github.com/zyke-99/PSP-2021)
Testai buvo aiškūs ir lengvai suprantama, ko tikimasi iš metodo. Buvo pataisytos kelios klaidos, tokios kaip:

    @Test
    void Validate_PasswordIsShorterThanRequiredLength_ShouldReturnFalse() {
        assertFalse(passwordChecker.validate("Pass@"));
    }


    @Test
    void Validate_PasswordAdheresToTheRules_ReturnsTrue() {
        assertTrue(passwordChecker.validate("Pass@"));
    }
    
(skirtingi testai kreipiasi į tą patį metodą, paduodami tokį pat argumentą, tačiau tikimasi skirtingo rezultato).
