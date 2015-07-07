package io.blinktech.patientprofile;

/**
 * Created by mayank on 7/5/15.
 */
public class Patient {

    private int profileId;
    private int patientId;
    private int familyId;
    private int houseId;
    private String name;
    private int age;
    private int phone;
    private String bloodGroup;
    private String previousDate;
    private String chronicDisease;
    private String geneticDisease;
    private String alcohol;
    private String tobacco;
    private String drugs;
    private String notes;


    public Patient() {
    }

    public Patient(int profileId, int patientId, int familyId, int houseId, String name, int age, int phone, String bloodGroup, String previousDate, String chronicDisease, String geneticDisease, String alcohol, String tobacco, String drugs, String notes) {

        this.profileId = profileId;
        this.patientId = patientId;
        this.familyId = familyId;
        this.houseId = houseId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
        this.previousDate = previousDate;
        this.chronicDisease = chronicDisease;
        this.geneticDisease = geneticDisease;
        this.alcohol = alcohol;
        this.tobacco = tobacco;
        this.drugs = drugs;
        this.notes = notes;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getGeneticDisease() {
        return geneticDisease;
    }

    public void setGeneticDisease(String geneticDisease) {
        this.geneticDisease = geneticDisease;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getTobacco() {
        return tobacco;
    }

    public void setTobacco(String tobacco) {
        this.tobacco = tobacco;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }




}
