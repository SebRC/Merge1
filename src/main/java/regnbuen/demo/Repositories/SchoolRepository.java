package regnbuen.demo.Repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Interfaces.SchoolInterface;
import regnbuen.demo.Models.SchoolModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SchoolRepository implements SchoolInterface
{
    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public void create(SchoolModel schoolModel)
    {
        String sqlInsertTo = "insert into school(school_id, school_name, school_address, school_phone)" +
                " values(" + schoolModel.getSchool_id() + ", '"
                + schoolModel.getSchool_name() + "', '"
                + schoolModel.getSchool_address() + "', '"
                + schoolModel.getSchool_phone() + "')";

        jdbc.update(sqlInsertTo);
    }

    @Override
    public void get()
    {

    }

    public List<SchoolModel> getList()
    {
        List<SchoolModel> schools = new ArrayList<>();
        String sqlQuery = "SELECT * FROM School";

        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        while(rs.next())
        {
            schools.add(new SchoolModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4)));
        }
        return schools;
    }


}
