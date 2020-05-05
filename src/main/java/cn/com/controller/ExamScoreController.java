package cn.com.controller;

import cn.com.entity.ExamScore;
import cn.com.service.ExamScoreService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/examScore")
public class ExamScoreController {

    @Autowired
    private ExamScoreService examScoreService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<ExamScore>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize){
        Result<List<ExamScore>> list = examScoreService.query(pageNum, pageSize);
        return list;
    }
}
