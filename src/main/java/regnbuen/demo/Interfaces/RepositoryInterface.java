package regnbuen.demo.Interfaces;


import regnbuen.demo.Models.MemberModel;
import java.util.List;

public interface RepositoryInterface
{
    MemberModel get (int id);
    List<MemberModel> get();
    void create(MemberModel memberModel);
    List<MemberModel> getForside();
    void update(int member_id);
    void delete(int id);
    MemberModel getSpecificMemberModel(int id);

}

