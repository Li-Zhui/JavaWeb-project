package com.itheima;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    /**
     * 方式一：基于HttpServletResponse对象，设置响应数据
     */
    //返回值代表要给前端返回的数据
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.设置响应状态码（由于浏览器会自动设置状态码，所以一般不设置状态码）
        response.setStatus(HttpServletResponse.SC_OK);

        //2.设置响应头
        response.setHeader("name", "heima");

        //3.设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    /**
     * 方式二：使用spring提供的ResponseEntity对象的静态方法，链式编程设置响应数据
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity.
                status(HttpStatus.OK).
                header("name", "heima").
                body("<h1>hello response2</h1>");
    }
}
