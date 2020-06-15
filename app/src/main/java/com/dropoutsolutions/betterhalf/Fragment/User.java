package com.dropoutsolutions.betterhalf.Fragment;

public class User {

    private String DateOfBirth, Gender, Name, Profession, ProfileImage;

    public User() {
    }

    public User(String dateOfBirth, String gender, String name, String profession, String profileImage) {
        DateOfBirth = dateOfBirth;
        Gender = gender;
        Name = name;
        Profession = profession;
        ProfileImage = profileImage;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }
}

