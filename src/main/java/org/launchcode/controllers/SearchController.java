package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value="results")
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        int jobsSize;
        if (searchType.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            jobsSize=jobs.size();
            model.addAttribute("jobs", jobs);
            model.addAttribute("jobsSize",jobsSize);
            model.addAttribute("columns", ListController.columnChoices);
            return "search";
        } else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            jobsSize=jobs.size();
            model.addAttribute("jobs", jobs);
            model.addAttribute("jobsSize",jobsSize);
            model.addAttribute("columns", ListController.columnChoices);
            return "search";
        }

    }

}
