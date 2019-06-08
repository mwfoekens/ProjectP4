package KantineAanlevering;

public class Student extends Persoon {
    private int studentNummer;
    private String studieRichting;

    public Student() {
        super();
        this.studentNummer = 0;
        this.studieRichting = "";
    }

    public Student(int studentNummer, String studieRichting, String BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNummer=" + studentNummer +
                ", studieRichting='" + studieRichting + '\'' +
                ", BSN='" + BSN + '\'' +
                ", voorNaam='" + voorNaam + '\'' +
                ", achterNaam='" + achterNaam + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", geslacht=" + geslacht +
                '}';
    }
}
