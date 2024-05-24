package com.daergaoth.svnhook.controller;

import com.daergaoth.svnhook.dto.SVNPostCommitDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/svn-hook")
public class SVNPostCommitController {

    @PostMapping("/post-commit")
    public ResponseEntity<String> getData(@RequestBody SVNPostCommitDTO commitDTO) {
        System.out.println("author:" + commitDTO.getAuthor());
        System.out.println("changed:" + commitDTO.getChanged());
        System.out.println("log:" + commitDTO.getLog());
        System.out.println("rev:" + commitDTO.getRev());
        return new ResponseEntity<>("OKAY", HttpStatusCode.valueOf(200));
    }
}
