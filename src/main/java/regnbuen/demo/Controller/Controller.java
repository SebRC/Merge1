package regnbuen.demo.Controller;


import org.springframework.web.bind.annotation.*;
import regnbuen.demo.Interfaces.RepositoryInterface;
import regnbuen.demo.Models.*;
import regnbuen.demo.Repositories.DoctorRepository;
import regnbuen.demo.Repositories.GradeRepository;
import regnbuen.demo.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import regnbuen.demo.Repositories.SchoolRepository;
import regnbuen.demo.ViewFactory;

@org.springframework.stereotype.Controller
public class Controller
{

    @Autowired
    private RepositoryInterface memberRepository = new MemberRepository();

    @Autowired
    private SchoolRepository schoolRepository = new SchoolRepository();

    @Autowired
    private DoctorRepository doctorRepository = new DoctorRepository();

    @Autowired
    private GradeRepository gradeRepository = new GradeRepository();

    @Autowired
    private ViewFactory viewFactory = new ViewFactory();


    /*@RequestMapping("/")
    public String home(Model medlem)
    {
        System.out.printf("hej");
        medlem.addAttribute("index");

        return "/index";
    }*/

    @RequestMapping(value="/opretmedlem",method = RequestMethod.GET)
    public String create (Model medlem)
    {
        medlem.addAttribute("model", new MemberModel());
        return "/opretmedlem";
    }

    @RequestMapping(value="/opretmedlem",method = RequestMethod.POST)
    public String create (@ModelAttribute MemberModel medlem)
    {
        memberRepository.create(medlem);
        return "redirect:/opretmedlem";
    }

    @RequestMapping("/index")
    public String readForside(Model model)
    {
        model.addAttribute("views", viewFactory.createViewModels());
        return "/index";
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String deleteMember(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("memberModel", memberRepository.getSpecificMemberModel(id));
        System.out.println(memberRepository.getSpecificMemberModel(id).getMember_id());
       // memberRepository.delete(memberRepository.getSpecificMemberModel(id));
        return "requestDelete";
    }
   /* @RequestMapping (value = "/requestDelete", method =RequestMethod.GET)
    public String requestDelete(Model model)
    {
     model.addAttribute("requestModelDelete", memberRepository.getSpecificMemberModel())
    }*/

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String deleteMember(@PathVariable int id)
    {
        System.out.println("før slet model");
        memberRepository.delete(id);
        System.out.println("slettet model");

        return "redirect:/index";
    }



    @RequestMapping(value="/opretskole", method = RequestMethod.GET)
    public String createSchool (Model skole)
    {
        skole.addAttribute("schools", new SchoolModel());
        return "/opretskole";
    }

    @RequestMapping(value="/opretskole", method = RequestMethod.POST)
    public String createSchool (@ModelAttribute SchoolModel skole)
    {
        schoolRepository.create(skole);
        return "redirect:/opretskole";
    }

    /*@RequestMapping(value="/testCreate",method = RequestMethod.GET)
    public String create (Model model)
    {
        model.addAttribute("model", new MemberModel());
        return "/testCreate";
    }

    @RequestMapping(value="/testCreate",method = RequestMethod.POST)
    public String create (@ModelAttribute MemberModel model)
    {
        memberRepository.create(model);
        return "redirect:/testCreate";
    }*/




}
