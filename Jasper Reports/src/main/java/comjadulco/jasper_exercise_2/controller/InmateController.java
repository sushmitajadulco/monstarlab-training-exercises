package comjadulco.jasper_exercise_2.controller;


import comjadulco.jasper_exercise_2.service.JasperService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class InmateController {

    @Autowired
    private JasperService jasperService;

    @GetMapping(value = "/export/{name}/{exportType}")
    public void export(@PathVariable("name") String name, @PathVariable("exportType") String exportType,
                       HttpServletResponse response) throws IOException, JRException {

        jasperService.generateReport(name, response, exportType);
    }
}
