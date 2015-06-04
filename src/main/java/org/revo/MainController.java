package org.revo;


import org.revo.Service.RepositeryService;
import org.revo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ashraf on 4/10/15.
 */
@RestController
public class MainController {
    @Autowired
    RepositeryService repositeryService;

    @RequestMapping("/")
    public String index() {
        return "   to create data in your database  go to  /create " +
                "to  list your frinds go to /myfrindes/name " +
                "to list my followers /myfollowers/name  "+
                "to list your follwoing  /myfollowing/name " +
                "to list your sugestFrindes /mysugestFrindes/name";
    }

    @RequestMapping("/create")
    public String create() {
        repositeryService.create();
        return "Sucesss";
    }

    @RequestMapping("/myfrindes/{name}")
    public List<Person> myfrindes(@PathVariable("name") String name) {
        List<Person> collect = repositeryService.MyFrinds(name).parallelStream().
                map(x -> new Person(x.getId(),x.getName())).collect(Collectors.toList());
        return collect;
    }
    @RequestMapping("/myfollowers/{name}")
    public List<Person> myfollowers(@PathVariable("name") String name) {
        List<Person> collect = repositeryService.follower(name).parallelStream().
                map(x -> new Person(x.getId(),x.getName())).collect(Collectors.toList());
        return collect;
    }
    @RequestMapping("/myfollowing/{name}")
    public List<Person> myfollowing(@PathVariable("name") String name) {
        List<Person> collect = repositeryService.follwoings(name).parallelStream().
                map(x -> new Person(x.getId(),x.getName())).collect(Collectors.toList());
        return collect;
    }
    @RequestMapping("/mysugestFrindes/{name}")
    public List<Person> mysugestFrindes(@PathVariable("name") String name) {
        List<Person> collect = repositeryService.sugestFrindes(name).parallelStream().
                map(x -> new Person(x.getId(),x.getName())).collect(Collectors.toList());
        return collect;
    }
}
