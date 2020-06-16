package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping()
public class MainController {
    @Autowired // This means to get the bean called TestResultRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TestResultRepository testResultRepository;

    // get: /id=id
    @GetMapping(path="/testById")
    public @ResponseBody Iterable<TestResult> getTestById(@RequestParam Integer id) {
        Iterable<TestResult> allTests = testResultRepository.findAll();
        List<TestResult> result = new ArrayList<TestResult>();
        for(TestResult t : allTests) {
            if(t.getId() == id) {
               result.add(t);
            }
        }
        return result;
    }

    // get: /testrailId=testrailId
    @GetMapping(path="/testByTestrailId")
    public @ResponseBody Iterable<TestResult> getTestByTestrailId(@RequestParam String testrailId) {
        Iterable<TestResult> allTests = testResultRepository.findAll();
        List<TestResult> result = new ArrayList<TestResult>();
        for(TestResult t : allTests) {
            if(t.getTestrailId().contains(testrailId)) {
                result.add(t);
            }
        }
        return result;
    }


    // get: /title=testrailTitle
    @GetMapping(path="/testByTitle")
    public @ResponseBody Iterable<TestResult> getTestByTitle(@RequestParam String title) {
        Iterable<TestResult> allTests = testResultRepository.findAll();
        List<TestResult> result = new ArrayList<TestResult>();
        for(TestResult t : allTests) {
            if(t.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    // get: /auto=auto
    @GetMapping(path="/testByAutoDefect")
    public @ResponseBody Iterable<TestResult> getTestByAutoDefect(@RequestParam String auto) {
        Iterable<TestResult> allTests = testResultRepository.findAll();
        List<TestResult> result = new ArrayList<TestResult>();
        for(TestResult t : allTests) {
            if(t.getAutomationDefect().contains(auto)) {
                result.add(t);
            }
        }
        return result;
    }

    // get /jira=jira
    @GetMapping(path="/testByJira")
    public @ResponseBody Iterable<TestResult> getTestByJira(@RequestParam String jira) {
        Iterable<TestResult> allTests = testResultRepository.findAll();
        List<TestResult> result = new ArrayList<TestResult>();
        for(TestResult t : allTests) {
            if(t.getJiraInfo().contains(jira)) {
                result.add(t);
            }
        }
        return result;
    }

    // get: /all
    @GetMapping(path="/all")
    public @ResponseBody Iterable<TestResult> getAllTests() {
        // This returns a JSON or XML with the users
        return testResultRepository.findAll();
    }

    // post: /add
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewTestrail (@RequestParam String title,
                                                @RequestParam String testrailId,
                                                @RequestParam String status,
                                                @RequestParam String jiraInfo,
                                                @RequestParam String automationDefect,
                                                @RequestParam String comment
    ) {
        TestResult t = new TestResult();;
        t.setTitle(title);
        t.setTestrailId(testrailId);
        t.setStatus(status);
        t.setJiraInfo(jiraInfo);
        t.setAutomationDefect(automationDefect);
        t.setComment(comment);
        testResultRepository.save(t);
        return "Saved";
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteTest(@RequestParam Integer id) {
        testResultRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/")
    public @ResponseBody String home() {
        return "This is home of testrsil test results";
    }

}