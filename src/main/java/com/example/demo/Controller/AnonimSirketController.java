package com.example.demo.Controller;

import com.example.demo.Entity.AnonimSirket;
import com.example.demo.Service.AnonimSirketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anonimsirket")

public class AnonimSirketController {

    AnonimSirketService anonimSirketService = new AnonimSirketService();

    @PostMapping("/add")
    public boolean add(@RequestParam String sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam int halka_aciklik_orani,@RequestParam long sektor_id,@RequestParam int plaka_kodu)
    {
        return anonimSirketService.addAnonimsirket(new AnonimSirket(sirket_ad,gelir,gider,vergi_borcu,halka_aciklik_orani),sektor_id,plaka_kodu);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long anonimsirket_id)
    {
        return anonimSirketService.deleteAnonimSirket(anonimsirket_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam String guncellenecek_sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam int halka_aciklik_orani)
    {
        return anonimSirketService.updateAnonimSirket(new AnonimSirket(guncellenecek_sirket_ad,gelir,gider,vergi_borcu,halka_aciklik_orani));
    }

    @GetMapping("/search")
    public AnonimSirket search(@RequestParam long anonimsirket_id)
    {
        return anonimSirketService.searchAnonimSirket(anonimsirket_id);
    }

    @GetMapping("/get")
    public List<AnonimSirket> get()
    {
        return anonimSirketService.getAnonimSirket();
    }

    @PostMapping("/addpaydas")
    public boolean addPaydas(@RequestParam long paydas_id,@RequestParam int hisse_sayisi,@RequestParam long anonimsirket_id)
    {
        return anonimSirketService.addPaydastoAnonimSirket(paydas_id, hisse_sayisi, anonimsirket_id);
    }
}
