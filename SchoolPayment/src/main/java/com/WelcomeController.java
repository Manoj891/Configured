package com;

import com.config.JWTToken;
import com.repository.utility.PaymentGetwayLoginRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ComponentScan
@CrossOrigin
public class WelcomeController {

    @Autowired
    PaymentGetwayLoginRepository repository;

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    @ResponseBody
    public Object doLogin(@RequestParam String userName, @RequestParam String userPassword) {
        Map m, map = new HashMap();
        Object data[];
        List l = repository.findLogin(userPassword, userName);
        if (l.isEmpty()) {
            map.put("error", "invalid login id!!");
            return map;
        }
        data = (Object[]) l.get(0);
        m = new HashMap();
        String status = data[5].toString();

        if (!status.equalsIgnoreCase("Y")) {
            map.put("error", "user login id expired!");
            return map;
        }
        String password = data[3].toString();
        userPassword = data[4].toString();
        if (!userPassword.equalsIgnoreCase(password)) {
            map.put("error", "invalid password!!");
            return map;
        }

        String loginId = data[0].toString();
        userName = data[1].toString();
        String email = data[2].toString();
        String token = com.config.JWTToken.get(loginId, userName, email);
        map.put("message", "Success");
        map.put("token", token);
        m.put("userId", loginId);
        m.put("userName", userName);
        m.put("email", email);
        m.put("status", status);
        return map;
    }

    @RequestMapping(value = "/Login/{token}", method = RequestMethod.GET)
    public String doLogin(@PathVariable String token, HttpServletRequest request, HttpSession session) {
        JWTToken td = new JWTToken("Bearer " + token);
        if (!td.isStatus()) {
            return "redirect:/";
        }
        session.setAttribute("paymentToken", "Bearer " + token);
        session.setAttribute("userId", td.getUserId());
        session.setAttribute("userName", td.getUserName());
        session.setAttribute("email", td.getUserType());

        return "redirect:/home";
    }

    @RequestMapping(value = "api/ChangePassword", method = RequestMethod.GET)
    @ResponseBody
    public Object doChangePassword(@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String rePassword, @RequestHeader(value = "Authorization") String Authorization) {
        JWTToken td = new JWTToken(Authorization);
        Message message = new Message();
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }
        if (!newPassword.equals(rePassword)) {
            return message.respondWithError("Re Password not match");
        }

        List list = repository.findChangePassword(oldPassword, td.getUserId());
        if (list.isEmpty()) {
            return message.respondWithError("invalid token");
        }
        Object[] data = (Object[]) list.get(0);

        String dbPassword = data[0].toString();
        oldPassword = data[1].toString();
        if (!dbPassword.equals(oldPassword)) {
            return message.respondWithError("Old Password not match");
        }

        int row = 0;
        String msg = "";
        try {
            repository.updateChangePassword(rePassword, td.getUserId());
            row = 1;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        if (row > 0) {
            return message.respondWithMessage("Success");
        } else if (msg.contains("Duplicate entry")) {
            msg = "This record already exist";
        } else if (msg.contains("foreign key")) {
            msg = "this record already used in reference tables, Cannot delete of this record";
        }
        return message.respondWithError(msg);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
    public String changePassword() {
        return "login/ChangePassword";
    }

    @RequestMapping(value = "/GenerateToken", method = RequestMethod.GET)
    public String generateToken() {
        return "Utility/GenerateToken";
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "login/home";
    }

}
