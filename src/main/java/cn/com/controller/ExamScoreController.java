package cn.com.controller;

import cn.com.entity.ExamScore;
import cn.com.service.ExamScoreService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/examScore")
public class ExamScoreController {

    @Autowired
    private ExamScoreService examScoreService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<ExamScore>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                         @RequestParam(value = "memberId",required = false)Integer memberId,
                                         @RequestParam(value = "examId",required = false)Integer examId,
                                         @RequestParam(value = "score",required = false)Integer score){
        Result<List<ExamScore>> list = examScoreService.query(pageNum, pageSize,memberId,examId,score);
        return list;
    }

    @GetMapping("/getById")
    @ResponseBody
    public Result<ExamScore> getById(@RequestParam(value = "id")Integer id){
        ExamScore list = examScoreService.getById(id);
        return new Result<>().success(list);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(ExamScore examScore){
        examScoreService.add(examScore);
        return new Result<>().success();
    }


    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        examScoreService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        examScoreService.removeList(id);
        return new Result<>().success();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(ExamScore examScore){
        examScoreService.update(examScore);
        return new Result<>().success();
    }
}
