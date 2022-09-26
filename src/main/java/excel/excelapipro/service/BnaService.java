package excel.excelapipro.service;

import excel.excelapipro.entity.Bna;
import excel.excelapipro.helper.Helper;
import excel.excelapipro.repository.BnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BnaService {

    @Autowired
    private BnaRepository bnaRepository;

    public void save(MultipartFile file)
    {
        try
        {
            List<Bna> products = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.bnaRepository.saveAll(products);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public List<Bna> getAllProducts()
    {
        return this.bnaRepository.findAll();
    }
}
