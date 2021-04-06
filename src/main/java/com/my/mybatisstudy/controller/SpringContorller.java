package com.my.mybatisstudy.controller;

import com.my.mybatisstudy.dao.StudentMapper;
import com.my.mybatisstudy.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RequestMapping("/test/threadLocal")
@RestController
public class SpringContorller {

    ThreadLocal<Long> local = new ThreadLocal<>();

    @Autowired
    private ContextRefresher contextRefresher;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/refresh")
    public String[]  getRefresh(){
        Set<String> refresh = contextRefresher.refresh();
        return refresh.toArray(new String[refresh.size()]);
    }
    @GetMapping("/set")
    public Long set(HttpServletRequest request) {
        String str = request.getParameter("str");
        if (StringUtils.isEmpty(str)) {
            local.set(null);
            return local.get();
        }
        local.set(Long.valueOf(str));
        return local.get();
    }

    @GetMapping("/{id}")
    public List<Student> getStudent(@PathVariable("id") Integer id, @RequestParam("name") String name){
       return studentMapper.selectByNameAndId(id,name);
    }
}
