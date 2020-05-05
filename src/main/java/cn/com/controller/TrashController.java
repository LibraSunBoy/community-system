package cn.com.controller;

import cn.com.entity.Trash;
import cn.com.service.TrashService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/trash")
public class TrashController {
    @Autowired
    private TrashService trashService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Trash>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize){
        Result<List<Trash>> list = trashService.query(pageNum, pageSize);
        return list;
    }
}
