package com.example.gymbudd;

import java.io.Serializable;

public class User implements Serializable {
    String email, name, age, gender, fitnessGoal, gymFreq, gymProgramInterest, gymTiming, sameGender, interestPT, gymSession, equipmentFamiliar, hardWorkoutPartner, rate, identifier, username;

    public User(String email, String name, String age, String gender, String fitnessGoal, String gymFreq, String gymProgramInterest, String gymTiming, String sameGender, String interestPT, String gymSession, String equipmentFamiliar, String hardWorkoutPartner, String rate, String identifier, String username) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.fitnessGoal = fitnessGoal;
        this.gymFreq = gymFreq;
        this.gymProgramInterest = gymProgramInterest;
        this.gymTiming = gymTiming;
        this.sameGender = sameGender;
        this.interestPT = interestPT;
        this.gymSession = gymSession;
        this.equipmentFamiliar = equipmentFamiliar;
        this.hardWorkoutPartner = hardWorkoutPartner;
        this.rate = rate;
        this.identifier = identifier;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                ", gymFreq='" + gymFreq + '\'' +
                ", gymProgramInterest='" + gymProgramInterest + '\'' +
                ", gymTiming='" + gymTiming + '\'' +
                ", sameGender='" + sameGender + '\'' +
                ", interestPT='" + interestPT + '\'' +
                ", gymSession='" + gymSession + '\'' +
                ", equipmentFamiliar='" + equipmentFamiliar + '\'' +
                ", hardWorkoutPartner='" + hardWorkoutPartner + '\'' +
                ", rate='" + rate + '\'' +
                ", identifier='" + identifier + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getGymFreq() {
        return gymFreq;
    }

    public void setGymFreq(String gymFreq) {
        this.gymFreq = gymFreq;
    }

    public String getGymProgramInterest() {
        return gymProgramInterest;
    }

    public void setGymProgramInterest(String gymProgramInterest) {
        this.gymProgramInterest = gymProgramInterest;
    }

    public String getGymTiming() {
        return gymTiming;
    }

    public void setGymTiming(String gymTiming) {
        this.gymTiming = gymTiming;
    }

    public String getSameGender() {
        return sameGender;
    }

    public void setSameGender(String sameGender) {
        this.sameGender = sameGender;
    }

    public String getInterestPT() {
        return interestPT;
    }

    public void setInterestPT(String interestPT) {
        this.interestPT = interestPT;
    }

    public String getGymSession() {
        return gymSession;
    }

    public void setGymSession(String gymSession) {
        this.gymSession = gymSession;
    }

    public String getEquipmentFamiliar() {
        return equipmentFamiliar;
    }

    public void setEquipmentFamiliar(String equipmentFamiliar) {
        this.equipmentFamiliar = equipmentFamiliar;
    }

    public String getHardWorkoutPartner() {
        return hardWorkoutPartner;
    }

    public void setHardWorkoutPartner(String hardWorkoutPartner) {
        this.hardWorkoutPartner = hardWorkoutPartner;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}