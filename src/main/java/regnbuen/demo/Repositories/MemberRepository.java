package regnbuen.demo.Repositories;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import regnbuen.demo.Interfaces.RepositoryInterface;
import regnbuen.demo.Models.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.SchoolModel;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MemberRepository implements RepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(MemberModel memberModel)
    {
        String sqlInsertTo = "insert into member(member_id, first_name, last_name)" +
        " values(" + memberModel.getMember_id() + ", '"
                + memberModel.getFirst_name() + "', '"
                + memberModel.getLast_name() + "')";

        jdbc.update(sqlInsertTo);

    }

    //!!!!!!!!!!!!!!! SKAL GØRES BREDERE TIL NYE PARAMETRE(EXTERNAL INFO), ELLER NY METODE TIL DEM

    @Override
    public MemberModel get(int id)
    {
        // MANGLER AT JOINE MED ANDRE TABELLER (forside)
        String sql = "SELECT * FROM Member where member_id = " + id;
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();
        //  (int id, int webshopId, int quantity, String title, double price)
        MemberModel member =
                new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8),
                        rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
        return member;
    }

    /*
    select first_name, last_name, member.school_id, member.grade_id, enrollment_date, date_of_resignation from Member
    join Grade on Member.grade_id = Grade.grade_id
    join School on Member.school_id = School.school_id
    order by enrollment_date desc;
    */

    public List<MemberModel> getForside()
    {
        List<MemberModel> members = new ArrayList<>();

        String sql = "SELECT * FROM Member " +
                    "join Grade on Member.grade_id = Grade.grade_id " +
                    "join School on Member.school_id = School.school_id " +
                    "order by enrollment_date desc";
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while(rs.next())
        {
            //  (int id, int webshopId, int quantity, String title, double price)
            members.add(new MemberModel(rs.getInt("member_id"), rs.getString("first_name"), rs.getString("last_name"),
                    rs.getInt("gender"), rs.getString("address"), rs.getString("member_phone"),
                    rs.getDate("enrollment_date"), rs.getDate("date_of_resignation"), rs.getInt("has_allergies"),
                    rs.getInt("school_id"), rs.getInt("grade_id"), rs.getInt("doctor_id")));

        }
        return members;
    }

    @Override
    public void update(int member_id)
    {

    }


    @Override
    public void delete(int memberid)
    {
        String sqlDelete = "DELETE FROM Member WHERE member_id = " + memberid;
        System.out.println("Før sql");
        jdbc.update(sqlDelete);
        System.out.println(sqlDelete);
        System.out.println(memberid);
        System.out.println("Efter SQL");

    }


    @Override
    public List<MemberModel> get()
    {
        List<MemberModel> member = new ArrayList<>();
        String sql = "select * from Member";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next())
        {
            member.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                    rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8),
                    rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
        }

        return member;
    }

    @Override
    public MemberModel getSpecificMemberModel(int id)
    {
        String sqlQuery= "SELECT * FROM member WHERE member_id = " + id + ";";

        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        rs.next();
        MemberModel memberModel = new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8),
                rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));

        return memberModel;
    }

}
