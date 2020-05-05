package cn.com.controller;

import cn.com.entity.TrashKnowledge;
import cn.com.service.TrashKnowledgeService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/trashKnowledge")
public class TrashKnowledgeController {

    @Autowired
    private TrashKnowledgeService trashKnowledgeService;


    @GetMapping("/list")
    @ResponseBody
    public Result<List<TrashKnowledge>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize){
        Result<List<TrashKnowledge>> list = trashKnowledgeService.query(pageNum, pageSize);
        return list;
    }
}
