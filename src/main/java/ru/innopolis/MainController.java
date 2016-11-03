package ru.innopolis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Smith on 01.11.2016.
 */
@Controller
public class MainController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    @RequestMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentJSP", new Student());
        modelAndView.setViewName("index1");
        return modelAndView;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    @RequestMapping(value = "/login")
    public ModelAndView other_main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentJSP", new Student());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /*как только на index1.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("studentJSP") Student student) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("studentJSP", student);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}
