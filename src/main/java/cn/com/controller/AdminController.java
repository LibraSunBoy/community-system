package cn.com.controller;

import cn.com.entity.Admin;
import cn.com.exception.CustomException;
import cn.com.service.AdminService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <pre>
 * Filename      :  AdminController
 * Package       :  cn.com.controller
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    @ResponseBody
    public Result<Admin> login(HttpServletRequest request, String account, String pwd){
        Admin login = adminService.login(account, pwd);
        request.getSession().setAttribute("ADMIN_USER",login.getAccount());
        return new Result<>(CustomException.CodeEnum.OK,login);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> add(@RequestBody Admin admin){
        Integer adminId = adminService.add(admin);
        return new Result<>(CustomException.CodeEnum.OK,adminId);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Admin>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize, String account){
        Result<List<Admin>> list = adminService.query(pageNum, pageSize, account);
        return list;
    }
}
