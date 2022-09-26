package excel.excelapipro.controller;

import excel.excelapipro.entity.Bna;
import excel.excelapipro.helper.Helper;
import excel.excelapipro.service.BnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BnaController {

    @Autowired
    private BnaService bnaService;

    @PostMapping("/transport/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
    {
        if (Helper.checkExcelFormat(file))
        {
            //true

            this.bnaService.save(file);

            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded and data is saved to db");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/transport")
    public List<Bna> getAllProduct()
    {
        return this.bnaService.getAllProducts();
    }
}
