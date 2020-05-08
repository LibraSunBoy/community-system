package cn.com.controller;

import cn.com.entity.TrashKnowledge;
import cn.com.service.TrashKnowledgeService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trashKnowledge")
public class TrashKnowledgeController {

    @Autowired
    private TrashKnowledgeService trashKnowledgeService;


    @GetMapping("/list")
    @ResponseBody
    public Result<List<TrashKnowledge>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                              @RequestParam(value = "trashTypeId",required = false)Integer trashTypeId,
                                              @RequestParam(value = "title",required = false)String title){
        Result<List<TrashKnowledge>> list = trashKnowledgeService.query(pageNum, pageSize,trashTypeId,title);
        return list;
    }

    @PostMapping("/getByTypeId")
    @ResponseBody
    public Result<List<TrashKnowledge>> getByTypeId(@RequestParam(value = "id") Integer id){
        Result<List<TrashKnowledge>> list = trashKnowledgeService.getByTypeId(id);
        return list;
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(TrashKnowledge trashKnowledge){
        trashKnowledgeService.add(trashKnowledge);
        return new Result<>().success();
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        trashKnowledgeService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        trashKnowledgeService.removeList(id);
        return new Result<>().success();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(TrashKnowledge trashKnowledge){
        trashKnowledgeService.update(trashKnowledge);
        return new Result<>().success();
    }

}
