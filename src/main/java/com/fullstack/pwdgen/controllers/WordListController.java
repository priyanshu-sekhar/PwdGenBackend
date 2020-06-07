package com.fullstack.pwdgen.controllers;

import com.fullstack.pwdgen.contract.Request;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class WordListController {
    List<String> wordList = new ArrayList<String>();

    @GetMapping(value ="/words")
    public List<String> getWords()
    { return wordList; }
    @PostMapping(value="/words")
    public void addWords(@RequestBody Request request)
    {
        wordList.add(request.getWord());
    }
    @DeleteMapping(value="/words")
    public List<String> getUpdatedWords(@RequestBody Request request)
    {
        String wordToExclude = request.getWord();
        wordList = wordList.stream().filter(word -> !(word.equals(request.getWord())))
                 .collect(Collectors.toList());
        return wordList;
    }

}
