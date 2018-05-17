package regnbuen.demo.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.GradeModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GradeRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public List<GradeModel> getList()
    {
        List<GradeModel> grades = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Grade";

        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        while(rs.next())
        {
            grades.add(new GradeModel(rs.getInt(1), rs.getString(2)));
        }
        return grades;
    }
}
