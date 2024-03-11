package org.example;

class FacultyDorm {
    private final int allocationId;
    private final String facultyName;
    private final int dormId;
    private final int boyRooms;
    private final int girlRooms;

    public FacultyDorm(int allocationId, String facultyName, int dormId, int boyRooms, int girlRooms)
    {
        this.allocationId = allocationId;
        this.facultyName = facultyName;
        this.dormId = dormId;
        this.boyRooms = boyRooms;
        this.girlRooms = girlRooms;
    }

    public int getAllocationId()
    {
        return allocationId;
    }

    public String getFacultyName()
    {
        return facultyName;
    }

    public int getDormId()
    {
        return dormId;
    }

    public int getBoyRooms()
    {
        return boyRooms;
    }

    public int getGirlRooms()
    {
        return girlRooms;
    }
}
