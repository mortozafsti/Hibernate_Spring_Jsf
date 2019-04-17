package com.example.classtest2.controller;

import com.example.classtest2.jasper.SummaryService;
import com.example.classtest2.repo.LoanSummaryRepo;
import com.example.classtest2.repo.UserRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.repo.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoanSummaryController {



    @Autowired
    private LoanSummaryRepo loanSummaryRepo;

    @Autowired
    private SummaryService summaryService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/loansummarylist")
    public String summarylist(Model model){
        model.addAttribute("summarylist",this.loanSummaryRepo.findAll());
        return "loan/loanSummarylist";
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(summaryService.report());
        InputStream inputStream = this.getClass().getResourceAsStream("/report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
    }


    @RequestMapping(value = "/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public void  reportPdf(HttpServletResponse response) throws Exception {
        String source = "D:\\IDB-J2EE\\Hibernate_Spring_Jsf\\loanmanagementsystem\\src\\main\\resources\\report.jrxml";
        try {
                JasperCompileManager.compileReportToFile(source);
        } catch (JRException e) {
            e.printStackTrace();
        }
//




        String sourceFileName = "D:\\IDB-J2EE\\Hibernate_Spring_Jsf\\loanmanagementsystem\\src\\main\\resources\\report1.jasper";


        String printFileName = null;
        String destFileName = "D:\\IDB-J2EE\\Hibernate_Spring_Jsf\\loanmanagementsystem\\src\\main\\resources\\report.pdf";
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(summaryService.report());
        Map parameters = new HashMap();
        try {
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,
                    parameters, dataSource);
            if (printFileName != null) {
                JasperExportManager.exportReportToPdfFile(printFileName,
                        destFileName);


            }
        } catch (JRException e) {
            e.printStackTrace();
        }


        /////////////////download
//        InputStream inputStream = this.getClass().getResourceAsStream("/report.jrxml");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=report.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(inputStream));
   }
}
