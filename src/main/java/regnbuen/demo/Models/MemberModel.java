package regnbuen.demo.Models;

import java.sql.Date;

public class MemberModel
{
    private int member_id;
    private String first_name;
    private String last_name;
    private int gender;
    private String address;
    private String member_phone;
    private Date enrollment_date;
    private Date date_of_resignation;
    private int has_allergies;
    private int school_id;
    private int grade_id;
    private int doctor_id;

    //test variabler KAN SAGTENS SLETTES


    public MemberModel()
    {

    }

    public MemberModel(int member_id)
    {
        this.member_id = member_id;
    }

    public MemberModel(int member_id, String first_name, String last_name, int gender, String address, String member_phone, Date enrollment_date, Date date_of_resignation, int has_allergies, int school_id, int grade_id, int doctor_id)
    {
        this.member_id = member_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.address = address;
        this.member_phone = member_phone;
        this.enrollment_date = enrollment_date;
        this.date_of_resignation = date_of_resignation;
        this.has_allergies = has_allergies;
        this.school_id = school_id;
        this.grade_id = grade_id;
        this.doctor_id = doctor_id;

    }

    public int getMember_id()
    {
        return member_id;
    }

    public void setMember_id(int member_id)
    {
        this.member_id = member_id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getMember_phone()
    {
        return member_phone;
    }

    public void setMember_phone(String member_phone)
    {
        this.member_phone = member_phone;
    }

    public Date getEnrollment_date()
    {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date)
    {
        this.enrollment_date = enrollment_date;
    }

    public Date getDate_of_resignation()
    {
        return date_of_resignation;
    }

    public void setDate_of_resignation(Date date_of_resignation)
    {
        this.date_of_resignation = date_of_resignation;
    }

    public int getHas_allergies()
    {
        return has_allergies;
    }

    public void setHas_allergies(int has_allergies)
    {
        this.has_allergies = has_allergies;
    }

    public int getSchool_id()
    {
        return school_id;
    }

    public void setSchool_id(int school_id)
    {
        this.school_id = school_id;
    }

    public int getGrade_id()
    {
        return grade_id;
    }

    public void setGrade_id(int grade_id)
    {
        this.grade_id = grade_id;
    }

    public int getDoctor_id()
    {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }
}
