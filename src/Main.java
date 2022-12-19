import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Metoda verifica da un CNP este valid prin a verifica lungimea acestuia
     * Lungimea unui CNP este intodeauna de 13 caractere astfel, verificam daca lungimea NU este egala cu 13
     * In cazul in care lungimea este diferita de 13, CNP-ul este marcat ca fiind invalid
     * @param length - transmis ca si parametru folosind CNP.length() in main la apelare
     * @return True/False in functie de rezultatul conditiei
     */
    public static boolean isCNPValid(int length) {
        boolean flag = true;
        if (length != 13) {
            flag = false;
        }
        return flag;
    }

    /**
     * Verificam prefixul anului pe baza primei cifre din CNP. Distribuita anilor arata in felul urmator:
     * 1/2 - Persoana de sex masculin/feminin nascuta in intervalul 1900 - 1999
     * 3/4 - Persoana de sex masculin/feminin nascuta in intervalul 1800 - 1899
     * 5/6 - Persoana de sex masculin/feminin nascuta in intervalul 2000 - 2099
     * 7/8 - Persoana de sex masculin/feminin rezidenta (Nu vom lua cazult acesta in calcul)
     * @param firstNumber - primul caracater din CNP transmis din main folosind CNP.charAt(0)
     * @return - Returnam un string de tip "19" in cazul persoanelor cu prima cifra fiind 1 din CNP
     */
    public static String getYearPrefix(char firstNumber) {
        String prefix = "";
        switch (firstNumber){
            case '1':
                prefix = "19";
                break;
            case '2':
                prefix = "19";
                break;
            case '3':
                prefix = "18";
                break;
            case '4':
                prefix = "18";
                break;
            case '5':
                prefix = "20";
                break;
            case '6':
                prefix = "20";
                break;
            default:
                prefix ="INVALID";
                break;
        }
        return prefix;
    }

    /**
     * Metoda returneaza sexul persoanei reprezentat printr-un caracter (M/F) prin verificarea primei cifre din CNP
     * @param firstNumber - primul caracater din CNP transmis din main folosind CNP.charAt(0)
     * @return - Returnam un singur caracter care reprezinta sexul persoanei i.e primul caracter 2 atunci returnam 'F'
     */
    public static char returnSexOfPerson(char firstNumber) {
        char sex;
        if (firstNumber == '1' ||
                firstNumber == '3' ||
                firstNumber == '5' ||
                firstNumber == '7') {
            sex = 'M';
        } else {
            sex = 'F';
        }
        return sex;
    }

    /**
     * Metoda care proceseaza substringul din CNP care contine data si il formateaza intr-un mod prin care putem lucra mai usor cu el
     * Astfel daca avem un CNP de forma: 1961201XXXXXX atunci data o sa fie substringul pentru data o sa fie 961201
     * @param CNP - Transmitem intregul CNP catre metoda
     * @return - Returnam data intr-un format de tipul dd-MM-yyyy in format String
     */
    public static String getBirthDateFromCnpAsString(String CNP) {
        String dateOfBirth = CNP.substring(1,7);
        String prefix = getYearPrefix(CNP.charAt(0));

        dateOfBirth = prefix + dateOfBirth;
        return dateOfBirth.substring(6,8) + "-" + dateOfBirth.substring(4,6) + "-" + dateOfBirth.substring(0,4);
    }

    // Scrieti o metoda care, pe baza stringului de tip dd-MM-yyyy obtinut, sa returneze varsta persoanei ca un int
    public static int getAgeFromBirthDate(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob, currentDate).getYears();
        
        return age;
    }

    /** Scrieti o metoda care sa verifice judetul in care persoana s-a nascut folosind caracterele aflate pe pozitia 7-8
     */
    public static String getCounty(String countyNumbers) {
        String county = "";
        switch (countyNumbers) {
            case "01":
                county = "Alba";
                break;
            case "02":
                county = "Arad";
                break;
            case "03":
                county = "Arges";
                break;
            case "04":
                county = "Bacau";
                break;
            case "05":
                county = "Bihor";
                break;
            case "06":
                county = "Bistrita-Nasaud";
                break;
            case "07":
                county = "Botosani";
                break;
            case "08":
                county = "Brasov";
                break;
            case "09":
                county = "Braila";
                break;
            case "10":
                county = "Buzau";
                break;
            case "11":
                county = "Caras-Severin";
                break;
            case "12":
                county = "Cluj";
                break;
            case "13":
                county = "Constanta";
                break;
            case "14":
                county = "Covasna";
                break;
            case "15":
                county = "Dambovita";
                break;
            case "16":
                county = "Dolj";
                break;
            case "17":
                county = "Galati";
                break;
            case "18":
                county = "Gorj";
                break;
            case "19":
                county = "Harghita";
                break;
            case "20":
                county = "Hunedoara";
                break;
            case "21":
                county = "Ialomita";
                break;
            case "22":
                county = "Iasi";
                break;
            case "23":
                county = "Ilfov";
                break;
            case "24":
                county = "Maramures";
                break;
            case "25":
                county = "Mehedinti";
                break;
            case "26":
                county = "Mures";
                break;
            case "27":
                county = "Neamt";
                break;
            case "28":
                county = "Olt";
                break;
            case "29":
                county = "Prahova";
                break;
            case "30":
                county = "Satu Mare";
                break;
            case "31":
                county = "Salaj";
                break;
            case "32":
                county = "Sibiu";
                break;
            case "33":
                county = "Suceava";
                break;
            case "34":
                county = "Teleorman";
                break;
            case "35":
                county = "Timis";
                break;
            case "36":
                county = "Tulcea";
                break;
            case "37":
                county = "Vaslui";
                break;
            case "38":
                county = "Valcea";
                break;
            case "39":
                county = "Vrancea";
                break;
            case "40":
                county = "Bucuresti";
                break;
            case "41":
                county = "Bucuresti - Sector 1";
                break;
            case "42":
                county = "Bucuresti - Sector 2";
                break;
            case "43":
                county = "Bucuresti - Sector 3";
                break;
            case "44":
                county = "Bucuresti - Sector 4";
                break;
            case "45":
                county = "Bucuresti - Sector 5";
                break;
            case "46":
                county = "Bucuresti - Sector 6";
                break;
            case "47":
                county = "Bucuresti - Sector 7 (desfiintat)";
                break;
            case "48":
                county = "Bucuresti - Sector 8 (desfiintat)";
                break;
            case "51":
                county = "Calarasi";
                break;
            case "52":
                county = "Giurgiu";
                break;
        }

        return county;
    }

    public static void main(String[] args) {
        String CNP = "2931111050098";
        char firstNumber = CNP.charAt(0);
        String countyNumbers = CNP.substring(7, 9);

        char genderOfPerson = returnSexOfPerson(firstNumber);
        String dateOfBirth = getBirthDateFromCnpAsString(CNP);
        int age = getAgeFromBirthDate(getBirthDateFromCnpAsString(CNP));
        String county = getCounty(countyNumbers);

        if (isCNPValid(CNP.length())) {
            System.out.println("You are a " + genderOfPerson + ". \n");
            System.out.println("Your date of birth is " + dateOfBirth + ". \n");
            System.out.println("You are " + age + " years old. \n");
            System.out.println("You are from " + county + " county.");
        } else {
            System.out.println("Enter a valid CNP");
        }
    }
}
