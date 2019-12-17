package io.turntabl.Hadoopapp.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Hadoopapp.model.TweetsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
public class TweetsController {

    @Autowired
    DataService dataService;

    @ApiOperation("tweets")
    @GetMapping("/viewAllTweets")
    public List<TweetsTO> view(){
        return dataService.getAllTweets();
    }
}
