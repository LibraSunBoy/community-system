package cn.com.controller;

import cn.com.entity.Exam;
import cn.com.service.ExamService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Exam>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                    @RequestParam(value = "title",required = false)String title){
        Result<List<Exam>> list = examService.query(pageNum, pageSize,title);
        return list;
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(Exam exam){
        examService.add(exam);
        return new Result<>().success();
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        examService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        examService.removeList(id);
        return new Result<>().success();
    }
}
