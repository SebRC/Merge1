package regnbuen.demo.Models;

public class DoctorModel
{
    private int doctor_id;
    private String doctor_phone;
    private String doctor_first_name;
    private String doctor_last_name;

    public DoctorModel(int doctor_id, String doctor_phone, String doctor_first_name, String doctor_last_name)
    {
        this.doctor_id = doctor_id;
        this.doctor_phone = doctor_phone;
        this.doctor_first_name = doctor_first_name;
        this.doctor_last_name = doctor_last_name;
    }

    public DoctorModel()
    {}

    public int getDoctor_id()
    {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_phone()
    {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone)
    {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_first_name()
    {
        return doctor_first_name;
    }

    public void setDoctor_first_name(String doctor_first_name)
    {
        this.doctor_first_name = doctor_first_name;
    }

    public String getDoctor_last_name()
    {
        return doctor_last_name;
    }

    public void setDoctor_last_name(String doctor_last_name)
    {
        this.doctor_last_name = doctor_last_name;
    }
}
