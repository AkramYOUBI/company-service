package com.example.companyservice.service.util;

import com.example.companyservice.domain.dto.CompanyOutput;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@RequiredArgsConstructor
@Slf4j
public class CSVExport {

    public static void writeToCsv(HttpServletResponse servletResponse, CompanyOutput companyOutput) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"company.csv\"");
        try (CSVPrinter csvPrinter = new CSVPrinter(servletResponse.getWriter(), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "nic", "fullAddress", "creationDate", "fullName", "tvaNumber");
            csvPrinter.printRecord(companyOutput.getId(), companyOutput.getNic(), companyOutput.getFullAddress(), companyOutput.getCreationDate(), companyOutput.getFullName(), companyOutput.getTvaNumber());
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
