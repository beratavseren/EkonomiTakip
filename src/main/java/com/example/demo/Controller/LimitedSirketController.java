package com.example.demo.Controller;

import com.example.demo.Entity.LimitedSirket;
import com.example.demo.Service.LimitedSirketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limitedsirket")
public class LimitedSirketController {

    LimitedSirketService limitedSirketService=new LimitedSirketService();

    @PostMapping("/add")
    public boolean add(@RequestParam String sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam int ortak_sayisi,@RequestParam long sektor_id,@RequestParam int plaka_kodu)
    {
        return limitedSirketService.addLimitedSirket(new LimitedSirket(sirket_ad,gelir,gider,vergi_borcu,ortak_sayisi),sektor_id,plaka_kodu);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long limitedsirket_id)
    {
        return limitedSirketService.deleteLimitedSirket(limitedsirket_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam String guncellenecek_sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam int ortak_sayisi)
    {
        return limitedSirketService.updateLimitedSirket(new LimitedSirket(guncellenecek_sirket_ad,gelir,gider,vergi_borcu,ortak_sayisi));
    }

    @GetMapping("/search")
    public LimitedSirket search(@RequestParam long limitedsirket_id)
    {
        return limitedSirketService.searchLimitedSirket(limitedsirket_id);
    }

    @GetMapping("/get")
    public List<LimitedSirket> get()
    {
        return limitedSirketService.getLimitedSirket();
    }

    @PostMapping("/addpaydas")
    public boolean addPaydas(@RequestParam long paydas_id,@RequestParam int ortaklik_yuzdesi,@RequestParam long limitedsirket_id)
    {
        return limitedSirketService.addPaydastoLimitedSirket(paydas_id, ortaklik_yuzdesi, limitedsirket_id);
    }
}
