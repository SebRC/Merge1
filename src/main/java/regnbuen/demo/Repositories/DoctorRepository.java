package regnbuen.demo.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.DoctorModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public List<DoctorModel> getList()
    {
        List<DoctorModel> doctors = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Doctor";

        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        while(rs.next())
        {
            doctors.add(new DoctorModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4)));
        }
        return doctors;
    }
}
