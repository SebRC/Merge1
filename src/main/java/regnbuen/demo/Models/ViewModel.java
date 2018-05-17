package regnbuen.demo.Models;

public class ViewModel
{

    private MemberModel memberModel = new MemberModel();
    private GradeModel gradeModel = new GradeModel();
    private SchoolModel schoolModel = new SchoolModel();
    private DoctorModel doctorModel = new DoctorModel();



    public ViewModel(MemberModel memberModel, GradeModel gradeModel, SchoolModel schoolModel, DoctorModel doctorModel)
    {
        this.memberModel = memberModel;
        this.gradeModel = gradeModel;
        this.schoolModel = schoolModel;
        this.doctorModel = doctorModel;
    }

    public ViewModel(){}


    public MemberModel getMemberModel()
    {
        return memberModel;
    }

    public void setMemberModel(MemberModel memberModel)
    {
        this.memberModel = memberModel;
    }

    public GradeModel getGradeModel()
    {
        return gradeModel;
    }

    public void setGradeModel(GradeModel gradeModel)
    {
        this.gradeModel = gradeModel;
    }

    public SchoolModel getSchoolModel()
    {
        return schoolModel;
    }

    public void setSchoolModel(SchoolModel schoolModel)
    {
        this.schoolModel = schoolModel;
    }

    public DoctorModel getDoctorModel()
    {
        return doctorModel;
    }

    public void setDoctorModel(DoctorModel doctorModel)
    {
        this.doctorModel = doctorModel;
    }
}
