package org.revo;



import org.revo.Service.RepositeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ashraf on 4/10/15.
 */
@RestController
public class MainController {
    @Autowired
    RepositeryService repositeryService;

    @RequestMapping("/")
    public String index() {
        repositeryService.mytest1();
        return "hhh";
    }
}
