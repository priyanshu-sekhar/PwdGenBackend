package com.fullstack.pwdgen.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping
public class PasswordGenerator {
    final WordListController wordListController;
    List<String> wordList;

//    public PasswordGenerator(WordListController wordListController) {
//        this.wordListController = wordListController;
//    }


    public PasswordGenerator(WordListController wordListController) {
        this.wordListController = wordListController;
        wordList = wordListController.getWords();
    }

    @GetMapping(value="/pwdgen")
    public String getPassword()
    {
        String password = "";
        Map<Character,Boolean> pwd = new HashMap<Character, Boolean>();
        int minWordsToPick = findMinWordsToPick(wordList);
        Random random = new Random();
        for(String word:wordList)
        {
            for (int i = 0; i <= minWordsToPick;i++) {
                if (!pwd.containsKey(word.charAt(i)))
                {
                    pwd.put(word.charAt(random.nextInt(minWordsToPick)), true);
                    password+=word.charAt(random.nextInt(minWordsToPick));
                }
            }
        }
        return password;
    }

    private int findMinWordsToPick(List<String> wordList) {
        int minPwdLength = 6;
        int size = wordList.size();
        if (minPwdLength <= (size*2)) {
            return 2;
        }else
        {
            return (minPwdLength/size);
        }
    }

}
