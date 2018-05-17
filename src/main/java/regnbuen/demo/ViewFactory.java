package regnbuen.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewFactory
{
    @Autowired
    private JdbcTemplate jdbc = new JdbcTemplate();

    public List<ViewModel> createViewModels()
    {

        List<ViewModel> viewModels = new ArrayList<>();

        String sqlQuery = "SELECT COUNT(*) FROM Member AS members;";

        SqlRowSet firstRs = jdbc.queryForRowSet(sqlQuery);
        System.out.println(firstRs.next());

        int numOfMembers = firstRs.getInt(1);

        sqlQuery = "SELECT * FROM Member AS m " +
                    "INNER JOIN Doctor AS d ON m.doctor_id = d.doctor_id " +
                    "INNER JOIN Grade AS g ON m.grade_id = g.grade_id " +
                    "INNER JOIN School AS s ON m.school_id = s.school_id;";
        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);


        while(rs.next())
        {
            ViewModel viewModel = new ViewModel();
             MemberModel memberModel = new MemberModel(rs.getInt("member_id"), rs.getString("first_name"), rs.getString("last_name"),
                    rs.getInt("gender"), rs.getString("address"), rs.getString("member_phone"),
                    rs.getDate("enrollment_date"), rs.getDate("date_of_resignation"), rs.getInt("has_allergies"),
                    rs.getInt("school_id"), rs.getInt("grade_id"), rs.getInt("doctor_id"));

             viewModel.setMemberModel(memberModel);

            GradeModel gradeModel = new GradeModel(rs.getInt("grade_id"), rs.getString("grade_name"));

            viewModel.setGradeModel(gradeModel);

            DoctorModel doctorModel = new DoctorModel(rs.getInt("doctor_id"), rs.getString("clinic_phone"),
                    rs.getString("doctor_first_name"), rs.getString("doctor_last_name"));


            viewModel.setDoctorModel(doctorModel);


            SchoolModel schoolModel = new SchoolModel(rs.getInt("school_id"), rs.getString("school_name"), rs.getString("school_address"),
                    rs.getString("school_phone"));

            viewModel.setSchoolModel(schoolModel);



            viewModel.setSchoolModel(schoolModel);


            viewModels.add(viewModel);

        }


        return viewModels;

    }
}
