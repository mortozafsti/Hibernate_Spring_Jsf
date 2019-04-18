package com.example.classtest2.jasper;

import com.example.classtest2.entity.LoanSummary;
import com.example.classtest2.repo.LoanSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("summaryService1")
public class SummaryServiceImpl1 implements SummaryService1{

    @Autowired
    private LoanSummaryRepo loanSummaryRepo;

    @Override
    public List<Map<String, Object>> report1() {

        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for (LoanSummary loanSummary : loanSummaryRepo.findAll()){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("id",loanSummary.getId());
            item.put("l_amount",loanSummary.getL_amount());
            item.put("l_branch",loanSummary.getL_branch());
            item.put("l_date",loanSummary.getL_date());
            item.put("lcode",loanSummary.getLoanCode());
            item.put("no_collected_amount",loanSummary.getNo_collected_amount());
            item.put("no_total_amount",loanSummary.getNo_total_amount());

            item.put("no_due_amount",loanSummary.getNo_due_amount());
            item.put("no_total_kisti",loanSummary.getNo_total_Kisti());
            item.put("no_collected_kisti",loanSummary.getNo_collected_Kisti());
            item.put("no_due_kisti",loanSummary.getNo_due_Kisti());

            item.put("m_id",loanSummary.getMember().getId());
            result.add(item);
        }
        return result;
    }
}
