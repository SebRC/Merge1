package regnbuen.demo.Interfaces;

import regnbuen.demo.Models.SchoolModel;

import java.util.List;

public interface SchoolInterface
{
    void get();
    List<SchoolModel> getList();
    void create(SchoolModel schoolModel);

}
