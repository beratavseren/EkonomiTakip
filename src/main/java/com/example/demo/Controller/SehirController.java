package com.example.demo.Controller;

import com.example.demo.Entity.Sehir;
import com.example.demo.Service.SehirService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sehir")
public class SehirController {
    SehirService sehirService=new SehirService();

    @PostMapping("/add")
    public boolean add(@RequestParam String sehir_ad,@RequestParam int plaka_kodu)
    {
        return sehirService.addSehir(new Sehir(sehir_ad,plaka_kodu));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam int plaka_kodu)
    {
        return sehirService.deleteSehir(plaka_kodu);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam String yeni_sehir_ad,@RequestParam int guncellenecek_sehrin_plaka_kodu)
    {
        return sehirService.updateSehir(guncellenecek_sehrin_plaka_kodu,new Sehir(yeni_sehir_ad));
    }

    @GetMapping("/search")
    public Sehir search(@RequestParam int plaka_kodu)
    {
        return sehirService.searchSehir(plaka_kodu);
    }

    @GetMapping("/get")
    public List<Sehir> get()
    {
        return sehirService.getSehir();
    }

}
