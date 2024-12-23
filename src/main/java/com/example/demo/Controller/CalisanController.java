package com.example.demo.Controller;

import com.example.demo.Entity.Calisan;
import com.example.demo.Entity.calisan_sirket;
import com.example.demo.Service.CalisanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calisan")
public class CalisanController {
    CalisanService calisanService=new CalisanService();

    @PostMapping("/add")
    public boolean add(@RequestParam String isim,@RequestParam String soyisim,@RequestParam long sirket_id,@RequestParam int maas)
    {
        return calisanService.addCalisan(new Calisan(isim,soyisim),sirket_id,maas);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long calisan_id)
    {
        return calisanService.deleteCalisan(calisan_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long calisan_id, @RequestParam long sirket_id, @RequestParam int maas)
    {
        return calisanService.updateCalisan(calisan_id, sirket_id, maas);
    }

    @GetMapping("/search")
    public calisan_sirket search(@RequestParam long calisan_id)
    {
        return calisanService.searchCalisan(calisan_id);
    }

    @GetMapping("/get")
    public List<calisan_sirket> get()
    {
        return calisanService.getCalisan();
    }

}
