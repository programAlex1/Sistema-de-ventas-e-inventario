package com.ventasinventario.Libreria.util;

import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.repository.ICustomerRepository;
import com.ventasinventario.Libreria.domain.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SaleReceiptGenerator {

    private final ICustomerRepository iCustomerRepository;
    private final IEmployeeRepository iEmployeeRepository;

    public byte[] exportToPdf(SaleDtoResponse saleDtoResponse) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReceipt(saleDtoResponse));
    }


    private JasperPrint getReceipt(SaleDtoResponse saleDtoResponse) throws FileNotFoundException, JRException {
        final String nameClient= iCustomerRepository.findById(saleDtoResponse.getIdCustomer()).get().getFullName();
        final String nameEmployee = iEmployeeRepository.findById(saleDtoResponse.getIdEmployee()).get().getName();
        final File imgLogo = ResourceUtils.getFile("classpath:static/logo.png");
        Map<String, Object> params = new HashMap<>();
        params.put("date", saleDtoResponse.getDate());
        params.put("nombreCliente",nameClient);
        params.put("nombreEmpleado",nameEmployee);
        params.put("metodo", saleDtoResponse.getMethod());
        params.put("total", saleDtoResponse.getTotal());
        params.put("imgLogo",new FileInputStream(imgLogo));
        params.put("dsInvoice", new JRBeanCollectionDataSource(saleDtoResponse.getBookList()));

        return  JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:BillBook.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());
    }
}
